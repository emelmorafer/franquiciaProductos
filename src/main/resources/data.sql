-- data.sql

CREATE TABLE IF NOT EXISTS Producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    stock INT NOT NULL,
    sucursal_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Sucursal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    franquicia_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Franquicia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);



INSERT INTO Franquicia (nombre)
SELECT
'MacDonals'
WHERE NOT EXISTS (SELECT 1 FROM Franquicia WHERE nombre = 'MacDonals');

INSERT INTO Franquicia (nombre)
SELECT
'KFC'
WHERE NOT EXISTS (SELECT 1 FROM Franquicia WHERE nombre = 'KFC');



INSERT INTO Sucursal (nombre, franquicia_id)
SELECT
'MacDonals Barranquilla',
(SELECT id FROM Franquicia WHERE nombre = 'MacDonals')
WHERE NOT EXISTS (SELECT 1 FROM Sucursal WHERE nombre = 'MacDonals Barranquilla');

INSERT INTO Sucursal (nombre, franquicia_id)
SELECT
'MacDonals Medellin',
(SELECT id FROM Franquicia WHERE nombre = 'MacDonals')
WHERE NOT EXISTS (SELECT 1 FROM Sucursal WHERE nombre = 'MacDonals Medellin');

INSERT INTO Sucursal (nombre, franquicia_id)
SELECT
'KFC Barranquilla',
(SELECT id FROM Franquicia WHERE nombre = 'KFC')
WHERE NOT EXISTS (SELECT 1 FROM Sucursal WHERE nombre = 'KFC Barranquilla');

INSERT INTO Sucursal (nombre, franquicia_id)
SELECT
'KFC Medellin',
(SELECT id FROM Franquicia WHERE nombre = 'KFC')
WHERE NOT EXISTS (SELECT 1 FROM Sucursal WHERE nombre = 'KFC Medellin');




INSERT INTO Producto (nombre, stock, sucursal_id)
SELECT
'hamburguesa1',
45,
(SELECT id FROM Sucursal WHERE nombre = 'MacDonals Barranquilla')
WHERE NOT EXISTS (SELECT 1 FROM Producto WHERE nombre = 'hamburguesa1');

INSERT INTO Producto (nombre, stock, sucursal_id)
SELECT
'malteada1',
35,
(SELECT id FROM Sucursal WHERE nombre = 'MacDonals Barranquilla')
WHERE NOT EXISTS (SELECT 1 FROM Producto WHERE nombre = 'malteada1');

INSERT INTO Producto (nombre, stock, sucursal_id)
SELECT
'hamburguesa2',
67,
(SELECT id FROM Sucursal WHERE nombre = 'MacDonals Medellin')
WHERE NOT EXISTS (SELECT 1 FROM Producto WHERE nombre = 'hamburguesa2');

INSERT INTO Producto (nombre, stock, sucursal_id)
SELECT
'malteada2',
21,
(SELECT id FROM Sucursal WHERE nombre = 'MacDonals Medellin')
WHERE NOT EXISTS (SELECT 1 FROM Producto WHERE nombre = 'malteada2');


INSERT INTO Producto (nombre, stock, sucursal_id)
SELECT
'pollo frito1',
34,
(SELECT id FROM Sucursal WHERE nombre = 'KFC Barranquilla')
WHERE NOT EXISTS (SELECT 1 FROM Producto WHERE nombre = 'pollo frito1');

INSERT INTO Producto (nombre, stock, sucursal_id)
SELECT
'carne azada1',
27,
(SELECT id FROM Sucursal WHERE nombre = 'KFC Barranquilla')
WHERE NOT EXISTS (SELECT 1 FROM Producto WHERE nombre = 'carne azada1');

INSERT INTO Producto (nombre, stock, sucursal_id)
SELECT
'pollo frito2',
56,
(SELECT id FROM Sucursal WHERE nombre = 'KFC Medellin')
WHERE NOT EXISTS (SELECT 1 FROM Producto WHERE nombre = 'pollo frito2');

INSERT INTO Producto (nombre, stock, sucursal_id)
SELECT
'carne azada2',
16,
(SELECT id FROM Sucursal WHERE nombre = 'KFC Medellin')
WHERE NOT EXISTS (SELECT 1 FROM Producto WHERE nombre = 'carne azada2');










