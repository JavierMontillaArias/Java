-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS libreta_direcciones;
USE libreta_direcciones;

-- Crear la tabla de contactos
CREATE TABLE IF NOT EXISTS contactos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL
);

-- Insertar datos de ejemplo
INSERT INTO contactos (nombre, telefono) VALUES
('Juan Pérez', '634521789'),
('María García', '918456723'),
('Carlos Rodríguez', '666234567'),
('Ana Martínez', '915673421'),
('Luis González', '678234567'),
('Laura Sánchez', '914567890'),
('Pedro Ramírez', '645789123'),
('Sofia Torres', '916789234'),
('Miguel Hernández', '654321987'),
('Carmen López', '913456789'),
('Roberto Díaz', '687654321'),
('Isabel Morales', '917890123'),
('Francisco Ruiz', '632123456'),
('Elena Castro', '912345678'),
('José Jiménez', '698765432');

-- Crear índice para búsquedas más eficientes
CREATE INDEX idx_nombre ON contactos(nombre);