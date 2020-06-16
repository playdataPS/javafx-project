package com.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

import com.vo.Room;
import com.vo.RoomStatus;
import com.vo.Status;
import com.vo.User;

public class ClientListener implements Runnable {
	private String serverIP;
	private String clientIP;
	private int serverPORT;
	private String nickname;
	private Socket socket;

	private User user;

	private ArrayList<User> userList;
	private ArrayList<Room> roomList;
	private boolean flag;
	private Thread listener;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	private static ClientListener instance;

	public ClientListener() {
		instance = this;

	}

	public static ClientListener getInstance() {
		return instance;
	}

	public ClientListener(String serverIP, int serverPORT, User user) {
		this.serverIP = serverIP;
		this.serverPORT = serverPORT;
		this.user = user;
	}

	public ClientListener(String serverIP, int serverPORT, String nickname) {
		this.serverIP = serverIP;
		this.serverPORT = serverPORT;
		this.nickname = nickname;
	}

	public void createConnect() {
		try {
			socket = new Socket(serverIP, serverPORT); // create client's socket
			oos = new ObjectOutputStream(socket.getOutputStream()); // send data to server socket
			ois = new ObjectInputStream(socket.getInputStream()); // receive data from server socket

			clientIP = socket.getLocalAddress().toString();
			System.out.println("ip를 가져옵니다" + clientIP);
			System.out.println(nickname);
			User client = new User(clientIP, nickname, Status.CONNECTED);
//			oos.writeObject(client);
			System.out.println("is connected the server socket");

		} catch (IOException e) {
			e.printStackTrace();
		}

//		//thread 
		listener = new Thread(this);
		listener.start();
	}

	// update UI according to the message from server
	@Override
	public void run() {
		while (!flag) {
			try {
				user = (User) ois.readObject();
				System.out.println(user.getIp());
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					oos.close();
					ois.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
				flag = true;
			} // try~catch end
			Status status = user.getStatus();
			String userNickname = user.getNickname();

			switch (status) {
			case CONNECTED:
				// 현재 접속 유저
				// List<User> nowUserList = user.getUserList();

				System.out.println("WaitingRoomController - login!! ");

				user.setOos(oos);
				// createRoom();
				break;
			case INCORRECT:
				System.out.println("loginController - try again ");
				break;

			case DISCONNECTED:
				userList.remove(user);
				System.out.println("update userList");
				flag = true;
				break;
			case HIDE:
				System.out.println("game playing  GameController> role - hide ");
				break;
			case SEEK:
				System.out.println("game playing GameController > role - seek ");
				break;
			case PLAYING:
				System.out.println("game playing GameController");
				break;
			case READY:
				System.out.println("game WaitingRoomController > status - READY ");
				break;

			case WAITING:
				System.out.println("game WaitingRoomController > status - waiting ");
				user.setOos(oos);
				user.setStatus(Status.READY);
				try {
					user.getOos().writeObject(user);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("error");
				break;

			}

		} // while end

		try {
			ois.close();
		} catch (IOException e) {
			System.err.println(" ChatClientThread에의 ObjectOutputStream을 Close하는 중에 IOException이 발생하였습니다.");
		} // catch

	}

	public void endConnect() {
		try {
			socket.close();
			oos.close();
			ois.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public void createRoom() {
//		try {
//			System.out.println("createRoom");
//			
//			Room room = new Room(user, "게임방!!!", 8, RoomStatus.WAITING);
//			//User data = new User();
//			user.setGameRoom(room);
//			user.setNickname("ibi");
//			user.setStatus(Status.WAITING);
//			
//			user.getOos().writeObject(user);
//			//oos.writeObject(data);
//			
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

//	public static void main(String[] args) {
//		User userData = new User("127.0.0.1", "eunhye");
//		
//		new ClientListener("127.0.0.1", 5555, userData).createConnect();
//	}

}
