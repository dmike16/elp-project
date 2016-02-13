DROP TABLE OrdArt;
DROP TABLE Ordini;
DROP TABLE Negozi;
DROP TABLE Compart;
DROP TABLE Componenti;
DROP TABLE Laboratori;
DROP TABLE Articoli;
DROP TABLE Categorie;

CREATE TABLE Categorie
(   Cat_Cod            CHAR(3) NOT NULL,
Cat_Descrizione    VARCHAR2(40),
PRIMARY KEY (Cat_Cod)
);

CREATE TABLE Articoli
(   Art_Cod             CHAR(4) NOT NULL,
Cat_Cod             CHAR(3) NOT NULL,
Art_Descrizione     VARCHAR2(40),
Art_Prezzo          NUMBER(6,2),
Art_IVA             NUMBER(3),
Art_Spese_Trasporto NUMBER(9),
PRIMARY KEY (Art_Cod),
FOREIGN KEY (Cat_Cod)
REFERENCES Categorie
);

CREATE TABLE Laboratori
(   Lab_Cod            CHAR(4) NOT NULL,
Lab_Indirizzo      VARCHAR2(40),
Lab_Citta          VARCHAR2(15),
Lab_Telefono       VARCHAR2(20),
PRIMARY KEY (Lab_Cod)
);

CREATE TABLE Componenti
(   Com_Cod            CHAR(4) NOT NULL,
Com_Descrizione    VARCHAR2(40),
Com_Costo          NUMBER(6,2),
Lab_Cod            CHAR(4),
PRIMARY KEY (Com_Cod),
FOREIGN KEY (Lab_Cod)
REFERENCES Laboratori
);

CREATE TABLE CompArt
(   Art_Cod            CHAR(4) NOT NULL,
Com_Cod            CHAR(4) NOT NULL,
CompArt_Qta        NUMBER(4) NOT NULL,
PRIMARY KEY (Art_Cod, Com_Cod),
FOREIGN KEY (Com_Cod)
REFERENCES Componenti,
FOREIGN KEY (Art_Cod)
REFERENCES Articoli
);

CREATE TABLE Negozi
(   Neg_Cod            CHAR(4) NOT NULL,
Neg_Nome           VARCHAR2(20),
Neg_Indirizzo      VARCHAR2(40),
Neg_Citta          VARCHAR2(15),
Neg_Telefono          VARCHAR2(20),
PRIMARY KEY (Neg_Cod)
);

CREATE TABLE Ordini
(Ord_Cod           CHAR(6) NOT NULL,
Neg_Cod            CHAR(4) NOT NULL,
Ord_Data           DATE,
PRIMARY KEY (Ord_Cod),
FOREIGN KEY (Neg_Cod)
REFERENCES Negozi
);

CREATE TABLE OrdArt
(   Ord_Cod            CHAR(6) NOT NULL,
Art_Cod            CHAR(4) NOT NULL,
OrdArt_Qta         NUMBER(4) NOT NULL,
PRIMARY KEY (Art_Cod, Ord_Cod),
FOREIGN KEY (Ord_Cod)
REFERENCES Ordini,
FOREIGN KEY (Art_Cod)
REFERENCES Articoli
);

INSERT INTO Categorie VALUES ('L10', 'Libreria');
INSERT INTO Categorie VALUES ('M10', 'Mobile');
INSERT INTO Categorie VALUES ('M20', 'Armadio');
INSERT INTO Categorie VALUES ('T10', 'Tavolo');

INSERT INTO Articoli VALUES (
'L100', 'L10', 'Libreria 100 cm x 120 cm', 475.00, 20, 48.00);
INSERT INTO Articoli VALUES (
'L200', 'L10', 'Libreria 200 cm x 120 cm 950', 950.00, 20, 95.00);
INSERT INTO Articoli VALUES ('L300', 'L10', 'Libreria 100 cm x 120 cm', 475.00, 20, 48.00);
INSERT INTO Articoli VALUES ('L400', 'L10', 'Libreria 200 cm x 120 cm 950', 950.00, 20, 95.00);
INSERT INTO Articoli VALUES ('M_40', 'M20', 'Armadio 2 ante 200 cm x 120 cm', 810.00, 20, 85.00);
INSERT INTO Articoli VALUES ('M_50', 'M20', 'Armadio 4 ante 200 cm x 240 cm', 149.00, 20, 150.00);
INSERT INTO Articoli VALUES ('M100', 'M10', 'Mobile 1 anta 100 cm x 60 cm', 390.00, 20, 39.00);
INSERT INTO Articoli VALUES ('M200', 'M10', 'Mobile 2 ante 100 cm x 120 cm', 720.00, 20, 72.00);
INSERT INTO Articoli VALUES ('M300', 'M10', 'Mobile 1 anta+cassetti 100 cm x 120 cm', 785.00, 20, 0.00);
INSERT INTO Articoli VALUES ('T100', 'T10', 'Tavolo tondo', 255.00, 20, 20.00);
INSERT INTO Articoli VALUES ('T200', 'T10', 'Tavolo quadrato', 255.00, 20, 21.00);
INSERT INTO Articoli VALUES ('T300', 'T10','Tavolo rettangolare', 390.00, 20, 35.00);
INSERT INTO Articoli VALUES ('T400', 'T10' ,'Tavolino basso da salotto', 196.00, 20, 19.00);

INSERT INTO Laboratori VALUES (
'0010', 'Via S. Lucia, 21', 'Firenze', '05513467998');
INSERT INTO Laboratori VALUES(
'0020', 'Viale Redi, 3 ','Roma' , '06 2451899');
INSERT INTO Laboratori VALUES(
'0030', 'Via Marino, 1' ,'Lucca', '0583 43451');
INSERT INTO Laboratori VALUES(
'0040', 'Viale dei Tigli, 13', 'Firenze' ,'055 3379801');
INSERT INTO Laboratori VALUES(
'0050' ,'Via Bianchi, 3', 'Roma', '06 6576804');
INSERT INTO Laboratori VALUES(
'0060', 'Via dei Poggi, 456' ,'Pisa' ,'050 32391');

INSERT INTO Componenti VALUES (
'0009', 'Montante laterale 100 cm', 50.00, '0010');
INSERT INTO Componenti VALUES (
'0010', 'Montante laterale 100 cm', 50.00, '0010');
INSERT INTO Componenti VALUES ('0020','Montante laterale 200 cm',100.00,'0010');
INSERT INTO Componenti VALUES ('0030','Ripiano 60 cm',50.00,'0050');
INSERT INTO Componenti VALUES ('0040','Piano tavolo tondo',120.00,'0050');
INSERT INTO Componenti VALUES ('0050','Piano tavolo quadrato',120.00,'0050');
INSERT INTO Componenti VALUES ('0060','Gamba tavolo 60 cm',20.00,'0020');
INSERT INTO Componenti VALUES ('0070','Gamba tavolo 40 cm',15.00,'0020');
INSERT INTO Componenti VALUES ('0080','Anta 100 cm',80.00,'0040');
INSERT INTO Componenti VALUES ('0090','Anta 200 cm',120.00,'0040');
INSERT INTO Componenti VALUES ('0100','Cassettiera da incasso',200.00,'0030');
INSERT INTO Componenti VALUES ('0110','Busta 10 tasselli',5.00,'0050');
INSERT INTO Componenti VALUES ('0120','Busta 10 viti',10.00,'0060');
INSERT INTO Componenti VALUES ('0130','Pomello anta/cassetti',5.00,'0060');
INSERT INTO Componenti VALUES ('0140','Bastone appendiabiti',15.00,'0060');
INSERT INTO Componenti VALUES ('0150','Pannello posteriore 100 cm x 60 cm',30.00,'0050');

INSERT INTO Compart VALUES (
'L100', '0010', 3);
INSERT INTO Compart VALUES ('L100','0030',6);
INSERT INTO Compart VALUES ('L100','0110',1);
INSERT INTO Compart VALUES ('L100','0120',1);
INSERT INTO Compart VALUES ('L200','0020',3);
INSERT INTO Compart VALUES ('L200','0030',12);
INSERT INTO Compart VALUES ('L200','0110',2);
INSERT INTO Compart VALUES ('L200','0120',2);
INSERT INTO Compart VALUES ('M_40','0020',2);
INSERT INTO Compart VALUES ('M_40','0030',4);
INSERT INTO Compart VALUES ('M_40','0090',2);
INSERT INTO Compart VALUES ('M_40','0110',2);
INSERT INTO Compart VALUES ('M_40','0120',2);
INSERT INTO Compart VALUES ('M_40','0130',2);
INSERT INTO Compart VALUES ('M_40','0150',4);
INSERT INTO Compart VALUES ('M_50','0020',3);
INSERT INTO Compart VALUES ('M_50','0030',8);
INSERT INTO Compart VALUES ('M_50','0090',4);
INSERT INTO Compart VALUES ('M_50','0110',3);
INSERT INTO Compart VALUES ('M_50','0120',3);
INSERT INTO Compart VALUES ('M_50','0130',4);
INSERT INTO Compart VALUES ('M_50','0140',2);
INSERT INTO Compart VALUES ('M_50','0150',4);
INSERT INTO Compart VALUES ('M100','0010',2);
INSERT INTO Compart VALUES ('M100','0030',3);
INSERT INTO Compart VALUES ('M100','0080',1);
INSERT INTO Compart VALUES ('M100','0110',1);
INSERT INTO Compart VALUES ('M100','0120',1);
INSERT INTO Compart VALUES ('M100','0130',1);
INSERT INTO Compart VALUES ('M100','0150',1);
INSERT INTO Compart VALUES ('M200','0010',3);
INSERT INTO Compart VALUES ('M200','0030',6);
INSERT INTO Compart VALUES ('M200','0080',2);
INSERT INTO Compart VALUES ('M200','0110',2);
INSERT INTO Compart VALUES ('M200','0120',2);
INSERT INTO Compart VALUES ('M200','0150',2);
insert into compart values ('M300', '0010', 3);
insert into compart values ('M300', '0030', 5);
insert into compart values ('M300', '0080', 1);
insert into compart values ('M300' ,'0100', 1);
insert into compart values ('M300' ,'0110', 2);
insert into compart values ('M300', '0120', 1);
insert into compart values ('M300' ,'0130', 5);
insert into compart values ('M300', '0150', 1);
insert into compart values ('T100', '0040', 1);
insert into compart values ('T100', '0060', 4);
insert into compart values ('T100', '0110', 1);
insert into compart values ('T100', '0120', 1);
insert into compart values ('T200', '0050', 1);
insert into compart values ('T200', '0060', 4);
insert into compart values ('T200', '0110', 1);
insert into compart values ('T200', '0120', 1);
insert into compart values ('T300', '0050', 2);
insert into compart values ('T300', '0060', 4);
insert into compart values ('T300', '0110', 2);
insert into compart values ('T300', '0120', 2);
insert into compart values ('T400', '0050', 1);
insert into compart values ('T400', '0070', 4);
insert into compart values ('T400', '0110', 1);
insert into compart values ('T400', '0120', 1);

INSERT INTO Negozi VALUES (
'0010', 'CompoLegno', 'Via S. Felice, 2', 'Firenze', '055 3232100');
INSERT INTO Negozi VALUES (
'0040', 'MobilMarket', 'L.go S. Severo, 11R', 'Firenze', '055 3245781');
INSERT INTO Negozi VALUES(
'0020' ,'EcoMobili', 'Viale Olanda', '33 Roma','06 5989331');
INSERT INTO Negozi VALUES(
'0030' ,'F. Bianchi e C.',' Via Circeo', '15/B Lucca 0583', '446690');
INSERT INTO Negozi VALUES(
'0050', 'Micheli', 'Via Landi', '189 Roma', '06 6936592');
INSERT INTO Negozi VALUES(
'0060' ,'Co.M.It.',' Via dei Pini', '119 Trento' ,'0336 390469');

INSERT INTO Ordini VALUES ('001095', '0040', to_date('10-01-2004', 'DD-MM-YYYY'));
INSERT INTO Ordini VALUES ('001595', '0010', to_date('13-01-2004', 'DD-MM-YYYY'));
INSERT INTO Ordini VALUES ('003295', '0060', to_date('25-01-2004', 'DD-MM-YYYY'));
INSERT INTO Ordini VALUES ('004095', '0020', to_date('02-02-2004', 'DD-MM-YYYY'));
 
INSERT INTO Ordart VALUES ('001095', 'L100', 4);
INSERT INTO Ordart VALUES ('001095', 'M200', 2);
INSERT INTO Ordart VALUES ('001595', 'L200', 1);
INSERT INTO Ordart VALUES ('001595', 'T400', 1);
INSERT INTO Ordart VALUES ('003295', 'L100', 2);
INSERT INTO Ordart VALUES ('003295', 'T200', 20);
INSERT INTO Ordart VALUES ('004095', 'L100', 1);
INSERT INTO Ordart VALUES ('004095', 'T400', 40);