package Gestor_Temperatura;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class GestorTemperaturasApp {
    private static Scanner scanner = new Scanner(System.in);
    private static RegistroTemperaturas registro = new RegistroTemperaturas();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        boolean continuar = true;
        
        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();
            
            try {
                switch (opcion) {
                    case 1: agregarRegistro(); break;
                    case 2: modificarRegistro(); break;
                    case 3: mostrarRegistros(); break;
                    case 4: calcularPromedioMensual(); break;
                    case 0:
                        continuar = false;
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (IOException e) {
                System.out.println("Error al acceder al archivo: " + e.getMessage());
            }
            
            System.out.println("\nPresione ENTER para continuar...");
            scanner.nextLine();
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.print("\033[H\033[2J");
        System.out.println("\n=== REGISTRO DE TEMPERATURAS ===");
        System.out.println("1. Añadir nuevo registro");
        System.out.println("2. Modificar registro");
        System.out.println("3. Mostrar todos los registros");
        System.out.println("4. Calcular promedio mensual");
        System.out.println("0. Salir");
        System.out.print("\tSeleccione una opción: ");
    }

    private static int leerOpcion() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Por favor, ingrese un número válido: ");
            }
        }
    }

    private static void agregarRegistro() throws IOException {
        System.out.println("\n--- Añadir Nuevo Registro ---");
        
        LocalDate fecha = leerFecha("Ingrese la fecha (dd/MM/yyyy): ");
        double tempMax = leerTemperatura("Ingrese temperatura máxima: ");
        double tempMin = leerTemperatura("Ingrese temperatura mínima: ");

        Temperatura temp = new Temperatura(fecha, tempMax, tempMin);
        registro.agregarRegistro(temp);
        System.out.println("Registro añadido correctamente");
    }

    private static void modificarRegistro() throws IOException {
        System.out.println("\n--- Modificar Registro ---");
        
        LocalDate fecha = leerFecha("Ingrese la fecha a modificar (dd/MM/yyyy): ");
        Temperatura tempExistente = registro.consultarPorFecha(fecha);
        
        if (tempExistente == null) {
            System.out.println("No existe registro para esa fecha");
            return;
        }

        System.out.println("Registro actual: " + tempExistente);
        double tempMax = leerTemperatura("Ingrese nueva temperatura máxima: ");
        double tempMin = leerTemperatura("Ingrese nueva temperatura mínima: ");

        registro.modificarTemperatura(fecha, tempMax, tempMin);
        System.out.println("Registro modificado correctamente");
    }

    private static void mostrarRegistros() throws IOException {
        System.out.println("\n--- Todos los Registros ---");
        try (RandomAccessFile raf = new RandomAccessFile("temperaturas.dat", "r")) {
            if (raf.length() == 0) {
                System.out.println("No hay registros almacenados");
                return;
            }

            for (long i = 0; i < raf.length(); i += 24) {
                raf.seek(i);
                LocalDate fecha = LocalDate.ofEpochDay(raf.readLong());
                double max = raf.readDouble();
                double min = raf.readDouble();
                System.out.printf("Fecha: %s, Máxima: %.1f°C, Mínima: %.1f°C%n", 
                    fecha.format(formatter), max, min);
            }
        }
    }

    private static void calcularPromedioMensual() throws IOException {
        System.out.println("\n--- Calcular Promedio Mensual ---");
        
        System.out.print("Ingrese el mes (1-12): ");
        int mes = leerNumeroEnRango(1, 12);
        
        System.out.print("Ingrese el año: ");
        int anio = leerNumeroEnRango(1900, 2100);

        double[] promedios = registro.promedioMensual(mes, anio);
        
        if (promedios[0] == 0 && promedios[1] == 0) {
            System.out.println("No hay registros para el mes y año especificados");
        } else {
            System.out.printf("Promedio mensual para %02d/%d:%n", mes, anio);
            System.out.printf("Temperatura máxima promedio: %.1f°C%n", promedios[0]);
            System.out.printf("Temperatura mínima promedio: %.1f°C%n", promedios[1]);
        }
    }

    private static LocalDate leerFecha(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String fechaStr = scanner.nextLine();
                return LocalDate.parse(fechaStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Use dd/MM/yyyy");
            }
        }
    }

    private static double leerTemperatura(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido");
            }
        }
    }

    private static int leerNumeroEnRango(int min, int max) {
        while (true) {
            try {
                int numero = Integer.parseInt(scanner.nextLine());
                if (numero >= min && numero <= max) {
                    return numero;
                }
                System.out.printf("Por favor, ingrese un número entre %d y %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("Por favor, ingrese un número válido: ");
            }
        }
    }
}