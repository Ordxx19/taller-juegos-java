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
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLayout(new GridLayout(3, 3));

        inicializarTablero();
    }

    private void inicializarTablero() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                botones[i][j] = new JButton("");
                botones[i][j].setFont(new Font("Arial", Font.BOLD, 40));

                int fila = i;
                int columna = j;

                botones[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (botones[fila][columna].getText().equals("")) {
                            botones[fila][columna].setText(turnoX ? "X" : "O");
                            turnoX = !turnoX;

                            
                            String ganador = verificarGanador();
                            if (ganador != null) {
                                JOptionPane.showMessageDialog(null,
                                        "Ganó: " + ganador + " (pendiente reiniciar el tablero)");
                            }
                        }
                    }
                });

                add(botones[i][j]);
            }
        }
    }

   
    private String verificarGanador() {

        // Revisar filas
        for (int i = 0; i < 3; i++) {
            if (!botones[i][0].getText().equals("") &&
                botones[i][0].getText().equals(botones[i][1].getText()) &&
                botones[i][1].getText().equals(botones[i][2].getText())) {

                return botones[i][0].getText();
            }
        }

      
        for (int j = 0; j < 3; j++) {
            if (!botones[0][j].getText().equals("") &&
                botones[0][j].getText().equals(botones[1][j].getText()) &&
                botones[1][j].getText().equals(botones[2][j].getText())) {

                return botones[0][j].getText();
            }
        }

 
        if (!botones[0][0].getText().equals("") &&
            botones[0][0].getText().equals(botones[1][1].getText()) &&
            botones[1][1].getText().equals(botones[2][2].getText())) {

            return botones[0][0].getText();
        }

        
        if (!botones[0][2].getText().equals("") &&
            botones[0][2].getText().equals(botones[1][1].getText()) &&
            botones[1][1].getText().equals(botones[2][0].getText())) {

            return botones[0][2].getText();
        }

  
        return null;
    }
}
