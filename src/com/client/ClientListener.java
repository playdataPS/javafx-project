package com.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

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
	private boolean flag;
	
	ObjectInputStream ois;
	ObjectOutputStream oos;
	PrintWriter out = null; // 메시지 출력 객체 
	BufferedReader in = null; //소켓으로 작성된 메세지를 읽어오는 객체 
	
	
	
	public ClientListener(String serverIP, int serverPORT, String nickname) {
		this.serverIP = serverIP;
		this.serverPORT = serverPORT;
		this.nickname = nickname;
	}
	
	public void start() {
		try {
			socket = new Socket(serverIP, serverPORT); //create client's socket
			oos = new ObjectOutputStream(socket.getOutputStream()); // send data to server socket 
			ois = new ObjectInputStream(socket.getInputStream()); // receive data from server socket
			
			User client = new User(clientIP, nickname, Status.CONNECTED);
			oos.writeObject(client);
			System.out.println("is connected the server socket");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//thread 
		Thread listener = new Thread(this);
		listener.start();
	}
	
	@Override
	public void run() {
		while(!flag) {
			try {
				user = (User) ois.readObject();
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
			}//try~catch end 
			Status status = user.getStatus();
			String userNickname = user.getNickname();
			
			switch (status) {
			case CONNECTED:
				System.out.println("roomListController - login!! ");
				
				break;
			case INCORRECT:
				System.out.println("loginController - try again ");
				break;	
				
			case DISCONNECTED:
				userList.remove(user);
				System.out.println("update userList");
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
				break;
			default:
				System.out.println("error");
				break;

			
			}
			
		}//while end 
		
	}

}
