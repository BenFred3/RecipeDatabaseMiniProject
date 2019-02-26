-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: recipes
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ingredients`
--

DROP TABLE IF EXISTS `ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ingredients` (
  `RECIPE_ID` int(11) NOT NULL,
  `INGREDIENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `INGREDIENT_NAME` varchar(50) NOT NULL,
  `INGREDIENT_QUANTITY` varchar(20) NOT NULL,
  `INGREDIENT_SORT_NUMBER` int(11) NOT NULL,
  PRIMARY KEY (`INGREDIENT_ID`),
  KEY `RECIPE_ID` (`RECIPE_ID`),
  CONSTRAINT `ingredients_ibfk_1` FOREIGN KEY (`RECIPE_ID`) REFERENCES `recipe_info` (`recipe_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredients`
--

LOCK TABLES `ingredients` WRITE;
/*!40000 ALTER TABLE `ingredients` DISABLE KEYS */;
INSERT INTO `ingredients` VALUES (1,1,'Dry Spaghetti','12 Ounces',1),(1,2,'Canola Oil','2 Tablespoons',2),(1,3,'Chopped Onion','1 Cup',3),(1,4,'Ground round beef','1 Pound',4),(1,5,'Pasta Sauce','1 Can',5);
/*!40000 ALTER TABLE `ingredients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe_info`
--

DROP TABLE IF EXISTS `recipe_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `recipe_info` (
  `RECIPE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RECIPE_NAME` varchar(50) NOT NULL,
  `RECIPE_TYPE` varchar(30) DEFAULT NULL,
  `DATE_ADDED` date DEFAULT NULL,
  `CALORIES` int(11) DEFAULT NULL,
  `PREP_TIME` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`RECIPE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe_info`
--

LOCK TABLES `recipe_info` WRITE;
/*!40000 ALTER TABLE `recipe_info` DISABLE KEYS */;
INSERT INTO `recipe_info` VALUES (1,'Spaghetti and Meat Sauce','Full Meal','2019-02-22',487,'15 Minutes');
/*!40000 ALTER TABLE `recipe_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-25 19:58:00
