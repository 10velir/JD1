-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ORDER_ID` int(11) NOT NULL,
  `PRODUCT_ID` int(11) NOT NULL,
  `QUANTITY` int(11) NOT NULL DEFAULT '1',
  `DISCOUNT` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `Order_fk` (`ORDER_ID`),
  KEY `Product_fk` (`PRODUCT_ID`),
  CONSTRAINT `Order_fk` FOREIGN KEY (`ORDER_ID`) REFERENCES `order` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `Product_fk` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (33,35,2,1,0),(34,36,2,1,0),(35,37,2,1,0),(36,38,2,1,0),(37,39,3,1,0),(38,40,2,1,0),(39,41,2,1,0),(40,42,2,1,0),(41,43,2,1,0),(42,44,2,1,0),(43,45,2,1,0),(44,46,2,1,0),(45,47,2,1,0),(46,48,2,1,0),(47,49,2,1,0),(48,50,2,1,0);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(10) NOT NULL,
  `DATE` datetime NOT NULL,
  `QUANTITY` int(5) NOT NULL DEFAULT '1',
  `STATUS` char(10) NOT NULL DEFAULT 'NEW',
  `TOTAL` bigint(20) NOT NULL DEFAULT '10',
  `PAID` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `user_fk` (`USER_ID`),
  CONSTRAINT `user_fk` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (35,2,'2018-02-17 02:08:12',1,'NEW',367,0),(36,2,'2018-02-17 02:08:15',1,'NEW',367,0),(37,2,'2018-02-17 02:19:12',1,'NEW',367,0),(38,2,'2018-02-17 02:19:26',1,'NEW',367,0),(39,2,'2018-02-17 02:19:33',1,'NEW',376,0),(40,2,'2018-02-17 02:21:26',1,'NEW',367,0),(41,2,'2018-02-17 02:22:04',1,'NEW',367,0),(42,2,'2018-02-17 02:28:48',1,'NEW',367,0),(43,2,'2018-02-17 02:29:31',1,'NEW',367,0),(44,2,'2018-02-17 02:29:35',1,'NEW',367,0),(45,2,'2018-02-17 02:29:42',1,'NEW',367,0),(46,2,'2018-02-17 02:51:56',1,'NEW',367,0),(47,2,'2018-02-17 02:52:12',1,'NEW',367,0),(48,2,'2018-02-17 02:53:11',1,'NEW',367,0),(49,2,'2018-02-17 03:22:58',1,'NEW',367,0),(50,2,'2018-02-17 03:26:16',1,'NEW',367,0);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `ID` int(8) NOT NULL AUTO_INCREMENT,
  `SUPPLIER` varchar(20) DEFAULT NULL,
  `MODEL` varchar(15) DEFAULT NULL,
  `PRICE` decimal(10,0) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Merc','GBH 2-24 D',259),(2,'Posrch','GBH 2-26 DFR',367),(3,'Lambor','GBH 2-28 DFV',376),(4,'Lada','GBH 2-24 DRE',309);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `USER_ID` int(10) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) DEFAULT NULL,
  `LOGIN` varchar(20) NOT NULL,
  `PASSWORD` varchar(25) NOT NULL,
  `BIRTHDAY` date DEFAULT NULL,
  `STATUS` char(10) NOT NULL DEFAULT 'ACTIVE',
  `ROLE` char(4) NOT NULL DEFAULT 'USER',
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USER_LOGIN_uindex` (`LOGIN`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Yulij','Yulij','Pass!',NULL,'ACTIVE','USER'),(2,'Denis','Denis','123',NULL,'ACTIVE','USER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-17  4:02:59
