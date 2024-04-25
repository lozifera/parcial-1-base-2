package org.example.dao;

import org.example.entidades.Notas;

import java.sql.SQLException;
import java.util.List;

public interface NotasDao {
    void creatNota(Notas nota);
    void createOrUpdateNota(int id_estudiante, String codigo_materia, double valor_nota);
    List<Notas> readNota(int id_estudiante);
    void updateNota(Notas nota);
    void deleteNota(int id_estudiante);
    List<Notas> getNotas();
}
