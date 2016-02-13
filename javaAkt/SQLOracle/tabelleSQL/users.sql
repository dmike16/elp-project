REM ===================
REM Cancellare tabella users
REM ===================

DROP TABLE users;
DROP TABLE users_type;

REM ===================
REM Generare tabella users_type
REM ===================

CREATE TABLE users_type(
	user_type 	NUMBER(2) NOT NULL,
	description	VARCHAR2(20),
	CONSTRAINT userType PRIMARY KEY (user_type) 
);

CREATE TABLE users (
	id		NUMBER PRIMARY KEY,
	user_name	VARCHAR2(15) NOT NULL,
	password	VARCHAR2(15) NOT NULL,
	fullname	VARCHAR2(50),
	email		VARCHAR2(50),
	salary		NUMBER(6,2),
	user_type 	NUMBER(2),
	CONSTRAINT userTyperRef FOREIGN KEY (user_type) REFERENCES  users_type
);

@tabelleSQL/typefill.sql
@tabelleSQL/userfill.sql

COMMIT;