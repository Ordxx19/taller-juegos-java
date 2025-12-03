import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Taller de Juegos");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnTriqui = new JButton("Jugar Triqui");
        JButton btnParejas = new JButton("Jugar Parejas");
        JButton btnAhorcado = new JButton("Jugar Ahorcado");
        JButton btnCalculadora = new JButton("Calculadora");

        panel.add(btnTriqui);
        panel.add(btnParejas);
        panel.add(btnAhorcado);
        panel.add(btnCalculadora);

        add(panel);

        // Acción de botón incompleta (a propósito)
        btnTriqui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JuegoTriqui().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new MainMenu().setVisible(true);
    }
}
