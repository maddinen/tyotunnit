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


INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-01-28', 3, 'Projektisuunnitelman revisointi');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-02-02', 2.5, 'Suunnittelua');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-02-04', 3, 'Suunnittelua ja toteutusta');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-02-09', 2.5, 'Toteutusta');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-02-11', 3, 'Toteutusta');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-02-13', 4, 'Toteutusta');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-02-15', 3, 'Toteutusta');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-02-16', 6, 'Toteutusta');

INSERT INTO Tunnit (kayttaja_id, pvm, tuntien_maara, selite)
VALUES (1, '2016-02-16', 2, 'Toteutusta');

