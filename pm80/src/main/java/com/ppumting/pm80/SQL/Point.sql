CREATE TABLE Point(
	aid					BIGINT		PRIMARY KEY 	AUTO_INCREMENT,
	point				BIGINT		NOT NULL,
	accountNum			VARCHAR(11)	NOT NULL,
	userId				VARCHAR(16)		NOT NULL,
	CONSTRAINT Point_userId_FK FOREIGN KEY (userId) REFERENCES Users(userId)
) AUTO_INCREMENT = 1;


SELECT * FROM Point;
SELECT * FROM Users;

UPDATE Point SET point=5000000 WHERE userId='sssssg06';


DROP TABLE Point;


--test
INSERT INTO Point (point, accountNum, userId)
VALUES (10000, '103-25-6485', 'htw')

-- inner join
SELECT * FROM Account, Customer WHERE Account.customerId = Customer.cid
AND Customer.ssn = '981212-1111111';

INSERT INTO Point (name, ssn, phone, userId, pw, addr, aid)
VALUES('박상규', '980618', '010-3490-3180', 'psg', '1234', 'daegu', '2');

SELECT * FROM Point p INNER JOIN Users u ON p.userId = u.userId;
SELECT userId FROM Point p INNER JOIN Users u ON p.userId = u.userId WHERE u.userId = 'sssssg06';

DELETE FROM Point WHERE userId = 'qwer';



