CREATE TABLE Users (
	name VARCHAR(20) NOT NULL,
	ssn VARCHAR(7) NOT NULL,
	phone VARCHAR(13) NOT NULL,
	userId VARCHAR(16)  PRIMARY KEY,
	pw VARCHAR(20) NOT NULL,
	addr VARCHAR(100) NOT NULL
);

SELECT * FROM Users;


DROP TABLE Users;

DELETE FROM Users WHERE userId = wed456;

INSERT INTO Users (name, ssn, phone, userId, pw, addr)
VALUES('이태영', '970312', '010-2881-2498', 'lty', '1234', 'daegu');

INSERT INTO Users (name, ssn, phone, userId, pw, addr)
VALUES('이성호', '930418', '010-2503-4372', 'tjdgh7984', '1234', 'daegu');
