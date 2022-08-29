package com.ppumting.pm80.replay.domain;

public class Replay {
	private String replayNo;
	private String replayContent;
	private String qnaNo;
	private String userNumber;
	
	public Replay() {
		
	}
	
	public Replay(String replayNo, String replayContent, String qanNo, String userNumber, String qnaNo) {
		this.replayNo = replayNo;
		this.replayContent = replayContent;
		this.qnaNo = qnaNo;
		this.userNumber = userNumber;
	}

	public String getReplayNo() {
		return replayNo;
	}

	public void setReplayNo(String replayNo) {
		this.replayNo = replayNo;
	}

	public String getReplayContent() {
		return replayContent;
	}

	public void setReplayContent(String replayContent) {
		this.replayContent = replayContent;
	} 

	public String getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(String qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	
	@Override
//	toString 메소드 만들어서 스트링으로 출력
	public String toString() {
		return "Replay [replayNo=" + replayNo + "replayContent=" + replayContent 
				+ "qnaNo" + qnaNo + "userNumber" + userNumber + "]";
	}
}
