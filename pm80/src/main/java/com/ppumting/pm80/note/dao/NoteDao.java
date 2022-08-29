package com.ppumting.pm80.note.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ppumting.pm80.note.domain.Note;
import com.ppumting.pm80.point.data.DataSource;
import com.ppumting.pm80.point.data.NamingService;

public class NoteDao {
	
	private static NoteDao instance = new NoteDao();
	
	public static NoteDao getInstance() {
		return instance;
	}
	
	NamingService namingService = NamingService.getInstance();
	DataSource datasource = (DataSource)namingService.getAttribute("dataSource");
	DataSource datasource2 = (DataSource)namingService.getAttribute("dataSource");
	
	
	//쪽지 보내기 기능
	public void addNote(Note note) {
		String sql = "INSERT INTO RcvNotes(sentid, userid, title, msg)"
				+ "VALUES(?, ?, ?, ?)";
		String sql2 = "INSERT INTO SendNotes(userid, recvid, title, msg)"
				+ "VALUES(?, ?, ?, ?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			Connection con2 = null;
			PreparedStatement pstmt2 = null;
			try {
				con = datasource.getConnection();
				con2 = datasource2.getConnection();
				
				pstmt = con.prepareStatement(sql);
				pstmt2 = con.prepareStatement(sql2);
				
				pstmt.setString(1, note.getSendUserId());
				pstmt.setString(2, note.getReceiveUserId());
				pstmt.setString(3, note.getTitle());
				pstmt.setString(4, note.getMsg());
				
				pstmt2.setString(1, note.getSendUserId());
				pstmt2.setString(2, note.getReceiveUserId());
				pstmt2.setString(3, note.getTitle());
				pstmt2.setString(4, note.getMsg());
				
				pstmt.executeUpdate();
				pstmt2.executeUpdate();
				System.out.println("addMsgComplete!");
			}finally {
				datasource.close(pstmt, con);
				datasource2.close(pstmt2, con2);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//보낸 쪽지 조회 기능
	public List<Note> findTitleSendNote(String sendUserId) {
		String sql = "SELECT no,title,msg,recvid,userid,sentDate From SendNotes WHERE userid = ?";
		ArrayList<Note> noteArray = new ArrayList<>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = datasource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sendUserId);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Note title = new Note();
					title.setNo(rs.getLong("no"));
					title.setTitle(rs.getString("title"));
					title.setReceiveUserId(rs.getString("recvid"));
					title.setSendUserId(rs.getString("userid"));
					title.setRegDate(rs.getDate("sentDate"));
					noteArray.add(title);
				}
				System.out.println("보낸 쪽지 Title을 모두 불러왔습니다.");
			}finally {
				datasource.close(rs, pstmt, con);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return noteArray;
	}
	
	//받은 쪽지 조회 기능
	public List<Note> findTitleReceiveNote(String sendUserId) {
		String sql = "SELECT no,title,msg,userid,sentid,sentDate From RcvNotes WHERE userid = ?";
		List<Note> noteArray = new ArrayList<>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = datasource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sendUserId);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Note title = new Note();
					title.setNo(rs.getLong("no"));
					title.setTitle(rs.getString("title"));
					title.setReceiveUserId(rs.getString("userid"));
					title.setSendUserId(rs.getString("sentid"));
					title.setRegDate(rs.getDate("sentDate"));
					noteArray.add(title);				}
				System.out.println("받은 쪽지 Title을 모두 불러왔습니다.");
			}finally {
				datasource.close(rs, pstmt, con);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return noteArray;
	}
	
	//쪽지 고유 번호로 받은 쪽지 내용 출력
	public Note viewRcvMsg(String getNo) {
		String sql = "SELECT no, sentid, userid, title, msg, sentDate, sendnote FROM RcvNotes WHERE no = ?";
		Note note = new Note();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = datasource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getNo);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					note.setNo(rs.getLong("no"));
					note.setSendUserId(rs.getString("sentid"));
					note.setReceiveUserId(rs.getString("userid"));
					note.setTitle(rs.getString("title"));
					note.setMsg(rs.getString("msg"));
					note.setRegDate(rs.getDate("sentDate"));
					note.setSendnote(rs.getBoolean("sendnote"));
				}
			}finally {
				datasource.close(rs, pstmt, con);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return note;
	}
	//쪽지 고유 번호로 보낸 쪽지 내용 출력
	public Note viewSendMsg(String getNo) {
		String sql = "SELECT no, userid, recvid, title, msg, sentDate, sendnote FROM SendNotes WHERE no = ?";
		Note note = new Note();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = datasource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getNo);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					note.setNo(rs.getLong("no"));
					note.setSendUserId(rs.getString("userid"));
					note.setReceiveUserId(rs.getString("recvid"));
					note.setTitle(rs.getString("title"));
					note.setMsg(rs.getString("msg"));
					note.setRegDate(rs.getDate("sentDate"));
					note.setSendnote(rs.getBoolean("sendnote"));
				}
			}finally {
				datasource.close(rs, pstmt, con);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return note;
	}
	// 보낸 쪽지 삭제 기능
	public void deleteSendNote(String no) {
		String sql = "DELETE FROM SendNotes WHERE no = ?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = datasource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, no);
				pstmt.executeUpdate();
				System.out.println("DeleteSendMsgComplete!");
			}finally {
				datasource.close(pstmt, con);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//받은 쪽지 삭제 기능
	public void deleteRcvNote(String no) {
		String sql = "DELETE FROM RcvNotes WHERE no = ?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = datasource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, no);
				pstmt.executeUpdate();
				System.out.println("DeleteRcvMsgComplete!");
			}finally {
				datasource.close(pstmt, con);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	// 로그인한 회원의 받은 쪽지 갯수
	public long countNote(String userId) {
		String sql = "SELECT COUNT(userId) FROM RcvNotes WHERE userId = ?";
		Note note = new Note();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = datasource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userId);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					note.setCount(rs.getLong(1));
				}
			}finally {
				datasource.close(rs, pstmt, con);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return note.getCount();
	}
}
