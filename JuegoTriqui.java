import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JuegoTriqui extends JFrame {
    private JButton[][] botones = new JButton[3][3];
    private char turno = 'X';

    public JuegoTriqui() {
        setTitle("Triqui");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j] = new JButton("");
                botones[i][j].setFont(new Font("Arial", Font.BOLD, 40));

                final int x = i, y = j;

                botones[i][j].addActionListener(e -> jugar(x, y));

                add(botones[i][j]);
            }
        }

        setVisible(true);
    }

    private void jugar(int x, int y) {
        if (!botones[x][y].getText().equals("")) return;

        botones[x][y].setText(String.valueOf(turno));

        if (ganador(turno)) {
            JOptionPane.showMessageDialog(this, "Ganó " + turno);
            reiniciar();
            return;
        }

        if (empate()) {
            JOptionPane.showMessageDialog(this, "Empate");
            reiniciar();
            return;
        }

        turno = (turno == 'X') ? 'O' : 'X';
    }

    private boolean ganador(char t) {
        for (int i = 0; i < 3; i++)
            if (botones[i][0].getText().equals(t+"") &&
                botones[i][1].getText().equals(t+"") &&
                botones[i][2].getText().equals(t+""))
                return true;

        for (int j = 0; j < 3; j++)
            if (botones[0][j].getText().equals(t+"") &&
                botones[1][j].getText().equals(t+"") &&
                botones[2][j].getText().equals(t+""))
                return true;

        return (botones[0][0].getText().equals(t+"") &&
                botones[1][1].getText().equals(t+"") &&
                botones[2][2].getText().equals(t+""))
            ||
               (botones[0][2].getText().equals(t+"") &&
                botones[1][1].getText().equals(t+"") &&
                botones[2][0].getText().equals(t+""));
    }

    private boolean empate() {
        for (JButton[] fila : botones)
            for (JButton b : fila)
                if (b.getText().equals(""))
                    return false;
        return true;
    }

    private void reiniciar() {
        for (JButton[] fila : botones)
            for (JButton b : fila)
                b.setText("");
        turno = 'X';
    }
}

