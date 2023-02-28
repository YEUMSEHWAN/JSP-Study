package com.city.model;

import java.sql.Timestamp;

public class BoardVO {
	
	private int num;
	private String writer;
	private String subject;
	private int readcount;
	private Timestamp regdate;
	private String content;
	private String imageUID;
	
	
	
	
	public String getImageUID() {
		return imageUID;
	}
	public void setImageUID(String imageUID) {
		this.imageUID = imageUID;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}