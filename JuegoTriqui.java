import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoTriqui extends JFrame {

    private JButton[][] botones = new JButton[3][3];
    private boolean turnoX = true; // true = X, false = O

    public JuegoTriqui() {
        setTitle("Triqui");
        setSize(300, 300);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3, 3));

        inicializarTablero();
    }

    private void inicializarTablero() {
        // Tablero básico (aún no revisa ganadores)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j] = new JButton("");
                botones[i][j].setFont(new Font("Arial", Font.BOLD, 40));

                int fila = i;
                int col = j;

                botones[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Lógica incompleta (para el commit inicial)
                        if (botones[fila][col].getText().equals("")) {
                            botones[fila][col].setText(turnoX ? "X" : "O");
                            turnoX = !turnoX;
                        }

                        // Aquí luego se agregará la función para revisar ganador
                    }
                });

                add(botones[i][j]);
            }
        }
    }
}
