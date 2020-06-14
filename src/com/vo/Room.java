package com.vo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Room {
	private final IntegerProperty no;
	private final StringProperty name;
	private final StringProperty userCnt;
	private final StringProperty enterButton;
	public Room(int no, String name) {
		this.no = new SimpleIntegerProperty(no);
		this.name = new SimpleStringProperty(name);
		
		this.userCnt = new SimpleStringProperty("0/ 0");
		this.enterButton = new SimpleStringProperty("����");
	}
	public Room() {
		this((Integer) null, null);
	}
	public IntegerProperty getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no.set(no);
	}
	public StringProperty getName() {
		return name;
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public StringProperty getUserCnt() {
		return userCnt;
	}
	public void setUserCnt(String userCnt) {
		this.userCnt.set(userCnt);
	}
	public StringProperty getEnterButton() {
		return enterButton;
	}
	public void setEnterButton(String enterButton) {
		this.enterButton.set(enterButton);
	}
}
