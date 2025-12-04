import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MemoriaGame extends JFrame {
    private JPanel panel;
    private JButton[] cards;

    public MemoriaGame() {
        setTitle("Juego de Memoria");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        cards = new JButton[16];
        for (int i = 0; i < 16; i++) {
            cards[i] = new JButton("?");
            cards[i].setFont(new Font("Arial", Font.BOLD, 20));
            cards[i].addActionListener(new CardListener());
            panel.add(cards[i]);
        }

        add(panel);
        setVisible(true);
    }

    private class CardListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton clicked = (JButton) e.getSource();
            clicked.setText("X"); // temporal para test
        }
    }

    public static void main(String[] args) {
        new MemoriaGame();
    }
}
