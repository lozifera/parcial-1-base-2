package org.example.entidades;

import java.util.Date;

public class Estudiante {
    private int id_estudiante;
    private String nombre;
    private String Papellido;
    private String Mapellido;
    private String fechaNacimiento;
    private String carrera;

    public Estudiante(int id_esudiante, String nombre, String papellido, String mapellido) {
        this.id_estudiante = id_esudiante;
        this.nombre = nombre;
        Papellido = papellido;
        Mapellido = mapellido;
    }

    public Estudiante() {
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPapellido() {
        return Papellido;
    }

    public void setPapellido(String papellido) {
        Papellido = papellido;
    }

    public String getMapellido() {
        return Mapellido;
    }

    public void setMapellido(String mapellido) {
        Mapellido = mapellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }


}


