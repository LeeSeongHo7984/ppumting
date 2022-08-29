package com.ppumting.pm80.qna.service;

import java.util.List;

import com.ppumting.pm80.qna.dao.QnaDao;
import com.ppumting.pm80.qna.domain.Qna;
import com.ppumting.pm80.replay.domain.Replay;

public class QnaService {
	private QnaDao qnaDao = QnaDao.getInstance();
	
	private static QnaService instance = new QnaService();
	
	public QnaService() {
		
	}
	
	public static QnaService getInstance() {
		return instance;
	}
	
	// qna 작성
	public void addQna(Qna qna) {
		qnaDao.insertQna(qna);
	}
	
	// qnaList 메소드 생성
	public void qnaList(Qna qna) {
		
	}
	
	// qna 안에 정보리스트 
	public List<Qna> getfindNoQna() {
		return qnaDao.findNoQna();
	}

	// qna 상세 조회
	public Qna viewQna(String getQnaNo) {
		return qnaDao.viewQna(getQnaNo);
	}
	
	// qna수정
	public void updateQna(Qna qna) {
		qnaDao.findModifyQna(qna);
	}
	
	// qna 삭제
	public boolean deleteQna(String qnaNo) {
		return qnaDao.deleteQna(qnaNo);
	}
}
