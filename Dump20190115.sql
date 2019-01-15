CREATE DATABASE  IF NOT EXISTS `tirociniofast` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `tirociniofast`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: tirociniofast
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `azienda`
--

DROP TABLE IF EXISTS `azienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `azienda` (
  `nome` varchar(45) DEFAULT NULL,
  `partitaIva` varchar(45) DEFAULT NULL,
  `ceo` varchar(45) DEFAULT NULL,
  `indirizzo` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `domanda` varchar(45) DEFAULT NULL,
  `descrizione` varchar(200) DEFAULT NULL,
  `logo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azienda`
--

LOCK TABLES `azienda` WRITE;
/*!40000 ALTER TABLE `azienda` DISABLE KEYS */;
INSERT INTO `azienda` VALUES ('InformaticSolution','9490384538453','Carmine Ippollito','Via micco n°78','infoSolution@gmail.com','328 5687456','infosolution','infosolution','infosolution','',''),('Soft','3948394839583','Pietro Coppola','Via Masanielli','Soft@gmail.com','3333339933','soft','soft','soft','',''),('Tech ','4289420204933','Vittorio Carrelli','Via Roma','tech@hotmail.it','3243439284','tech','tech','tech','','');
/*!40000 ALTER TABLE `azienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `convenzione`
--

DROP TABLE IF EXISTS `convenzione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `convenzione` (
  `id` int(11) NOT NULL,
  `azienda` varchar(45) DEFAULT NULL,
  `tutorAccademico` varchar(45) DEFAULT NULL,
  `impiegato` varchar(45) DEFAULT NULL,
  `luogoNascitaCeo` varchar(45) DEFAULT NULL,
  `dataNascitaCeo` varchar(45) DEFAULT NULL,
  `numeroDipendenti` int(11) DEFAULT NULL,
  `referente` varchar(45) DEFAULT NULL,
  `telefonoReferente` varchar(45) DEFAULT NULL,
  `emailReferente` varchar(45) DEFAULT NULL,
  `attivita` varchar(200) DEFAULT NULL,
  `convalida` tinyint(4) DEFAULT NULL,
  `url` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `convenzione`
--

LOCK TABLES `convenzione` WRITE;
/*!40000 ALTER TABLE `convenzione` DISABLE KEYS */;
/*!40000 ALTER TABLE `convenzione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `impiegato`
--

DROP TABLE IF EXISTS `impiegato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `impiegato` (
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `matricola` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `domanda` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `impiegato`
--

LOCK TABLES `impiegato` WRITE;
/*!40000 ALTER TABLE `impiegato` DISABLE KEYS */;
INSERT INTO `impiegato` VALUES ('Francesco','Ciacci','0000000002','ciacci@gmail.com','ciacci','ciacci','ciacci'),('Carmela','De Rosa','0000000001','derosa@gmail.com','derosa','derosa','derosa');
/*!40000 ALTER TABLE `impiegato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionarioazienda`
--

DROP TABLE IF EXISTS `questionarioazienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionarioazienda` (
  `id` int(11) NOT NULL,
  `studente` varchar(45) DEFAULT NULL,
  `azienda` varchar(45) DEFAULT NULL,
  `tutorAccademico` varchar(45) DEFAULT NULL,
  `impiegato` varchar(45) DEFAULT NULL,
  `periodoTirocinio` varchar(45) DEFAULT NULL,
  `titoloTirocinio` varchar(45) DEFAULT NULL,
  `posizioneRicoperta` varchar(45) DEFAULT NULL,
  `scelte` varchar(200) DEFAULT NULL,
  `convalida` tinyint(4) DEFAULT NULL,
  `url` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionarioazienda`
--

LOCK TABLES `questionarioazienda` WRITE;
/*!40000 ALTER TABLE `questionarioazienda` DISABLE KEYS */;
/*!40000 ALTER TABLE `questionarioazienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionariostudente`
--

DROP TABLE IF EXISTS `questionariostudente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionariostudente` (
  `id` int(11) NOT NULL,
  `studente` varchar(45) DEFAULT NULL,
  `azienda` varchar(45) DEFAULT NULL,
  `tutorAccademico` varchar(45) DEFAULT NULL,
  `impiegato` varchar(45) DEFAULT NULL,
  `periodoTirocinio` varchar(45) DEFAULT NULL,
  `titoloTirocinio` varchar(45) DEFAULT NULL,
  `scelte` varchar(200) DEFAULT NULL,
  `convalida` tinyint(4) DEFAULT NULL,
  `url` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionariostudente`
--

LOCK TABLES `questionariostudente` WRITE;
/*!40000 ALTER TABLE `questionariostudente` DISABLE KEYS */;
/*!40000 ALTER TABLE `questionariostudente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studente`
--

DROP TABLE IF EXISTS `studente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studente` (
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `luogoNascita` varchar(45) DEFAULT NULL,
  `dataNascita` varchar(45) DEFAULT NULL,
  `indirizzo` varchar(45) DEFAULT NULL,
  `citta` varchar(45) DEFAULT NULL,
  `codiceFiscale` varchar(45) DEFAULT NULL,
  `matricola` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `domanda` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studente`
--

LOCK TABLES `studente` WRITE;
/*!40000 ALTER TABLE `studente` DISABLE KEYS */;
INSERT INTO `studente` VALUES ('mario','greco','salerno','09-09-1939','via duomo','nocera','rmcnmwdkn84jf8d','0512108543','grecia@gmail.com','32445842849','grecia','atene','atene'),('anna','riccio','napoli','04-09-1996','via scotola','somma vesuviana','rccnmr84045mdk50y','0512103799','anna_096@hotmail.it','3284399560','riccia96','sbanf','sbanf');
/*!40000 ALTER TABLE `studente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tirocinio`
--

DROP TABLE IF EXISTS `tirocinio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tirocinio` (
  `id` int(11) NOT NULL,
  `studente` varchar(45) DEFAULT NULL,
  `azienda` varchar(45) DEFAULT NULL,
  `tutorAccademico` varchar(45) DEFAULT NULL,
  `impiegato` varchar(45) DEFAULT NULL,
  `annoAccademico` varchar(45) DEFAULT NULL,
  `cfu` int(11) DEFAULT NULL,
  `handicap` tinyint(4) DEFAULT NULL,
  `sedeTirocinio` varchar(45) DEFAULT NULL,
  `accessoLocali` varchar(200) DEFAULT NULL,
  `periodoTirocinio` varchar(45) DEFAULT NULL,
  `obiettivoTirocinio` varchar(45) DEFAULT NULL,
  `facilitazioni` varchar(45) DEFAULT NULL,
  `convalidaAzienda` tinyint(4) DEFAULT NULL,
  `convalidaTutor` tinyint(4) DEFAULT NULL,
  `convalidaStudente` tinyint(4) DEFAULT NULL,
  `convalidaRichiesta` tinyint(4) DEFAULT NULL,
  `convalidaAttivita` tinyint(4) DEFAULT NULL,
  `registroOre` varchar(300) DEFAULT NULL,
  `questionarioStudente` int(11) DEFAULT NULL,
  `questionarioAzienda` int(11) DEFAULT NULL,
  `url` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tirocinio`
--

LOCK TABLES `tirocinio` WRITE;
/*!40000 ALTER TABLE `tirocinio` DISABLE KEYS */;
/*!40000 ALTER TABLE `tirocinio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutor`
--

DROP TABLE IF EXISTS `tutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tutor` (
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `matricola` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `domanda` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor`
--

LOCK TABLES `tutor` WRITE;
/*!40000 ALTER TABLE `tutor` DISABLE KEYS */;
INSERT INTO `tutor` VALUES ('Vincenzo','Auletta','0010010004','auletta@gamil.com','auletta','auletta','auletta'),('Roberto','De Prisco','0010010003','dePrisco@gmail.com','deprisco','deprisco','deprisco'),('Filomena','Ferrucci','0010010002','ferrucci@gmail.com','ferrucci','ferrucci','ferrucci'),('Carmine','Gravino','0010010001','gravino@gmail.com','gravino','gravino','gravino'),('Giuseppe','Polese','0010010005','polese@gamil.com','polese','polese','polese');
/*!40000 ALTER TABLE `tutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'tirociniofast'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-15 23:05:57
