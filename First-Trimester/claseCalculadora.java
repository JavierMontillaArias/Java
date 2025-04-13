import java.util.Scanner;
class Calculadora {
    private double numeroA;
    private double numeroB;
    private double resultado;

    Calculadora () {
        numeroA=0.0;
        numeroB=0.0;
        resultado=0.0;
    }

    //Getters
    public Double getNumeroA() {return this.numeroA;}
    public Double getNumeroB() {return this.numeroB;}
    public Double getResultado() {return this.resultado;}
    //Setters
    public void setNumeroA (double numA) {this.numeroA=numA;}
    public void setNumeroB (double numB) {this.numeroB=numB;}
    public void setResultado (double res) {this.resultado=res;}

    @Override
    public String toString() {return "Numero A: " +numeroA+ "\nNumero B: " +numeroB+ "\nResultado: "+resultado;}
    
    //Funciones
    public double suma (double numA, double numB) {return numA+numB;}
    public double resta (double numA, double numB) {return numA-numB;}
    public double multiplicacion (double numA, double numB) {return numA*numB;}
    public double division (double numA, double numB) {return numA/numB;}
    public double potencia (double numA, double numB) {return Math.pow(numA, numB);}
    public double raizCuadrada (double numA) {return Math.sqrt(numA);}
    public void borrar () {
        this.numeroA=0.0;
        this.numeroB=0.0;
        this.resultado=0.0;
    }
    //Funcion menu de calculadora
    public void calcular () {
        Scanner tec = new Scanner (System.in);
        int eleccion;
        //Esta es la eleccion para el switch
        System.out.println("¿Que operacion quieres realizar suma(1), resta(2), multiplicacion(3), division(4), potencia(5), raiz(6), borrar resultado(7) o acabar el programa(8)?");
        eleccion=tec.nextInt();
        //Si el usuario pone 8 se sale de la función
        if (eleccion==8) {
            System.out.println("Gracias por usar la calculadora!");
            System.exit(0);
        }
        //Meter los numeros
        System.out.println("Dame el primer numero: ");
        this.numeroA=tec.nextDouble();
        System.out.println("Dame el segundo numero: ");
        this.numeroB=tec.nextDouble();
        switch (eleccion) {
            case 1:
                System.out.println(this.numeroA+" + "+this.numeroB+ " = "+this.suma(this.numeroA, this.numeroB));
                break;
            case 2:
                System.out.println(this.numeroA+" - "+this.numeroB+ " = "+this.resta(this.numeroA, this.numeroB));
                break;
            case 3:
                System.out.println(this.numeroA+" * "+this.numeroB+ " = "+this.multiplicacion(this.numeroA, this.numeroB));
                break;
            case 4:
                System.out.println(this.numeroA+" / "+this.numeroB+ " = "+this.division(this.numeroA, this.numeroB));
                break;
            case 5:
                System.out.println(this.numeroA+" ^ "+this.numeroB+ " = "+potencia(this.numeroA, this.numeroB));
                break;
            case 6:
                System.out.println("El resultado de la raiz cuadrada es: "+this.raizCuadrada(this.numeroA));
                break;
            case 7:
                this.borrar();
                System.out.println("Las variables fueron borradas.");
                break;
            default:
                System.out.println("No es ningula de las opciones.");
                break;
        }
        this.calcular();
        tec.close();
    }
}
public class claseCalculadora {
    public static void main(String[] args) {
        Calculadora n = new Calculadora();
        n.calcular();
    }
}