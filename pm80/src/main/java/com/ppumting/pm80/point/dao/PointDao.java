package com.ppumting.pm80.point.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ppumting.pm80.point.data.DataSource;
import com.ppumting.pm80.point.data.NamingService;
import com.ppumting.pm80.user.domain.User;

public class PointDao {
	private static PointDao pointdao = new PointDao();
	private static User user = new User();

	NamingService namingService = NamingService.getInstance();
	DataSource datasource = (DataSource) namingService.getAttribute("dataSource");

	// 랜덤한 숫자의 계좌 생성 				
	public String createAccountNum(String userId) { 
		String sql = "INSERT INTO Point (point, accountNum, userId) VALUES (0, ?, ?)";

		String numStr = String.valueOf((int) (Math.random() * 1000000000));
		StringBuilder sb = new StringBuilder();
		sb.append(numStr.substring(0, 3));
		sb.append("-");
		sb.append(numStr.substring(3, 5));
		sb.append("-");
		sb.append(numStr.substring(5));

		String result = sb.toString();

		try {
			Connection con = datasource.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			try {
				if (pointdao.isValidUser(userId)) { 
					if( pointdao.checkAccountNum(userId) == null ) { //생성해주기
						stmt.setString(1, result);
						stmt.setString(2, userId);
						stmt.executeUpdate();
					}else { 
						result = null;
					}
				} else {
					result = null;
				}
			} finally {
				stmt.close();
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 계좌 삭제
	public boolean deleteAccount(String userId) {
		String sql = "DELETE FROM Point WHERE userId = ?";
		boolean result = false;

		try {
			Connection con = datasource.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			try {
				if (pointdao.isValidUser(userId)) { 
					if( pointdao.checkAccountNum(userId) != null ) { 
						stmt.setString(1, userId);
						stmt.executeUpdate();
						System.out.println("계좌 삭제 완료");
						result = true;
					}
				}
			} finally {
				stmt.close();
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 계좌번호 조회 		
	public String checkAccountNum(String userId) {
		String sql = "SELECT accountNum FROM Point p INNER JOIN " +
				"Users u ON p.userId = u.userId WHERE u.userId = ?";
		String result = null;
		
		try {
			Connection con = datasource.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, userId);
			ResultSet rs = stmt.executeQuery();
			try {
				while (rs.next()) {
					String accountNum = rs.getString("accountNum");
					if(accountNum != null) { // 본인에게 계좌가 있다면
						result = accountNum;
					}
				}
			} finally {
				stmt.close();
				con.close();
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 사용자 아이디 존재 여부 확인(아이디 중복확인) 
	public boolean isValidUser(String userId) { 
		String sql = "SELECT userId FROM Users WHERE userId=?";
		boolean result = false;

		try {
			Connection con = datasource.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, userId);
			ResultSet rs = stmt.executeQuery();
			try {
				while (rs.next()) {
					String userid = rs.getString("userId");
					if (userid != null || userid.length() != 0) {
						result = true;
					}
				}
			} finally {
				stmt.close();
				con.close();
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 보유포인트 조회 		
	public String checkPoint(String userId) { 
		String sql = "SELECT point,accountNum FROM Point p INNER JOIN Users u ON p.userId = u.userId WHERE u.userId = ?";
		String result = "0";
		try {
			Connection con = datasource.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, userId);
			ResultSet rs = stmt.executeQuery();
			try {
				while (rs.next()) {
					String userPoint = rs.getString("point");
					result = userPoint;
				}
			} finally {
				stmt.close();
				con.close();
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 포인트 충전 					
	public boolean addPoint(String userId, long point) {
		String sql = "UPDATE Point SET point=? WHERE userId=?";
		boolean result = false;
		try {
			Connection con = datasource.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			try {
				long balance = Long.parseLong(pointdao.checkPoint(userId)); // 보유하고있는 point
				if ((balance * point) >= 0) { // x,y 둘다 양수라면
					stmt.setLong(1, balance + point);
					stmt.setString(2, userId);
					stmt.executeUpdate();
					result = true;
				} else {
					System.out.println("음수 입력으로 인한 실패");
					result = false;
				}
			} finally {
				stmt.close();
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 포인트 차감 (결제) 				
	public boolean minusPoint(String userId, String trainerPrice, String month) { 
		String sql = "UPDATE Point SET point=? WHERE userId=?";
		boolean result = false;

		try {
			Connection con = datasource.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			try {
				if ( pointdao.isValidUser(userId) ) {
					long x = Long.parseLong(pointdao.checkPoint(userId)); //사용자가 보유한 포인트
					long y = Long.parseLong(trainerPrice); // 트레이너 몸값
					long z = Long.parseLong(month); // 개월 수
					if( x-(y*z) >= 0) {
						stmt.setLong(1, x - (y*z) );
						stmt.setString(2, userId);
						stmt.executeUpdate();
						result = true;
					}else {
						//포인트 부족할 때
						result = false;
					}
				}else {
					//없는 아이디 입력했을 때
					result = false;
				}
			} finally {
				stmt.close();
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 싱글톤 받아주기
	public static PointDao getInstance() { 
		return pointdao;
	}
	
}
