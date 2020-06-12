package com.vo;

import java.sql.Date;

public class Game {
	private int no;
	private int dictNo;
	private String img;
	private Date regdate;
	private Status status;
	private boolean state;
	
	public Game() {
		// TODO Auto-generated constructor stub
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getDictNo() {
		return dictNo;
	}

	public void setDictNo(int dictNo) {
		this.dictNo = dictNo;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
	
}
