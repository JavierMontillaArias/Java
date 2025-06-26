package com.cliente;

public class SQLClient {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
                GestorUI ui = new GestorUI();
                ui.setVisible(true);
        });
    }
}
