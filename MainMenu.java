import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Menú Principal");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnTriqui = new JButton("Triqui");
        JButton btnAhorcado = new JButton("Ahorcado");
        JButton btnMemoria = new JButton("Memoria");
        JButton btnCalculadora = new JButton("Calculadora");
        JButton btnSalir = new JButton("Salir");

        btnTriqui.addActionListener(e -> new TriquiGame());
        btnAhorcado.addActionListener(e -> new AhorcadoGame());
        btnMemoria.addActionListener(e -> new MemoriaGame());
        btnCalculadora.addActionListener(e -> new CalculadoraGame());
        btnSalir.addActionListener(e -> System.exit(0));

        panel.add(btnTriqui);
        panel.add(btnAhorcado);
        panel.add(btnMemoria);
        panel.add(btnCalculadora);
        panel.add(btnSalir);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}

