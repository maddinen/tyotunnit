
-- delete from Kayttajat;
-- delete from Tunnit;

INSERT INTO
	Authority
VALUES
	(2,'ROLE_ADMIN'),
	(1,'ROLE_USER');

INSERT INTO
	Kayttajat
VALUES
	(1,'marita','bf2e94e54051074338044ac39392000f8bf05eca06a3f8836b4083c73aee76f61359252cfdd5592a',1,'Marita','Klaavu', 'marita.klaavu@gmail.com'),
	(2,'katri','9e72e4cf83f01fd171091025172c70b4e87009e0d80839628cbaa99281f9f5a5d9b8fe9af45c8cef',1,'Katri','Vilonen', 'katri.vilonen@gmail.com'),
	(3,'jusju','078cb7e9d960c6ba02c24f174cb47e3517345af0aab32f1f8c2e532eaf64ef9191976f5caeee50ec',1,'Jukka','Juslin', 'jukka.juslin@haaga-helia.fi');
	
INSERT INTO
	Kayttaja_authority
VALUES
	(1,1,1),
	(2,2,1),
	(3,2,2),
	(4,1,2),
	(5,3,1),
	(6,3,2);


INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-01-28', 3, 'Projektisuunnitelman revisointi');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-02-02', 2.5, 'Suunnittelua');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-02-04', 3, 'Suunnittelua ja toteutuksen aloittelua');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-02-09', 2.5, 'Tietokantahaut');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-02-11', 3, 'Toteutusta');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-02-13', 4, 'Toteutusta');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-02-15', 3, 'Tietokantaan sy�t�t');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-02-16', 6, 'Konsoliversion toteutus');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-02-16', 2, 'Ongelman ratkontaa');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-02-17', 3, 'Toteutusta');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-02-18', 3, 'Sprint #1 Review');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-03-01', 3, 'Spring MVC');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-03-03', 6, 'REST Json, Spring MVC');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (3, '2016-03-03', 3, 'Spring MVC yms. protolle');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-03-04', 1, 'CSS suunnittelua');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-03-06', 3, 'CSS, datepicker, tietyn henkilön tunnit');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-03-06', 1, 'Bean Validation aloittelua');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (3, '2016-03-07', 0.1, 'pull komento');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-03-08', 3.5, 'CSS, js oikeaan paikkaan, bean validation');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-03-09', 1, 'Tietokannan korjausta');

