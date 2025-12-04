import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraGame extends JFrame {
    private JTextField display;
    private double num1 = 0;
    private double num2 = 0;
    private String operador = "";

    public CalculadoraGame() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] botones = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String text : botones) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 22));
            btn.addActionListener(new Listener());
            panel.add(btn);
        }

        add(panel);
        setVisible(true);
    }

    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();

            if (cmd.matches("[0-9]")) {
                display.setText(display.getText() + cmd);
                return;
            }

            if (cmd.equals("C")) {
                display.setText("");
                num1 = num2 = 0;
                operador = "";
                return;
            }

            if (cmd.equals("=") && !operador.equals("")) {
                num2 = Double.parseDouble(display.getText());
                double resultado = 0;

                switch (operador) {
                    case "+": resultado = num1 + num2; break;
                    case "-": resultado = num1 - num2; break;
                    case "*": resultado = num1 * num2; break;
                    case "/": 
                        if (num2 != 0) resultado = num1 / num2;
                        else {
                            display.setText("Error");
                            return;
                        }
                        break;
                }

                display.setText(String.valueOf(resultado));
                operador = "";
                return;
            }

            if (cmd.matches("[+\-*/]")) {
                num1 = Double.parseDouble(display.getText());
                operador = cmd;
                display.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new CalculadoraGame();
    }
}
