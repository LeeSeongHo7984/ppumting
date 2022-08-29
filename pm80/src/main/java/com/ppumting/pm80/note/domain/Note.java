package com.ppumting.pm80.note.domain;

import java.sql.Date;

public class Note {
	long	no;
	String receiveUserId;
	String sendUserId;
	String msg;
	String title;
	boolean sendnote;
	long count = 0;
	
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public boolean isSendnote() {
		return sendnote;
	}
	public void setSendnote(boolean sendnote) {
		this.sendnote = sendnote;
	}

	Date regDate;
	
	public String getTitle() {
		return title;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getMsg() {
		return msg;
	}
	public String getReceiveUserId() {
		return receiveUserId;
	}
	public void setReceiveUserId(String receiveUserId) {
		this.receiveUserId = receiveUserId;
	}
	public String getSendUserId() {
		return sendUserId;
	}
	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
