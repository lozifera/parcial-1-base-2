package org.example.gui;

import org.example.entidades.Materia;
import org.example.entidades.Notas;
import org.example.interfaces.EstudianteDaoImpl;
import org.example.interfaces.MateriaDaoImpl;
import org.example.interfaces.NotasDaoImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MateriasEstudiante extends JFrame {
    private JTable materiasTable;
    private DefaultTableModel tableModel;
    private NotasDaoImpl notasDao;
    private MateriaDaoImpl materiaDao;
    private EstudianteDaoImpl estudianteDao;
    public MateriasEstudiante(int idEstudiante) {
        notasDao = new NotasDaoImpl();
        estudianteDao = new EstudianteDaoImpl();
        materiaDao = new MateriaDaoImpl();
        setLayout(new BorderLayout());
        setSize(400,400);
        String nombreEstu = estudianteDao.readEstudiante(idEstudiante).getNombre();
        double promedio = calcularPromedioNotas(idEstudiante);
        setTitle("Materias de " + nombreEstu + " (Promedio: " + promedio + ")");;
        definirTabla();
        cargarMaterias(idEstudiante);
    }

    private void cargarMaterias(int idEstudiante) {
        List<Notas> notas = notasDao.readNota(idEstudiante);
        for (Notas nota : notas) {
            String codigoMateria = nota.getCodigo_Materia();
            Materia materia = materiaDao.readMateria(codigoMateria); // Utiliza el método read de tu CRUD
            String nombreMateria = materia.getNombreMateria();
            String[] fila = {
                    codigoMateria,
                    nombreMateria,
                    String.valueOf(nota.getValorNota())};
            tableModel.addRow(fila);
        }

    }

    private void definirTabla() {
        String[] columnas ={"Código Materia", "Nombre Materia", "Notas"};
        tableModel = new DefaultTableModel(columnas,0);
        materiasTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(materiasTable);
        add(scrollPane,BorderLayout.CENTER);
    }
    private double calcularPromedioNotas(int idEstudiante) {
        List<Notas> notas = notasDao.readNota(idEstudiante);
        if (notas.isEmpty()) {
            return 0.0;
        }
        double suma = 0.0;
        for (Notas nota : notas) {
            suma += nota.getValorNota();
        }
        return suma / notas.size();
    }
}
