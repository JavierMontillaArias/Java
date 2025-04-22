import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MapaInverso {
    public static void main(String[] args) {
        HashMap<String, String> empleadosPorDepartamento = new HashMap<>();
        empleadosPorDepartamento.put("Juan", "Ventas");
        empleadosPorDepartamento.put("María", "Ventas");
        empleadosPorDepartamento.put("Pedro", "IT");
        empleadosPorDepartamento.put("Ana", "IT");
        empleadosPorDepartamento.put("Luis", "Recursos Humanos");
        HashMap<String, HashSet<String>> empleados = new HashMap<>();
        for(Map.Entry<String, String> dict : empleadosPorDepartamento.entrySet()){
            String dep = dict.getValue();
            String nom = dict.getKey();
            if(!empleados.containsKey(dep)){
                empleados.put(dep, new HashSet<>());
            }
            empleados.get(dep).add(nom);
        }
        for(Map.Entry<String, HashSet<String>> dict : empleados.entrySet()){
            System.out.println("Departamento: " + dict.getKey() + " | Nombre: " + dict.getValue());
        }
    }
}
