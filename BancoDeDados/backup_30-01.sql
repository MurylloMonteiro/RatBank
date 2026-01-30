-- MySQL dump 10.13  Distrib 8.0.44, for Linux (x86_64)
--
-- Host: localhost    Database: ratbank
-- ------------------------------------------------------
-- Server version	8.0.44-0ubuntu0.22.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account_model`
--

DROP TABLE IF EXISTS `account_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_model` (
  `id` binary(16) NOT NULL,
  `balance` double NOT NULL,
  `date_time_create` date DEFAULT NULL,
  `negative_balance` double NOT NULL,
  `number_account` varchar(255) NOT NULL,
  `pixkey` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK7i1bnr673fqrwv0f6jco6jye4` (`number_account`),
  UNIQUE KEY `UKpld9yso84s97jk06d9a8r1u2i` (`pixkey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_model`
--

LOCK TABLES `account_model` WRITE;
/*!40000 ALTER TABLE `account_model` DISABLE KEYS */;
INSERT INTO `account_model` VALUES (_binary 'tFE}\ÔWCDÅ\Êë˚ò©êò',0,'2026-01-24',0,'237131942','469.722.748-47'),(_binary '§û:¸®L≠∑Ø∏cÄ¸\Ó≥',8046,'2026-01-26',0,'290606324','469.722.258-98'),(_binary '≠á\≈\Œ\nNÇsrM!g*£',1608,'2026-01-24',0,'185806012','469.722.748-97'),(_binary '∏\‘¸w\˜\"G\ÓÇp|\‘\Àµì',160,'2026-01-24',0,'818495452','469.722.258-25'),(_binary '\Î\\º∆¶BF=Ω\÷=â\“v',359,'2026-01-24',0,'462601078','469.722.748-25');
/*!40000 ALTER TABLE `account_model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transation_model`
--

DROP TABLE IF EXISTS `transation_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transation_model` (
  `id` binary(16) NOT NULL,
  `date_time` datetime(6) DEFAULT NULL,
  `number_account_envoy` varchar(255) DEFAULT NULL,
  `number_accout_received` varchar(255) DEFAULT NULL,
  `pix_key_envoy` varchar(255) DEFAULT NULL,
  `pix_key_received` varchar(255) DEFAULT NULL,
  `transation_value` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transation_model`
--

LOCK TABLES `transation_model` WRITE;
/*!40000 ALTER TABLE `transation_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `transation_model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_model`
--

DROP TABLE IF EXISTS `user_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_model` (
  `id` binary(16) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `date_birth` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `account_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKwxxx62753hssb9t5n93gaweb` (`cpf`),
  UNIQUE KEY `UKla8xty622mpbfdhq2iixt9lhu` (`email`),
  UNIQUE KEY `UK1us3bb5f8gmf0rxahndslyvaq` (`account_id`),
  CONSTRAINT `FK2syl8q0178hxbr4680whniooy` FOREIGN KEY (`account_id`) REFERENCES `account_model` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_model`
--

LOCK TABLES `user_model` WRITE;
/*!40000 ALTER TABLE `user_model` DISABLE KEYS */;
INSERT INTO `user_model` VALUES (_binary '$xYY}vKG¶\Ô≤4ÄÄ\Ú ','469.722.748-47',NULL,'rama@gmail.com','1234','83 93453-1236','maurilio',_binary 'tFE}\ÔWCDÅ\Êë˚ò©êò'),(_binary ',\Õ\ÿ\ZA˚ÄG>¯{','469.722.748-97',NULL,'ramaas@gmail.com','$2a$12$Z.zQuWrI2FhiRQoRIt0EKOaFWilIbB.g7FC/JO8hBaxGIp3U6//Va','83 93453-4236','robertinho',_binary '≠á\≈\Œ\nNÇsrM!g*£'),(_binary 'çnG&ñâDI°\Ù\ÔP\·B\0','469.722.258-25',NULL,'mauasdaio@gmail.com','$2a$12$PgnZ4YkR0C0IjE3Z59q6iuZz5.0O6f3YUhXcX49gi9HSwfdNHewF.','83 94753-4236','ratomanocu',_binary '∏\‘¸w\˜\"G\ÓÇp|\‘\Àµì'),(_binary '±äõJëÜA∂,±ºiT˙','469.722.748-25',NULL,'maurilio@gmail.com','$2a$12$HkKV9RhvMqRZ6tO4mOIr6e0W2KzlUXp08SZnqlQrJHIKaafmb5v4S','83 94753-4236','maurilio',_binary '\Î\\º∆¶BF=Ω\÷=â\“v'),(_binary '∂ù®XnO%å©]®c(Ø','469.722.258-98',NULL,'muryllomonteiro209@gmail.com','$2a$12$9TTSa.gkxNlPzJjJCsm04.SMSSb4gbK33BQHYAjsgaMMyciLP4xGG','83 94753-1234','Muryllo Monteiro de lima',_binary '§û:¸®L≠∑Ø∏cÄ¸\Ó≥');
/*!40000 ALTER TABLE `user_model` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-30 12:55:20
