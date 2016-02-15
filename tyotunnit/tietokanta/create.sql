
CREATE TABLE Kayttajat
( kayttaja_id 		SMALLINT NOT NULL AUTO_INCREMENT
, kayttajatunnus 	VARCHAR(50) NOT NULL
, email 			VARCHAR(50)
, etunimi 			VARCHAR(50)
, sukunimi 			VARCHAR(50)
, salasana 			VARCHAR(50)
, suola 			VARCHAR(50)
, PRIMARY KEY (kayttaja_id)
)Engine=InnoDB;
		

CREATE TABLE Tunnit
( tunti_id 			SMALLINT NOT NULL AUTO_INCREMENT
, kayttaja_id 		SMALLINT NOT NULL
, pvm 				DATE NOT NULL
, tuntien_maara	 	DECIMAL(5,2)
, selite 			VARCHAR(200)
, PRIMARY KEY (tunti_id)
, FOREIGN KEY (kayttaja_id) REFERENCES Kayttajat(kayttaja_id)
)Engine=InnoDB;


CREATE TABLE Kayttajan_tunnit
( kt_id SMALLINT NOT NULL AUTO_INCREMENT
, tunti_id SMALLINT NOT NULL
, kayttaja_id SMALLINT NOT NULL
, PRIMARY KEY (kt_id)
, FOREIGN KEY (tunti_id) REFERENCES Tunnit(tunti_id)
, FOREIGN KEY (kayttaja_id) REFERENCES Kayttaja(kayttaja_id)
)Engine=InnoDB;