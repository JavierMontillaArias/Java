import java.util.TreeSet;

public class EjemplosSetDAM {
    public static void main(String[] args) {
        TreeSet<String> conjunto = new TreeSet<>();

        System.out.println("-----------------------------------------------------");

        if(conjunto.isEmpty()){
            System.out.println("Conjunto vacío");
            System.out.println("-----------------------------------------------------");
        }
        if(conjunto.add("Juan"))
            System.out.println("Añadido correctamente");
        else
            System.out.println("No se pudo añadir");
        if(conjunto.add("Marta"))
            System.out.println("Añadido correctamente");
        else
            System.out.println("No se pudo añadir");
        conjunto.add("Aaron");
        conjunto.add("Marta");
        conjunto.add("Juan");

        System.out.println("El tamaño del conjunto es: " + conjunto.size());
        System.out.println("-----------------------------------------------------");

        for(String elemento : conjunto){
            System.out.println("Elemento: " + elemento);
        }
        System.out.println("-----------------------------------------------------");
        conjunto.remove("Juan");
        for(String elemento : conjunto){
            System.out.println("Elemento: " + elemento);
        }
        System.out.println("-----------------------------------------------------");
    }
}
