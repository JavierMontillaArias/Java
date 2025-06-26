package Gestion_Notas;

import java.io.Serializable;
import java.util.*;

public class Alumno implements Serializable{
    private String nombre;   
    private String curso;
    private HashMap<Asignatura, Integer> notas;

    public Alumno(String nombre, String curso) {
        this.nombre = nombre;
        this.curso = curso;
        this.notas = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public HashMap<Asignatura, Integer> getNotas() {
        return notas;
    }
    public void setNotas(HashMap<Asignatura, Integer> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        resultado.append(nombre + " - " + curso + "\n");
        for(Map.Entry<Asignatura, Integer> nota : notas.entrySet()){
            resultado.append("\t" + nota.getKey().getNombre() + " -> " + nota.getValue());
            resultado.append("\n");
        }
        return resultado.toString();
    }
    
}