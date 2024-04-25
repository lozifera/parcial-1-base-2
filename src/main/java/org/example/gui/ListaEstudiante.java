package org.example.gui;

import org.example.entidades.Estudiante;
import org.example.entidades.Notas;
import org.example.interfaces.EstudianteDaoImpl;
import org.example.interfaces.NotasDaoImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListaEstudiante extends JFrame {
    private JTable estudiantesTable;
    private DefaultTableModel tableModel;
    private JPanel leftPanel, rightPanel;
    private JButton verMaterias,registrarEstudiante,actualizarButton,eliminarButton,actualizarEstudianteButton;
    private JTextField idEstudianteField;

    private EstudianteDaoImpl estudianteDao;
    private NotasDaoImpl notasDao;
    Estudiante estudiantes = new Estudiante();
    Notas notas = new Notas();

    public ListaEstudiante() {
            estudianteDao = new EstudianteDaoImpl();
            notasDao = new NotasDaoImpl();

            idEstudianteField = new JTextField(10);
            verMaterias = new JButton("Ver Materias");
            registrarEstudiante = new JButton("Registrar Estudiante");
            actualizarButton = new JButton("Actualizar");
             eliminarButton = new JButton("Eliminar");
            actualizarEstudianteButton = new JButton("Actualizar Estudiante");




            leftPanel = new JPanel();
            leftPanel.setPreferredSize(new Dimension(500, 500));
            leftPanel.setBackground(Color.BLUE);

            rightPanel = new JPanel();
            rightPanel.setPreferredSize(new Dimension(200, 500));
            rightPanel.add(idEstudianteField);
            rightPanel.add(verMaterias);
            rightPanel.add(registrarEstudiante);
            rightPanel.add(actualizarButton);
            rightPanel.add(actualizarEstudianteButton);
            rightPanel.setBackground(Color.RED);
            rightPanel.add(eliminarButton);

            setLayout(new BorderLayout());
            DefinirTabla();
    }

    private void DefinirTabla() {
        String[] columnas = {"  ID  ", "  Nombre  ", "  Apellido  ","  apellido  ", "  Fecha de nacimento  ", "  Carrera  "};
        tableModel = new DefaultTableModel(columnas, 0);

        estudiantesTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(estudiantesTable);
        scrollPane.setPreferredSize(leftPanel.getPreferredSize()); // Ajustar el tamaño del JScrollPane al del panel izquierdo
        leftPanel.add(scrollPane,BorderLayout.CENTER);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);

        configurarAciones();


    }

    private void configurarAciones() {
        verMaterias.addActionListener(e -> {
            int id_estudiante = Integer.parseInt(idEstudianteField.getText());
            new MateriasEstudiante(id_estudiante).setVisible(true);
        });
        registrarEstudiante.addActionListener(e -> {
            new RegistroEstudiante().setVisible(true);

        });
        actualizarButton.addActionListener(e -> {
            // Limpiar la tabla antes de cargar los estudiantes
            tableModel.setRowCount(0);
            // Cargar los estudiantes
            cargarEstudiantes();
        });
        eliminarButton.addActionListener(e -> {
            eliminar();
        });
        actualizarEstudianteButton.addActionListener(e -> {
            int idEstudiante = Integer.parseInt(idEstudianteField.getText());
            new ActualizarEstudiante(idEstudiante).setVisible(true);
            System.out.println("se abrio" + idEstudiante);
        });
        cargarEstudiantes();
    }

    private void eliminar() {
        int idEstudiante = Integer.parseInt(idEstudianteField.getText());
        notasDao.deleteNota(idEstudiante);
        estudianteDao.deleteEstudiante(idEstudiante);
        // Actualizar la tabla
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(idEstudiante)) {
                tableModel.removeRow(i);
                break;
            }
        }
    }

    public void cargarEstudiantes() {
        List<Estudiante> estudiantes = estudianteDao.getEstudiantes();
        for(Estudiante estudiante : estudiantes){
            Object[] row = new Object[6];
            row[0] = estudiante.getId_estudiante();
            row[1] = estudiante.getNombre();
            row[2] = estudiante.getPapellido();
            row[3] = estudiante.getMapellido();
            row[4] = estudiante.getFechaNacimiento();
            row[5] = estudiante.getCarrera();
            tableModel.addRow(row);

          }
        }
    }



