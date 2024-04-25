package org.example.gui;

import org.example.entidades.Estudiante;
import org.example.interfaces.EstudianteDaoImpl;

import javax.swing.*;
import java.awt.*;

public class ActualizarEstudiante extends JFrame {
    private JTextField idField, nombreField, papellidoField, mapellidoField, fechaNacimientoField, carreraField;
    private JButton guardarButton;
    private EstudianteDaoImpl estudianteDao;

    public ActualizarEstudiante(int idEstudiante) {
        estudianteDao = new EstudianteDaoImpl();
        Estudiante estudiante = estudianteDao.readEstudiante(idEstudiante);

        idField = new JTextField(String.valueOf(estudiante.getId_estudiante()));
        nombreField = new JTextField(estudiante.getNombre());
        papellidoField = new JTextField(estudiante.getPapellido());
        mapellidoField = new JTextField(estudiante.getMapellido());
        fechaNacimientoField = new JTextField(estudiante.getFechaNacimiento().toString());
        carreraField = new JTextField(estudiante.getCarrera());
        guardarButton = new JButton("Guardar");

        setLayout(new GridLayout(7, 2)); // Usar un GridLayout para organizar los componentes
        add(new JLabel("ID:"));
        add(idField);
        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Primer apellido:"));
        add(papellidoField);
        add(new JLabel("Segundo apellido:"));
        add(mapellidoField);
        add(new JLabel("Fecha de nacimiento:"));
        add(fechaNacimientoField);
        add(new JLabel("Carrera:"));
        add(carreraField);
        add(guardarButton);

        setTitle("Actualizar Estudiante");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        guardarButton.addActionListener(e -> {
            // Actualizar el estudiante y guardar los cambios
            estudiante.setNombre(nombreField.getText());
            estudiante.setPapellido(papellidoField.getText());
            estudiante.setMapellido(mapellidoField.getText());
            // Aquí necesitas convertir la fecha de nacimiento de String a LocalDate
            // estudiante.setFechaNacimiento(LocalDate.parse(fechaNacimientoField.getText()));
            estudiante.setCarrera(carreraField.getText());
            estudianteDao.updateEstudiante(estudiante);
        });
    }
}