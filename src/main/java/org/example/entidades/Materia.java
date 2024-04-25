package org.example.entidades;

public class Materia {
    private String codigo;
    private  String nombreMateria;
    private int numeroCredito;

    public Materia(String codigo, String nombreMateria, int numeroCredito) {
        this.codigo = codigo;
        this.nombreMateria = nombreMateria;
        this.numeroCredito = numeroCredito;
    }

    public Materia() {
    }

    public String getCodigo() {return codigo;}

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getNumeroCredito() {
        return numeroCredito;
    }

    public void setNumeroCredito(int numeroCredito) {
        this.numeroCredito = numeroCredito;
    }
}
