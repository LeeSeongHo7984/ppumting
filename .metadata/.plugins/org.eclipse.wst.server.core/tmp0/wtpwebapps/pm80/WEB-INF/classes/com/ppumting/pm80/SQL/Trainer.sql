CREATE TABLE Trainer (
	trainerId	 	VARCHAR(20) PRIMARY KEY,
	name			VARCHAR(20) NOT NULL,
	ssn 			VARCHAR(7) 	NOT NULL,
	phone 			VARCHAR(13) NOT NULL,
	passwd			VARCHAR(20) NOT NULL,
	addr 			VARCHAR(25) NOT NULL,
	price			BIGINT		NOT NULL
)AUTO_INCREMENT = 1;
	-- CONSTRAINT Trainers_aid_FK FOREIGN KEY (aid) REFERENCES Point(aid)

-- ALTER TABLE Trainers ADD CONSTRAINT Trainers_aid_FK FOREIGN KEY (aid) REFERENCES Point(aid);

ALTER TABLE Trainer MODIFY Price MEDIUMTEXT;

SELECT * FROM Trainer;
DROP TABLE Trainer;
DELETE FROM Trainer WHERE trainerId = 'admin1';

INSERT INTO Trainer (name, ssn, phone, trainerId, passwd, addr, price)
VALUES('마동석', '950512', '010-1212-1212', 'pt1', '1234', 'daegu', 300000);

UPDATE Trainer SET ssn='961025', phone='01077777777' WHERE trainerId='pt1';
