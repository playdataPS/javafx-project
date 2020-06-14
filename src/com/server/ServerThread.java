package com.server;

import java.io.*;
import java.net.*;
import java.sql.SQLException;

import com.vo.Data;

public class ServerThread implements Runnable {
	private Socket socket;
	private boolean exit;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Data data = null;
	
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
		while (!exit) {
			try {
				data = (Data) ois.readObject();
				int state = data.getState();
				switch (state) {
				case Data.FIRST_CONNECTION:
					data.setOos(oos);
					System.out.println("[" + data.getName() + "] " + data.getMessage());
					Server.getUserListOfRoomListInServer().add(data.getName());
					//System.out.println(Server.getUserListOfRoomListInServer().get(0));
					break;
				case Data.DISCONNECTION:
					System.out.println(data.getName()+ "님이 접속을 종료하셨습니다.");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
