package com.vo;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IntegerProperty no;
	private StringProperty ip; 
	private StringProperty nickname;
	private IntegerProperty score;
	private ObjectProperty<Date> regdate;
	private transient ObjectOutputStream oos;
	private Status status;
	private Room gameRoom;
	private List<User> userList;

	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String ip, String nickname, Status status, ObjectOutputStream oos) {
		this.ip = new SimpleStringProperty(ip);
		this.nickname = new SimpleStringProperty(nickname);
		this.status = status;
		this.oos = oos;

	}

	public User(String ip, String nickname, Status status) {
		this(ip, nickname, status, null);
	}


	public User(String ip, String nickname) {
		super();
		this.ip = new SimpleStringProperty(ip);
		this.nickname = new SimpleStringProperty(nickname);
	}
	
	

	public User(int no,String ip, String nickname, int score, Date regdate,Status status ,ObjectOutputStream oos) {
		this.no = new SimpleIntegerProperty(no);
		this.ip = new SimpleStringProperty(ip);
		this.nickname = new SimpleStringProperty(nickname);
		this.score = new SimpleIntegerProperty(score);
		this.regdate = new SimpleObjectProperty<Date>(regdate);
		this.status = status;
		this.oos = oos;
	}
	
	public User(int no,String ip, String nickname, int score, Date regdate,Status status) {
		this(no, ip, nickname, score, regdate, status, null);
	}
	
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public Room getGameRoom() {
		return gameRoom;
	}
	
	public void setGameRoom(Room gameRoom) {
		this.gameRoom = gameRoom;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	public int getNo() {
		return no.get();
	}
	public void setNo(int no) {
		this.no = new SimpleIntegerProperty(no);
	}
	public String getIp() {
		return ip.get();
	}
	public void setIp(String ip) {
		this.ip = new SimpleStringProperty(ip);
	}
	public String getNickname() {
		return nickname.get();
	}
	public void setNickname(String nickname) {
		this.nickname = new SimpleStringProperty(nickname);
	}
	public int getScore() {
		return score.get();
	}
	public void setScore(int score) {
		this.score.set(score);
	}

	
	public Date getRegdate() {
		return regdate.get();
	}
	public void setRegdate(Date regdate) {
		this.regdate.set(regdate);
	}
	

//	public int getNo() {
//		return no;
//	}
//
//	public void setNo(int no) {
//		this.no = no;
//	}
//
//	public String getIp() {
//		return ip;
//	}
//
//	public void setIp(String ip) {
//		this.ip = ip;
//	}
//
//	public String getNickname() {
//		return nickname;
//	}
//
//	public void setNickname(String nickname) {
//		this.nickname = nickname;
//	}
//
//	public int getScore() {
//		return score;
//	}
//
//	public void setScore(int score) {
//		this.score = score;
//	}
//
//	public Date getRegdate() {
//		return regdate;
//	}
//
//	public void setRegdate(Date regdate) {
//		this.regdate = regdate;
//	}

	/**
	 * @return the oos
	 */
	public ObjectOutputStream getOos() {
		return oos;
	}

	/**
	 * @param oos the oos to set
	 */
	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}

}
