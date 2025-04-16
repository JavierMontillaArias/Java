import java.util.Scanner;
class Coche{
    String marca;
    String modelo;
    float potencia;
    String matricula;
    Coche(){
        this.marca="";
        this.modelo="";
        this.potencia=0;
        this.matricula="";
    }
    public void registrar(String mar, String mod, float pot, String mat){
        this.marca=mar;
        this.modelo=mod;
        this.potencia=pot;
        this.matricula=mat;
    }
    @Override
    public String toString(){
        return "Marca: "+marca+ "\nModelo:" +modelo+ "\nPotencia:" +potencia+ "\nMatricula:" +matricula;
    }
}
public class claseCocheMejorado {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String mar, mod, mat;
        float pot;
        Coche car =new Coche();
        System.out.print("Dame una marca para introducirla: ");
        mar=sc.nextLine();
        System.out.print("Dame un modelo para introducirlo: ");
        mod=sc.nextLine();
        System.out.print("Dame una potencia para introducirla: ");
        pot=sc.nextFloat();
        sc.nextLine();
        System.out.print("Dame una matricula para introducirla: ");
        mat=sc.nextLine();
        car.registrar(mar, mod, pot, mat);
        System.out.println(car);
        sc.close();
    }
}