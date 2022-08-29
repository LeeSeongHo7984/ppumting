package com.ppumting.pm80.point.service;

import com.ppumting.pm80.point.dao.PointDao;

public class PointService {
	private PointDao pointdao = PointDao.getInstance();
	
	// 랜덤한 숫자의 계좌 생성 
	public String createAccountNum(String userId) { 
		return pointdao.createAccountNum(userId);
	}
	
	// 사용자 아이디 존재 여부 확인(아이디 중복확인)
	public boolean isValidUser(String userId) {
		return pointdao.isValidUser(userId);
	}
	
	// 사용자 포인트 차감 (결제)
	public boolean minusPoint(String userId, String trainerPrice, String month) { 
		return pointdao.minusPoint(userId, trainerPrice, month);
	}
	
	// 사용자 아이디를 이용한 본인 계좌 조회
	public String checkAccountNum(String userId) {
		return pointdao.checkAccountNum(userId);
	}
	
	//사용자 포인트 충전
	public boolean addPoint(String userId, long point) { 
		return pointdao.addPoint(userId, point);
	}
	
	// 사용자 아이디를 이용한 보유포인트 조회
	public String checkPoint(String userId) { 
		return pointdao.checkPoint(userId);
	}
	
	public boolean deleteAccount(String userId) {
		return pointdao.deleteAccount(userId);
	}
	
}
