CREATE DATABASE  IF NOT EXISTS `gestorinscripciones` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestorinscripciones`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gestorinscripciones
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` bigint NOT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `rol` enum('ADMIN','ESTUDIANTE','MENTOR') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (2,'admin123','admin@admin.com.ar','POLO IT Buenos Aires','ADMIN');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_seq`
--

DROP TABLE IF EXISTS `admin_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_seq`
--

LOCK TABLES `admin_seq` WRITE;
/*!40000 ALTER TABLE `admin_seq` DISABLE KEYS */;
INSERT INTO `admin_seq` VALUES (101);
/*!40000 ALTER TABLE `admin_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id` bigint NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `institucion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `rubro` varchar(255) DEFAULT NULL,
  `estado` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'programa de practivca laboral para Egresados y Mentores',NULL,'ACELERADOR 2024',NULL,_binary ''),(2,'Programa del polo it para Egresados y mentores',NULL,'Acelerador 2024 - 2da Edicon',NULL,_binary ''),(52,'Proyecto de prueba',NULL,'Prueba',NULL,_binary '\0'),(102,'prueba desde el formulario',NULL,'PROYECTO PRUEBA',NULL,_binary '\0'),(152,'Prueba del 17 de Octubre 2024',NULL,'Proyecto de Prueba Polo IT',NULL,_binary ''),(202,'proyecto desde el formulario de registro de proyecto para probar funcionalidad ok',NULL,'Proyecto de Prueba 21 de Octibre',NULL,_binary '\0');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso_seq`
--

DROP TABLE IF EXISTS `curso_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso_seq`
--

LOCK TABLES `curso_seq` WRITE;
/*!40000 ALTER TABLE `curso_seq` DISABLE KEYS */;
INSERT INTO `curso_seq` VALUES (301);
/*!40000 ALTER TABLE `curso_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `id` bigint NOT NULL,
  `contacto` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `tipo_entidad` enum('EMPRESA','INSTITUCION_EDUCATIVA') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'codoacodo@talentotech.com.ar','Talento Tech ','Codo a Codo','INSTITUCION_EDUCATIVA'),(2,'mentorias@alianza.com.ar','Empresa aliada para mentorias','EMPRESA ALIANZA','EMPRESA'),(52,'contacto@Silvertech.com.ar','string','SilverTech','INSTITUCION_EDUCATIVA'),(53,'contacto@empujar.com.ar','string','Fundacion Empujar','INSTITUCION_EDUCATIVA'),(54,'contacto@epidata.com.ar','Empresa Aliada','EpiData','EMPRESA'),(55,'contacto@globant.com.ar','Empresa Socia','Globant','EMPRESA'),(56,'contacto@prisma.com.ar','Empresa Socia','Prisma','EMPRESA'),(57,'contacto@d3.com.ar','Empresa Socia','d3','EMPRESA'),(58,'contacto@pigmalion.com.ar','Empresa Socia','Pigmalion','EMPRESA');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa_seq`
--

DROP TABLE IF EXISTS `empresa_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa_seq`
--

LOCK TABLES `empresa_seq` WRITE;
/*!40000 ALTER TABLE `empresa_seq` DISABLE KEYS */;
INSERT INTO `empresa_seq` VALUES (151);
/*!40000 ALTER TABLE `empresa_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `curso` bigint DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `curso_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn2dh0gseetcnrnhj9hy0lfsuq` (`curso_id`),
  KEY `FKfa61u97dmkbmx7eyjp5akij8f` (`curso`),
  CONSTRAINT `FKfa61u97dmkbmx7eyjp5akij8f` FOREIGN KEY (`curso`) REFERENCES `curso` (`id`),
  CONSTRAINT `FKn2dh0gseetcnrnhj9hy0lfsuq` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES (17,NULL,'SQUAD-02',1),(25,NULL,'e-1',1),(26,NULL,'eq-2',2);
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensajes`
--

DROP TABLE IF EXISTS `mensajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensajes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `contenido` varchar(255) DEFAULT NULL,
  `fecha_envio` datetime(6) DEFAULT NULL,
  `destinatario_id` bigint DEFAULT NULL,
  `remitente_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj4p5oyowb71mx2ldnopynq1cp` (`destinatario_id`),
  KEY `FKfv72pen01rsg99l238rp1s2r3` (`remitente_id`),
  CONSTRAINT `FKfv72pen01rsg99l238rp1s2r3` FOREIGN KEY (`remitente_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKj4p5oyowb71mx2ldnopynq1cp` FOREIGN KEY (`destinatario_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensajes`
--

LOCK TABLES `mensajes` WRITE;
/*!40000 ALTER TABLE `mensajes` DISABLE KEYS */;
INSERT INTO `mensajes` VALUES (1,'Hola probando Enviar mensajes','2024-10-18 13:38:10.647831',58,55),(2,'Probando desde el form del front','2024-10-18 14:47:47.290756',63,55),(3,'prueba envio desde el front','2024-10-18 19:28:17.913199',60,58),(4,'Hola soy del e-1','2024-10-18 19:36:14.354344',53,1),(5,'Hola Blanca, un gusto ','2024-10-18 19:37:04.326188',1,53),(6,'prueba 5','2024-10-18 19:40:59.072557',65,1),(7,'prueba 6','2024-10-18 19:47:36.196295',65,1),(8,'Hola Soy Marcelo! Te contacto por ...','2024-10-21 11:02:03.911582',1,252),(9,'Mensaje Envio de prueba','2024-10-21 12:48:20.736043',54,1);
/*!40000 ALTER TABLE `mensajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `especializacion` enum('DESARROLLADOR','QA','UX_UI') DEFAULT NULL,
  `fecha_creacion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `rol` enum('ADMIN','ESTUDIANTE','MENTOR') DEFAULT NULL,
  `curso_id` bigint DEFAULT NULL,
  `empresa_id` bigint DEFAULT NULL,
  `equipo_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKckf90nc6vgevo8asel0kfjkst` (`curso_id`),
  KEY `FKm21n0rvmqditlvvor5ew330gr` (`empresa_id`),
  KEY `FK6d3b8rddr61ara5h3ti5uukq1` (`equipo_id`),
  CONSTRAINT `FK6d3b8rddr61ara5h3ti5uukq1` FOREIGN KEY (`equipo_id`) REFERENCES `equipo` (`id`),
  CONSTRAINT `FKckf90nc6vgevo8asel0kfjkst` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`id`),
  CONSTRAINT `FKm21n0rvmqditlvvor5ew330gr` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Suarez','12345678','blanca@gmail.com','DESARROLLADOR','2024-09-16','Blanca','ESTUDIANTE',1,1,25),(2,'Lopez','mentor123','juan@mentor.com.ar','DESARROLLADOR','2024-10-01','Juan','MENTOR',1,2,25),(52,'Gonzalez','contraseña123','juan.gonzalez@example.com','DESARROLLADOR','2024-10-01','Juan','ESTUDIANTE',1,1,25),(53,'Lopez','contraseña123','carlos.lopez@example.com','UX_UI','2024-10-01','Carlos','ESTUDIANTE',1,52,25),(54,'Fernandez','contraseña123','maria.fernandez@example.com','QA','2024-10-10','Maria','ESTUDIANTE',2,53,17),(55,'Perez','contra123','luis.perez@example.com','DESARROLLADOR','2024-09-15','Luis','MENTOR',1,55,17),(56,'Gomez','contra123','laura.gomez@example.com','UX_UI','2024-09-30','Laura','MENTOR',2,56,26),(57,'Rodriguez','contra123','miguel.rodriguez@example.com','QA','2024-10-12','Miguel','MENTOR',1,58,NULL),(58,'Diaz','contra123','lucia.diaz@example.com','DESARROLLADOR','2024-10-02','Lucia','ESTUDIANTE',2,57,26),(59,'Rammirez','contraseña123','sofia.ramirez@example.com','DESARROLLADOR','2024-09-25','Sofia','ESTUDIANTE',1,1,17),(60,'Torres','contraseña123','gabriel.torres@example.com','DESARROLLADOR','2024-09-15','Gabriel','ESTUDIANTE',1,1,NULL),(61,'Garcia','contraseña123','elena.garcia@example.com','DESARROLLADOR','2024-10-10','Elena','ESTUDIANTE',1,53,NULL),(62,'Rojas','contraseña123','lucas.rojas@example.com','UX_UI','2024-10-05','Lucas','ESTUDIANTE',1,52,17),(63,'Hernandez','contraseña123','valentina.hernandez@example.com','UX_UI','0024-09-28','Valentina','ESTUDIANTE',1,52,26),(64,'Castro','contraseña123','matias.castro@example.com','QA','2024-10-04','Matias','ESTUDIANTE',1,53,25),(65,'Morales','contraseña123','isabella.morales@example.com','UX_UI','2024-10-02','Isabella','ESTUDIANTE',2,52,NULL),(66,'Silva','contraseña123','tomas.silva@example.com','QA','2024-09-23','Tomas','ESTUDIANTE',1,53,26),(152,'prueba','contra123','prueba@prueba.com.ar','UX_UI','2024-10-14','Prueba','MENTOR',NULL,2,NULL),(202,'Estudiante','contra123','prueba@estudiante.com.ar','QA','2024-10-17','Prueba','ESTUDIANTE',2,1,NULL),(252,'Gimenez','contra123','gimenezm@prueba.com.ar','DESARROLLADOR','2024-10-21','Marcelo','ESTUDIANTE',152,52,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (351);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-21 13:05:40
