CREATE TABLE QNA (
	qna_no			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	user_id			VARCHAR(20)		NOT NULL,
	qna_title		VARCHAR(150)	NOT NULL,
	qna_content		VARCHAR(2000)	NOT NULL,
	qna_reg_date	TIMESTAMP		DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT QNA_user_id_FK FOREIGN KEY (user_id) REFERENCES Users(userId)
)AUTO_INCREMENT = 1;

SELECT * FROM QNA

DELETE FROM QNA WHERE qna_no = 9

drop table QNA
-- 외래키 선언 방법
-- CONSTRAINT QNA_user_number_FK FOREIGN KEY (user_number) REFERENCES Users(userId)

INSERT INTO QNA (user_id, qna_title, qna_content)
VALUES ('tjdgh7984', '왜', '안드가')

DELETE FROM QNA WHERE qna_no = 1

-- INSERT INTO QNA (name, ssn, phone, userId, pw, addr, aid)
-- VALUES('이태영', '970312', '010-2881-2498', 'lty', '1234', 'daegu', '1');

