package org.example.interfaces;

import org.example.conexion.Conexion;
import org.example.dao.MateriaDao;
import org.example.entidades.Materia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MateriaDaoImpl implements MateriaDao {
    private Conexion conn = Conexion.getInstance();

    public MateriaDaoImpl() {

    }


    @Override
    public void createMateria(Materia materia) {
        String sql = "INSERT INTO materia (codigo, nombre, numero_Creditos) VALUES (?, ?, ?)";
        try (Connection connection = conn.conectar();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, materia.getCodigo());
            ps.setString(2, materia.getNombreMateria());
            ps.setInt(3, materia.getNumeroCredito());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Materia readMateria(String codigo) {
        Materia materia = null;
        String sql = "SELECT * FROM materia WHERE codigo = ?";
        try (Connection connection = conn.conectar();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setCodigo(rs.getString("codigo"));
                materia.setNombreMateria(rs.getString("nombre"));
                materia.setNumeroCredito(rs.getInt("numero_Creditos"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return materia;
    }

    @Override
    public void updateMateria(Materia materia) {
        String sql = "UPDATE materia SET nombre = ?, numero_Creditos = ? WHERE codigo = ?";
        try (Connection connection = conn.conectar();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, materia.getNombreMateria());
            ps.setInt(2, materia.getNumeroCredito());
            ps.setString(3, materia.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteMateria(String codigo) {
        String sql = "DELETE FROM materia WHERE codigo = ?";
        try (Connection connection = conn.conectar();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, codigo);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Materia> getMaterias() {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia";
        try (Connection connection = conn.conectar();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setCodigo(rs.getString("codigo"));
                materia.setNombreMateria(rs.getString("nombre"));
                materia.setNumeroCredito(rs.getInt("numero_Creditos"));
                materias.add(materia);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return materias;
    }
}
