package principal;

import data.GestorDatos;
import gui.VentanaBienvenida;

public class Principal {
    public static void main(String[] args) {
        GestorDatos gestor = new GestorDatos("Estudiantes.txt", "Carreras.txt");
        new VentanaBienvenida("Intranet", 500, 300,gestor);
    }
}