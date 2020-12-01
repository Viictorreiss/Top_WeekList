-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: db_recomendacoes
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `tb_avaliacao`
--

DROP TABLE IF EXISTS `tb_avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_avaliacao` (
  `idAvaliacao` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int DEFAULT NULL,
  `idMusica` int DEFAULT NULL,
  `nota` int DEFAULT NULL,
  PRIMARY KEY (`idAvaliacao`),
  KEY `idUsuario` (`idUsuario`),
  KEY `idMusica` (`idMusica`),
  CONSTRAINT `tb_avaliacao_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `tb_usuario` (`idUsuario`),
  CONSTRAINT `tb_avaliacao_ibfk_2` FOREIGN KEY (`idMusica`) REFERENCES `tb_musica` (`idMusica`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_avaliacao`
--

LOCK TABLES `tb_avaliacao` WRITE;
/*!40000 ALTER TABLE `tb_avaliacao` DISABLE KEYS */;
INSERT INTO `tb_avaliacao` VALUES (1,1,1,5),(2,1,20,5),(3,1,7,3),(5,2,2,2),(6,3,2,5),(11,1,3,4),(12,5,3,5),(14,12,2,5),(15,12,3,5),(16,12,4,4);
/*!40000 ALTER TABLE `tb_avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_colecao`
--

DROP TABLE IF EXISTS `tb_colecao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_colecao` (
  `idColecao` int NOT NULL AUTO_INCREMENT,
  `idMusica` int DEFAULT NULL,
  `idGenero` int DEFAULT NULL,
  PRIMARY KEY (`idColecao`),
  KEY `idMusica` (`idMusica`),
  KEY `idGenero` (`idGenero`),
  CONSTRAINT `tb_colecao_ibfk_1` FOREIGN KEY (`idMusica`) REFERENCES `tb_musica` (`idMusica`),
  CONSTRAINT `tb_colecao_ibfk_2` FOREIGN KEY (`idGenero`) REFERENCES `tb_genero` (`idGenero`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_colecao`
--

LOCK TABLES `tb_colecao` WRITE;
/*!40000 ALTER TABLE `tb_colecao` DISABLE KEYS */;
INSERT INTO `tb_colecao` VALUES (1,1,1),(2,1,2),(3,6,3),(4,2,1),(5,3,1),(6,4,1),(7,5,1),(8,6,1),(9,7,1),(10,8,1),(11,9,1),(12,10,1),(13,11,1),(14,12,1),(15,13,1),(16,14,1),(17,15,1),(18,16,1),(19,17,1),(20,18,1),(21,19,1),(22,20,1);
/*!40000 ALTER TABLE `tb_colecao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_genero`
--

DROP TABLE IF EXISTS `tb_genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_genero` (
  `idGenero` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idGenero`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_genero`
--

LOCK TABLES `tb_genero` WRITE;
/*!40000 ALTER TABLE `tb_genero` DISABLE KEYS */;
INSERT INTO `tb_genero` VALUES (1,'Rock'),(2,'Clássico'),(3,'Pop'),(4,'Blues'),(5,'Jazz'),(6,'Eletronica'),(7,'MPB');
/*!40000 ALTER TABLE `tb_genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_generofavorito`
--

DROP TABLE IF EXISTS `tb_generofavorito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_generofavorito` (
  `idGeneroFavorito` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int DEFAULT NULL,
  `idGenero` int DEFAULT NULL,
  `registro` date DEFAULT NULL,
  PRIMARY KEY (`idGeneroFavorito`),
  KEY `idUsuario` (`idUsuario`),
  KEY `idGenero` (`idGenero`),
  CONSTRAINT `tb_generofavorito_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `tb_usuario` (`idUsuario`),
  CONSTRAINT `tb_generofavorito_ibfk_2` FOREIGN KEY (`idGenero`) REFERENCES `tb_genero` (`idGenero`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_generofavorito`
--

LOCK TABLES `tb_generofavorito` WRITE;
/*!40000 ALTER TABLE `tb_generofavorito` DISABLE KEYS */;
INSERT INTO `tb_generofavorito` VALUES (7,1,3,'2020-11-30'),(9,1,5,'2020-11-30'),(10,5,1,'2020-11-30'),(11,5,3,'2020-11-30'),(12,5,6,'2020-11-30'),(16,11,1,'2020-11-30'),(17,11,3,'2020-11-30'),(18,12,1,'2020-11-30'),(19,12,5,'2020-11-30');
/*!40000 ALTER TABLE `tb_generofavorito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_musica`
--

DROP TABLE IF EXISTS `tb_musica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_musica` (
  `idMusica` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idMusica`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_musica`
--

LOCK TABLES `tb_musica` WRITE;
/*!40000 ALTER TABLE `tb_musica` DISABLE KEYS */;
INSERT INTO `tb_musica` VALUES (1,'Layla - Eric Clapton'),(2,'Rainbow in the Dark - Dio'),(3,'Wildcard  - KSHMR'),(4,'Kings & Queens - Ava Max'),(5,'Let it Be - Beatles'),(6,'I Cant Quit You Baby – Otis Rush'),(7,'I’d Rather Go Blind – Etta James'),(8,'Fly Me To The Moon - Frank Sinatra'),(9,'Mood Indigo - Duke Ellington & His Famous Orchestra'),(10,'Lone Digger - Caravan Palace '),(11,'Crossroad Blues – Robert Johnson'),(12,'Desce Pro Play - MC Zaac, Annitta, Tyga'),(13,'Os Boys Amam, o Ex Chora - Jerry Smith, Simone e Simaria'),(14,'Born This Way - Lady Gaga'),(15,'We Found Love - Rihanna '),(16,'Memories - Maroon 5'),(17,'Moonlight Sonata - Bethoveen'),(18,'Oh Juliana - MC Niack'),(19,'Sad Story (Out Of Luck) - Merk & Kremont'),(20,'Life Goes On - BTS'),(21,'Born to Be Wild'),(22,'Born to Be Wild'),(23,'Batatinha quando nasce'),(24,'Rumors'),(25,'Enter Sandman');
/*!40000 ALTER TABLE `tb_musica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `login` varchar(200) DEFAULT NULL,
  `Senha` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,'Giovana','123'),(2,'Ana','456'),(3,'Felipe','789'),(4,'Bella','222'),(5,'victor','6924'),(6,'Gabriel','147'),(9,'Feulinho ','123456'),(10,'Rose','147'),(11,'Jack','369'),(12,'Totoro','258');
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-30 21:25:23
