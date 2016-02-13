DROP TABLE Proprieta;
DROP TABLE Proprietari;
DROP TABLE Veicoli;
DROP TABLE Modelli;
DROP TABLE Fabbriche;
DROP TABLE Combustibili;
DROP TABLE Categorie_Auto;

CREATE TABLE Categorie_Auto
(
     Cod_categoria                 varchar2(2),
     Nome_categoria               varchar2(30),
     PRIMARY KEY(Cod_categoria)
);

CREATE TABLE Combustibili
(
       Cod_combustibile                   varchar2(2),
       Descrizione_combustibile       varchar2(30),
       PRIMARY KEY(Cod_combustibile)
);


CREATE TABLE Fabbriche
(
     Cod_fabbrica              varchar2(3),
     Nome_fabbrica           varchar2(30),
     PRIMARY KEY(Cod_fabbrica)
);

CREATE TABLE Modelli
(
     Cod_modello           varchar2(3),
     Nome_modello        varchar2(30),
     Numero_versioni     number,
     Cod_fabbrica          varchar2(3),
     PRIMARY KEY(Cod_modello),
     FOREIGN KEY (Cod_fabbrica) REFERENCES Fabbriche (Cod_fabbrica)
);

CREATE TABLE Veicoli
(
       Targa                       varchar2(8),
       Cilindrata                 number,
       Cavalli_fiscali           number,
       Velocita                    number,
       Posti                         number,
       Immatricolazione      date,
       Cod_categoria         varchar2(2),
       Cod_combustibile     varchar2(2),
       Cod_modello            varchar2(3),
       PRIMARY KEY (Targa),
       FOREIGN KEY (Cod_categoria) REFERENCES Categorie_Auto (Cod_categoria),
       FOREIGN KEY (Cod_combustibile) REFERENCES Combustibili (Cod_combustibile),
       FOREIGN KEY (Cod_modello) REFERENCES Modelli (Cod_modello)
);

CREATE TABLE Proprietari
(
       Cod_proprietario           varchar2(5),
       Cognome                       varchar2(30),
       Nome                             varchar2(30),
       Indirizzo                         varchar2(30),
       Provincia                        varchar2(2),
       PRIMARY KEY(Cod_proprietario)
);

CREATE TABLE Proprieta
(
      Targa_veicolo         varchar2(10),
      Cod_proprietario    varchar2(5),
      Data_acquisto        date,
      Data_vendita         date,
      PRIMARY KEY (Targa_veicolo,Cod_proprietario),
      FOREIGN KEY (Targa_veicolo) REFERENCES Veicoli (Targa),
      FOREIGN KEY (Cod_proprietario) REFERENCES Proprietari (Cod_proprietario)
);

INSERT INTO Categorie_Auto ( Cod_categoria, Nome_Categoria )
VALUES ('01', 'Autovettura');
INSERT INTO Categorie_Auto ( Cod_categoria, Nome_Categoria )
VALUES ('02', 'Rimorchio');
INSERT INTO Categorie_Auto ( Cod_categoria, Nome_Categoria )
VALUES ('03', 'Motociclo');
INSERT INTO Categorie_Auto ( Cod_categoria, Nome_Categoria )
VALUES ('04', 'Furgone');

INSERT INTO combustibili (Cod_combustibile, Descrizione_Combustibile)
VALUES ('01', 'Benzina');
INSERT INTO combustibili (Cod_combustibile, Descrizione_Combustibile)
VALUES ('02', 'Gasolio');
INSERT INTO combustibili (Cod_combustibile, Descrizione_Combustibile)
VALUES ('03', 'GPL');
INSERT INTO combustibili (Cod_combustibile, Descrizione_Combustibile)
VALUES ('04', 'Metano');

INSERT INTO fabbriche (Cod_fabbrica, Nome_fabbrica)
VALUES ('001','FIAT');
INSERT INTO fabbriche (Cod_fabbrica, Nome_fabbrica)
VALUES ('003','FORD');
INSERT INTO fabbriche (Cod_fabbrica, Nome_fabbrica)
VALUES ('004','PIAGGIO');
INSERT INTO fabbriche (Cod_fabbrica, Nome_fabbrica)
VALUES ('005','VOLVO');
INSERT INTO fabbriche (Cod_fabbrica, Nome_fabbrica)
VALUES ('006','RENAULT');
INSERT INTO fabbriche (Cod_fabbrica, Nome_fabbrica)
VALUES ('007','TOYOTA');
INSERT INTO fabbriche (Cod_fabbrica, Nome_fabbrica)
VALUES ('008','VOLKSWAGEN');
INSERT INTO fabbriche (Cod_fabbrica, Nome_fabbrica)
VALUES ('009','HONDA');

INSERT INTO modelli ( Cod_modello, Nome_modello, Numero_versioni, Cod_fabbrica )
VALUES ('001', 'panda', 3, '001');
INSERT INTO modelli ( Cod_modello, Nome_modello, Numero_versioni, Cod_fabbrica )
VALUES ('002', 'vespa', 4, '004');
INSERT INTO modelli ( Cod_modello, Nome_modello, Numero_versioni, Cod_fabbrica )
VALUES ('003', 'brava', 2, '001');
INSERT INTO modelli ( Cod_modello, Nome_modello, Numero_versioni, Cod_fabbrica )
VALUES ('004', 'mondeo', 3, '003');
INSERT INTO modelli ( Cod_modello, Nome_modello, Numero_versioni, Cod_fabbrica )
VALUES ('005', 'V-10', 2, '005');
INSERT INTO modelli ( Cod_modello, Nome_modello, Numero_versioni, Cod_fabbrica )
VALUES ('006', 'ducato', 5, '001');
INSERT INTO modelli ( Cod_modello, Nome_modello, Numero_versioni, Cod_fabbrica )
VALUES ('007', 'clio', 5, '006');
INSERT INTO modelli ( Cod_modello, Nome_modello, Numero_versioni, Cod_fabbrica )
VALUES ('008', 'corolla', 4, '007');
INSERT INTO modelli ( Cod_modello, Nome_modello, Numero_versioni, Cod_fabbrica )
VALUES ('009', 'coupe', 1, '001');
INSERT INTO modelli ( Cod_modello, Nome_modello, Numero_versioni, Cod_fabbrica )
VALUES ('010', 'golf', 4, '008');
INSERT INTO modelli ( Cod_modello, Nome_modello, Numero_versioni, Cod_fabbrica )
VALUES ('011', 'megane', 2, '006');
INSERT INTO modelli ( Cod_modello, Nome_modello, Numero_versioni, Cod_fabbrica )
VALUES ('012', 'seicento', 2, '001');
INSERT INTO modelli ( Cod_modello, Nome_modello, Numero_versioni, Cod_fabbrica )
VALUES ('013', 'laguna', 2, '006');
INSERT INTO modelli ( Cod_modello, Nome_modello, Numero_versioni, Cod_fabbrica )
VALUES ('014', 'civic', 3, '009');

INSERT INTO veicoli ( Targa, Cilindrata, Cavalli_fiscali, Velocita, Posti, Immatricolazione, Cod_categoria, Cod_combustibile, Cod_modello )
VALUES ('A123456X', 1796, 85, 195, 5, to_date('1998-12-30','YYYY-MM-DD'), '01', '01', '004');
INSERT INTO veicoli ( Targa, Cilindrata, Cavalli_fiscali, Velocita, Posti, Immatricolazione, Cod_categoria, Cod_combustibile, Cod_modello )
VALUES ('B256787Y', 708, 10, 120, 5, to_date('1989-09-21','YYYY-MM-DD'), '01', '02', '001');
INSERT INTO veicoli ( Targa, Cilindrata, Cavalli_fiscali, Velocita, Posti, Immatricolazione, Cod_categoria, Cod_combustibile, Cod_modello )
VALUES ('C76589AG', 1106, 54, 130, 5, to_date('1998-08-13','YYYY-MM-DD'), '01', '01', '001');
INSERT INTO veicoli ( Targa, Cilindrata, Cavalli_fiscali, Velocita, Posti, Immatricolazione, Cod_categoria, Cod_combustibile, Cod_modello )
VALUES ('C78905GT', 1998, 117, 212, 4, to_date('1994-11-06','YYYY-MM-DD'), '01', '01', '009');
INSERT INTO veicoli ( Targa, Posti, Immatricolazione, Cod_categoria, Cod_combustibile, Cod_modello )
VALUES ('C845905Z', 3, to_date('1995-04-11','YYYY-MM-DD'), '04', '03', '006');
INSERT INTO veicoli ( Targa, Cilindrata, Cavalli_fiscali, Velocita, Posti, Immatricolazione, Cod_categoria, Cod_combustibile, Cod_modello )
VALUES ('CFT340VB', 1390, 75, 170, 5, to_date('1995-01-12','YYYY-MM-DD'), '01', '02', '007');
INSERT INTO veicoli ( Targa, Posti, Immatricolazione, Cod_categoria, Cod_combustibile, Cod_modello )
VALUES ('D239765W', 2, to_date('1997-08-12','YYYY-MM-DD'), '03', '01', '002');
INSERT INTO veicoli ( Targa, Cilindrata, Cavalli_fiscali, Posti, Immatricolazione, Cod_categoria, Cod_combustibile, Cod_modello )
VALUES ('DD4567XX', 1581, 17, 5, to_date('1997-06-05','YYYY-MM-DD'), '01', '01', '003');
INSERT INTO veicoli ( Targa, Cilindrata, Cavalli_fiscali, Velocita, Posti, Immatricolazione, Cod_categoria, Cod_combustibile, Cod_modello )
VALUES ('DGH789JC', 1590, 114, 170, 5, to_date('1995-10-05','YYYY-MM-DD'), '01', '02', '014');
INSERT INTO veicoli ( Targa, Cilindrata, Cavalli_fiscali, Velocita, Posti, Cod_categoria, Cod_combustibile, Cod_modello )
VALUES ('DH79567H', 1589, 107, 170, 5, '01', '04', '011');
INSERT INTO veicoli ( Targa, Cilindrata, Cavalli_fiscali, Velocita, Posti, Immatricolazione, Cod_categoria, Cod_combustibile, Cod_modello )
VALUES ('ERG567NM', 1598, 107, 175, 5, to_date('1997-12-18','YYYY-MM-DD'), '01', '04', '013');
INSERT INTO veicoli ( Targa, Cilindrata, Cavalli_fiscali, Velocita, Posti, Immatricolazione, Cod_categoria, Cod_combustibile, Cod_modello )
VALUES ('F96154NH', 1781, 125, 185, 5, to_date('1992-03-08','YYYY-MM-DD'), '01', '03', '010');
INSERT INTO veicoli ( Targa, Cilindrata, Cavalli_fiscali, Velocita, Posti, Immatricolazione, Cod_categoria, Cod_combustibile, Cod_modello )
VALUES ('FGH673FV', 899, 39, 140, 5, to_date('1998-08-09','YYYY-MM-DD'), '01', '01', '012');
INSERT INTO veicoli ( Targa, Cilindrata, Cavalli_fiscali, Velocita, Posti, Immatricolazione, Cod_categoria, Cod_combustibile, Cod_modello )
VALUES ('XCH56GJK', 1918, 110, 210, 5, to_date('1998-09-04','YYYY-MM-DD'), '01', '01', '005');
INSERT INTO veicoli ( Targa, Cilindrata, Cavalli_fiscali, Velocita, Posti, Immatricolazione, Cod_categoria, Cod_combustibile, Cod_modello )
VALUES ('XF5789CY', 1587, 107, 175, 5, to_date('1996-05-05','YYYY-MM-DD'), '01', '01', '008');
INSERT INTO veicoli ( Targa, Cilindrata, Cavalli_fiscali, Velocita, Posti, Immatricolazione, Cod_categoria, Cod_combustibile, Cod_modello )
VALUES ('AS508FH', 1796, 85, 195, 5, to_date('1998-12-30','YYYY-MM-DD'), '01', '01', '004');

INSERT INTO proprietari VALUES('01','Spoldi','Diego','Via Giovanni XXIII, 12','MI');
INSERT INTO proprietari VALUES('02','Cattaneo','Luca','Via del Capanno, 12','LO');
INSERT INTO proprietari VALUES('03','Calcaterra','Giovanni','Via Ferretti, 12','LO');
INSERT INTO proprietari VALUES('04','Spoldi','Simona','Via Croce, 12','LO');
INSERT INTO proprietari VALUES('05','Spoldi','Diego','Via S.Angelo, 11','LO');
INSERT INTO proprietari VALUES('06','Bernocchi','Giuseppina','Via Pascoli, 1','LO');
INSERT INTO proprietari VALUES('07','Cottarelli','Cristian','Via Cannero, 18','MI');

/*
Inseriti 3 proprietari che si sono susseguiti per auto con 
targa AS508FH per query_05
*/

INSERT INTO proprieta VALUES ('AS508FH','01',to_date('1994-06-20','YYYY-MM-DD'),to_date('2001-12-13','YYYY-MM-DD'));
INSERT INTO proprieta VALUES ('AS508FH','02',to_date('2001-12-14','YYYY-MM-DD'),to_date('2002-12-13','YYYY-MM-DD'));
INSERT INTO proprieta VALUES ('AS508FH','03',to_date('2002-12-14','YYYY-MM-DD'),to_date('2003-12-13','YYYY-MM-DD'));

/*
Ai proprietari 04 Spoldi Simona e 05 Spoldi Diego vengono attribuite
piu' di 10 autovetture per query_27. (Ogni volta che 04 vende una 
macchina 05 la acquista il giorno successivo)
*/


INSERT INTO proprieta VALUES ('A123456X','04',to_date('1994-06-20','YYYY-MM-DD'),to_date('2001-12-13','YYYY-MM-DD'));
INSERT INTO proprieta VALUES ('A123456X','05',to_date('2001-12-14','YYYY-MM-DD'),to_date('2002-12-13','YYYY-MM-DD'));

INSERT INTO proprieta VALUES ('B256787Y','04',to_date('2001-12-14','YYYY-MM-DD'),to_date('2002-12-13','YYYY-MM-DD'));
INSERT INTO proprieta VALUES ('B256787Y','05',to_date('2002-12-14','YYYY-MM-DD'),to_date('2003-12-13','YYYY-MM-DD'));

INSERT INTO proprieta VALUES ('C76589AG','04',to_date('2002-12-14','YYYY-MM-DD'),to_date('2003-12-13','YYYY-MM-DD'));
INSERT INTO proprieta VALUES ('C76589AG','05',to_date('2003-12-14','YYYY-MM-DD'),to_date('2004-12-13','YYYY-MM-DD'));

INSERT INTO proprieta VALUES ('XF5789CY','04',to_date('2003-12-14','YYYY-MM-DD'),to_date('2004-12-13','YYYY-MM-DD'));
INSERT INTO proprieta VALUES ('XF5789CY','05',to_date('2004-12-14','YYYY-MM-DD'),to_date('2005-12-13','YYYY-MM-DD'));

INSERT INTO proprieta VALUES ('C78905GT','04',to_date('2004-12-14','YYYY-MM-DD'),to_date('2005-12-13','YYYY-MM-DD'));
INSERT INTO proprieta VALUES ('C78905GT','05',to_date('2005-12-14','YYYY-MM-DD'),to_date('2006-12-13','YYYY-MM-DD'));

INSERT INTO proprieta VALUES ('C845905Z','04',to_date('2005-12-14','YYYY-MM-DD'),to_date('2006-12-13','YYYY-MM-DD'));
INSERT INTO proprieta VALUES ('C845905Z','05',to_date('2006-12-14','YYYY-MM-DD'),to_date('2007-12-13','YYYY-MM-DD'));

INSERT INTO proprieta VALUES ('CFT340VB','04',to_date('2006-12-14','YYYY-MM-DD'),to_date('2007-12-13','YYYY-MM-DD'));
INSERT INTO proprieta VALUES ('CFT340VB','05',to_date('2007-12-14','YYYY-MM-DD'),to_date('2008-01-13','YYYY-MM-DD'));

INSERT INTO proprieta VALUES ('D239765W','04',to_date('2007-12-14','YYYY-MM-DD'),to_date('2008-01-13','YYYY-MM-DD'));
INSERT INTO proprieta VALUES ('D239765W','05',to_date('2008-01-14','YYYY-MM-DD'),to_date('2008-03-13','YYYY-MM-DD'));

INSERT INTO proprieta VALUES ('DD4567XX','04',to_date('2008-01-14','YYYY-MM-DD'),to_date('2008-03-13','YYYY-MM-DD'));
INSERT INTO proprieta VALUES ('DD4567XX','05',to_date('2008-03-14','YYYY-MM-DD'),to_date('2008-05-13','YYYY-MM-DD'));

INSERT INTO proprieta VALUES ('DGH789JC','04',to_date('2008-03-14','YYYY-MM-DD'),to_date('2008-05-13','YYYY-MM-DD'));
INSERT INTO proprieta VALUES ('DGH789JC','05',to_date('2008-05-14','YYYY-MM-DD'),to_date('2008-07-13','YYYY-MM-DD'));

INSERT INTO proprieta VALUES ('DH79567H','04',to_date('2008-05-14','YYYY-MM-DD'),to_date('2008-07-13','YYYY-MM-DD'));
INSERT INTO proprieta VALUES ('DH79567H','05',to_date('2008-07-14','YYYY-MM-DD'),to_date('2008-09-13','YYYY-MM-DD'));



INSERT INTO proprieta VALUES ('ERG567NM','06',to_date('1999-10-11','YYYY-MM-DD'),to_date('2007-05-23','YYYY-MM-DD'));
INSERT INTO proprieta VALUES ('F96154NH','07',to_date('2000-03-15','YYYY-MM-DD'),to_date('2008-09-16','YYYY-MM-DD'));
INSERT INTO proprieta VALUES ('FGH673FV','07',to_date('1995-02-28','YYYY-MM-DD'),to_date('2005-12-25','YYYY-MM-DD'));
INSERT INTO proprieta VALUES ('XCH56GJK','04',to_date('1994-02-27','YYYY-MM-DD'),to_date('2001-04-13','YYYY-MM-DD'));

COMMIT;