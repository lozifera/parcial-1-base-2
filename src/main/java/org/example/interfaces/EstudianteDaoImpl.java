package org.example.interfaces;

import org.example.conexion.Conexion;
import org.example.dao.EstudianteDao;
import org.example.entidades.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDaoImpl implements EstudianteDao {
    private Conexion conn = Conexion.getInstance();

    public EstudianteDaoImpl() {

    }


    @Override
    public void createEstudiante(Estudiante estudiante) {
        String sql = "INSERT INTO estudiante (nombre, Papellido,Mapellido, fecha_nacimiento, carrera) VALUES (?, ?, ?, ?,?)";
        try (Connection connection = conn.conectar();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getPapellido());
            ps.setString(3, estudiante.getMapellido());
            ps.setDate(4, Date.valueOf(estudiante.getFechaNacimiento()));
            ps.setString(5, estudiante.getCarrera());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Estudiante readEstudiante(int id_estudiante) {
        Estudiante estudiante = null;
        String sql = "SELECT * FROM estudiante WHERE id_estudiante = ?";
        try(Connection con = conn.conectar();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id_estudiante);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                estudiante = new Estudiante();
                estudiante.setId_estudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setPapellido(rs.getString("Papellido"));
                estudiante.setMapellido(rs.getString("Mapellido"));
                estudiante.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                estudiante.setCarrera(rs.getString("carrera"));
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        return estudiante;
        }


    @Override
    public void updateEstudiante(Estudiante estudiante) {
        String sql = "UPDATE estudiante SET nombre = ?, Papellido = ?, Mapellido = ?, fecha_nacimiento = ?, carrera = ? WHERE id_estudiante = ?";
        try (Connection con = conn.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getPapellido());
            ps.setString(3, estudiante.getMapellido());
            ps.setDate(4, Date.valueOf(estudiante.getFechaNacimiento()));
            ps.setString(5, estudiante.getCarrera());
            ps.setInt(6, estudiante.getId_estudiante());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEstudiante(int id_estudiante) {
        String sql = "DELETE FROM estudiante WHERE id_estudiante = ?";
        try (Connection con = conn.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id_estudiante);
            int rowsAffected = ps.executeUpdate();
            System.out.println("Filas afectadas en estudiante: " + rowsAffected);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Estudiante> getEstudiantes() {
        List<Estudiante> estudiantes  = new ArrayList<>();
        String sql = "SELECT * FROM estudiante";
        try (Connection con = conn.conectar();
            PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Estudiante estudiante = new Estudiante();
                estudiante.setId_estudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setPapellido(rs.getString("Papellido"));
                estudiante.setMapellido(rs.getString("Mapellido"));
                estudiante.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                estudiante.setCarrera(rs.getString("carrera"));
                estudiantes.add(estudiante);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return estudiantes;
    }
}