-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         11.3.2-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para contactosdb
DROP DATABASE IF EXISTS `contactosdb`;
CREATE DATABASE IF NOT EXISTS `contactosdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `contactosdb`;

-- Volcando estructura para tabla contactosdb.contactos
DROP TABLE IF EXISTS `contactos`;
CREATE TABLE IF NOT EXISTS `contactos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `apellido` varchar(50) NOT NULL DEFAULT '0',
  `telefono` varchar(50) NOT NULL DEFAULT '0',
  `email` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla contactosdb.contactos: ~11 rows (aproximadamente)
REPLACE INTO `contactos` (`id`, `nombre`, `apellido`, `telefono`, `email`) VALUES
	(1, 'Juan', 'Pérez', '625749851', 'juan.perez@example.com'),
	(2, 'Ana', 'López', '647852946', 'ana.lopez@example.com'),
	(3, 'Luis', 'Martínez', '623159746', 'luis.martinez@example.com'),
	(4, 'Carmen', 'Herrera', '648129758', 'carmen.herrera@example.com'),
	(5, 'Carlos', 'Gómez', '674122489', 'carlos.gomez@example.com'),
	(6, 'Sara', 'Jiménez', '631158744', 'sara.jimenez@example.com'),
	(7, 'Francisco', 'Molina', '689784151', 'francisco.molina@example.com'),
	(8, 'Laura', 'Díaz', '697454662', 'laura.diaz@example.com'),
	(9, 'Javier', 'Castro', '698447353', 'javier.castro@example.com'),
	(10, 'Marta', 'González', '648759989', 'marta.gonzalez@example.com'),
	(11, 'Juan', 'Martínez', '64547812558', 'juanmartinez@example.com');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;