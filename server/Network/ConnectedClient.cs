﻿using System;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Net.Sockets;
using System.Reflection;
using ARSoft.Tools.Net.Dns;
using DevOne.Security.Cryptography.BCrypt;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Database;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Controller;
using System.Threading.Tasks;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.View;
using System.Timers;
using Newtonsoft.Json;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Network {
    public class ConnectedClient : IDisposable {
        const double ServerUpdatePeriod = 500;
        static readonly string VersionString = string.Format("Island Decimation/{0}", Assembly.GetExecutingAssembly().GetName().Version);

        TcpClient Client;
        NetworkServer Server;
        TextReader Reader;
        TextWriter Writer;
        User User;
        Timer Timer;
        public ViewModel Model;

        void ReadCallback(Task<string> task) {
            if (task.IsFaulted) {
                Console.Error.WriteLine(task.Exception);
            } else if (task.IsCompleted) {
                Console.Error.WriteLine("Not implemented: C.G.G.I.S.N.ConnectedClient");
            }
        }

        void SendModel(object sender, ElapsedEventArgs e) {
            string json = JsonConvert.SerializeObject(Model);
            Writer.WriteLine(json);
        }

        public void LoadModel() {
            Model = new ViewModel {
                State = ViewState.BuildView,
                Troops = new ViewModelList<Troop>(),
                BattlingIslands = new ViewModelList<View.Island>(),
                UserIsland = User.Islands.Select(i => new View.Island {
                    Score = i.User.Score,
                    Experience = i.User.Experience,
                    Resources = new Resources {
                        Wood = i.Wood,
                        Wheat = i.Wheat,
                        Iridium = i.Iridium
                    },
                    Buildings = i.Buildings.Select(b => new View.Building {
                        Type = b.Type,
                        Position = new Vertex2 {
                            X = b.X,
                            Y = b.Y
                        },
                        Level = b.Level
                    }).ToViewModelList(),
                    Angle = 0,
                    Terrain = i.Terrain
                }).First()
            };
        }

        public void DoHandshake() {
            Writer.WriteLine(VersionString);
            string email = Reader.ReadLine();
            string password = Reader.ReadLine();
            if (string.IsNullOrWhiteSpace(email) || string.IsNullOrWhiteSpace(password)) {
                Writer.WriteLine("Missing credentials.");
                Dispose();
                return;
            }
            User = DatabaseContext.Instance.Users.FirstOrDefault(u => u.Email == email);
            if (email.StartsWith("+", StringComparison.Ordinal)) {
                email = email.Substring(1);
                User = DatabaseContext.Instance.Users.FirstOrDefault(u => u.Email == email);
                if (User == null) {
                    try {
                        new DnsStubResolver().Resolve<MxRecord>(new MailAddress(email).Host, RecordType.Mx).First();
                    } catch {
                        Writer.WriteLine("Invalid email.");
                        Dispose();
                        return;
                    }
                    User = new User {
                        Email = email,
                        PasswordHash = BCryptHelper.HashPassword(password, BCryptHelper.GenerateSalt())
                    };
                    UserCreator.CreateUser(User);
                    Writer.WriteLine("Account created.");
                } else {
                    Writer.WriteLine("Email taken.");
                }
                Dispose();
                return;
            } else if (User != null) {
                if (BCryptHelper.CheckPassword(password, User.PasswordHash)) {
                    Writer.WriteLine("Authentication successful.");
                    Server.ConnectedUsers[User] = this;
                    Reader.ReadLineAsync().ContinueWith(ReadCallback);
                    LoadModel();
                    Timer.Start();
                } else {
                    Writer.WriteLine("Invalid password.");
                    Dispose();
                    return;
                }
            } else {
                Writer.WriteLine("Invalid email.");
                Dispose();
                return;
            }
        }

        public void Dispose() {
            Client.Dispose();
            Reader.Dispose();
            Writer.Dispose();
        }

        public ConnectedClient(TcpClient client, NetworkServer server) {
            Client = client;
            Server = server;
            Stream stream = Client.GetStream();
            Reader = new StreamReader(stream);
            Writer = new StreamWriter(stream);
            ((StreamWriter) Writer).AutoFlush = true;
            Timer = new Timer {
                AutoReset = true,
                Enabled = false,
                Interval = ServerUpdatePeriod
            };
            Timer.Elapsed += SendModel;
        }
    }
}
