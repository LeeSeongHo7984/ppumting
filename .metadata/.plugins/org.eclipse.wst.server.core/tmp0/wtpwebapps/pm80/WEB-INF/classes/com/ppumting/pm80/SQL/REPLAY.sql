CREATE TABLE REPLAY(
	replay_no			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	replay_content		VARCHAR(4000)	NOT NULL,
	replay_reg_date		TIMESTAMP		DEFAULT CURRENT_TIMESTAMP,
	qna_no				BIGINT			NOT NULL
);

SELECT * FROM REPLAY;

DROP TABLE REPLAY;

-- INSERT INTO Users (name, ssn, phone, userId, pw, addr, aid)
-- VALUES('이태영', '970312', '010-2881-2498', 'lty', '1234', 'daegu', '1');

