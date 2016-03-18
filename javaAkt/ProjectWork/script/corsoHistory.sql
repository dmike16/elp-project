REM ======================
REM 	Creazione Tabelle 
REM 	Corso history
REM ======================= 

CREATE TABLE CorsoHistory(
	idcorso		CHAR(7),
	idrisora	VARCHAR2(3),
	CONSTRAINT rifCorso FOREIGN KEY(idcorso) REFERENCES Corso,
	CONSTRAINT rifCandidato FOREIGN KEY(idrisorsa) REFERENCES Risorsa,
	CONSTRAINT corsoCandidato PRIMARY KEY(idcorso,idrisorsa)
);
