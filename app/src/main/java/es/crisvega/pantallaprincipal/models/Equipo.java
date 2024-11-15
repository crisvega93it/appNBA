package es.crisvega.pantallaprincipal.models;

public class Equipo {

    private String equipo;
    private String descripcion;
    private int    imagenId;

    public Equipo(String equipo, String descripcion, int imagenId) {
        this.equipo = equipo;
        this.descripcion = descripcion;
        this.imagenId = imagenId;
    }

    public String getEquipo() {
        return equipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}
