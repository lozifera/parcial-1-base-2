-- Crear tabla Estudiante
CREATE TABLE Estudiante (
    Id_estudiante SERIAL  PRIMARY KEY,
    Nombre VARCHAR(50),
    Papellido VARCHAR(50),
    Mapellido VARCHAR(50),
    Fecha_Nacimiento DATE,
    Carrera VARCHAR(100)
);

-- Crear tabla Materia
CREATE TABLE Materia (
    Codigo VARCHAR(20) PRIMARY KEY,
    Nombre VARCHAR(100),
    Numero_Creditos INTEGER
);

-- Crear tabla Nota
CREATE TABLE Nota (
    ID_Estudiante INTEGER REFERENCES Estudiante(Id_estudiante),
    Codigo_Materia VARCHAR(20) REFERENCES Materia(Codigo),
    Nota FLOAT,
    PRIMARY KEY (ID_Estudiante, Codigo_Materia)
);

select *from Estudiante;


INSERT INTO Estudiante (Nombre, Papellido, Mapellido, Fecha_Nacimiento, Carrera) 
VALUES ('Juan', 'Pérez', 'García', '2000-05-15', 'Ingeniería Informática');

-- Insertar la primera materia
INSERT INTO Materia (Codigo, Nombre, Numero_Creditos) 
VALUES ('MAT001', 'Matemáticas', 4);

-- Insertar la segunda materia
INSERT INTO Materia (Codigo, Nombre, Numero_Creditos) 
VALUES ('FIS001', 'Física', 3);
-- Insertar la nota de Matemáticas para Juan Pérez García
INSERT INTO Nota (ID_Estudiante, Codigo_Materia, Nota) 
VALUES ((SELECT Id_estudiante FROM Estudiante WHERE Nombre = 'Juan' AND Papellido = 'Pérez' AND Mapellido = 'García'), 'MAT001', 85);

-- Insertar la nota de Física para Juan Pérez García
INSERT INTO Nota (ID_Estudiante, Codigo_Materia, Nota) 
VALUES ((SELECT Id_estudiante FROM Estudiante WHERE Nombre = 'Juan' AND Papellido = 'Pérez' AND Mapellido = 'García'), 'FIS001', 78);



SELECT Materia.Nombre AS Materia, Nota.Nota
FROM Estudiante
JOIN Nota ON Estudiante.Id_estudiante = Nota.ID_Estudiante
JOIN Materia ON Nota.Codigo_Materia = Materia.Codigo
WHERE Estudiante.Id_estudiante = 1;

SELECT *
FROM Nota
WHERE ID_Estudiante = 2;

DELETE FROM Nota
WHERE ID_Estudiante = 2;

delete from estudiante e 
where ID_Estudiante = 2 ;

