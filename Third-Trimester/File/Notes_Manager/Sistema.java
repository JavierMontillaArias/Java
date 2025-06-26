package Gestion_Notas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Sistema {
    private ArrayList<Asignatura> asignaturas;
    private ArrayList<Alumno> alumnos;
    public Scanner sc;

    public Sistema() {
        this.asignaturas = new ArrayList<>();
        this.alumnos = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }   
    
    //Gestión de alumnos
    public void añadirAlumno(){
        System.out.print("Introduce el nombre del alumno: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce el curso del alumno: ");
        String curso = sc.nextLine();
        alumnos.add(new Alumno(nombre, curso));    
    }

    public void elminarAlumno(){
        System.out.print("Introduce el nombre del alumno: ");
        String nombre = sc.nextLine();
        Alumno encontrado = null;
        for(Alumno al : alumnos){
            if(al.getNombre().toLowerCase().equals(nombre.toLowerCase())){
                encontrado = al;
            }
        }
        if(encontrado != null){
            alumnos.remove(encontrado);
            System.out.println("Eliminado correctamente");
        }
        else
            System.out.println("No se ha encontrado");      
    }

    public void mostrarAlumnos(){
        for(Alumno al : alumnos){
            System.out.println(al);
        }
    }

    //Gestión de asignaturas
    public void añadirAsignatura(){
        System.out.print("Introduce el nombre de la asignatura: ");
        String nombre = sc.nextLine();

        asignaturas.add(new Asignatura(nombre));
    }

    public void eliminarAsignatura(){
        System.out.print("Introduce el el nombre de la asignatura: ");
        String nombre = sc.nextLine();
        Asignatura encontrado = null;
        for(Asignatura as : asignaturas){
            if(as.getNombre().toLowerCase().equals(nombre.toLowerCase())){
                encontrado = as;
            }
        }
        if(encontrado != null){
            asignaturas.remove(encontrado);
            System.out.println("Eliminada correctamente");
        }
        else
            System.out.println("No se ha encontrado"); 
    }

    public void mostrarAsignaturas(){
        for(Asignatura as : asignaturas){
            System.out.println(as);
        }
    }

    //Gestión de notas
    public void añadirNotas(){
        System.out.print("Introduce el nombre del alumno: ");
        String nombre = sc.nextLine();
        Alumno encontrado = null;

        for(Alumno al : alumnos){
            if(al.getNombre().toLowerCase().equals(nombre.toLowerCase())){
                encontrado = al;
            }
        }
        if(encontrado != null){
            HashMap<Asignatura, Integer> notasAlumno = encontrado.getNotas();
            for(Asignatura as : asignaturas){
                System.out.print("Dime la nota para " + as.getNombre() + ": ");
                int nota = Integer.parseInt(sc.nextLine());
                notasAlumno.put(as, nota);
            }
        }
        else
            System.out.println("No existe el alumno");
    }
 
    public void eliminarNotas(){
        System.out.print("Introduce el nombre del alumno: ");
        String nombre = sc.nextLine();
        Alumno encontrado = null;

        for(Alumno al : alumnos){
            if(al.getNombre().toLowerCase().equals(nombre.toLowerCase())){
                encontrado = al;
            }
        }
        if(encontrado != null){
            HashMap<Asignatura, Integer> notasAlumno = encontrado.getNotas();
            notasAlumno.clear();
        }
        else
            System.out.println("No existe el alumno");
    }

    //Gestión de datos
    public void guardarDatos(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos.bin"))) {
            oos.writeObject(alumnos);
            oos.writeObject(asignaturas);   
            System.out.println("Escritura correcta");        
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void leerDatos(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datos.bin"))) {
            alumnos.clear();
            alumnos = (ArrayList<Alumno>) ois.readObject();
            asignaturas.clear();;
            asignaturas = (ArrayList<Asignatura>) ois.readObject();
            System.out.println("Lectura correcta");            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}