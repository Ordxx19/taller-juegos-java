import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MemoriaGame extends JFrame {
    private JPanel panel;
    private JButton[] cards;
    private int[] values = new int[16];
    private JButton firstCard = null;
    private JButton secondCard = null;
    private int matches = 0;

    public MemoriaGame() {
        setTitle("Juego de Memoria");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        // asignar pares
        int num = 1;
        for (int i = 0; i < 16; i += 2) {
            values[i] = num;
            values[i + 1] = num;
            num++;
        }

        // mezclar
        for (int i = 0; i < 16; i++) {
            int j = (int)(Math.random() * 16);
            int temp = values[i];
            values[i] = values[j];
            values[j] = temp;
        }

        cards = new JButton[16];
        for (int i = 0; i < 16; i++) {
            cards[i] = new JButton("?");
            cards[i].setFont(new Font("Arial", Font.BOLD, 20));
            cards[i].putClientProperty("index", i);
            cards[i].addActionListener(new CardListener());
            panel.add(cards[i]);
        }

        add(panel);
        setVisible(true);
    }

    private class CardListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton clicked = (JButton) e.getSource();
            int index = (int) clicked.getClientProperty("index");

            clicked.setText(String.valueOf(values[index]));
            clicked.setEnabled(false);

            if (firstCard == null) {
                firstCard = clicked;
            } else if (secondCard == null) {
                secondCard = clicked;
                Timer timer = new Timer(600, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        verificar();
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

    private void verificar() {
        int idx1 = (int) firstCard.getClientProperty("index");
        int idx2 = (int) secondCard.getClientProperty("index");

        if (values[idx1] == values[idx2]) {
            matches++;
            if (matches == 8) {
                JOptionPane.showMessageDialog(this, "¡Ganaste!");
            }
        } else {
            firstCard.setText("?");
            secondCard.setText("?");
            firstCard.setEnabled(true);
            secondCard.setEnabled(true);
        }

        firstCard = null;
        secondCard = null;
    }

    public static void main(String[] args) {
        new MemoriaGame();
    }
}
        }
    }

    public static void main(String[] args) {
        new MemoriaGame();
    }
}
