CREATE DATABASE  IF NOT EXISTS `newcodington` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `newcodington`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: newcodington
-- ------------------------------------------------------
-- Server version	5.5.21

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
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events` (
  `id_event` int(11) NOT NULL AUTO_INCREMENT,
  `name_event` varchar(45) DEFAULT NULL,
  `description_event` varchar(250) DEFAULT NULL,
  `start_event` datetime DEFAULT NULL,
  `end_event` datetime DEFAULT NULL,
  `type_event` varchar(50) DEFAULT NULL,
  `ticket_price` float DEFAULT NULL,
  `seats_available` int(11) DEFAULT NULL,
  `seats_total` int(11) DEFAULT NULL,
  `id_place` int(11) NOT NULL,
  PRIMARY KEY (`id_event`),
  KEY `fk_events_places1` (`id_place`),
  CONSTRAINT `fk_events_places1` FOREIGN KEY (`id_place`) REFERENCES `places` (`id_place`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1,'Evento 1','desc evento1','2014-02-01 00:00:00','2014-02-01 00:00:00','1',20,30,30,1),(2,'Evento2','desc evento2','2014-02-01 00:00:00','2014-02-01 00:00:00','1',30,40,40,2),(3,'Evento3','desc evento3','2014-02-01 00:00:00','2014-02-01 00:00:00','1',24,24,24,3),(4,'Evento4','desc evento4','2014-02-01 00:00:00','2014-02-01 00:00:00','1',4,66,66,4),(5,'Evento5','desc evento5','2014-02-01 00:00:00','2014-02-01 00:00:00','1',3,22,22,5),(6,'Evento6','desc evento6','2014-02-01 00:00:00','2014-02-01 00:00:00','1',2,22,22,6),(7,'Evento7','desc evento7','2014-02-01 00:00:00','2014-02-01 00:00:00','1',33,99,99,7),(8,'Evento8','desc evento8','2014-02-01 00:00:00','2014-02-01 00:00:00','1',1,98,98,8),(9,'Evento9','desc evento9','2014-02-01 00:00:00','2014-02-01 00:00:00','1',11,11,11,1),(10,'Evento10','desc evento10','2014-02-01 00:00:00','2014-02-01 00:00:00','1',111,111,111,9),(11,'Evento11','desc evento11','2014-02-01 00:00:00','2014-02-01 00:00:00','1',1,11,11,3),(12,'Evento12','desc evento12','2014-02-01 00:00:00','2014-02-01 00:00:00','1',2,2,2,4),(13,'Evento13','desc evento13','2014-02-01 00:00:00','2014-02-01 00:00:00','1',44,44,44,5),(14,'Evento14','desc evento14','2014-02-01 00:00:00','2014-02-01 00:00:00','1',877,88,88,6),(15,'Evento15','desc evento15','2014-02-01 00:00:00','2014-02-01 00:00:00','1',33,33,33,7),(16,'Evento 16','desc evento16','2014-02-01 00:00:00','2014-02-01 00:00:00','1',11,11,11,8);
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-02  4:04:05
