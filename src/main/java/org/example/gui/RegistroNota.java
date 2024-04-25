package org.example.gui;

import org.example.entidades.Estudiante;
import org.example.entidades.Materia;
import org.example.interfaces.NotasDaoImpl;

import javax.swing.*;
import java.awt.*;

public class RegistroNota extends JFrame {
    private JTextField idEstudianteField, codigoMateriaField, notaField;
    private JButton registrarButton;
    private NotasDaoImpl notaDao;

    public RegistroNota() {
        this.notaDao = new NotasDaoImpl();

        setSize(500, 200);
        setLocationRelativeTo(null);

        idEstudianteField = new JTextField(20);
        codigoMateriaField = new JTextField(20);
        notaField = new JTextField(20);
        registrarButton = new JButton("Registrar nota");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID Estudiante:"), gbc);
        gbc.gridx = 1;
        panel.add(idEstudianteField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Código Materia:"), gbc);
        gbc.gridx = 1;
        panel.add(codigoMateriaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Nota:"), gbc);
        gbc.gridx = 1;
        panel.add(notaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(registrarButton, gbc);

        add(panel);

        registrarButton.addActionListener(e -> {
            int idEstudiante = Integer.parseInt(idEstudianteField.getText());
            String codigoMateria = codigoMateriaField.getText();
            double nota = Double.parseDouble(notaField.getText());
            notaDao.createOrUpdateNota(idEstudiante, codigoMateria, nota);
        });
    }
}