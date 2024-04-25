package org.example.dao;

import org.example.entidades.Estudiante;

import java.sql.SQLException;
import java.util.List;

public interface EstudianteDao {
    //crud
    void createEstudiante(Estudiante estudiante);
    Estudiante readEstudiante(int id_estudiante);
    void updateEstudiante(Estudiante estudiante);
    void deleteEstudiante(int id_estudiante);
    List<Estudiante> getEstudiantes();
}
