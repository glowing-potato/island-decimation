package com.github.glowingpotato.islanddecimation.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	private Socket client;
	private String address;
	private int port;
	private Thread connectThread;

	public Client(String address, int port) {
		client = new Socket();
		this.address = address;
		this.port = port;
		connectThread = new Thread(() -> {
			try {
				Scanner in = new Scanner(client.getInputStream());
				while (in.hasNext()) {
					String packet = "";
					String line;
					while (!(line = in.nextLine()).equals("")) {
						packet += line + "\n";
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	public void bind() throws IOException {
		client.bind(new InetSocketAddress(address, port));
	}

	public void run() {
		connectThread.start();
	}
	// public String get

}
