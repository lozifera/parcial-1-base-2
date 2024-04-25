package org.example.gui;

import org.example.entidades.Materia;
import org.example.interfaces.MateriaDaoImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroMateria extends JFrame {
    private JTextField codigoField, nombreField, creditosField; // Agregar campo de texto para el código
    private JButton guardarButton;
    private MateriaDaoImpl materiaDao;

    public RegistroMateria() {
        this.materiaDao = new MateriaDaoImpl();

        setSize(500, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        codigoField = new JTextField(20); // Inicializar campo de texto para el código
        nombreField = new JTextField(20);
        creditosField = new JTextField(20);
        guardarButton = new JButton("Guardar");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Código:"), gbc); // Agregar etiqueta para el código
        gbc.gridx = 1;
        panel.add(codigoField, gbc); // Agregar campo de texto para el código

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        panel.add(nombreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Créditos:"), gbc);
        gbc.gridx = 1;
        panel.add(creditosField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(guardarButton, gbc);

        add(panel);
        agregarAccionBoton();
    }

    private void agregarAccionBoton() {
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Materia materia = new Materia();
                materia.setCodigo(codigoField.getText()); // Establecer el código de la materia
                materia.setNombreMateria(nombreField.getText());
                materia.setNumeroCredito(Integer.parseInt(creditosField.getText()));

                materiaDao.createMateria(materia);
            }
        });
    }
}