package com.cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class GestorUI extends JFrame {
    private JTextField userField, passwordField, hostField, dbField;
    private JTextArea queryArea;
    private JTable resultTable;
    private JButton connectButton, disconnectButton, executeButton, clearButton;
    private GestorBD dbManager;
    private DefaultTableModel tableModel;

    public GestorUI() {
        dbManager = new GestorBD();
        initializeComponents();
        setupLayout();
        setupListeners();
    }

    private void initializeComponents() {
        // Campos de conexión
        userField = new JTextField(20);
        passwordField = new JPasswordField(20);
        hostField = new JTextField(20);
        dbField = new JTextField(20);
        
        // Botones
        connectButton = new JButton("Conectar");
        disconnectButton = new JButton("Desconectar");
        executeButton = new JButton("Ejecutar Query");
        clearButton = new JButton("Limpiar");
        
        // Área de consulta
        queryArea = new JTextArea(4, 40);
        queryArea.setLineWrap(true);
        queryArea.setWrapStyleWord(true);
        
        // Tabla de resultados
        tableModel = new DefaultTableModel();
        resultTable = new JTable(tableModel);
    }

    private void setupLayout() {
        setTitle("Gestor de Base de Datos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel superior (conexión)
        JPanel connectionPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        gbc.gridx = 0; gbc.gridy = 0;
        connectionPanel.add(new JLabel("Usuario:"), gbc);
        gbc.gridx = 1;
        connectionPanel.add(userField, gbc);
        
        gbc.gridx = 2;
        connectionPanel.add(new JLabel("Contraseña:"), gbc);
        gbc.gridx = 3;
        connectionPanel.add(passwordField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        connectionPanel.add(new JLabel("Host:"), gbc);
        gbc.gridx = 1;
        connectionPanel.add(hostField, gbc);
        
        gbc.gridx = 2;
        connectionPanel.add(new JLabel("Base de Datos:"), gbc);
        gbc.gridx = 3;
        connectionPanel.add(dbField, gbc);
        
        gbc.gridx = 4; gbc.gridy = 0;
        connectionPanel.add(connectButton, gbc);

        gbc.gridx = 4; gbc.gridy = 1;
        disconnectButton.setEnabled(false);
        connectionPanel.add(disconnectButton, gbc);

        // Panel central (query)
        JPanel queryPanel = new JPanel(new BorderLayout(5, 5));
        queryPanel.add(new JLabel("Consulta SQL (SELECT):"), BorderLayout.NORTH);
        queryPanel.add(new JScrollPane(queryArea), BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        executeButton.setEnabled(false);
        buttonPanel.add(executeButton);
        clearButton.setEnabled(false);
        buttonPanel.add(clearButton);
        queryPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Panel inferior (resultados)
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.add(new JScrollPane(resultTable), BorderLayout.CENTER);

        // Añadir todos los paneles al frame
        add(connectionPanel, BorderLayout.NORTH);
        add(queryPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void setupListeners() {
        connectButton.addActionListener(e -> {
            boolean connected = dbManager.connect(
                hostField.getText(),
                dbField.getText(),
                userField.getText(),
                passwordField.getText()
            );
            
            if (connected) {
                JOptionPane.showMessageDialog(this, "Conexión exitosa!");
                executeButton.setEnabled(true);
                clearButton.setEnabled(true);
                disconnectButton.setEnabled(true);
                connectButton.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Error al conectar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        disconnectButton.addActionListener(e -> {
            dbManager.disconnect();
                JOptionPane.showMessageDialog(this, "Desconexión exitosa!");
                executeButton.setEnabled(false);
                clearButton.setEnabled(false);
                connectButton.setEnabled(true);
                disconnectButton.setEnabled(false);
        });

        executeButton.addActionListener(e -> {
            String query = queryArea.getText().trim();
            if (!query.toLowerCase().startsWith("select")) {
                JOptionPane.showMessageDialog(this, "Solo se permiten consultas SELECT", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Object[][] data = dbManager.executeQuery(query);
            if (data != null) {
                tableModel.setDataVector(data, dbManager.getColumnNames());
            } else {
                JOptionPane.showMessageDialog(this, "Error al ejecutar la consulta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        clearButton.addActionListener(e -> {
            queryArea.setText("");
            tableModel.setRowCount(0);
            tableModel.setColumnCount(0);
        });
    }
}