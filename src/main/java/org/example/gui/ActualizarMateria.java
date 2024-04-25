package org.example.gui;

import org.example.entidades.Materia;
import org.example.interfaces.MateriaDaoImpl;

import javax.swing.*;
import java.awt.*;

public class ActualizarMateria extends JFrame{
    private JTextField codigoField, nombreField, descripcionField;
    private JButton guardarButton;
    private MateriaDaoImpl materiaDao;

    public ActualizarMateria(String codigoMateria) {
        materiaDao = new MateriaDaoImpl();
        Materia materia = materiaDao.readMateria(codigoMateria);

        codigoField = new JTextField(materia.getCodigo());
        nombreField = new JTextField(materia.getNombreMateria());
        descripcionField = new JTextField(String.valueOf(materia.getNumeroCredito()));
        guardarButton = new JButton("Guardar");

        setLayout(new GridLayout(4, 2)); // Usar un GridLayout para organizar los componentes
        add(new JLabel("Código:"));
        add(codigoField);
        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Número de Créditos:"));
        add(descripcionField);
        add(guardarButton);

        setTitle("Actualizar Materia");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        guardarButton.addActionListener(e -> {
            // Actualizar la materia y guardar los cambios
            materia.setNombreMateria(nombreField.getText());
            materia.setNumeroCredito(Integer.parseInt(descripcionField.getText()));
            materiaDao.updateMateria(materia);
        });
    }
}