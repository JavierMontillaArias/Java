import java.util.Scanner;

class Doctor {
    private String nombre, apellido, especialidad;
    //Constructor
    Doctor (String nombre, String apellido, String especialidad) {
        this.nombre=nombre;
        this.apellido=apellido;
        this.especialidad=especialidad;
    }
    //Setters
    public void setNombre (String nombre) {this.nombre=nombre;}
    public void setApellido (String apellido) {this.apellido=apellido;}
    public void setEspecialidad (String especialidad) {this.especialidad=especialidad;}
    //Getters
    public String getNombre() { return this.nombre;}
    public String getApellido() { return this.apellido;}
    public String getEspecialidad() { return this.especialidad;}
    //Imprimir datos del doctor
    public void datos () {
        System.out.println("Nombre del doctor: "+this.nombre+" "+this.apellido);
        System.out.println("Especialidad: "+this.especialidad);

    }
}
class Paciente {
    private String nombre, apellido;
    //Constructor
    Paciente(String nombre, String apellido) {
        this.nombre=nombre;
        this.apellido=apellido;
    }
    //Setters
    public void setNombre (String nombre) {this.nombre=nombre;}
    public void setApellido (String apellido) {this.apellido=apellido;}
    //Getters
    public String getNombre() { return this.nombre;}
    public String getApellido() { return this.apellido;}
    //imprimir datos del paciente
    public void datos () {
        System.out.println("Nombre del paciente: "+this.nombre+ " "+this.apellido);
    }
}
class Cita {
    String idCita, fecha, hora;
    Paciente p;
    Doctor d1;
    Doctor d2;
    //Constructor
    Cita(String idCita) {
        this.idCita=idCita;
        this.fecha="";
        this.hora="";
        d1 = new Doctor("Mario", "Perez", "Cardiologo");
        d2 = new Doctor("Marta", "Rodriguez", "Gastroenterologo");
    }
    //Este programa reserva una cita
    public void programarCita () {
        Scanner tec = new Scanner (System.in);
        int eleccion;
        String nombrePaciente, apellidoPaciente;
        System.out.print("Introduza al medico que quiere ir (1) Cardiologo, (2) Gastroenterologo: ");
        eleccion=tec.nextInt();
        tec.nextLine();
        switch (eleccion) {
            case 1:
                System.out.print("Introduca su nombre: ");
                nombrePaciente=tec.nextLine();
                System.out.print("Introduca su apellido: ");
                apellidoPaciente=tec.nextLine();
                p=new Paciente(nombrePaciente, apellidoPaciente);
                System.out.print("Introduce la fecha: ");
                this.fecha=tec.nextLine();
                System.out.print("Introduzca la hora: ");
                this.hora=tec.nextLine();
                System.out.println("--------------------------------------------------------------");
                d1.datos();
                p.datos();
                System.out.println("Fecha: "+this.fecha);
                System.out.println("Hora: "+this.hora);
                System.out.println("--------------------------------------------------------------");
                break;
        
            case 2:
                System.out.print("Introduca su nombre: ");
                nombrePaciente=tec.nextLine();
                System.out.print("Introduca su apellido: ");
                apellidoPaciente=tec.nextLine();
                p=new Paciente(nombrePaciente, apellidoPaciente);
                System.out.print("Introduce la fecha: ");
                this.fecha=tec.nextLine();
                System.out.print("Introduzca la hora: ");
                this.hora=tec.nextLine();
                System.out.println("--------------------------------------------------------------");
                d2.datos();
                p.datos();
                System.out.println("Fecha: "+this.fecha);
                System.out.println("Hora: "+this.hora);
                System.out.println("--------------------------------------------------------------");
                break;
        }
    }
    public void cancelarCita () {
        this.fecha="";
        this.hora="";
        this.idCita="";
        System.out.println("Cita cancelada");
    }
    public void reprogramarCita(String fecha, String hora) {
        cancelarCita();
        this.fecha=fecha;
        this.hora=hora;
    }
    public boolean confirmarCita() {
        Scanner sc = new Scanner(System.in);
        String eleccion;
        System.out.println("Confirma usted su cita: (SI/NO) ");
        eleccion=sc.nextLine();
        if(eleccion.equals("SI")) {
            return true;
        }
        return false;
    }
    public void recordarCita() {
        if(confirmarCita()) {
            System.out.println("Su cita es el "+this.fecha+" a las "+this.hora);
        }
        else {
            cancelarCita();
        }
    }
}
public class citasMedicas {
    public static void main(String[] args) {
        String fecha, hora, eleccion;
        Cita c = new Cita("ABC1234");
        c.programarCita();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Quiere usted cambiar la hora? (SI/NO)");
        eleccion=teclado.nextLine();
        if(eleccion.equals("SI")) {
            System.out.print("Introduce la fecha: ");
            fecha=teclado.nextLine();
            System.out.print("Introduzca la hora: ");
            hora=teclado.nextLine();
            c.reprogramarCita(fecha, hora);
            c.recordarCita();
        }
        else {
            c.recordarCita();
        }
        teclado.close();
    }
}
