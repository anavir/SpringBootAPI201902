CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `localidades`
--

DROP TABLE IF EXISTS `localidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `localidades` (
  `id_localidad` int(11) NOT NULL,
  `nombre` varchar(300) NOT NULL,
  `id_provincia` int(11) NOT NULL,
  `codigo_postal` varchar(10) NOT NULL,
  PRIMARY KEY (`id_localidad`),
  UNIQUE KEY `localidades_nombre_id_provincia_UNIQUE` (`nombre`,`id_provincia`),
  KEY `fk_provincias_id_provincia_idx` (`id_provincia`),
  CONSTRAINT `fk_provincias_id_provincia` FOREIGN KEY (`id_provincia`) REFERENCES `provincias` (`id_provincia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidades`
--

LOCK TABLES `localidades` WRITE;
/*!40000 ALTER TABLE `localidades` DISABLE KEYS */;
INSERT INTO `localidades` VALUES (1,'ROSARIO',1,'2000'),(2,'SANTA FE',1,'3000'),(3,'CAPITAL FEDERAL',2,'1000'),(4,'CORDOBA',3,'5000');
/*!40000 ALTER TABLE `localidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `personas` (
  `id_tipodocumento` int(11) NOT NULL,
  `numero_documento` int(11) NOT NULL,
  `nombre_apellido` varchar(400) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `genero` char(1) NOT NULL,
  `es_argentino` tinyint(1) NOT NULL,
  `correo_electronico` varchar(300) DEFAULT NULL,
  `foto_cara` blob,
  `id_localidad` int(11) NOT NULL,
  `codigo_postal` varchar(10) NOT NULL,
  PRIMARY KEY (`id_tipodocumento`,`numero_documento`),
  UNIQUE KEY `nombre_apellido_UNIQUE` (`nombre_apellido`),
  KEY `fk_localidades_id_localidad_idx` (`id_localidad`),
  CONSTRAINT `fk_localidades_id_localidad` FOREIGN KEY (`id_localidad`) REFERENCES `localidades` (`id_localidad`),
  CONSTRAINT `fk_tipos_documentos_id_documento` FOREIGN KEY (`id_tipodocumento`) REFERENCES `tipos_documentos` (`id_tipodocumento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,24222111,'JAVIER GONZALEZ','1984-02-01','M',1,'gonzalez@gmail.com',NULL,1,'2000'),(1,24222333,'ESTEBAN MARTINEZ','1984-02-01','M',1,'martinez@gmail.com',NULL,1,'2000'),(1,30123456,'JUANA PEREZ','1984-02-02','F',1,'juana@gmail.com',NULL,1,'2000'),(1,35222333,'JOSE LOPEZ','1990-02-01','M',1,'joselopeze@gmail.com',NULL,1,'2000');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincias`
--

DROP TABLE IF EXISTS `provincias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `provincias` (
  `id_provincia` int(11) NOT NULL,
  `nombre` varchar(400) NOT NULL,
  `region` char(3) NOT NULL,
  PRIMARY KEY (`id_provincia`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincias`
--

LOCK TABLES `provincias` WRITE;
/*!40000 ALTER TABLE `provincias` DISABLE KEYS */;
INSERT INTO `provincias` VALUES (1,'SANTA FE','PAM'),(2,'BUENOS AIRES','GBA'),(3,'CORDOBA','PAM'),(4,'CHUBUT','PAT');
/*!40000 ALTER TABLE `provincias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles_usuario`
--

DROP TABLE IF EXISTS `roles_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `roles_usuario` (
  `nombre_usuario` varchar(45) NOT NULL,
  `rol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nombre_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles_usuario`
--

LOCK TABLES `roles_usuario` WRITE;
/*!40000 ALTER TABLE `roles_usuario` DISABLE KEYS */;
INSERT INTO `roles_usuario` VALUES ('admin','ROLE_ADMIN');
/*!40000 ALTER TABLE `roles_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_documentos`
--

DROP TABLE IF EXISTS `tipos_documentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipos_documentos` (
  `id_tipodocumento` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `abreviatura` varchar(5) NOT NULL,
  `validar_como_cuit` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_tipodocumento`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_documentos`
--

LOCK TABLES `tipos_documentos` WRITE;
/*!40000 ALTER TABLE `tipos_documentos` DISABLE KEYS */;
INSERT INTO `tipos_documentos` VALUES (1,'DOCUMENTO UNICO','DNI',0),(2,'LIBRETA CIVICA','LC',0),(3,'PASAPORTE','PASAP',0);
/*!40000 ALTER TABLE `tipos_documentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuarios` (
  `id_tipodocumento` int(11) NOT NULL,
  `numero_documento` int(11) NOT NULL,
  `nombre_usuario` varchar(50) NOT NULL,
  `hashed_pwd` varchar(200) NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id_tipodocumento`,`numero_documento`),
  UNIQUE KEY `nombre_usuario_UNIQUE` (`nombre_usuario`),
  CONSTRAINT `fk_usuarios_personas` FOREIGN KEY (`id_tipodocumento`, `numero_documento`) REFERENCES `personas` (`id_tipodocumento`, `numero_documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,30123456,'admin','$2a$10$uKHPwwG/iSWlbOwrZ6U7.uv1DasSJZ2iDP7A4ykiAfIUgx/6UovtC',1),(1,35222333,'user','$2a$10$sWl61XowvHS8kdcvrgSAHePcMA1j8GIr6PFqCdF55ADU7o7LtH0wu',1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-21 14:18:27
