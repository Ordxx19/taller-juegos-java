import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Menu Principal");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton triquiBtn = new JButton("Jugar Triqui");
        JButton parejasBtn = new JButton("Jugar Parejas");
        JButton ahorcadoBtn = new JButton("Jugar Ahorcado");
        JButton calculadoraBtn = new JButton("Calculadora");

        panel.add(triquiBtn);
        panel.add(parejasBtn);
        panel.add(ahorcadoBtn);
        panel.add(calculadoraBtn);

        triquiBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TriquiGame();
            }
        });

        parejasBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Juego en desarrollo");
            }
        });

        ahorcadoBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Juego en desarrollo");
            }
        });

        calculadoraBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Juego en desarrollo");
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
