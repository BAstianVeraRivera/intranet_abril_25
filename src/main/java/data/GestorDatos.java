package data;
import model.Estudiante;
import model.Carrera;

import java.io.*;
public class GestorDatos {
    private String archivoEstudiante;
    private String archivoCarrera;

    public String getArchivoEstudiante() {
        return archivoEstudiante;
    }

    public void setArchivoEstudiante(String archivoEstudiante) {
        this.archivoEstudiante = archivoEstudiante;
    }

    public String getArchivoCarrera() {
        return archivoCarrera;
    }

    public void setArchivoCarrera(String archivoCarrera) {
        this.archivoCarrera = archivoCarrera;
    }

    public GestorDatos(String archivoEstudiante, String archivoCarrera) {
        this.archivoCarrera = archivoCarrera;
        this.archivoEstudiante = archivoEstudiante;
    }

    public void registrarEstudiante(Estudiante estudiante) {
        try {
            FileWriter fw = new FileWriter(archivoEstudiante, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(estudiante.getNombre() + "," + estudiante.getApellido() + "," + estudiante.getRut() + "," + estudiante.getMatricula());
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registrarCarrera(Carrera carrera) {
        try {
            FileWriter fw = new FileWriter(archivoCarrera, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(carrera.getNombreCarrera() + "," + carrera.getCodigoCarrera() + "," + carrera.getCantidadSemestres());
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String buscarVehiculo(String nombre) {
        try {
            FileReader fr = new FileReader(archivoVehiculo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(nombre)) {
                    br.close();
                    fr.close();
                    return datos[1];
                }
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Vehiculo buscarVehiculoPorNombre(String nombre) {
        try {
            FileReader fr = new FileReader(archivoVehiculo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(nombre )) {
                    br.close();
                    fr.close();
                    return new Vehiculo(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), datos[4], datos[5]);
                }
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}