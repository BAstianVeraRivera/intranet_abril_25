package model;

public class Carrera {
    private String nombreCarrera;
    private String codigoCarrera;
    private String cantidadSemestres;

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public String getCantidadSemestres() {
        return cantidadSemestres;
    }

    public void setCantidadSemestres(String cantidadSemestres) {
        this.cantidadSemestres = cantidadSemestres;
    }

    public Carrera(String nombreCarrera, String codigoCarrera, String cantidadSemestres) {
        this.nombreCarrera = nombreCarrera;
        this.codigoCarrera = codigoCarrera;
        this.cantidadSemestres = cantidadSemestres;
    }
    public String toString(){
        return "\n Nombre de la carrera: "+this.nombreCarrera+"\n Código de la carrera: "+this.codigoCarrera+"\n Duración (en semestres): "+this.cantidadSemestres;
    }
}