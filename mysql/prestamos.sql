-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: prestamos
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cds`
--

DROP TABLE IF EXISTS `cds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cds` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) NOT NULL,
  `autor` varchar(255) DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `prestamo` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cds`
--

LOCK TABLES `cds` WRITE;
/*!40000 ALTER TABLE `cds` DISABLE KEYS */;
INSERT INTO `cds` VALUES (1,'Dark Side of the Moon','Pink Floyd','Rock',NULL),(2,'Thriller','Michael Jackson','Pop','Prestado a Rosa el 11/09/2024'),(3,'Back in Black','AC/DC','Rock',NULL),(4,'The Wall','Pink Floyd','Rock','Prestado a Juan el 15/10/2024'),(5,'Abbey Road','The Beatles','Rock',NULL),(6,'Led Zeppelin IV','Led Zeppelin','Rock','Prestado a Luis el 01/11/2024'),(7,'Nevermind','Nirvana','Grunge',NULL),(8,'Rumours','Fleetwood Mac','Rock','Prestado a María el 20/08/2024'),(9,'The Joshua Tree','U2','Rock',NULL),(10,'Hotel California','Eagles','Rock','Prestado a Ana el 05/07/2024'),(11,'Born to Run','Bruce Springsteen','Rock',NULL),(12,'A Night at the Opera','Queen','Rock','Prestado a Pedro el 22/06/2024'),(13,'American Idiot','Green Day','Punk Rock',NULL),(14,'Metallica (Black Album)','Metallica','Metal','Prestado a Laura el 30/09/2024'),(15,'21','Adele','Pop',NULL),(16,'Random Access Memories','Daft Punk','Electrónica','Prestado a Javier el 14/08/2024'),(17,'Revolver','The Beatles','Rock',NULL),(18,'Sgt. Pepper’s Lonely Hearts Club Band','The Beatles','Rock','Prestado a Carla el 03/05/2024'),(19,'Goodbye Yellow Brick Road','Elton John','Rock',NULL),(20,'Parachutes','Coldplay','Alternative','Prestado a Daniel el 12/04/2024');
/*!40000 ALTER TABLE `cds` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-03 22:40:11
