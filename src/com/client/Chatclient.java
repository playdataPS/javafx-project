package com.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;


import com.vo.User;



public class Chatclient implements Runnable {

	private final String serverName="192.168.0.5";
	private final int PORT = 5555;
	String userName;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	private Thread listener;
	private boolean flag; 
	PrintWriter out = null; // 메시지 출력 객체 
	BufferedReader in = null; //소켓으로 작성된 메세지를 읽어오는 객체 
	
	private Socket socket;
	private User user;
	
//	public Chatclient() {
//		
//	}
	public Chatclient(String userName) {
		this.userName = userName;
	}

	public void start() {
		
		try {
			System.out.println(userName);
			socket = new Socket(serverName, PORT);
			
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			User u = new User(serverName, userName);
			
			oos.writeObject(u);
			System.out.println(oos+"start");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		listener = new Thread(this);
		listener.start();
		

	}// end start
	@Override
	public void run() {
		
		try {
			System.out.println(user.getNickname());
			
			user = (User) ois.readObject();
			
			System.out.println(user.getNickname()+"연결되었습니다.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				oos.close();
				ois.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
//		Chatclient mf = new Chatclient("kikiki");
//		Thread thread = new Thread(mf);
//		thread.start();//run() 호출 실행 
		new Chatclient("kimdb").start();
		
	
	}



	
	


	

}
