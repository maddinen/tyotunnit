-- delete from Kayttajat;
-- delete from Tunnit;

INSERT INTO Kayttajat
(kayttajatunnus, email, etunimi, sukunimi, salasana) VALUES(
'maka', 'marita.klaavu@gmail.com','Marita','Klaavu', '1234maka');

INSERT INTO Kayttajat
(kayttajatunnus, email, etunimi, sukunimi, salasana) VALUES(
'kavi', 'katri.vilonen@gmail.com','Katri','Vilonen', '6666kavi');

INSERT INTO Kayttajat
(kayttajatunnus, email, etunimi, sukunimi, salasana) VALUES(
'juju', 'jukka.juslin@haaga-helia.fi','Jukka','Juslin', '9999juju');

INSERT INTO Tunnit
(pvm, tuntien_maara, kayttaja) VALUES(
'2015-12-31', 10.5, '9999');

INSERT INTO Tunnit
(pvm, tuntien_maara, kayttaja) VALUES(
'2016-01-11', 5.0, '6666');

INSERT INTO Tunnit
(pvm, tuntien_maara, kayttaja) VALUES(
'2008-01-06', 5.0, '1234');

