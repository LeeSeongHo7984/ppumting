package com.ppumting.pm80.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import com.ppumting.pm80.qna.domain.Qna;
import com.ppumting.pm80.qna.service.DataSource;
import com.ppumting.pm80.qna.service.NamingService;
import com.ppumting.pm80.replay.domain.Replay;

public class QnaDao {
	private static QnaDao instance = new QnaDao(); 
	
	public static QnaDao getInstance() {
		return instance;
	}
	
	NamingService namingService = NamingService.getInstance();
	DataSource datasource = (DataSource)namingService.getAttribute("dataSource");
	
	
	// 게시판
	
	// 게시물 생성 메소드
	public void insertQna(Qna qna) {
		String sql = "INSERT INTO QNA (user_id, qna_title, qna_content)"
					+ "VALUES(?, ?, ?)";
		try {
			Connection con = null; 
			PreparedStatement pstmt = null;
			try {
				con = datasource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, qna.getUserId());;
				pstmt.setString(2, qna.getQnaTitle());
				pstmt.setString(3, qna.getQnaContent());
				pstmt.executeUpdate();
			} finally {
				datasource.close(pstmt,con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//게시글 조회 메소드
	public List<Qna> findNoQna() {
		String sql = "SELECT * FROM Qna";
		List<Qna> qnaList = new ArrayList<>();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		try {
			con = datasource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Qna qna = new Qna();
				qna.setQnaNo(rs.getString("qna_no"));
				qna.setUserId(rs.getString("user_id"));
				qna.setQnaTitle(rs.getString("qna_title"));
				qna.setQnaContent(rs.getString("qna_content"));
				qna.setQnaRegDate(rs.getDate("qna_reg_date"));
				qnaList.add(qna);
			}
		} finally {
			datasource.close(rs, pstmt, con);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qnaList;
	}

	// 고유번호로 게시글 데이터 정보 출력
	public Qna viewQna(String QnaNo) {
		String sql = "SELECT qna_no, qna_title, qna_content, user_id, qna_reg_date"
				+ " FROM Qna"
				+ " WHERE qna_no = ?";
		Qna qna = new Qna();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = datasource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, QnaNo);
				rs = pstmt.executeQuery();
				
				while( rs.next()) {
					qna.setQnaNo(rs.getString("qna_no"));
					qna.setQnaTitle(rs.getString("qna_title"));
					qna.setQnaContent(rs.getString("qna_content"));
					qna.setUserId(rs.getString("user_id"));
					qna.setQnaRegDate(rs.getDate("qna_reg_date"));
				}
			} finally {
				datasource.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qna;
	}
	
	// 게시판 수정
		public void findModifyQna(Qna qna) {
			String sql = "UPDATE QNA SET qna_title = ?, qna_content = ? WHERE qna_no = ?";
				try {
					Connection con = null;
					PreparedStatement pstmt = null;
					try {
						con = datasource.getConnection();
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, qna.getQnaTitle());
						pstmt.setString(2, qna.getQnaContent());
						pstmt.setString(3, qna.getQnaNo());
						pstmt.executeUpdate();
					} finally {
						datasource.close(pstmt, con);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	// 게시글번호를 이용한 게시글 삭제
	public boolean deleteQna(String qnaNo) {
		String sql = "DELETE FROM QNA WHERE qna_no = ?";
		boolean result = false;
		
		try {
			Connection con = datasource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			try {
				pstmt.setString(1, qnaNo);
				pstmt.executeUpdate(); // 쿼리문 DELETE , INSERT 사용할때 executeUpdate() 사용
				result = true;
			} finally {
				datasource.close(pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}