import java.util.Scanner;

public class rote {

    public static int[] rotarLista(int lista [], int posiciones, boolean izquierda){
        int n = lista.length;
        int [] nuevaLista = new int[n];
        for(int i = 0; i < n; i++){
            int nuevaPosicion;
            if(izquierda == true){
                nuevaPosicion = (n + i - posiciones)%n;
            } else {
                nuevaPosicion = (i + posiciones)%n;
            }
            nuevaLista[nuevaPosicion] = lista [i];
        }
        return nuevaLista;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el tamaño de la lista: ");
        int tamanio = sc.nextInt();
        int lista [] = new int[tamanio];
        System.out.print("Cuantas posiciones rota: ");
        int posiciones = sc.nextInt();
        sc.nextLine();
        System.out.print("Rota a Izquierda o a la Derecha (I/D): ");
        String eleccion = sc.nextLine().toLowerCase();
        boolean izq;
        for(int i = 0; i < tamanio; i++){
            lista[i] = i;
        }
        
        if(eleccion.equals("i")){
            izq=true;
        } else {
            izq=false;
        }
        System.out.print("Lista sin rotar -> [");
        for(int i = 0; i < tamanio; i++){
            if(i < tamanio - 1){
                System.out.print(lista[i] + ", ");
            } else {
                System.out.println(lista[i] + "]");
            }
        }
        lista = rotarLista(lista, posiciones, izq);
        System.out.print("Lista rotada -> [");
        for(int i = 0; i < tamanio; i++){
            if(i < tamanio - 1){
                System.out.print(lista[i] + ", ");
            } else {
                System.out.println(lista[i] + "]");
            }
        }
        sc.close();
    }
}
