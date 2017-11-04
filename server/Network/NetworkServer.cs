﻿using System;
using System.Net;
using System.Net.Sockets;
using System.Collections.Generic;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Database;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Network {
    public class NetworkServer {
        public Dictionary<User, ConnectedClient> ConnectedUsers;
        TcpListener Listener;

        void ClientAccepted(IAsyncResult iar) {
            TcpClient tcp = Listener.EndAcceptTcpClient(iar);
            Listener.BeginAcceptTcpClient(ClientAccepted, null);
            ConnectedClient client = new ConnectedClient(tcp, this);
            try {
                client.DoHandshake();
            } catch (Exception ex) {
                Console.Error.WriteLine(ex);
                client.Dispose();
            }
        }

        public NetworkServer(int port) {
            ConnectedUsers = new Dictionary<User, ConnectedClient>();
            Listener = new TcpListener(IPAddress.Any, port);
            Listener.Start();
            Listener.BeginAcceptTcpClient(ClientAccepted, null);
        }
    }
}
