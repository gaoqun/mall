-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: dev_mall
-- ------------------------------------------------------
-- Server version	5.6.37

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
-- Table structure for table `goods_info`
--

DROP TABLE IF EXISTS `goods_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(45) NOT NULL,
  `goods_describe` varchar(45) NOT NULL,
  `goods_price` decimal(5,2) NOT NULL DEFAULT '0.00',
  `goods_count` int(11) NOT NULL,
  `goods_pic` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_info`
--

LOCK TABLES `goods_info` WRITE;
/*!40000 ALTER TABLE `goods_info` DISABLE KEYS */;
INSERT INTO `goods_info` VALUES (1,'秦时明月','123阿斯达',322.22,1212,'timg.jpeg'),(2,'十里春风不如你','书还好吧',33.99,12,'cfslbrn.jpg'),(3,'十里春风不如你2','哈哈哈',88.99,43,'cfslbrn.jpg'),(4,'秦时明月2','是否撒大声地',132.33,321,'timg.jpeg'),(5,'哈哈哈','啊实打实的',322.11,123,'timg.jpeg'),(6,'斤斤计较','是多大',123.33,123,'timg.jpeg'),(7,'dffgdf','asdasd',123.22,12212,'cfslbrn.jpg'),(8,'啊实打实的','啊实打实的',123.55,122,'cfslbrn.jpg'),(9,'人斯蒂芬斯蒂芬','啊实打实的',33.55,234,'timg.jpeg'),(10,'看见了框架阿斯达','啊实打实的',123.11,5467,'cfslbrn.jpg'),(11,'2','啊实打实的',33.99,1231,'timg.jpeg'),(12,'ewdasda','啊实打实的',12.99,234,'timg.jpeg'),(13,'cv斯蒂芬斯蒂芬','阿萨斯多',33.99,23,'timg.jpeg'),(14,'东方故事大风更','啊实打实的',87.99,432,'timg.jpeg'),(15,'从VB从VB','啊实打实的',18.99,1232,'timg.jpeg');
/*!40000 ALTER TABLE `goods_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-19 13:08:51
