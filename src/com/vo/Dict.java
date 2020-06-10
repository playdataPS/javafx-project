package com.vo;

import java.sql.Date;

public class Dict {
	private int no;
	private String word;
	private Date regdate;
	
	public Dict() {
		// TODO Auto-generated constructor stub
	}
	

	public Dict(int no, String word, Date regdate) {
		super();
		this.no = no;
		this.word = word;
		this.regdate = regdate;
	}


	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
