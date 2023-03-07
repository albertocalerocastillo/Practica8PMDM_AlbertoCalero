package es.studium.practica8pmdmalbertocalero;

public class Pasitos {
    private double longitud, latitud, bateria;
    private long id;
    String titulo;

    public Pasitos(double latitud, double longitud, double bateria, String titulo) {
        this.longitud = longitud;
        this.latitud = latitud;
        this.bateria = bateria;
        this.titulo = titulo;
    }

    public Pasitos(long id, double latitud, double longitud, double bateria, String titulo) {
        this.longitud = longitud;
        this.latitud = latitud;
        this.bateria = bateria;
        this.titulo = titulo;
        this.id = id;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getBateria() {
        return bateria;
    }

    public void setBateria(double bateria) {
        this.bateria = bateria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Pasitos{" +
                "longitud=" + longitud +
                ", latitud=" + latitud +
                ", bateria=" + bateria +
                ", titulo=" + titulo +
                ", id=" + id +
                '}';
    }
}