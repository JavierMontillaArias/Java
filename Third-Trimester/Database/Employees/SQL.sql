CREATE DATABASE `empleadosdb`; /*!40100 COLLATE 'utf8mb4_0900_ai_ci' */

CREATE TABLE `empleados` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`apellido` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`salario` DOUBLE NULL DEFAULT NULL,
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;

INSERT INTO empleados (nombre, apellido, salario) VALUES
('Juan', 'Pérez', 35000.00),
('María', 'González', 42000.00),
('Carlos', 'Rodríguez', 38500.00),
('Ana', 'Martínez', 45000.00),
('Luis', 'Sánchez', 33000.00),
('Laura', 'Fernández', 39000.00),
('Pedro', 'López', 41000.00),
('Carmen', 'Díaz', 36500.00),
('Miguel', 'Torres', 43000.00),
('Paula', 'Ramírez', 37500.00);