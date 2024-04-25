package org.example.gui;

import org.example.entidades.Materia;
import org.example.interfaces.MateriaDaoImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListaMateria extends JFrame{

    private JTable materiasTable;
    private DefaultTableModel tableModel;
    private JPanel leftPanel, rightPanel;
    private JTextField codigoField;
    private JButton registrarMateria, actualizarButton,eliminarButton,actMateriaButton;

    private MateriaDaoImpl materiaDao;

    public ListaMateria() {
        materiaDao = new MateriaDaoImpl();

        registrarMateria = new JButton("Registrar Materia");
        actualizarButton = new JButton("Actualizar");
        eliminarButton = new JButton("Eliminar");
        actMateriaButton = new JButton("Actualizar Materia");
        codigoField = new JTextField(20);

        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(500, 500));                                                    
        leftPanel.setBackground(Color.BLUE);

        rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(200, 500));
        rightPanel.add(codigoField);
        rightPanel.add(registrarMateria);
        rightPanel.add(actualizarButton);
        rightPanel.add(eliminarButton);
        rightPanel.add(actMateriaButton);
        rightPanel.setBackground(Color.RED);

        setLayout(new BorderLayout());
        DefinirTabla();
    }

    private void DefinirTabla() {


        String[] columnas = {"Codigo", "Nombre", "Créditos"};
        tableModel = new DefaultTableModel(columnas, 0);

        materiasTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(materiasTable);
        scrollPane.setPreferredSize(leftPanel.getPreferredSize());
        leftPanel.add(scrollPane, BorderLayout.CENTER);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);

        configurarAcciones();
    }

    private void configurarAcciones() {
        registrarMateria.addActionListener(e -> {
            new RegistroMateria().setVisible(true);
        });

        actualizarButton.addActionListener(e -> {
            tableModel.setRowCount(0);
            cargarMaterias();
        });
        actMateriaButton.addActionListener(e -> {
            String codigoMateria = codigoField.getText();
            if (!codigoMateria.isEmpty()) {
                new ActualizarMateria(codigoMateria).setVisible(true);
            }
        });
        eliminarButton.addActionListener(e -> {
            String codigoMateria = codigoField.getText(); // Obtener el código de la materia del campo de texto
            if (!codigoMateria.isEmpty()) {
                materiaDao.deleteMateria(codigoMateria);
                // Actualizar la tabla
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    if (tableModel.getValueAt(i, 0).equals(codigoMateria)) {
                        tableModel.removeRow(i);
                        break;
                    }
                }
            }
        });
        cargarMaterias();
    }

    public void cargarMaterias() {
        List<Materia> materias = materiaDao.getMaterias();
        for (Materia materia : materias) {
            Object[] row = new Object[3];
            row[0] = materia.getCodigo();
            row[1] = materia.getNombreMateria();
            row[2] = materia.getNumeroCredito();
            tableModel.addRow(row);
        }
    }
}
