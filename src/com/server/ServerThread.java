package com.server;

import java.io.*;
import java.net.*;
import java.sql.SQLException;

public class ServerThread implements Runnable {
	private Socket socket;
	private boolean exit;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public ServerThread(Socket socket) {
		super();
		this.socket = socket;
		exit = false;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println(socket.getPort());
		while (!exit) {
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
