package com.ppumting.pm80.replay.service;

import com.ppumting.pm80.replay.Dao.ReplayDao;
import com.ppumting.pm80.replay.domain.Replay;

public class ReplayService {
	private ReplayDao replayDao = ReplayDao.getInstance();
	
	public ReplayService() {
		
	}
	
	// replay 생성
	public void addReplay(Replay replay) {
		replayDao.insertReplay(replay);
	}
}
