package com.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.server.Server;
import com.vo.Data;
import com.vo.User;

public class Client implements Runnable {
	private User user;
	private int state;
	
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private final String serverName = "127.0.0.1";
	private final int PORT = 5555;
	private Thread listener;
	private boolean exit;
	private Data data;

	public Client(User user, int state) {
		super();
		this.user = user;
		this.state = state;
		
		try {
			socket = new Socket(serverName, PORT);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			listener = new Thread(this);
			listener.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendData(Data data) {
		try {
			oos.writeObject(data);
			oos.reset();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		switch (state) {
		case Data.FIRST_CONNECTION:
			data = new Data(user.getNickname().get(), "님이 접속했습니다.", Data.FIRST_CONNECTION);
			this.sendData(data);
			break;
		}
		while (!exit) {
			try {
				data = (Data) ois.readObject();
			} catch (IOException e) {
				try {
					oos.close();
					ois.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				exit = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			switch (data.getState()) {
			case Data.DISCONNECTION:
				Server.getUserListOfRoomListInServer().remove(data.getName());
				break;

			default:
				break;
			}
		}
	}
}
