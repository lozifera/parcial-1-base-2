package org.example.interfaces;

import org.example.conexion.Conexion;
import org.example.dao.NotasDao;
import org.example.entidades.Notas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotasDaoImpl implements NotasDao {
    private Conexion manager = new Conexion();

    @Override
    public void creatNota(Notas nota) {
        String sql = "INSERT INTO nota (id_estudiante, codigo_materia, valor_nota) VALUES (?, ?, ?)";
        try (Connection conn = manager.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, nota.getIdEstudiante());
            pstmt.setString(2, nota.getCodigo_Materia());
            pstmt.setDouble(3, nota.getValorNota());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Notas> readNota(int id_estudiante) {
        List<Notas> notas = new ArrayList<>();
        String sql = "SELECT * FROM nota WHERE id_estudiante = ? ";
        try (Connection conn = manager.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_estudiante);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Notas nota = new Notas();
                nota.setIdEstudiante(rs.getInt("id_estudiante"));
                nota.setCodigo_Materia(rs.getString("codigo_materia"));
                nota.setValorNota(rs.getDouble("Nota"));
                notas.add(nota);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notas;
    }

    @Override
    public void updateNota(Notas nota) {
        String sql = "UPDATE nota SET Nota = ? WHERE codigo_materia = ? AND id_estudiante = ?";
        try (Connection conn = manager.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, nota.getValorNota());
            pstmt.setString(2, nota.getCodigo_Materia());
            pstmt.setInt(3, nota.getIdEstudiante());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            }

    }

    @Override
    public void deleteNota( int id_estudiante) {
        String sql = "DELETE FROM nota WHERE id_estudiante = ?";
        try (Connection conn = manager.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_estudiante);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Filas afectadas en nota: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Notas> getNotas() {
        List<Notas> notas = new ArrayList<>();
        String sql = "SELECT * FROM nota";
        try (Connection conn = manager.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Notas nota = new Notas();
                nota.setIdEstudiante(rs.getInt("id_estudiante"));
                nota.setCodigo_Materia(rs.getString("codigo_materia"));
                nota.setValorNota(rs.getDouble("valor_nota"));
                notas.add(nota);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notas;
    }
    public void createOrUpdateNota(int idEstudiante, String codigoMateria, double nota) {   String sqlInsert = "INSERT INTO nota (id_estudiante, codigo_materia, nota) VALUES (?, ?, ?)";
        String sqlUpdate = "UPDATE nota SET nota = ? WHERE id_estudiante = ? AND codigo_materia = ?";
        try (Connection connection = manager.conectar();
             PreparedStatement psInsert = connection.prepareStatement(sqlInsert);
             PreparedStatement psUpdate = connection.prepareStatement(sqlUpdate)) {
            psInsert.setInt(1, idEstudiante);
            psInsert.setString(2, codigoMateria);
            psInsert.setDouble(3, nota);
            int rowsInserted = psInsert.executeUpdate();
            if (rowsInserted == 0) {
                psUpdate.setDouble(1, nota);
                psUpdate.setInt(2, idEstudiante);
                psUpdate.setString(3, codigoMateria);
                psUpdate.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
