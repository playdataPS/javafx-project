package com.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayingRoom implements Serializable {
	// 방장
	private User user;
	private String roomName;
	private ArrayList<User> userList = new ArrayList<User>();
	private ArrayList<String> words;
	
	// 방안의 플레이어
	private User turnUser;
	private int pointer = 0;
	private ArrayList<String> turnUserList = new ArrayList<String>();
	private int currUserNum;
	
	public PlayingRoom(User user, String roomName) {
		super();
		this.user = user;
		this.roomName = roomName;
	}
	
	// 게임 시작 시 실행
	public void turnUserSet() {
		for (User user1 : userList) {
			turnUserList.add(user1.getNickname());
		}
		currUserNum = userList.size();
	}

	public User getTurnUser() {
		return turnUser;
	}

	public void setTurnUser(User turnUser) {
		this.turnUser = turnUser;
	}

	public void setTurnUser() {
		// 나머지 값으로 다음 턴 유저의 인덱스를 정함 
		int index = pointer % currUserNum;
		pointer++;
		String currUserNickName = turnUserList.get(index);
		turnUser = userList.get(index);
		System.out.println(index + " : " + currUserNickName);
	}

	public int getCurrUserNum() {
		return currUserNum;
	}

	public void setCurrUserNum(int currUserNum) {
		this.currUserNum = currUserNum;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public ArrayList<String> getWords() {
		return words;
	}

	public void setWords(ArrayList<String> words) {
		this.words = words;
	}
	
	// 제시어
	public String getWord() {
		int index = pointer % (words.size() - 1);
		String word = words.get(index-1);
		return word;
	}
	
}
