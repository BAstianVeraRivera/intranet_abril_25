package gui;
import data.GestorDatos;
import model.Carrera;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaRegistroCarrera extends Ventana implements ActionListener {
    private JLabel lblNombreCarrera, lblCodigo, lblSemestres;
    private JTextField txtNombreCarrera, txtCodigo, txtSemestres;
    private JButton btnRegistrar, btnCancelar;
    private JPanel panel;
    private GestorDatos gestor;

    public VentanaRegistroCarrera(String titulo, int ancho, int alto, GestorDatos gestor) {
        super(titulo, ancho, alto);
        this.gestor = gestor;
        crearComponentes();
        agregarComponentes();
        agregarEventos();
        setVisible(true);
    }

    private void crearComponentes() {
        lblNombreCarrera = new JLabel("Nombre de la carrera:");
        lblCodigo = new JLabel("Codigo de la carrera:");
        lblSemestres = new JLabel("Cantidad de semestres:");
        txtNombreCarrera = new JTextField(15);
        txtCodigo = new JTextField(15);
        txtSemestres = new JTextField(15);
        btnRegistrar = new JButton("Registrar");
        btnCancelar = new JButton("Cancelar");
        panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));
    }

    private void agregarComponentes() {
        panel.add(lblNombreCarrera);
        panel.add(txtNombreCarrera);
        panel.add(lblCodigo);
        panel.add(txtCodigo);
        panel.add(lblSemestres);
        panel.add(txtSemestres);
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
            String nombreCarrera = txtNombreCarrera.getText();
            String codigo = txtCodigo.getText();
            String semestres =txtSemestres.getText();

            Carrera carrera = new Carrera(nombreCarrera, codigo, semestres);
            gestor.registrarCarrera(carrera);
            JOptionPane.showMessageDialog(this, "Carrera registrada con éxito");
            dispose();
            new VentanaBienvenida("Intranet", 500, 300, gestor);
        } else if (accion.getSource() == btnCancelar) {
            dispose();
            new VentanaBienvenida("Intranet", 500, 300, gestor);
        }
    }
}