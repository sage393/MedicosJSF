-- MySQL dump 10.13  Distrib 5.7.16, for Linux (x86_64)
--
-- Host: localhost    Database: MEDICOS
-- ------------------------------------------------------
-- Server version	5.7.16-0ubuntu0.16.04.1

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
-- Table structure for table `ESPECIALIDAD`
--

DROP TABLE IF EXISTS `ESPECIALIDAD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ESPECIALIDAD` (
  `ID_ESPECIALIDAD` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID_ESPECIALIDAD`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ESPECIALIDAD`
--

LOCK TABLES `ESPECIALIDAD` WRITE;
/*!40000 ALTER TABLE `ESPECIALIDAD` DISABLE KEYS */;
INSERT INTO `ESPECIALIDAD` VALUES (1,'Odontologo'),(2,'Pediatra'),(3,'Otorrino');
/*!40000 ALTER TABLE `ESPECIALIDAD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ESTABLECIMIENTO`
--

DROP TABLE IF EXISTS `ESTABLECIMIENTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ESTABLECIMIENTO` (
  `ID_ESTABLECIMIENTO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID_ESTABLECIMIENTO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ESTABLECIMIENTO`
--

LOCK TABLES `ESTABLECIMIENTO` WRITE;
/*!40000 ALTER TABLE `ESTABLECIMIENTO` DISABLE KEYS */;
INSERT INTO `ESTABLECIMIENTO` VALUES (1,'ISSS'),(2,'XYZ');
/*!40000 ALTER TABLE `ESTABLECIMIENTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MEDICO`
--

DROP TABLE IF EXISTS `MEDICO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MEDICO` (
  `ID_MEDICO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_ESPECIALIDAD` int(11) NOT NULL,
  `ID_ESTABLECIMIENTO` int(11) NOT NULL,
  `NOMBRES` varchar(50) DEFAULT NULL,
  `APELLIDOS` varchar(50) DEFAULT NULL,
  `JVP` varchar(50) DEFAULT NULL,
  `ESTADO` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_MEDICO`),
  KEY `ID_ESPECIALIDAD_idx` (`ID_ESPECIALIDAD`),
  KEY `ID_ESTABLECIMIENTO_idx` (`ID_ESTABLECIMIENTO`),
  CONSTRAINT `ID_ESPECIALIDAD` FOREIGN KEY (`ID_ESPECIALIDAD`) REFERENCES `ESPECIALIDAD` (`ID_ESPECIALIDAD`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_ESTABLECIMIENTO` FOREIGN KEY (`ID_ESTABLECIMIENTO`) REFERENCES `ESTABLECIMIENTO` (`ID_ESTABLECIMIENTO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MEDICO`
--

LOCK TABLES `MEDICO` WRITE;
/*!40000 ALTER TABLE `MEDICO` DISABLE KEYS */;
INSERT INTO `MEDICO` VALUES (1,1,1,'Roberto','Perez','12345','True'),(2,1,1,'Samuel','Gonzalez','54321','True'),(3,1,1,'Fernando','Escobar','12345','True'),(4,1,1,'Felipe','Gonzalez','54321','True'),(5,1,1,'Diego','Fernandez','12345','False');
/*!40000 ALTER TABLE `MEDICO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-01 22:30:38
