package com.vo;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.util.LocalDateAdapter;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User2 {
	private IntegerProperty no;
	private StringProperty ip;
	private StringProperty nickname;
	private IntegerProperty score;
	private ObjectProperty<LocalDate> regdate;
	public User2() {
		this((Integer) null, null, null);
	}
	public User2(int no, String ip, String nickname) {
		this.no = new SimpleIntegerProperty(no);
		this.ip = new SimpleStringProperty(ip);
		this.nickname = new SimpleStringProperty(nickname);
		
		this.score = new SimpleIntegerProperty(0);
		this.regdate = new SimpleObjectProperty<LocalDate>(LocalDate.of(2020, 6, 11));
	}
	public User2(String nickname) {
		this.nickname = new SimpleStringProperty(nickname);
	}
	public IntegerProperty getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no.set(no);
	}
	public StringProperty getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip.set(ip);
	}
	public StringProperty getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname.set(nickname);
	}
	public IntegerProperty getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score.set(score);
	}
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getRegdate() {
	    return regdate.get();
	}
	public void setRegdate(LocalDate regdate) {
		this.regdate.set(regdate);
	}
	public ObjectProperty<LocalDate> getRegdateProperty() {
		return regdate;
	}
}
