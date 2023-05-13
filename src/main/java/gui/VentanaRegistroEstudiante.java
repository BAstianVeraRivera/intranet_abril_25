package gui;
import data.GestorDatos;
import model.Estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaRegistroEstudiante extends Ventana implements ActionListener {
    private JLabel lblNombre, lblApellido, lblRut, lblMatricula;
    private JTextField txtNombre, txtApellido, txtRut, txtMatricula;
    private JButton btnRegistrar, btnCancelar;
    private JPanel panel;
    private GestorDatos gestor;

    public VentanaRegistroEstudiante(String titulo, int ancho, int alto, GestorDatos gestor) {
        super(titulo, ancho, alto);
        this.gestor = gestor;
        crearComponentes();
        agregarComponentes();
        agregarEventos();
        setVisible(true);
    }
    private void crearComponentes() {
        lblNombre = new JLabel("Nombre:");
        lblApellido= new JLabel("Apellido:");
        lblRut = new JLabel("RUT:");
        lblMatricula = new JLabel("Número de matrícula:");
        txtNombre = new JTextField(15);
        txtApellido = new JTextField(15);
        txtRut = new JTextField(15);
        txtMatricula = new JTextField(15);
        btnRegistrar = new JButton("Registrar");
        btnCancelar = new JButton("Cancelar");
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
    }
    private void agregarComponentes() {
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblApellido);
        panel.add(txtApellido);
        panel.add(lblRut);
        panel.add(txtRut);
        panel.add(lblMatricula);
        panel.add(txtMatricula);
        panel.add(btnRegistrar);
        panel.add(btnCancelar);

        add(panel);
    }
    private void agregarEventos() {
        btnRegistrar.addActionListener(this);
        btnCancelar.addActionListener(this);
    }
    public void actionPerformed(ActionEvent accion) {
        if (accion.getSource() == btnRegistrar) {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String rut = txtRut.getText();
            String matricula = txtMatricula.getText();
            Estudiante estudiante = new Estudiante(nombre, apellido, rut, matricula);
            gestor.registrarEstudiante(estudiante);
            JOptionPane.showMessageDialog(this, "Estudiante registrado con éxito");
            dispose();
            new VentanaBienvenida("Intranet", 500, 300, gestor);
        } else if (accion.getSource() == btnCancelar) {
            dispose();
            new VentanaBienvenida("Intranet", 500, 300, gestor);
        }
    }
}