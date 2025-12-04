import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JuegoTriqui extends JFrame {
    private JButton[][] board;
    private boolean turnX = true;
    private JButton resetBtn;

    public Triqui() {
        setTitle("Triqui");
        setSize(350, 420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(3, 3));
        board = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton();
                btn.setFont(new Font("Arial", Font.BOLD, 40));
                int x = i;
                int y = j;

                btn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (btn.getText().equals("")) {
                            btn.setText(turnX ? "X" : "O");
                            turnX = !turnX;
                            checkWinner();
                        }
                    }
                });

                board[i][j] = btn;
                grid.add(btn);
            }
        }

        resetBtn = new JButton("Reiniciar partida");
        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        add(grid, BorderLayout.CENTER);
        add(resetBtn, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].setText("");
            }
        }
        turnX = true;
    }

    private void checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].getText().equals("") && 
                board[i][0].getText().equals(board[i][1].getText()) &&
                board[i][1].getText().equals(board[i][2].getText())) {
                announceWinner(board[i][0].getText());
            }
            if (!board[0][i].getText().equals("") && 
                board[0][i].getText().equals(board[1][i].getText()) &&
                board[1][i].getText().equals(board[2][i].getText())) {
                announceWinner(board[0][i].getText());
            }
        }

        if (!board[0][0].getText().equals("") &&
            board[0][0].getText().equals(board[1][1].getText()) &&
            board[1][1].getText().equals(board[2][2].getText())) {
            announceWinner(board[0][0].getText());
        }

        if (!board[0][2].getText().equals("") &&
            board[0][2].getText().equals(board[1][1].getText()) &&
            board[1][1].getText().equals(board[2][0].getText())) {
            announceWinner(board[0][2].getText());
        }
    }

    private void announceWinner(String player) {
        JOptionPane.showMessageDialog(this, "Ganó " + player);
        resetGame();
    }
}
