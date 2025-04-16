import java.util.Random;
import java.util.Scanner;

class Cuenta {
    private String numeroCuenta;
    private double saldo;
    private String titular;

    Cuenta() {
        numeroCuenta="";
        saldo=0;
        titular="";
    }

    public String getNumeroCuenta() { return this.numeroCuenta;}
    public double getSaldo() { return this.saldo;}
    public String getTitular() { return this.titular;}

    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta;}
    public void setSaldo(double saldo) { this.saldo = saldo;}
    public void setTitular(String titular) { this.titular = titular;}

    @Override
    public String toString() {
        return "Numero de cuenta: " +numeroCuenta+ "\nSaldo: " +saldo+ "\nTitular: " +titular;
    }

    public void menuCuenta(String numCuenta) {
        Scanner ec=new Scanner (System.in);
        int eleccion;
        double dinero;
        System.out.println("¿Que operacion desea realizar? (1)Revisar su saldo, (2)Ingresar dinero, (3)Extraer dinero y (-1)Terminar operaciones");
        eleccion=ec.nextInt();
        while(eleccion!=-1) {
            switch (eleccion) {
                case 1:
                    System.out.println("Su saldo es de: "+this.getSaldo()+" $");
                    break;
                case 2:
                    System.out.println("¿Cuanto quiere ingresar?");
                    dinero=ec.nextDouble();
                    this.saldo+=dinero;
                    System.out.println("Su saldo es de: "+this.getSaldo());
                    break;
                case 3:
                    System.out.println("¿Cuanto dinero quiere retirar?");
                    dinero=ec.nextDouble();
                    if(dinero>this.saldo) {
                        System.out.println("No tiene suficiente dinero");
                    }
                    else {
                        this.saldo-=dinero;
                        System.out.println("Su saldo es de: "+this.getSaldo());
                    }
                    break;
                default:
                    System.out.println("No es ninguna de las opciones por favor vuelva a intentarlo.");
                    break;
            }
            System.out.println("¿Que operacion desea realizar? (1)Revisar su saldo, (2)Ingresar dinero, (3)Extraer dinero y (-1)Terminar operaciones");
            eleccion=ec.nextInt();
        }
        System.out.println("Gracias por usar este banco");
        ec.close();
    }

    public void cuentaNueva(String nombre){
        Scanner tec=new Scanner (System.in);
        Random rand=new Random();
        this.titular=nombre;
        StringBuilder cuenta=new StringBuilder();
        System.out.println("Vamos a crear su número de cuenta de 20 digitos.");
        for(int i=0; i<20; i++) {
            cuenta.append(rand.nextInt(10));
        }
        this.numeroCuenta=cuenta.toString();
        System.out.println("Su cuenta es: "+this.getNumeroCuenta());
        menuCuenta(this.numeroCuenta);
        tec.close();
    }
}

public class cuentaBancaria {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String eleccion, nombre, numCuenta="";
        Cuenta cu=new Cuenta();
        Cuenta rf = new Cuenta();
        rf.setTitular("Rodolfo");
        rf.setSaldo(15267);
        rf.setNumeroCuenta("01234567899876543210");
        System.out.println("¿Es usted nuevo en el banco? (Si/No)");
        eleccion=sc.nextLine();
        if(eleccion.equals("Si")) {
            System.out.println("¿Cual es su nombre?");
            nombre=sc.nextLine();
            cu.cuentaNueva(nombre);
        }
        else {
            System.out.print("Introduzca su numero de cuenta: ");
            numCuenta=sc.nextLine();
            if(numCuenta.equals(rf.getNumeroCuenta())) {
                rf.menuCuenta(numCuenta);
            }
            else {
                System.out.println("Cuenta no registrada.");
            }
        }
        sc.close();
    }
}