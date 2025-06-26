package Gestion_Notas;


public class GestorNotasApp {
    public static void main(String[] args) {
        Sistema sis = new Sistema();
        sis.leerDatos();
        int opcion = 0;

        do {
            System.out.println("1. Gestionar alumnos");
            System.out.println("2. Gestionar asignaturas");
            System.out.println("3. Asignar/modificar notas");
            System.out.println("4. Guardar datos");
            System.out.println("5. Cargar datos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(sis.sc.nextLine());

            switch (opcion) {
                case 1:
                    gestionarAlumnos(sis);
                    break;
                case 2:
                    gestionarAsignaturas(sis);
                    break;
                case 3:
                    gestionarNotas(sis);
                    break;
                case 4:
                    sis.guardarDatos();
                    break;
                case 5:
                    sis.leerDatos();
                    break;
            }
        } while (opcion != 0);
    }


    public static void gestionarAlumnos(Sistema sis){
        int opcion = 0;
        do {
            System.out.println("1. Añadir alumno");
            System.out.println("2. Eliminar alumno");
            System.out.println("3. Mostrar alumnos");            
            System.out.println("0. Volver al menú principal");    
            opcion = Integer.parseInt(sis.sc.nextLine());

            switch (opcion) {
                case 1:
                    sis.añadirAlumno();
                    break;
                case 2:
                    sis.elminarAlumno();
                    break;
                case 3:
                    sis.mostrarAlumnos();
                    break;
            }
            
        } while (opcion != 0);
    }

    public static void gestionarAsignaturas(Sistema sis){
        int opcion = 0;
        do {
            System.out.println("1. Añadir asignatura");
            System.out.println("2. Eliminar asignatura");
            System.out.println("3. Mostrar asignaturas");            
            System.out.println("0. Volver al menú principal");    
            opcion = Integer.parseInt(sis.sc.nextLine());

            switch (opcion) {
                case 1:
                    sis.añadirAsignatura();
                    break;
                case 2:
                    sis.eliminarAsignatura();
                    break;
                case 3:
                    sis.mostrarAsignaturas();
                    break;
            }
            
        } while (opcion != 0);        
    }

    public static void gestionarNotas(Sistema sis){
        int opcion = 0;
        do {
            System.out.println("1. Añadir notas");
            System.out.println("2. Eliminar notas");
            System.out.println("0. Volver al menú principal");    
            opcion = Integer.parseInt(sis.sc.nextLine());

            switch (opcion) {
                case 1:
                    sis.añadirNotas();
                    break;
                case 2:
                    sis.eliminarNotas();
                    break;
            }
            
        } while (opcion != 0);         
    }
}