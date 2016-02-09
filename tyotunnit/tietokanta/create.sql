CREATE TABLE Kayttajat (
        id     				SMALLINT NOT NULL AUTO_INCREMENT,
        kayttajatunnus		VARCHAR(50),
        email        		VARCHAR(50),
		etunimi				VARCHAR(50),
		sukunimi			VARCHAR(50),
		salasana			VARCHAR(700),
		suola				VARCHAR(50),
        PRIMARY KEY (id)
);
		
CREATE TABLE Tunnit (
	id					SMALLINT NOT NULL AUTO_INCREMENT,
	pvm					TIMESTAMP,
	tuntien_maara		DECIMAL(5,2),
	kayttaja			SMALLINT NOT NULL,
	kommentti			VARCHAR(200),
	PRIMARY KEY (id),
	FOREIGN KEY (kayttaja) REFERENCES Kayttajat(kayttajatunnus)
);