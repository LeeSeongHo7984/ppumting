package com.ppumting.pm80.note.service;


import java.util.List;

import com.ppumting.pm80.note.dao.NoteDao;
import com.ppumting.pm80.note.domain.Note;

public class NoteService {
	
	private NoteDao noteDao = NoteDao.getInstance();
	
	private static NoteService instance = new NoteService();
	
	public static NoteService getInstance() {
		return instance;
	}
	
	public void sendNote(Note note) {
		noteDao.addNote(note);
	}

	public List<Note> findSendNote(String sendUserId) {
		return noteDao.findTitleSendNote(sendUserId);
		
	}

	public List<Note> findReceiveNote(String sendUserId) {
		return noteDao.findTitleReceiveNote(sendUserId);
	}

	public Note viewRcvMsg(String getNo) {
		return noteDao.viewRcvMsg(getNo);
		
	}
	
	public Note viewSendMsg(String getNo) {
		return noteDao.viewSendMsg(getNo);
		
	}

	public void deleteSendNote(String no) {
		noteDao.deleteSendNote(no);
		
	}
	
	public void deleteRcvNote(String no) {
		noteDao.deleteRcvNote(no);
		
	}

	public long countNote(String userId) {
		return noteDao.countNote(userId);
		
	}
	
}
