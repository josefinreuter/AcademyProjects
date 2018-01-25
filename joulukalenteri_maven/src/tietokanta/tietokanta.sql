DROP DATABASE IF EXISTS joulukalenteri;
CREATE DATABASE joulukalenteri;
	DEFAULT CHARACTER SET utf8;
USE joulukalenteri;
SET NAMES 'utf8';
SET AUTOCOMMIT=0;

DROP TABLE IF EXISTS `reseptit`;
CREATE TABLE `reseptit` (
  `reseptiid` int NOT NULL AUTO_INCREMENT,
  `nimi` varchar(128) NOT NULL,
  `kuvaus` text NOT NULL,
  PRIMARY KEY (`reseptiid`)
);

INSERT INTO `reseptit` VALUES(1, 'Piparit', '1dl tummaa siirappia<br>
1dl taloussokeria<br>
2tl kanelia<br>
1tl inkivääriä<br>
1tl neilikkaa<br>
125g voita<br>
1 muna<br>
5dl vehnäjauhoja<br>
1tl soodaa');

INSERT INTO `reseptit` VALUES(2, 'Taatelikakku', '1,5dl vettä<br>
1pkt taateleita<br>
200g voita<br>
2 munaa<br>
2-3dl sokeria<br>
0,5dl kermaa<br>
4,5dl vehnäjauhoja<br>
1tl soodaa<br>
1tl leivinjauhetta<br>
1-2tl vaniljasokeria');

INSERT INTO `reseptit` VALUES(3, 'Joulutortut', '1pkt voitaikinalevyjä<br>
2dl (luumu)marmeladia<br>
(1rkl konjakkia)<br>
(0,5tl kanelia)<br><br>
Voiteluun:<br>
kananmunaa');

INSERT INTO `reseptit` VALUES(4, 'Kallen Mangokakku', 'Pohjaan:<br>
75g voita<br>
150g digestivekeksejä<br><br>
Täyte:<br>
4dl kuohukermaa<br>
300g tuorejuustoa<br>
2dl sokeria<br>
1tl vaniljasokeria<br>
1tl limemehua<br>
tilkka vettä<br>
6 liivatetta');

INSERT INTO `reseptit` VALUES(5, 'Pepen korvapuustit', '200g voita<br>
5dl täysmaitoa<br>
50g hiivaa<br>
2dl sokeria<br>
1rkl vaniljasokeria<br>
2rkl kardemummaa<br>
2tl suolaa<br>
1 muna<br>
n. 15dl vehnäjauhoja<br><br>
Täyte:<br>
150g pehmeää voita<br>
2dl fariinisokeria<br>
vaniljasokeria<br>
kanelia<br>
(kardemummaa)<br><br>
Pinnalle:<br>
1 muna<br>
raesokeria');

INSERT INTO `reseptit` VALUES(6, 'Joulupiirakka', '400g piparitaikinaa<br>
1rkl juoksevaa rasvaa<br><br>
Täyte:<br>
2 liivatetta<br>
120g kuivattuja pehmeitä hedelmiä<br>
2dl vispikermaa<br>
2rkl rommia<br>
2prk luumu-kanelirahkaa<br><br>
Koristelu:<br>
kuivattuja hedelmiä ja manteleita<br>
kanelitankoja');

INSERT INTO `reseptit` VALUES(7, 'Jouluhalko', '4 munaa<br>
1,5dl sokeria<br>
0,75dl vehnäjauhoja<br>
0,75dl perunajauhoja<br>
3rkl kaakaojauhetta<br>
1tl leivinjauhetta<br><br>
Täyte:<br>
1dl vadelmahilloa<br>
2dl vispikermaa<br>
1prk luumu-kanelirahkaa<br>
1tl vaniljasokeria<br><br>
Pinnalle:<br>
100g tummaa suklaata<br>
1prk luumu-kanelirahkaa<br>
1dl vispikermaa');

INSERT INTO `reseptit` VALUES(8, 'Kaneliässät', '200g voita<br>
2dl sokeria<br>
2 munaa<br>
5dl vehnäjauhoja<br>
2tl leivinjauhetta<br><br>
Pinnalle:<br>
2tl kanelia<br>
3rkl sokeria');

INSERT INTO `reseptit` VALUES(9, 'Lusikkaleivät', '200g voita<br>
1,5dl sokeria<br>
2tl vaniljasokeria<br>
4,5dl vehnäjauhoja<br>
1tl soodaa<br><br>
Väliin:<br>
1dl omena- tai vadelmamarmeladia<br><br>
Pinnalle:<br>
hienoa sokeria');

INSERT INTO `reseptit` VALUES(10, 'Joulusuklaa', '200g tummaa suklaata<br>
muutama piparkakku<br>
0,5dl rusinoita<br>
muutama saksanpähkinä');

DROP TABLE IF EXISTS `kysymykset`;
CREATE TABLE `kysymykset` (
  `id` int NOT NULL AUTO_INCREMENT,
  `kysymys` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS `vastaukset`;
CREATE TABLE `vastaukset` (
  `id` int NOT NULL AUTO_INCREMENT,
  `kysymysid` int NOT NULL,

  `teksti` varchar(128) NOT NULL,

  `oikeavastaus` tinyint(1) NOT NULL,

  CONSTRAINT `vastaukset_kysymykset_fk` FOREIGN KEY (`kysymysid`) REFERENCES
`kysymykset` (`id`),
  PRIMARY KEY (`id`)

);
INSERT INTO `kysymykset` VALUES(1, 'Kuinka monta neulasta on keskimäärin pienehkössä joulukuusessa?');
INSERT INTO `kysymykset` VALUES(2, 'Riisipuuro on 1800-luvulta peräisin. Mistä ennen joulupuuro keitettiin?');
INSERT INTO `kysymykset` VALUES(3, 'Mistä glögi on tullut Suomeen?');
INSERT INTO `kysymykset` VALUES(4, 'Millä nimellä kutsutaan venäjällä joulupukkia?');
INSERT INTO `kysymykset` VALUES(5, 'Mistä tulee joulupukin asun punainen väri?');
INSERT INTO `kysymykset` VALUES(6, 'Mitä maustetta perinteisesti laitetaan luciapulliin?');
INSERT INTO `kysymykset` VALUES(7, 'Kuinka paljon tehdään Fazerin Lappeenrannan tehtaalla Vihreitä kuulia jouluksi?');
INSERT INTO `kysymykset` VALUES(8, 'Paljonko kasvatetaan joulukuusia Euroopassa vuosittain?');
INSERT INTO `kysymykset` VALUES(9, 'Koska tuli ensimmäinen pahvijoulukalenteri?');
INSERT INTO `kysymykset` VALUES(10, 'Mistä tulee perinne, että jaetaan joululahjoja?');
INSERT INTO `vastaukset` VALUES(1, 1, '150 000', 1);
INSERT INTO `vastaukset` VALUES(2, 1, '1 000 000', 0);
INSERT INTO `vastaukset` VALUES(3, 1, '500 000', 0);
INSERT INTO `vastaukset` VALUES(4, 2, 'Kaurasta', 0);
INSERT INTO `vastaukset` VALUES(5, 2, 'Ohrasta', 1);
INSERT INTO `vastaukset` VALUES(6, 2, 'Rukiista', 0);
INSERT INTO `vastaukset` VALUES(7, 3, 'Norjasta', 0);
INSERT INTO `vastaukset` VALUES(8, 3, 'Ruotsista', 1);
INSERT INTO `vastaukset` VALUES(9, 3, 'Saksasta', 0);
INSERT INTO `vastaukset` VALUES(10, 4, 'Routavaari', 0);
INSERT INTO `vastaukset` VALUES(11, 4, 'Hallaukko', 0);
INSERT INTO `vastaukset` VALUES(12, 4, 'Pakkasukko', 1);
INSERT INTO `vastaukset` VALUES(13, 5, 'Coca-Cola mainoksesta', 1);
INSERT INTO `vastaukset` VALUES(14, 5, 'Uskonnollisista perinteistä', 0);
INSERT INTO `vastaukset` VALUES(15, 5, 'Petteri punakuonon nenän väristä', 0);
INSERT INTO `vastaukset` VALUES(16, 6, 'Kurkumaa', 0);
INSERT INTO `vastaukset` VALUES(17, 6, 'Sahramia', 1);
INSERT INTO `vastaukset` VALUES(18, 6, 'Kardemummaa', 0);
INSERT INTO `vastaukset` VALUES(19, 7, '17 miljoonaa', 1);
INSERT INTO `vastaukset` VALUES(20, 7, '25 miljoonaa', 0);
INSERT INTO `vastaukset` VALUES(21, 7, '10 miljoonaa', 0);
INSERT INTO `vastaukset` VALUES(22, 8, '2 miljoonaa', 0);
INSERT INTO `vastaukset` VALUES(23, 8, '30 miljoonaa', 0);
INSERT INTO `vastaukset` VALUES(24, 8, '60 miljoonaa', 1);
INSERT INTO `vastaukset` VALUES(25, 9, '1905', 0);
INSERT INTO `vastaukset` VALUES(26, 9, '1939', 1);
INSERT INTO `vastaukset` VALUES(27, 9, '1922', 0);
INSERT INTO `vastaukset` VALUES(28, 10, 'Saksasta', 1);
INSERT INTO `vastaukset` VALUES(29, 10, 'Amerikasta', 0);
INSERT INTO `vastaukset` VALUES(30, 10, 'Ranskasta', 0);

DROP TABLE IF EXISTS `sanakirja`;
CREATE TABLE `sanakirja` (
  `lauseid` int NOT NULL AUTO_INCREMENT,
  `suomi` varchar(128) NOT NULL,
  `ruotsi` varchar(128) NOT NULL,
  `englanti` varchar(128) NOT NULL,
  `espanja` varchar(128) NOT NULL,
  `ranska` varchar(128) NOT NULL,
  PRIMARY KEY (`lauseid`)
);

INSERT INTO `sanakirja` VALUES(1, 'Hyvää joulua!', 'God Jul!', 'Merry Christmas!', 'Feliz Navidad!', 'Joyeux Noël!');
INSERT INTO `sanakirja` VALUES(2, 'Hyvää uutta vuotta!', 'Gott Nytt År!', 'Happy New Year!', 'Prospero Año Nuevo!', 'Bonne Année Nouvelle!');
INSERT INTO `sanakirja` VALUES(3, 'Joulupukki on ovella.', 'Julgubben är bakom dörren.', 'Santa Claus is at the door.', 'El Papa Noel está en la puerta.', 'Le Père Noël est à la porte.');
INSERT INTO `sanakirja` VALUES(4, 'Joulukuusi pitäisi koristella.', 'Julgranen borde pynttas.', 'The christmas tree should be decorated.', 'Se tendría que decorar el arból de Navidad.', 'On devrait décorer le sapin de Noël');
INSERT INTO `sanakirja` VALUES(5, 'Onko kinkku vielä uunissa?', 'Är skinkan fortfarande i ugnen?', 'Is the ham still in the oven?', '¿El jamón está todavía en el horno?', 'Est-ce que le jambon est toujours au four?');
INSERT INTO `sanakirja` VALUES(6, 'Saadaanko jo avata paketit?', 'Kan vi öppna paketen redan?', 'Can we open the presents already?', '¿Ya podemos abrir los regalos?', 'Est-ce qu''on peut déjà ouvrir les cadeaux?');
INSERT INTO `sanakirja` VALUES(7, 'Taisin syödä liikaa.', 'Jag tror jag åt för mycket.', 'I think I ate too much.', 'Creo que he comido demasiado.', 'Je crois que j''ai trop mangé.');
INSERT INTO `sanakirja` VALUES(8, 'Mitä ihmettä, kuka söi kaikki suklaakonvehdit?!?', 'Vad i helsike, vem åt alla chokladkonfekter?!?', 'What the heck, who ate all the chocolate candies?!?', '¡¿¡Qué narices, quien ha comido todos los dulces de chocolate!?!', 'C''est quoi ce truc, qui a mangé tous les bonbons du chocolat?!?');

COMMIT;
SET AUTOCOMMIT=1;

-- Poista kommentit seuraavilta riveiltä jos haluat esimerkkitulostuksen..
-- set names 'cp850'; -- vaihda oikeaksi, esim. cp1250
/*status;
select * from `henkilo`;*/
