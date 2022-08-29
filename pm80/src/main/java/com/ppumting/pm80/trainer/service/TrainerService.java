package com.ppumting.pm80.trainer.service;

import java.util.List;

import com.ppumting.pm80.trainer.dao.TrainerDao;
import com.ppumting.pm80.trainer.domain.Trainer;

public class TrainerService {
	private static TrainerService instance = new TrainerService(); //싱글톤
	private TrainerDao trainerDao = TrainerDao.getInstance();
	
	public static TrainerService getInstance() {
		return instance;
	}

	public void addTrainer(Trainer trainer) {
		trainerDao.addTrainer(trainer);
	}
	
	public String checkTrainerPoint(String trainerId) {
		return trainerDao.checkTrainerPoint(trainerId);
	}

	public List<Trainer> findAllTrainers() {
		return trainerDao.findAllTrainers();
	}

	public boolean isValidTrainers(String trainerId, String passwd) {
		return trainerDao.isValidTrainers(trainerId, passwd);
	}

	public boolean login(String trainerId, String passwd) {
		return trainerDao.login(trainerId, passwd);
	}
	
	public void delete(String trainerId, String passwd) {
		trainerDao.delete(trainerId, passwd);
	}

	public boolean checkTrainer(String trainerId) {
		return trainerDao.checkTrainer(trainerId);
	}

	public Trainer trainerSelect(String trainerId) {
		return trainerDao.trainerSelect(trainerId);
	}
	
	public void updateTrainer(Trainer trainer) {
		trainerDao.updateTrainer(trainer);
	}
}
