import java.util.Scanner;

class Coche{
    private String marca;
    private String modelo;
    private float potencia;
    private String matricula;
    Coche(){
        this.marca="";
        this.modelo="";
        this.potencia=0;
        this.matricula="";
    }
    public void setMarca (String marc) { this.marca=marc;}
    public void setModelo (String mod) { this.modelo=mod;}
    public void setPotencia (Float pot) { this.potencia=pot;}
    public void setMatricular (String mat) {this.matricula=mat;}
    
    public String getMarca (){ return this.marca;}
    public String getModelo (){ return this.modelo;}
    public Float getPotencia (){ return this.potencia;}
    public String getMatricula (){ return this.matricula;}
}

public class claseCoche {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        sc.close();
    }
}