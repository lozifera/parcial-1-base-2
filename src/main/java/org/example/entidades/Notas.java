package org.example.entidades;

public class Notas {
    private int idEstudiante;
    private String Codigo_Materia;
    private double valorNota;

    public Notas(String codigo, int idEstudiante, double valorNota) {
        this.Codigo_Materia = codigo;
        this.idEstudiante = idEstudiante;
        this.valorNota = valorNota;
    }
    public Notas() {
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public double getValorNota() {
        return valorNota;
    }

    public void setValorNota(double valorNota) {
        this.valorNota = valorNota;
    }

    public String getCodigo_Materia() {
        return Codigo_Materia;
    }

    public void setCodigo_Materia(String codigo_Materia) {
        this.Codigo_Materia = codigo_Materia;
    }
}
