REM =================
REM Genera tabella libri
REM =================

DROP TABLE Libri;

CREATE TABLE Libri(
	id_libro 		NUMBER(3) ,
	titolo_libro	VARCHAR2(50),
	nome_autore		VARCHAR2(50),
	prezzo_libro	NUMBER(5),	
	CONSTRAINT id_unico PRIMARY KEY(id_libro)
);
