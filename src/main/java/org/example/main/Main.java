package org.example.main;

import org.example.conexion.Conexion;
import org.example.gui.Ventana;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Conexion conexion = Conexion.getInstance();
        Ventana listaEstudiantes = new Ventana();
        listaEstudiantes.setVisible(true);
        conexion.closeConnection();

    }
}