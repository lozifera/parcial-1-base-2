package org.example.conexion;

import java.sql.*;

public class Conexion {
    private String host = "localhost";
    private  String port = "5432";
    private String database = "Notas";
    private String user = "postgres";
    private String pass = "loza";
    private  static Conexion instance;
    Connection conn = null;

    public Connection conectar()  {
        try{
            Class.forName("org.postgresql.Driver");
            String connectionString = "jdbc:postgresql://" + host + ":" + port + "/" + database;
            conn = DriverManager.getConnection(connectionString,user,pass);
            System.out.println("Conexion PosgresSQL = Java EXITOSA");

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            System.out.println("Sin conexion a PostgresSQl");

        }
        return conn;
    }
    public void getSQL(String sql, int columnIndex) {
        try (Connection con = conectar()) {
            Statement consulta = con.createStatement();
            ResultSet rs = consulta.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(columnIndex));
            }
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexión cerrada exitosamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    public void ejecutarSQL(String sql) {
        try (Connection con = conectar()) {
            Statement consulta = con.createStatement();
            consulta.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

