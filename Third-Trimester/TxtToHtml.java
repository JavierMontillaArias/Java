import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class TxtToHtml {
    public static void main(String[] args) {
        String archivoEntrada = "input.txt";
        String archivoSalida = "output.html";
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivoEntrada));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida));

            String htmlCabecera = "<!DOCTYPE html>\n <html>\n <head>\n <title>Conversi&oacute;n de " + archivoEntrada +"</title>\n </head>\n <body>\n <pre>";
            String htmlPie = "</pre></body>\n</html>\n";

            escritor.write(htmlCabecera);
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] palabras = linea.split(" ");
                for(String palabra : palabras) {
                    if(palabra.toLowerCase().startsWith("s")){
                        escritor.write("<b>");
                        escritor.write(palabra + " ");
                        escritor.write("</b>");
                    }
                    else {
                        escritor.write(palabra + " ");
                    }
                }
                escritor.write("\n");
            }
            escritor.write(htmlPie);
            escritor.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
        
        
    }
}