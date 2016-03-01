REM ===================
REM Cancellare tabella users
REM ===================

DROP TABLE passeggeri;
DROP TABLE arrivi;
DROP TABLE partenze;
DROP TABLE aeroporti;
DROP TABLE voli;

REM ===================
REM Generare tabella users_type
REM ===================

CREATE TABLE aeroporti(
	nome 	VARCHAR2(10) NOT NULL,
	citta 	VARCHAR2(10) NOT NULL,
	sigla	CHAR(4) NOT NULL,
	CONSTRAINT siglaNome PRIMARY KEY(nome,sigla)
);


CREATE TABLE voli(
	id 		CHAR(5) PRIMARY KEY,
	sigla 	CHAR(7) ,
	aereo   VARCHAR2(10)
);

CREATE TABLE arrivi(
	nome_d		VARCHAR2(10),
	aereo_d		CHAR(4),
	volo 		CHAR(7),
	CONSTRAINT voliArrivi FOREIGN KEY(volo) REFERENCES voli(id),
	CONSTRAINT aereopArrivi FOREIGN KEY(nome_d,aereo_d) REFERENCES aeroporti(nome,sigla),
	PRIMARY KEY(nome_d,aereo_d,volo)
);

CREATE TABLE partenze(
	nome_p		VARCHAR2(10),
	aereo_p		CHAR(4),
	volo 		CHAR(7),
	FOREIGN KEY(volo) REFERENCES voli(id),
	FOREIGN KEY(nome_p,aereo_p) REFERENCES aeroporti(nome,sigla),
	PRIMARY KEY(nome_p,aereo_p,volo)
);

CREATE TABLE passeggeri(
	nome 	VARCHAR2(10) NOT NULL,
	cognome	VARCHAR2(10) NOT NULL,
	code	VARCHAR2(10) PRIMARY KEY,
	pasto	CHAR(1) DEFAULT('0'),
	posto	VARCHAR2(5) NOT NULL,
	volo	CHAR(7),
	CONSTRAINT vegetariano CHECK(pasto in (0,1)),
	CONSTRAINT voloSigla FOREIGN KEY(volo) REFERENCES voli(id) 
);

@tabelleSQL/aeroporti.sql
@tabelleSQL/voli.sql
@tabelleSQL/arrivi.sql
@tabelleSQL/partenze.sql
@tabelleSQL/passeggeri.sql

COMMIT;