﻿using System;
using System.Net;
using System.Net.Sockets;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Network {
    public class NetworkServer {
        TcpListener Listener;

        void ClientAccepted(IAsyncResult iar) {
            TcpClient tcp = Listener.EndAcceptTcpClient(iar);
            Listener.BeginAcceptTcpClient(ClientAccepted, null);
            ConnectedClient client = new ConnectedClient(tcp);
            try {
                client.DoHandshake();
            } catch (Exception ex) {
                Console.Error.WriteLine(ex);
                client.Dispose();
            }
        }

        public NetworkServer(int port) {
            Listener = new TcpListener(IPAddress.Any, port);
            Listener.Start();
            Listener.BeginAcceptTcpClient(ClientAccepted, null);
        }
    }
}
