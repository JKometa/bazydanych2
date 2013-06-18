CREATE DATABASE  IF NOT EXISTS `bd` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bd`;
-- MySQL dump 10.13  Distrib 5.5.24, for osx10.5 (i386)
--
-- Host: jatokor.net    Database: bd
-- ------------------------------------------------------
-- Server version	5.1.66-0+squeeze1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Administrator`
--

DROP TABLE IF EXISTS `Administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Administrator` (
  `IdAdministratora` int(11) NOT NULL AUTO_INCREMENT,
  `AdresSieci` varchar(255) NOT NULL,
  `IdPracownika` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdAdministratora`),
  KEY `FK_Jest` (`IdPracownika`),
  KEY `FK_Jest_przypisany_do` (`AdresSieci`),
  CONSTRAINT `FK_Jest` FOREIGN KEY (`IdPracownika`) REFERENCES `Pracownik` (`IdPracownika`),
  CONSTRAINT `FK_Jest_przypisany_do` FOREIGN KEY (`AdresSieci`) REFERENCES `Siec` (`AdresSieci`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Administrator`
--

LOCK TABLES `Administrator` WRITE;
/*!40000 ALTER TABLE `Administrator` DISABLE KEYS */;
INSERT INTO `Administrator` VALUES (1,'123.234.123.123',1);
/*!40000 ALTER TABLE `Administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Gwarancja`
--

DROP TABLE IF EXISTS `Gwarancja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Gwarancja` (
  `IdGwarancji` int(11) NOT NULL AUTO_INCREMENT,
  `NazwaGwaranta` varchar(255) NOT NULL,
  `PoczatekGwarancji` date NOT NULL,
  `KoniecGwarancji` date NOT NULL,
  `NumerUmowy` int(11) NOT NULL,
  PRIMARY KEY (`IdGwarancji`),
  KEY `FK_Nale¿y_do2` (`NazwaGwaranta`),
  CONSTRAINT `FK_Nale¿y_do2` FOREIGN KEY (`NazwaGwaranta`) REFERENCES `Gwarant` (`NazwaGwaranta`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Gwarancja`
--

LOCK TABLES `Gwarancja` WRITE;
/*!40000 ALTER TABLE `Gwarancja` DISABLE KEYS */;
INSERT INTO `Gwarancja` VALUES (1,'Andrzej Krawczyk','2012-12-01','2012-12-01',1234),(2,'Firma XYZ','2012-12-01','2015-01-01',2345),(3,'Andrzej Krawczyk','2012-10-04','2014-01-01',1111),(4,'Firma XYZ','2012-10-04','2014-01-01',567),(5,'Firma XYZ','2012-10-04','2014-01-01',11123),(6,'Andrzej Krawczyk','2012-10-04','2014-01-01',888);
/*!40000 ALTER TABLE `Gwarancja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Gwarant`
--

DROP TABLE IF EXISTS `Gwarant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Gwarant` (
  `NazwaGwaranta` varchar(255) NOT NULL,
  `Ulica` text NOT NULL,
  `Miasto` text NOT NULL,
  `NrLokalu` text NOT NULL,
  `NrTelefonu` int(11) NOT NULL,
  PRIMARY KEY (`NazwaGwaranta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Gwarant`
--

LOCK TABLES `Gwarant` WRITE;
/*!40000 ALTER TABLE `Gwarant` DISABLE KEYS */;
INSERT INTO `Gwarant` VALUES ('Andrzej Krawczyk','Marszalkowska 55','Warszawa','0',0),('Firma ASD','Krakowskie Przedmiescie 33','Warszawa','0',4326353),('Firma Inna',' Admiralska 99','Warszawa','44',42111233),('Firma IOP','Polna 3','Kraków','0',23424316),('Firma Taka','pl Politechniki 3','Pozna?','0',12311212),('Firma XYZ','pl Politechniki 55\n','Warszawa','55',12342112);
/*!40000 ALTER TABLE `Gwarant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Lokalizacja`
--

DROP TABLE IF EXISTS `Lokalizacja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Lokalizacja` (
  `IdLokalizacja` int(11) NOT NULL AUTO_INCREMENT,
  `Pokoj` int(11) NOT NULL,
  `Pietro` int(11) NOT NULL,
  `Budynek` text NOT NULL,
  PRIMARY KEY (`IdLokalizacja`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Lokalizacja`
--

LOCK TABLES `Lokalizacja` WRITE;
/*!40000 ALTER TABLE `Lokalizacja` DISABLE KEYS */;
INSERT INTO `Lokalizacja` VALUES (1,3,2,'1'),(2,1,3,'1'),(3,2,3,'4');
/*!40000 ALTER TABLE `Lokalizacja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pracownik`
--

DROP TABLE IF EXISTS `Pracownik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Pracownik` (
  `IdPracownika` int(11) NOT NULL AUTO_INCREMENT,
  `Imie` text NOT NULL,
  `Nazwisko` text NOT NULL,
  `IdZespolu` int(11) DEFAULT NULL,
  `Status` text NOT NULL,
  `Login` varchar(21) NOT NULL,
  `Haslo` varchar(21) NOT NULL,
  `HasAccess` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IdPracownika`),
  KEY `FK_Nalezy_do` (`IdZespolu`),
  CONSTRAINT `FK_Nalezy_do` FOREIGN KEY (`IdZespolu`) REFERENCES `Zespol` (`IdZespolu`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pracownik`
--

LOCK TABLES `Pracownik` WRITE;
/*!40000 ALTER TABLE `Pracownik` DISABLE KEYS */;
INSERT INTO `Pracownik` VALUES (1,'Michal','Krawczyk',2,'Pracuje','michal','admin1',0),(2,'Andrzej','Kowalski',NULL,'Urlop','andrzej','admin2',1),(3,'Jaromir','Podbipieta',NULL,'Pracuje','jaromir','admin3',0),(4,'Ahmed','Nowak',NULL,'Urlop','ahmed','admin4',0),(5,'Ela','Zapedowska',NULL,'Pracuje','el','admin5',0),(6,'','',NULL,'','','',0);
/*!40000 ALTER TABLE `Pracownik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Siec`
--

DROP TABLE IF EXISTS `Siec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Siec` (
  `AdresSieci` varchar(255) NOT NULL,
  `IdSprzetu` int(11) NOT NULL,
  PRIMARY KEY (`AdresSieci`),
  KEY `FK_Jest_podlaczone_do` (`IdSprzetu`),
  CONSTRAINT `FK_Jest_podlaczone_do` FOREIGN KEY (`IdSprzetu`) REFERENCES `Urzadzenie` (`IdSprzetu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Siec`
--

LOCK TABLES `Siec` WRITE;
/*!40000 ALTER TABLE `Siec` DISABLE KEYS */;
INSERT INTO `Siec` VALUES ('123.234.123.123',1);
/*!40000 ALTER TABLE `Siec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Urzadzenie`
--

DROP TABLE IF EXISTS `Urzadzenie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Urzadzenie` (
  `IdSprzetu` int(11) NOT NULL AUTO_INCREMENT,
  `NazwaRodzaju` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`IdSprzetu`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Urzadzenie`
--

LOCK TABLES `Urzadzenie` WRITE;
/*!40000 ALTER TABLE `Urzadzenie` DISABLE KEYS */;
INSERT INTO `Urzadzenie` VALUES (1,'Router'),(2,'Serwer'),(3,'Switch'),(4,'Monitor');
/*!40000 ALTER TABLE `Urzadzenie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WlasciwosciUzytkowe`
--

DROP TABLE IF EXISTS `WlasciwosciUzytkowe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WlasciwosciUzytkowe` (
  `IdEgz` int(11) NOT NULL AUTO_INCREMENT,
  `IdTypu` int(11) NOT NULL,
  `IdGwarancji` int(11) NOT NULL,
  `IdLokalizacji` int(11) NOT NULL,
  PRIMARY KEY (`IdEgz`),
  KEY `FK_Ma3` (`IdGwarancji`),
  KEY `FK_Ma2` (`IdTypu`),
  KEY `FK_jest_w_idx` (`IdLokalizacji`),
  CONSTRAINT `FK_Ma2` FOREIGN KEY (`IdTypu`) REFERENCES `Urzadzenie` (`IdSprzetu`),
  CONSTRAINT `FK_Ma3` FOREIGN KEY (`IdGwarancji`) REFERENCES `Gwarancja` (`IdGwarancji`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WlasciwosciUzytkowe`
--

LOCK TABLES `WlasciwosciUzytkowe` WRITE;
/*!40000 ALTER TABLE `WlasciwosciUzytkowe` DISABLE KEYS */;
INSERT INTO `WlasciwosciUzytkowe` VALUES (1,3,1,1),(2,1,2,2),(3,1,3,0);
/*!40000 ALTER TABLE `WlasciwosciUzytkowe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Zespol`
--

DROP TABLE IF EXISTS `Zespol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Zespol` (
  `IdZespolu` int(11) NOT NULL AUTO_INCREMENT,
  `NazwaZespolu` text NOT NULL,
  `Opis` text,
  PRIMARY KEY (`IdZespolu`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Zespol`
--

LOCK TABLES `Zespol` WRITE;
/*!40000 ALTER TABLE `Zespol` DISABLE KEYS */;
INSERT INTO `Zespol` VALUES (1,'Obsluga','Opis Obslugi'),(2,'Technicy','Opis Technikow'),(3,'Malarze','Opis Malarzy');
/*!40000 ALTER TABLE `Zespol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Zgloszenia_log`
--

DROP TABLE IF EXISTS `Zgloszenia_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Zgloszenia_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idZgloszenia` int(11) NOT NULL,
  `status` varchar(10) NOT NULL,
  `data` datetime NOT NULL,
  `statusZgloszenia` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `FK_odnosi` (`idZgloszenia`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Zgloszenia_log`
--

LOCK TABLES `Zgloszenia_log` WRITE;
/*!40000 ALTER TABLE `Zgloszenia_log` DISABLE KEYS */;
INSERT INTO `Zgloszenia_log` VALUES (1,1,'NEW','0000-00-00 00:00:00',''),(2,2,'NEWZglosze','2013-06-18 00:43:23',''),(3,7,'NEW','2013-06-18 00:47:07','AAA'),(4,7,'UPDATED','2013-06-18 00:49:51','BBB'),(13,7,'DELETE','2013-06-18 01:08:58','BBB'),(14,1,'UPDATED','2013-06-18 17:19:06','OK'),(15,9,'NEW','2013-06-18 17:45:36','OK'),(16,1,'DELETE','2013-06-18 17:56:45','OK'),(17,2,'DELETE','2013-06-18 18:55:05','OK'),(18,6,'NEW','2013-06-19 00:25:55','n'),(20,8,'NEW','2013-06-19 00:57:06','NOWE'),(21,9,'NEW','2013-06-19 00:57:07','NOWE'),(22,1,'UPDATED','2013-06-19 01:26:47','Nowe'),(23,2,'UPDATED','2013-06-19 01:26:48','Nowe'),(24,3,'UPDATED','2013-06-19 01:26:49','Nowe'),(25,4,'UPDATED','2013-06-19 01:26:50','Nowe'),(26,1,'UPDATED','2013-06-19 01:26:51','Nowe'),(27,2,'UPDATED','2013-06-19 01:26:52','Nowe'),(28,3,'UPDATED','2013-06-19 01:26:52','Nowe'),(29,4,'UPDATED','2013-06-19 01:26:53','Nowe'),(30,10,'NEW','2013-06-19 01:29:48','NOWE'),(31,10,'UPDATED','2013-06-19 01:33:31','NOWE');
/*!40000 ALTER TABLE `Zgloszenia_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Zgloszenie`
--

DROP TABLE IF EXISTS `Zgloszenie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Zgloszenie` (
  `IdZgloszenia` int(11) NOT NULL AUTO_INCREMENT,
  `NazwaGwaranta` varchar(255) NOT NULL DEFAULT '',
  `IdSprzetu` int(11) NOT NULL,
  `IdDodajacego` int(11) NOT NULL,
  `IdZespolu` int(11) DEFAULT NULL,
  `Status` text NOT NULL,
  `Opis` text NOT NULL,
  PRIMARY KEY (`IdZgloszenia`),
  KEY `FK_Obsluguje_idx` (`IdZespolu`),
  KEY `FK_Obsluguje2_idx` (`NazwaGwaranta`),
  KEY `FK_Jest_przypisane_do_idx` (`IdSprzetu`),
  CONSTRAINT `FK_Jest_przypisane_do` FOREIGN KEY (`IdSprzetu`) REFERENCES `WlasciwosciUzytkowe` (`IdEgz`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Obsluguje` FOREIGN KEY (`IdZespolu`) REFERENCES `Zespol` (`IdZespolu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Obsluguje2` FOREIGN KEY (`NazwaGwaranta`) REFERENCES `Gwarant` (`NazwaGwaranta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Zgloszenie`
--

LOCK TABLES `Zgloszenie` WRITE;
/*!40000 ALTER TABLE `Zgloszenie` DISABLE KEYS */;
INSERT INTO `Zgloszenie` VALUES (1,'Firma XYZ',1,1,3,'Nowe','aa'),(2,'Firma IOP',2,1,2,'Nowe','aa'),(3,'Firma XYZ',3,1,3,'Nowe','a'),(4,'Firma IOP',3,1,3,'Nowe',''),(6,'Firma IOP',3,1,3,'n','n'),(8,'Andrzej Krawczyk',1,1,NULL,'NOWE','Jarek to pogromca calek'),(9,'Andrzej Krawczyk',1,1,NULL,'NOWE','Jarek to pogromca calek'),(10,'Andrzej Krawczyk',1,2,3,'NOWE','Zgloszenie bledu');
/*!40000 ALTER TABLE `Zgloszenie` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`bd2.elka`@`%`*/ /*!50003 TRIGGER `Zgloszenie_AINS` AFTER INSERT ON Zgloszenie FOR EACH ROW
-- Edit trigger body code below this line. Do not edit lines above this one
BEGIN
-- h
INSERT INTO Zgloszenia_log (`status`, `data`, `idZgloszenia`, `statusZgloszenia`) VALUES ('NEW', NOW() ,NEW.idZgloszenia, NEW.Status);
   

 END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`bd2.elka`@`%`*/ /*!50003 TRIGGER `Zgloszenie_AUPD` AFTER UPDATE ON Zgloszenie FOR EACH ROW
-- Edit trigger body code below this line. Do not edit lines above this one

BEGIN

		INSERT INTO Zgloszenia_log (`status`, `data`, `idZgloszenia`, `statusZgloszenia`) VALUES ('UPDATED', NOW() ,NEW.idZgloszenia, NEW.Status);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`bd2.elka`@`%`*/ /*!50003 TRIGGER `Zgloszenie_BDEL` BEFORE DELETE ON Zgloszenie FOR EACH ROW

BEGIN

INSERT INTO Zgloszenia_log (`status`, `data`, `idZgloszenia`, `statusZgloszenia`) 
VALUES ('DELETE', NOW() ,OLD.idZgloszenia, OLD.Status);
    

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `jeden` int(11) NOT NULL,
  PRIMARY KEY (`jeden`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1),(111),(222),(234),(1111);
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test2`
--

DROP TABLE IF EXISTS `test2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test2` (
  `dwa` int(11) NOT NULL,
  PRIMARY KEY (`dwa`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test2`
--

LOCK TABLES `test2` WRITE;
/*!40000 ALTER TABLE `test2` DISABLE KEYS */;
/*!40000 ALTER TABLE `test2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-19  1:39:26
