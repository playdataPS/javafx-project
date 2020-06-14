package com.vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User3 {
	private final StringProperty nickname;
	public User3(String nickname) {
		this.nickname = new SimpleStringProperty(nickname);
	}
	public User3() {
		this(null);
	}
	public StringProperty getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname.set(nickname);
	}
}