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
-- Table structure for table `places`
--

DROP TABLE IF EXISTS `places`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `places` (
  `id_place` int(11) NOT NULL AUTO_INCREMENT,
  `id_type_place` int(11) DEFAULT NULL,
  `name_place` varchar(50) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `description_place` varchar(250) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `zone` varchar(50) DEFAULT NULL,
  `image` longblob,
  `is_building` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_place`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `places`
--

LOCK TABLES `places` WRITE;
/*!40000 ALTER TABLE `places` DISABLE KEYS */;
INSERT INTO `places` VALUES (1,1,'Large business1',100,'desc large business1','2014-02-01 00:00:00','2014-02-01 00:00:00','SOUTH',NULL,1),(2,2,'museum1',100,'desc museum1','2014-02-01 00:00:00','2014-02-01 00:00:00','SOUTH',NULL,1),(3,3,'park1',100,'desc park1','2014-02-01 00:00:00','2014-02-01 00:00:00','SOUTH',NULL,0),(4,4,'stadium1',100,'desc stadium1','2014-02-01 00:00:00','2014-02-01 00:00:00','SOUTH',NULL,0),(5,5,'theater1',100,'desc theater1','2014-02-01 00:00:00','2014-02-01 00:00:00','SOUTH',NULL,0),(6,6,'touristic attraction1',100,'desc touristic attraction1','2014-02-01 00:00:00','2014-02-01 00:00:00','SOUTH',NULL,0),(7,7,'traditional market1',100,'desc trad market1','2014-02-01 00:00:00','2014-02-01 00:00:00','SOUTH',NULL,0),(8,8,'zoo1',100,'desc zoo1','2014-02-01 00:00:00','2014-02-01 00:00:00','SOUTH',NULL,0),(9,2,'museum2',100,'desc museum2','2014-02-01 00:00:00','2014-02-01 00:00:00','SOUTH',NULL,0);
/*!40000 ALTER TABLE `places` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-17  7:46:38