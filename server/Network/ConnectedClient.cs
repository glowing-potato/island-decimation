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

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Network {
    public class ConnectedClient : IDisposable {
        static readonly string VersionString = string.Format("Island Decimation/{0}", Assembly.GetExecutingAssembly().GetName().Version);

        TcpClient Client;
        TextReader Reader;
        TextWriter Writer;

        public void DoHandshake() {
            Writer.WriteLine(VersionString);
            string email = Reader.ReadLine();
            string password = Reader.ReadLine();
            if (string.IsNullOrWhiteSpace(email) || string.IsNullOrWhiteSpace(password)) {
                Writer.WriteLine("Missing credentials.");
                Dispose();
                return;
            }
            User user = DatabaseContext.Instance.Users.FirstOrDefault(u => u.Email == email);
            if (email.StartsWith("+", StringComparison.Ordinal)) {
                email = email.Substring(1);
                user = DatabaseContext.Instance.Users.FirstOrDefault(u => u.Email == email);
                if (user == null) {
                    try {
                        new DnsStubResolver().Resolve<MxRecord>(new MailAddress(email).Host, RecordType.Mx).First();
                    } catch {
                        Writer.WriteLine("Invalid email.");
                        Dispose();
                        return;
                    }
                    user = new User {
                        Email = email,
                        PasswordHash = BCryptHelper.HashPassword(password, BCryptHelper.GenerateSalt())
                    };
                    DatabaseContext.Instance.Users.Add(user);
                    Writer.WriteLine("Account created.");
                } else {
                    Writer.WriteLine("Email taken.");
                }
                Dispose();
                return;
            } else if (user != null) {
                if (BCryptHelper.CheckPassword(password, user.PasswordHash)) {
                    Writer.WriteLine("Authentication successful.");
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

        public ConnectedClient(TcpClient client) {
            Client = client;
            Stream stream = Client.GetStream();
            Reader = new StreamReader(stream);
            Writer = new StreamWriter(stream);
            ((StreamWriter) Writer).AutoFlush = true;
        }
    }
}
