package com.ppumting.pm80.trainer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ppumting.pm80.point.data.DataSource;
import com.ppumting.pm80.point.data.NamingService;
import com.ppumting.pm80.trainer.domain.Trainer;

public class TrainerDao {
	private static TrainerDao instance = new TrainerDao();

	public static TrainerDao getInstance() {
		return instance;
	}

	NamingService namingService = NamingService.getInstance();
	DataSource datasource = (DataSource)namingService.getAttribute("dataSource");
	
	public TrainerDao() {
		
	}

     public void addTrainer(Trainer trainer) {
    	 System.out.println("START addTrainer!");
         String sql = "INSERT INTO Trainer(trainerId, name, ssn, phone, passwd, addr, price)"
                  + "VALUES(?, ?, ?, ?, ?, ?, ?)";

         try {
            Connection con = null;
            PreparedStatement  pstmt = null;
            try {
               con = datasource.getConnection();
               pstmt = con.prepareStatement(sql);
               pstmt.setString(1, trainer.getTrainerId());
               pstmt.setString(2, trainer.getName());
               pstmt.setString(3, trainer.getSsn());
               pstmt.setString(4, trainer.getPhone());
               pstmt.setString(5, trainer.getPasswd());
               pstmt.setString(6, trainer.getAddr());
               pstmt.setString(7, trainer.getPrice());
               pstmt.executeUpdate();
               System.out.println("END addTrainer!");
            } finally{
            	datasource.close(pstmt,con);
            	System.out.println("NEW Trainer Registration");
            }

         } catch (Exception e) {
            e.printStackTrace();
         }
      }

     public List<Trainer> findAllTrainers() {
         String sql = "SELECT * FROM Trainer";

         List<Trainer> trainerList = new ArrayList<>();

         try {
            Connection con = null;
            PreparedStatement  pstmt = null;
            ResultSet rs = null;
            try {
               con = datasource.getConnection();
               pstmt = con.prepareStatement(sql);
               rs = pstmt.executeQuery();
               while(rs.next()) {
            	   Trainer t = new Trainer();
            	   t.setTrainerId(rs.getString("trainerId"));
            	   t.setName(rs.getString("name"));
            	   t.setPasswd(rs.getString("passwd"));
            	   t.setSsn(rs.getString("ssn"));
            	   trainerList.add(t);
               }
            } finally{
            	datasource.close(rs, pstmt,con);
            }

            System.out.println("Find Trainer");
         } catch (Exception e) {
            e.printStackTrace();
         }
		return trainerList;
      }

	public boolean isValidTrainers(String trainerId, String passwd) {
	    String sql = "SELECT trainerId, passwd FROM Trainer WHERE trainerId = ?";

        try {
           Connection con = null;
           PreparedStatement pstmt = null;
           ResultSet rs = null;
           try {
              con = datasource.getConnection();
              pstmt = con.prepareStatement(sql);
              pstmt.setString(1, trainerId);
              rs = pstmt.executeQuery();

              Trainer trainerInfo = new Trainer();
              while(rs.next()) {
           	   trainerInfo.setTrainerId(rs.getString("trainerId"));
           	   trainerInfo.setPasswd(rs.getString("passwd"));
              }
              if(trainerId.equals(trainerInfo.getTrainerId()) && passwd.equals(trainerInfo.getPasswd())) {
            	  return true;
              }else {
            	  return false;
              }
           } finally{
           	datasource.close(rs, pstmt,con);
           }
        } catch (Exception e) {
           e.printStackTrace();
        }
		return false;
	}
	
	public String checkTrainerPoint(String trainerId) {
		String sql = "SELECT price FROM Trainer WHERE trainerId = ?";
		String result = "없는 트레이너";
		try {
			Connection con = datasource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, trainerId);
			ResultSet rs = pstmt.executeQuery();
			try {
				while(rs.next()) {
					result = rs.getString("price");
				}
			} finally {
				datasource.close(rs, pstmt, con); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;	
	}

	public boolean login(String trainerId, String passwd) {
		String sql = "SELECT trainerId, passwd FROM Trainer WHERE trainerId = ?";
		boolean loginResult = false;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = datasource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, trainerId);
				rs = pstmt.executeQuery();
				Trainer trainer= new Trainer();
				while(rs.next()) {
					trainer.setTrainerId(rs.getString("trainerId"));
					trainer.setPasswd(rs.getString("passwd"));
					if(trainerId.equals(trainer.getTrainerId()) && passwd.equals(trainer.getPasswd())) {
						loginResult = true;
					}else {
						loginResult = false;
					}
				}
			} finally {
				datasource.close(rs, pstmt, con); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginResult;	
	}

	public void delete(String trainerId, String passwd) {
		String sql = "DELETE FROM Trainer WHERE trainerId = ?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = datasource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, trainerId);
				pstmt.executeUpdate();
			} finally {
				datasource.close(pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Trainer trainerSelect(String trainerId) {
		String sql = "SELECT * FROM Trainer WHERE trainerId = ?";
		Trainer trainer = new Trainer();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = datasource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, trainerId);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					trainer.setTrainerId(rs.getString("trainerId"));
					trainer.setPasswd(rs.getString("passwd"));
					trainer.setName(rs.getString("name"));
					trainer.setAddr(rs.getString("addr"));
					trainer.setSsn(rs.getString("ssn"));
					trainer.setPhone(rs.getString("phone"));
				}
			} finally {
				datasource.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trainer;
	}
	
	public boolean checkTrainer(String trainerId) {
		String sql = "SELECT trainerId FROM Trainer WHERE trainerId = ? ";
		boolean checkResult = false;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = datasource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, trainerId);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Trainer trainer = new Trainer();
					trainer.setTrainerId(rs.getString("trainerId"));
					if(trainerId.equals(trainer.getTrainerId())) {
						checkResult = true;
					}
				}
			} finally {
				datasource.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkResult;
	}
	
	public void updateTrainer(Trainer trainer) {
		String sql = "UPDATE Trainer SET passwd = ?, name = ?, phone = ?, addr = ? WHERE trainerId = ?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = datasource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, trainer.getPasswd());
				pstmt.setString(2, trainer.getName());
				pstmt.setString(3, trainer.getPhone());
				pstmt.setString(4, trainer.getAddr());
				pstmt.setString(5, trainer.getTrainerId());
				pstmt.executeUpdate();
			} finally {
				datasource.close(pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
