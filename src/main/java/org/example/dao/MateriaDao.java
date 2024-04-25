package org.example.dao;

import org.example.entidades.Materia;

import java.sql.SQLException;
import java.util.List;

public interface MateriaDao {
    void createMateria(Materia materia);
    Materia readMateria(String codigo) ;
    void updateMateria(Materia materia);
    void deleteMateria(String codigo);
    List<Materia> getMaterias();
}
