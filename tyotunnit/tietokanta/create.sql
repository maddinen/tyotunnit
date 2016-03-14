-- drop table Kayttaja_authority, Authority, Tunnit, Kayttajat;

CREATE TABLE Kayttajat (
  id SMALLINT NOT NULL auto_increment PRIMARY KEY,
  kayttajatunnus varchar(255) NOT NULL UNIQUE,
  password_encrypted varchar(255) NOT NULL,
  enabled tinyint NOT NULL,
  etunimi varchar(255) default NULL,
  sukunimi varchar(255) default NULL,
  email varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE Tunnit(
 tunti_id 			SMALLINT NOT NULL AUTO_INCREMENT,
 kayttaja_id 		SMALLINT NOT NULL,
 pvm 				DATE NOT NULL, 
 tuntien_maara	 	DECIMAL(5,2), 
 selite 			VARCHAR(200), 
PRIMARY KEY (tunti_id), 
FOREIGN KEY (kayttaja_id) REFERENCES Kayttajat(id)
)Engine=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE Authority (
  id SMALLINT NOT NULL auto_increment PRIMARY KEY,
  role varchar(255) NOT NULL UNIQUE
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE Kayttaja_authority (
  id SMALLINT NOT NULL auto_increment PRIMARY KEY,
  kayttaja_id SMALLINT NOT NULL,
  authority_id SMALLINT NOT NULL,
  FOREIGN KEY (kayttaja_id) REFERENCES Kayttajat(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (authority_id) REFERENCES Authority(id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;