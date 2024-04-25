package org.example.gui;

import org.example.entidades.Estudiante;
import org.example.entidades.Notas;
import org.example.interfaces.EstudianteDaoImpl;
import org.example.interfaces.NotasDaoImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegistroEstudiante extends JFrame {
    private JTextField nombreField, apellidoPaternoField, apellidoMaternoField, fechaNacimientoField, carreraField;
    private JButton guardarButton;
    private EstudianteDaoImpl estudianteDao;


    public RegistroEstudiante() {
        this.estudianteDao = new EstudianteDaoImpl();

        setSize(500, 300);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(new GridBagLayout()); // Cambiar a GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        nombreField = new JTextField(20);
        apellidoPaternoField = new JTextField(20);
        apellidoMaternoField = new JTextField(20);
        fechaNacimientoField = new JTextField(20);
        carreraField = new JTextField(20);
        guardarButton = new JButton("Guardar");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        panel.add(nombreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Apellido Paterno:"), gbc);
        gbc.gridx = 1;
        panel.add(apellidoPaternoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Apellido Materno:"), gbc);
        gbc.gridx = 1;
        panel.add(apellidoMaternoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Fecha de Nacimiento:"), gbc);
        gbc.gridx = 1;
        panel.add(fechaNacimientoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Carrera:"), gbc);
        gbc.gridx = 1;
        panel.add(carreraField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(guardarButton, gbc);

        add(panel);
        agregarAccionBoton();
    }

    private void agregarAccionBoton() {
        guardarButton.addActionListener(e -> {
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre(nombreField.getText());
            estudiante.setPapellido(apellidoPaternoField.getText());
            estudiante.setMapellido(apellidoMaternoField.getText());
            estudiante.setFechaNacimiento(fechaNacimientoField.getText());
            estudiante.setCarrera(carreraField.getText());

            estudianteDao.createEstudiante(estudiante);
        });

    }
}