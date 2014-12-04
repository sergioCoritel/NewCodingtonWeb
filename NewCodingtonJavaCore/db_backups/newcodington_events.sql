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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1,'Big Data conference','Big data is an all encompassing term for any collection of data sets so large and complex that it becomes difficult to process them using traditional data processing applications','2014-12-03 05:39:00','2014-12-23 05:39:00','Conference',31,301,300,1),(2,'Life and work of Goya','Guided by the work and life of Goya','2014-02-01 00:00:00','2014-02-01 00:00:00','Exhibition of paintings',25,100,100,2),(3,'E-commerce platform conference','Deliver relevant, immersive experiences to every customer at every stage of the purchase journey across every channel, including the mobile web and apps.','2014-02-01 00:00:00','2014-02-01 00:00:00','adsfads',20,100,100,1),(4,'Guided tour Santiago Bernabeu','Visit the Santiago Bernabeu Stadium in Madrid with an entrance, and explore the iconic stadium of football club Real Madrid at your own pace.','2014-02-01 00:00:00','2014-02-01 00:00:00','Deportes',17,66,66,4),(5,'life and work of Picasso','Guided by the work and life of Goya','2014-02-01 00:00:00','2014-02-01 00:00:00','Exhibition of paintings ',5,40,40,2),(6,'Port aventura ','Park of attractions','2014-02-01 00:00:00','2014-02-01 00:00:00','Entertainment',25,22,22,6),(7,'The Rastro market',NULL,'2014-12-09 08:00:00','2014-12-16 16:00:00','Entertainment',33,99,99,7),(9,'Young Entrepreneurs','Conference talented young entrepreneurs with business.','2014-05-18 10:00:00','2014-05-18 18:00:00','Conference',0,60,60,1),(10,'Evento10','desc evento10','2014-02-01 00:00:00','2014-02-01 00:00:00','1',111,111,111,9),(11,'The Retiro','Guided tour of the lung of Madrid','2014-02-01 00:00:00','2014-02-01 00:00:00','Culture',3,30,30,3),(12,'Atletico de Madrid - Real Betis Balompie','Cup quarter-finals of the Copa del Rey','2014-02-01 00:00:00','2014-02-01 00:00:00','Sports2',205,60000,60000,4),(13,'The Lion King 2','Musical inspired by the movie disney','2014-02-01 00:00:00','2014-02-01 00:00:00','Entretainmen',75,50000,50000,5),(21,'Bear','Show of bears','2014-02-01 00:00:00','2014-02-01 00:00:00','Entertainment',30,40,40,8);
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

-- Dump completed on 2014-12-04  6:13:58
