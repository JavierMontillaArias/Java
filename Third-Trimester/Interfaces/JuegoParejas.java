import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class JuegoParejas extends Frame {
    private ArrayList<Integer> numeros;
    private Button[] botones;
    private int primerBoton, segundoBoton;
    private int primerNumero;
    private boolean esperandoSegundo;
    private int paresEncontrados;
    private boolean necesitaOcultar;

    JuegoParejas() {
        primerBoton = -1;
        segundoBoton = -1;
        primerNumero = -1;
        esperandoSegundo = false;
        paresEncontrados = 0;
        necesitaOcultar = false;

        generarParejas();
        
        setTitle("Juego de Parejas");
        setLayout(new GridLayout(2, 3, 10, 10));

        botones = new Button[6];
        for(int i = 0; i < 6; i++) {
            botones[i] = new Button();
            int numBoton = i;
            botones[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    manejarClick(numBoton);
                }
            });
            add(botones[i]);
        }

        setSize(300, 200);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    private void manejarClick(int botonActual) {
        // Si hay cartas incorrectas mostradas, ocultarlas primero
        if (necesitaOcultar) {
            botones[primerBoton].setLabel("");
            botones[segundoBoton].setLabel("");
            necesitaOcultar = false;
            primerBoton = -1;
            segundoBoton = -1;
            esperandoSegundo = false;
        }

        // Si el botón ya está mostrado, no hacer nada
        if (!botones[botonActual].getLabel().equals("")) {
            return;
        }

        // Mostrar el número en el botón
        botones[botonActual].setLabel(String.valueOf(numeros.get(botonActual)));

        if (!esperandoSegundo) {
            // Primer botón de la pareja
            primerBoton = botonActual;
            primerNumero = numeros.get(botonActual);
            esperandoSegundo = true;
        } else {
            // Segundo botón de la pareja
            segundoBoton = botonActual;
            esperandoSegundo = false;

            // Verificar si los números son iguales
            if (primerNumero == numeros.get(botonActual)) {
                // Par encontrado
                paresEncontrados++;
                primerBoton = -1;
                segundoBoton = -1;
                
                // Verificar si el juego ha terminado
                if (paresEncontrados == 3) {
                    mostrarMensajeVictoria();
                }
            } else {
                // No son pares, marcar para ocultar en el próximo click
                necesitaOcultar = true;
            }
        }
    }

    private void mostrarMensajeVictoria() {
        Dialog dialog = new Dialog(this, "¡Felicitaciones!", true);
        dialog.setLayout(new FlowLayout());
        dialog.add(new Label("¡Has encontrado todos los pares!"));
        Button okButton = new Button("OK");
        okButton.addActionListener(e -> {
            dialog.dispose();
            reiniciarJuego();
        });
        dialog.add(okButton);
        dialog.setSize(200, 100);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void reiniciarJuego() {
        paresEncontrados = 0;
        esperandoSegundo = false;
        primerBoton = -1;
        segundoBoton = -1;
        necesitaOcultar = false;
        generarParejas();
        
        
        for (Button bnt : botones) {
            bnt.setLabel("");
        }
    }

    public void generarParejas() {
        numeros = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            int num = i + 1;
            numeros.add(num);
            numeros.add(num);
        }
        Collections.shuffle(numeros);
    }

    public static void main(String[] args) {
        new JuegoParejas();
    }
}