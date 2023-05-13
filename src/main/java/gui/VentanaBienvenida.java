package gui;
import data.GestorDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaBienvenida extends Ventana implements ActionListener {
    private JButton btnRegistrarCarrera, btnRegistrarEstudiante, btnSalir, btnBuscarEstudiante;
    private JPanel panel;
    private GestorDatos gestor;

    public VentanaBienvenida(String titulo, int ancho, int alto, GestorDatos gestor) {
        super(titulo, ancho, alto);
        this.gestor = gestor;
        crearComponentes();
        agregarComponentes();
        agregarEventos();
        setVisible(true);
    }


    private void crearComponentes() {
        btnRegistrarCarrera = new JButton("Registrar carrera");
        btnRegistrarEstudiante = new JButton("Registrar estudiante");
        btnBuscarEstudiante = new JButton("Buscar estudiante");
        btnSalir = new JButton("Salir");
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
    }

    private void agregarComponentes() {
        panel.add(btnRegistrarCarrera);
        panel.add(btnBuscarEstudiante);
        panel.add(btnBuscarEstudiante);
        panel.add(btnSalir);

        add(panel);
    }

    private void agregarEventos() {
        btnRegistrarCarrera.addActionListener(this);
        btnRegistrarEstudiante.addActionListener(this);
        btnBuscarEstudiante.addActionListener(this);
        btnSalir.addActionListener(this);
    }

    public void actionPerformed(ActionEvent accion) {
        if (accion.getSource() == btnRegistrarCarrera) {
            dispose();
            new VentanaRegistroCarrera("Registrar vehículo", 300, 200, gestor);
        } else if (accion.getSource() == btnRegistrarEstudiante) {
            dispose();
            new VentanaRegistroEstudiante("Registrar cliente", 300, 200, gestor);
        } else if (accion.getSource() == btnBuscarEstudiante) {
            dispose();
            new VentanaBuscarEstudiante("Buscar vehículo", 300, 200, gestor);
        } else if (accion.getSource() == btnSalir) {
            System.exit(0);
        }
    }
}