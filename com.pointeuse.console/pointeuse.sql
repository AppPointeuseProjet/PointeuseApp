drop table if exists PLAGE_HORAIRE ;
drop table if exists DROIT_ACCESS;
drop table if exists PORTE;
drop table if exists CARTE;
drop table if exists PERSONNEL;

CREATE TABLE `PERSONNEL` (
  `matricule` varchar(10),
  `nom` varchar(255),
  `prenom` varchar(255),
  PRIMARY KEY(`matricule`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `CARTE` (
  `numSerie` varchar(10),
  `dateExpiration` date,
  `statut` int,
  `libelle` varchar(255),
  `matricule` varchar(10),
  PRIMARY KEY(`numSerie`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `PORTE` (
  `numPorte` varchar(10),
  `service` varchar(255),
  `batiment` varchar(255),
  PRIMARY KEY(`numPorte`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `PLAGE_HORAIRE` (
  `libelle` varchar(255),
  `heure_debut` time,
  `heure_fin` time,
  PRIMARY KEY(`libelle`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `DROIT_ACCESS` (
  `numSerie` varchar(10),
  `numPorte` varchar(10),
  `ouvre` int,
  PRIMARY KEY(`numSerie`, `numPorte`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

ALTER TABLE `CARTE` ADD FOREIGN KEY (`libelle`) REFERENCES `PLAGE_HORAIRE` (`libelle`);
ALTER TABLE `CARTE` ADD FOREIGN KEY (`matricule`) REFERENCES `PERSONNEL` (`matricule`);
ALTER TABLE `DROIT_ACCESS` ADD FOREIGN KEY (`numSerie`) REFERENCES `CARTE` (`numSerie`);
ALTER TABLE `DROIT_ACCESS` ADD FOREIGN KEY (`numPorte`) REFERENCES `PORTE` (`numPorte`);




INSERT INTO PUBLIC.PLAGE_HORAIRE(LIBELLE, HEURE_DEBUT, HEURE_FIN) VALUES
('DG', TIME '06:00:00', TIME '22:00:00'),
('MANAGEUR', TIME '08:00:00', TIME '22:00:00'),            
('CADRE', TIME '09:00:00', TIME '20:00:00'),           
('TECHNICIEN', TIME '06:00:00', TIME '20:00:00');  
           
              
INSERT INTO PUBLIC.PERSONNEL(MATRICULE, NOM, PRENOM) VALUES
('0a123', 'CANARD', 'COCUS'),
('0b456', 'DUTROU', 'JEAN'),
('0a124', 'GIANCARLO', 'GIRONE'),
('0b457', 'TROUILLARD', 'MATHILDE'),
('0b458', 'PAPAGALLO', 'LOREDANA'),
('0a125', 'MAGNINI', 'NATALIA'),
('0c100', 'MAGLIA', 'LUPITA'),
('0c101', 'LEVAUD', 'AMBRE'),
('0a126', 'DUPONT', 'OLIVIER'),
('0c102', 'BERANGER', 'JEROME');      

INSERT INTO PUBLIC.PORTE(NUMPORTE, SERVICE, BATIMENT) VALUES
('123', 'LABORATOIRE', 'A'),
('240', 'SI', 'C'),
('124', 'ADMINISTRATION', 'B'),
('125', 'MAGAZIN', 'F'),
('241', 'PRODUCTION', 'C');  


 
INSERT INTO PUBLIC.CARTE(NUMSERIE, DATEEXPIRATION, STATUT, LIBELLE, MATRICULE) VALUES
('0000001', DATE '2018-01-01', 1, 'DG', '0a123'),
('0000002', DATE '2016-01-01', 1, 'MANAGEUR', '0b456'),
('0000003', DATE '2016-01-01', 1, 'CADRE', '0a124'),
('0000004', DATE '2017-01-01', 1, 'MANAGEUR', '0b457'),
('0000005', DATE '2016-01-01', 1, 'MANAGEUR', '0b458'),
('0000006', DATE '2016-01-01', 1, 'CADRE', '0a125'),
('0000007', DATE '2016-01-01', 1, 'CADRE', '0c100'),
('0000008', DATE '2016-01-01', 1, 'TECHNICIEN', '0c101'),
('0000009', DATE '2016-01-01', 1, 'CADRE', '0a126'),
('00000010', DATE '2016-01-01', 1, 'TECHNICIEN', '0c102');      


INSERT INTO PUBLIC.DROIT_ACCESS(NUMSERIE, NUMPORTE, OUVRE) VALUES
('0000001', '123', 1),
('0000001', '124', 1),
('0000002', '123', 1),
('0000001', '240', 1),
('0000006', '124', 1),
('0000001', '125', 1),
('0000001', '241', 1),
('0000004', '125', 1),
('0000003', '241', 1);     

