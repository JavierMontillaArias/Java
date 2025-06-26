package Gestor_Temperatura;

import java.io.Serializable;
import java.time.LocalDate;

public class Temperatura implements Serializable {
    private LocalDate fecha;
    private double tempMaxima;
    private double tempMinima;
    
    public Temperatura(LocalDate fecha, double tempMaxima, double tempMinima) {
        this.fecha = fecha;
        this.tempMaxima = tempMaxima;
        this.tempMinima = tempMinima;
    }
    
    // Getters y setters
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public double getTempMaxima() { return tempMaxima; }
    public void setTempMaxima(double tempMaxima) { this.tempMaxima = tempMaxima; }
    public double getTempMinima() { return tempMinima; }
    public void setTempMinima(double tempMinima) { this.tempMinima = tempMinima; }
    
    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Máxima: " + tempMaxima + "°C, Mínima: " + tempMinima + "°C";
    }
}