package Gestion_Notas;

import java.io.Serializable;

public class Asignatura implements Serializable {
    private String nombre;

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Asignatura [nombre=" + nombre + "]";
    }
    
}
