package com.server;

import java.io.*;
import java.net.*;

public class Server {
	private static Socket socket = null;
	
	public void service() {
		ServerSocket serverSocket = null;
		try {
			System.out.println("접속 준비중");
			serverSocket = new ServerSocket(5555);
			while (!serverSocket.isClosed()) {
				socket = serverSocket.accept();
				System.out.println(socket.getPort());
				System.out.println(socket.getInetAddress());
				Thread thread = new Thread(new ServerThread(socket));
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Start Server Service...");
		Server server = new Server();
		server.service();
	}
}
