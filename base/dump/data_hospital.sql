-- MariaDB dump 10.18  Distrib 10.5.8-MariaDB, for osx10.15 (x86_64)
--
-- Host: localhost    Database: data
-- ------------------------------------------------------
-- Server version	10.5.9-MariaDB-1:10.5.9+maria~focal

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
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospital` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `cocode` int(11) NOT NULL,
  `full_file_size` int(11) NOT NULL,
  `start_date` date DEFAULT current_timestamp(),
  `end_date` date DEFAULT current_timestamp(),
  `use_YN` varchar(1) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`idx`),
  KEY `idx_hospital_cocode` (`cocode`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` VALUES (1,1,0,'2021-04-14','2021-04-14','Y'),(2,2,0,'2021-04-14','2021-04-14','Y'),(3,3,0,'2021-04-14','2021-04-14','Y'),(4,4,0,'2021-04-14','2021-04-14','Y'),(5,5,0,'2021-04-14','2021-04-14','Y'),(6,6,0,'2021-04-14','2021-04-14','Y'),(7,7,0,'2021-04-14','2021-04-14','Y'),(8,8,0,'2021-04-14','2021-04-14','Y'),(9,9,0,'2021-04-14','2021-04-14','Y'),(10,10,0,'2021-04-14','2021-04-14','N'),(11,11,0,'2021-04-14','2021-04-14','Y'),(12,12,0,'2021-04-14','2021-04-14','Y'),(13,13,0,'2021-04-14','2021-04-14','Y'),(14,14,0,'2021-04-14','2021-04-14','Y'),(15,15,0,'2021-04-14','2021-04-14','N'),(16,16,0,'2021-04-14','2021-04-14','Y'),(17,17,0,'2021-04-14','2021-04-14','Y'),(18,1000,100,'2021-05-03','2021-05-03','Y');
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-06 12:43:14
