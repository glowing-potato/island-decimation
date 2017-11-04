using System;
using System.Threading;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Network;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server {
    public class Program {
        public static void Main(string[] args) {
            int port = 8000;
            if (args.Length > 0) {
                int.TryParse(args[0], out port);
            }
            NetworkServer server = new NetworkServer(port);
            Console.WriteLine("Running server on tcp://localhost:{0}", port);
            Thread.Sleep(int.MaxValue);
        }
    }
}
