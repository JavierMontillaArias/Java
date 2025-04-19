public class TiposEnumerados {
    public enum Dias {LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO, ENERO};
    
    public static void main(String[] args) {
        Dias diaActual = Dias.MARTES;
        Dias diaSiguiente = Dias.ENERO;
        
        System.out.println("Hoy es: " + diaActual);
        System.out.println("Mañana es " + diaSiguiente);
    }
}
