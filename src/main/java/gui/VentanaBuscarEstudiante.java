package gui;
import data.GestorDatos;
import model.Estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaBuscarEstudiante extends Ventana implements ActionListener {
    private JTextField txtNombre;
    private JLabel lblNombre;
    private JButton btnBuscar, btnCancelar;
    private JPanel panel;
    private GestorDatos gestor;

    public VentanaBuscarEstudiante(String titulo, int ancho, int alto, GestorDatos gestor) {
        super(titulo, ancho, alto);
        this.gestor = gestor;
        crearComponentes();
        agregarComponentes();
        agregarEventos();
        setVisible(true);
    }

    private void crearComponentes() {
        lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(15);
        btnBuscar = new JButton("Buscar");
        btnCancelar = new JButton("Cancelar");
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
    }

    private void agregarComponentes() {
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(btnBuscar);
        panel.add(btnCancelar);
        add(panel);
    }

    private void agregarEventos() {
        btnBuscar.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent accion) {
        if (accion.getSource() == btnBuscar) {
            String nombre = txtNombre.getText();
            Estudiante estudiante = gestor.buscarEstudiantePorNombre(nombre);
            if (estudiante != null) {
                JOptionPane.showMessageDialog(this, "Estudiante encontrado: " +estudiante.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Estudiante no hallado");
            }
        } else if (accion.getSource() == btnCancelar) {
            dispose();
            new VentanaBienvenida("Intranet", 200, 100, gestor);
        }
    }
}