import java.awt.*;
import java.awt.event.*;

public class Calculadora extends Frame {
    private double operando = 0;
    private String operacion = "";

    Calculadora(){
        Font fuente = new Font("Arial", Font.PLAIN, 30);

        setTitle("Calculadora");
        setLayout(new BorderLayout());
        Panel pnlNumeros = new Panel();
        Panel pnlOpc = new Panel();
        pnlOpc.setPreferredSize(new Dimension(80,0));
        pnlNumeros.setLayout(new GridLayout(4,3, 5,5));
        pnlOpc.setLayout(new GridLayout(5,1,5,5));

        Button btn1 = new Button("1"); pnlNumeros.add(btn1); btn1.setFont(fuente);
        Button btn2 = new Button("2"); pnlNumeros.add(btn2); btn2.setFont(fuente);
        Button btn3 = new Button("3"); pnlNumeros.add(btn3); btn3.setFont(fuente);
        Button btn4 = new Button("4"); pnlNumeros.add(btn4); btn4.setFont(fuente);
        Button btn5 = new Button("5"); pnlNumeros.add(btn5); btn5.setFont(fuente);
        Button btn6 = new Button("6"); pnlNumeros.add(btn6); btn6.setFont(fuente);
        Button btn7 = new Button("7"); pnlNumeros.add(btn7); btn7.setFont(fuente);
        Button btn8 = new Button("8"); pnlNumeros.add(btn8); btn8.setFont(fuente);
        Button btn9 = new Button("9"); pnlNumeros.add(btn9); btn9.setFont(fuente);
        Button btn0 = new Button("0"); pnlNumeros.add(btn0); btn0.setFont(fuente);
        Button btnD = new Button("."); pnlNumeros.add(btnD); btnD.setFont(fuente);
        Button btnC = new Button("C"); pnlNumeros.add(btnC); btnC.setFont(fuente);

        Button btnMas = new Button("+"); pnlOpc.add(btnMas); btnMas.setFont(fuente);
        Button btnMenos = new Button("-"); pnlOpc.add(btnMenos); btnMenos.setFont(fuente);
        Button btnMult = new Button("*"); pnlOpc.add(btnMult); btnMult.setFont(fuente);
        Button btnDiv = new Button("/"); pnlOpc.add(btnDiv); btnDiv.setFont(fuente);
        Button btnIgual = new Button("="); pnlOpc.add(btnIgual); btnIgual.setFont(fuente);

        Label lblVisor = new Label(); 
        lblVisor.setPreferredSize(new Dimension(0,50));
        lblVisor.setAlignment(Label.RIGHT);
        lblVisor.setFont(fuente);

        btnC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblVisor.setText("");
                operando = 0;
                operacion = "";
            }
        });
        btn1.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {lblVisor.setText(lblVisor.getText()+"1");}});
        btn2.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {lblVisor.setText(lblVisor.getText()+"2");}});
        btn3.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {lblVisor.setText(lblVisor.getText()+"3");}});
        btn4.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {lblVisor.setText(lblVisor.getText()+"4");}});
        btn5.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {lblVisor.setText(lblVisor.getText()+"5");}});
        btn6.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {lblVisor.setText(lblVisor.getText()+"6");}});
        btn7.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {lblVisor.setText(lblVisor.getText()+"7");}});
        btn8.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {lblVisor.setText(lblVisor.getText()+"8");}});
        btn9.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {lblVisor.setText(lblVisor.getText()+"9");}});
        btn0.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {lblVisor.setText(lblVisor.getText()+"0");}});
        btnD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!lblVisor.getText().contains("."))
                    lblVisor.setText(lblVisor.getText()+".");
            }
        });
        btnMas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operando = Double.parseDouble(lblVisor.getText());
                lblVisor.setText("");
                operacion = "+";
            }
        });
        btnMenos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operando = Double.parseDouble(lblVisor.getText());
                lblVisor.setText("");
                operacion = "-";
            }
        });
        btnMult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operando = Double.parseDouble(lblVisor.getText());
                lblVisor.setText("");
                operacion = "*";
            }
        });
        btnDiv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operando = Double.parseDouble(lblVisor.getText());
                lblVisor.setText("");
                operacion = "/";
            }
        });
        btnIgual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!operacion.equals(""))
                {
                    switch (operacion) {
                        case "+": lblVisor.setText(String.valueOf(operando + Double.parseDouble(lblVisor.getText())));break;
                        case "-": lblVisor.setText(String.valueOf(operando - Double.parseDouble(lblVisor.getText())));break;
                        case "*": lblVisor.setText(String.valueOf(operando * Double.parseDouble(lblVisor.getText())));break;
                        case "/": lblVisor.setText(String.valueOf(operando / Double.parseDouble(lblVisor.getText())));break;
                    }
                    operando = 0;
                    operacion = "";
                }

            }
        });






        setLayout(new BorderLayout());
        add(lblVisor, BorderLayout.NORTH);
        add(pnlNumeros, BorderLayout.CENTER);
        add(pnlOpc, BorderLayout.EAST);
        setSize(400, 500);     
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });        
    }


    public static void main(String[] args) {
        new Calculadora();    
    }

}