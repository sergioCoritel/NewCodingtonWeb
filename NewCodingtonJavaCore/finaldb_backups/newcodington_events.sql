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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1,'Big Data conference','Big data is an all encompassing term for any collection of data sets so large and complex that it becomes difficult to process them using traditional data processing applications','2015-04-01 09:00:00','2015-04-18 20:00:00','Conference',31,301,301,1),(2,'Life and work of Goya','Guided by the work and life of Goya','2015-03-04 09:00:00','2015-03-14 20:00:00','Exhibition of paintings',18,100,100,2),(3,'E-commerce platform conference','Deliver relevant, immersive experiences to every customer at every stage of the purchase journey across every channel, including the mobile web and apps.','2015-06-04 10:00:00','2015-04-06 14:00:00','Conference',10,100,100,1),(4,'Guided tour Santiago Bernabeu','Visit the Santiago Bernabeu Stadium in Madrid with an entrance, and explore the iconic stadium of football club Real Madrid at your own pace.','2014-12-13 11:00:00','2014-12-13 14:00:00','Deportes',17,66,66,4),(5,'Life and work of Picasso','Guided by the work and life of Picasso','2014-12-06 09:00:00','2014-12-13 22:00:00','Exhibition of paintings ',5,40,40,2),(6,'Port aventura ','Park of attractions','2015-01-01 09:00:00','2014-12-31 22:00:00','Entertainment',25,22,22,6),(7,'The Rastro market','Exposition of traditional productos of our Country.','2014-12-09 11:00:00','2014-12-24 21:00:00','Entertainment',8,99,99,7),(9,'Young Entrepreneurs','Conference talented young entrepreneurs with business.','2015-08-07 09:00:00','2015-08-08 19:00:00','Conference',4,60,60,1),(11,'The Retiro','Guided tour of the lung of Madrid','2014-12-05 10:00:00','2014-12-05 14:00:00','Culture',3,30,30,3),(12,'Atletico de Madrid - Real Betis Balompie','Cup quarter-finals of the Copa del Rey','2014-12-20 18:00:00','2014-12-20 20:30:00','Sports2',85,60000,60000,12),(13,'The Lion King 2','Musical inspired by the movie disney','2015-01-03 18:00:00','2015-01-03 20:00:00','Entertainment',75,50000,50000,5),(21,'Bear','Show of bears','2015-05-08 10:00:00','2015-05-08 13:00:00','Entertainment',30,40,40,8);
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

-- Dump completed on 2014-12-05  9:59:42
