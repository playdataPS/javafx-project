package com.vo;

import java.io.*;
import java.util.*;

public class Data implements Serializable {
	private String name; // Ŭ���̾�Ʈ �̸�
	private String receiver; // �Ӹ��� ���� Ŭ���̾�Ʈ �̸�
	private String message; // Ŭ���̾�Ʈ�� �޽���
	private Room room;
	private int state; // Ŭ���̾�Ʈ�� ���Ӱ� ������¸� �����ϴ� ����
	private transient ObjectOutputStream oos; // �ڷ����� ��ü
	private Vector<String> userList; // �����ڵ��� �̸�(ó�� �����Ҷ� ����)
	//Ŭ���̾�Ʈ�� ���¸� ��Ÿ���� ���
	//private Vector<String> roomList;
	private HashMap<String, Room> roomList;
	private Vector<String> playerlist;
	
	public static final int FIRST_CONNECTION = 0;
	public static final int DISCONNECTION = -1;
	public static final int CHAT_MESSAGE = 1;
	public static final int ANSWER_MESSAGE = 2;
	public static final int GAME_READY = 10;
	public static final int GAME_START = 20;
	
	public Data() {
		super();
	}
	public Data(String name, String message, int state, ObjectOutputStream oos) {
		super();
		this.name = name;
		this.message = message;
		this.state = state;
		this.oos = oos;
	}
	public Data(String name, String message, int state) {
		this(name, message, state, null);
	}
	public Data(String name, String receiver, String message, int state) {
		super();
		this.name = name;
		this.receiver = receiver;
		this.message = message;
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Room getRoom() {
		return room;
	}
	public void setGameRoom(Room room) {
		this.room = room;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public ObjectOutputStream getOos() {
		return oos;
	}
	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}
	public Vector<String> getUserList() {
		return userList;
	}
	public void setUserList(Vector<String> userList) {
		this.userList = userList;
	}
	public HashMap<String, Room> getRoomList() {
		return roomList;
	}
	public void setRoomList(HashMap<String, Room> roomList) {
		this.roomList = roomList;
	}
	public Vector<String> getPlayerlist() {
		return playerlist;
	}
	public void setPlayerlist(Vector<String> playerlist) {
		this.playerlist = playerlist;
	}
	
}
