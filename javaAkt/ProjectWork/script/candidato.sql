REM ======================
REM 	Creazione Tabelle 
REM   		Candidato
REM ======================= 

CREATE TABLE Candidato(
	idcandidato		VARCHAR2(5),
	idanagrafica	NUMBER(6),
	idrisorsa 		VARCHAR2(3),
	idcv			NUMBER(6),
	CONSTRAINT idprimary PRIMARY KEY(idcandidato),
	CONSTRAINT	refrisorsa FOREIGN KEY(idrisorsa) REFERENCES Risorsa,
	CONSTRAINT refcv FOREIGN KEY(idcv) REFERENCES Cv,
	CONSTRAINT refanagrafica FOREIGN KEY(idanagrafica) REFERENCES AnagraficaCandidato
);

