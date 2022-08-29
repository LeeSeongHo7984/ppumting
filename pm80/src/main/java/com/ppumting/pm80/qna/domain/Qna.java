package com.ppumting.pm80.qna.domain;

import java.util.Date;
import java.util.List;

import com.ppumting.pm80.replay.domain.Replay;

public class Qna {
	private String qnaNo;
	private String userId;
	private String qnaTitle;
	private String qnaContent;
	private Date qnaRegDate;
	private String qnaViews;
	private List<Replay> replays;
	
	public Qna() {
		
	}

	public Qna(String qnaNo, String userId, String qnaTitle, String qnaContent, Date qnaRegDate, String qnaViews) {
		super();
		this.qnaNo = qnaNo;
		this.userId = userId;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaRegDate = qnaRegDate;
		this.qnaViews = qnaViews;
	}

	public String getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(String qnaNo) {
		this.qnaNo = qnaNo;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public Date getQnaRegDate() {
		return qnaRegDate;
	}

	public void setQnaRegDate(Date qnaRegDate) {
		this.qnaRegDate = qnaRegDate;
	}
	
	public String getQnaViews() {
		return qnaViews;
	}

	public void setQnaViews(String qnaViews) {
		this.qnaViews = qnaViews;
	}
	
	public List<Replay> getReplays() {
		return replays;
	}

	public void setReplays(List<Replay> replays) {
		this.replays = replays;
	}
	
	@Override
	// toString 메소드 만들어서 스트링으로 출력
	public String toString() {
		return "Qna [qnaNo=" + qnaNo + "userId=" + userId + ", qnaTitle=" + qnaTitle 
				+ ", qnaContent=" + qnaContent + "qnaRegDate=" + qnaRegDate + "]";
	}
	
	
}
