package Gestor_Temperatura;

import java.io.RandomAccessFile;
import java.io.IOException;
import java.time.LocalDate;

public class RegistroTemperaturas {
    private static final String ARCHIVO = "temperaturas.dat";
    private static final int REGISTRO_SIZE = 24; // 8 (fecha) + 8 (max) + 8 (min)
    
    public void agregarRegistro(Temperatura temp) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(ARCHIVO, "rw")) {
            raf.seek(raf.length());
            escribirTemperatura(raf, temp);
        }
    }
    
    public void modificarTemperatura(LocalDate fecha, double nuevaMax, double nuevaMin) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(ARCHIVO, "rw")) {
            for (int i = 0; i < raf.length(); i += REGISTRO_SIZE) {
                raf.seek(i);
                long fechaArchivo = raf.readLong();
                if (fechaArchivo == fecha.toEpochDay()) {
                    raf.writeDouble(nuevaMax);
                    raf.writeDouble(nuevaMin);
                    return;
                }
            }
        }
    }
    
    public Temperatura consultarPorFecha(LocalDate fecha) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(ARCHIVO, "r")) {
            for (int i = 0; i < raf.length(); i += REGISTRO_SIZE) {
                raf.seek(i);
                long fechaArchivo = raf.readLong();
                if (fechaArchivo == fecha.toEpochDay()) {
                    return new Temperatura(
                        LocalDate.ofEpochDay(fechaArchivo),
                        raf.readDouble(),
                        raf.readDouble()
                    );
                }
            }
        }
        return null;
    }
    
    public double[] promedioMensual(int mes, int anio) throws IOException {
        double sumaMax = 0, sumaMin = 0;
        int contador = 0;
        
        try (RandomAccessFile raf = new RandomAccessFile(ARCHIVO, "r")) {
            for (int i = 0; i < raf.length(); i += REGISTRO_SIZE) {
                raf.seek(i);
                LocalDate fecha = LocalDate.ofEpochDay(raf.readLong());
                if (fecha.getMonthValue() == mes && fecha.getYear() == anio) {
                    sumaMax += raf.readDouble();
                    sumaMin += raf.readDouble();
                    contador++;
                }
            }
        }
        
        if (contador == 0) return new double[]{0, 0};
        return new double[]{sumaMax/contador, sumaMin/contador};
    }
    
    private void escribirTemperatura(RandomAccessFile raf, Temperatura temp) throws IOException {
        raf.writeLong(temp.getFecha().toEpochDay());
        raf.writeDouble(temp.getTempMaxima());
        raf.writeDouble(temp.getTempMinima());
    }
}