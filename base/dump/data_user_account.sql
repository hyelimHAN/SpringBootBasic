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
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_account` (
  `sno` int(11) NOT NULL AUTO_INCREMENT COMMENT '고유번호',
  `username` varchar(10) NOT NULL COMMENT '사용자 아이디 (병원코드)',
  `password` varchar(100) NOT NULL DEFAULT '$2a$10$M4mxye0LD1cGefVrbofk7OzZDUHMikh3xbAyv5PTmMo53/1mpzTWG' COMMENT '비밀번호(into7898!@#$)',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '사용자 이름 (병원 이름)',
  `isAccountNonExpired` tinyint(1) unsigned NOT NULL DEFAULT 1 COMMENT '계정 만료 여부 (true : 사용가능, false : 사용 불가능)',
  `isAccountNonLocked` tinyint(1) NOT NULL DEFAULT 1 COMMENT '계정 잠금 여부 (true : 사용가능, false : 계정 잠금)',
  `isCredentialsNonExpired` tinyint(1) NOT NULL DEFAULT 1 COMMENT '자격 증명 여부 (true : 사용가능, false : 계정 자격 증명 안됨)',
  `isEnabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '계정 활성화 여부 (true: 사용 가능, false: 사용 불가능)',
  `insertDate` datetime NOT NULL COMMENT '등록일시',
  `updateDate` datetime DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`sno`),
  UNIQUE KEY `sno_UNIQUE` (`sno`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES (1,'1000','$2a$10$M4mxye0LD1cGefVrbofk7OzZDUHMikh3xbAyv5PTmMo53/1mpzTWG','테스트 병원 USER',1,1,1,1,'2021-04-30 00:00:00',NULL),(2,'1001','$2a$10$M4mxye0LD1cGefVrbofk7OzZDUHMikh3xbAyv5PTmMo53/1mpzTWG','테스트 병원 ADMIN',1,1,1,1,'2021-04-30 00:00:00',NULL);
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-06 12:43:15
