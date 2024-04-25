package org.example.gui;

import javax.swing.*;

public class Ventana
        extends JFrame {
    public Ventana() {
        setTitle("Lista de Estudiantes");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu();
    }

    private void menu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Opciones");
        JMenu salir = new JMenu("Salir");
        salir.addActionListener(e -> System.exit(0));

        JMenuItem itemEs = new JMenuItem("Lista de Estudiantes");
        JMenuItem itemMa = new JMenuItem("Lista de Materias");
        JMenuItem itemNotas = new JMenuItem("Registro de Notas");


        menu.add(itemEs);
        menu.add(itemMa);
        menu.add(itemNotas);

        menuBar.add(menu);
        menuBar.add(salir);
        setJMenuBar(menuBar);

        itemEs.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Lista de Estudiantes");
            mostrarEstudiantes();

        });
        itemMa.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Lista de Materias");
            mostrarMaterias();
        });
        itemNotas.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Registro de Notas");
            registrarNotas();
        });

    }

    private void registrarNotas() {
        RegistroNota registroNota = new RegistroNota();
        registroNota.setSize(500, 200);
        registroNota.setLocationRelativeTo(null);

        registroNota.setTitle("Registro de Notas");
        registroNota.setVisible(true);
    }

    private void mostrarMaterias() {
        ListaMateria listaMateria = new ListaMateria();
        listaMateria.setSize(710, 300);
        listaMateria.setLocationRelativeTo(null);

        listaMateria.setTitle("Lista de Materias");
        listaMateria.setVisible(true);
    }

    private void mostrarEstudiantes() {
        ListaEstudiante listaEstudiante = new ListaEstudiante();
        listaEstudiante.setSize(700, 300);
        listaEstudiante.setLocationRelativeTo(null);

        listaEstudiante.setTitle("Lista de Estudiantes");
        listaEstudiante.setVisible(true);
    }


}
