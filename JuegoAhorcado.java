import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

public class HangmanGame extends JFrame {
    private String[] words = {"JAVA", "AHORCADO", "PROGRAMAR", "CLASE", "OBJETO"};
    private String currentWord;
    private Set<Character> guessedLetters;
    private int lives;

    private JLabel wordLabel;
    private JLabel livesLabel;
    private JTextField inputField;
    private JButton guessButton;
    private JButton restartButton;

    public HangmanGame() {
        setTitle("Ahorcado");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        wordLabel = new JLabel();
        livesLabel = new JLabel();
        inputField = new JTextField(5);
        guessButton = new JButton("Adivinar");
        restartButton = new JButton("Reiniciar");

        add(wordLabel);
        add(livesLabel);
        add(new JLabel("Letra:"));
        add(inputField);
        add(guessButton);
        add(restartButton);

        startGame();

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guessLetter();
            }
        });

        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
    }

    private void startGame() {
        currentWord = words[(int)(Math.random() * words.length)];
        guessedLetters = new HashSet<>();
        lives = 6;

        updateLabels();
    }

    private void guessLetter() {
        String text = inputField.getText().toUpperCase();
        if (text.length() != 1) return;

        char letter = text.charAt(0);
        inputField.setText("");

        if (!guessedLetters.contains(letter)) {
            guessedLetters.add(letter);
            if (!currentWord.contains(String.valueOf(letter))) {
                lives--;
            }
        }

        updateLabels();
        checkGameState();
    }

    private void updateLabels() {
        String display = "";

        for (char c : currentWord.toCharArray()) {
            if (guessedLetters.contains(c)) {
                display += c + " ";
            } else {
                display += "_ ";
            }
        }

        wordLabel.setText("Palabra: " + display);
        livesLabel.setText("Vidas: " + lives);
    }

    private void checkGameState() {
        boolean won = true;
        for (char c : currentWord.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                won = false;
                break;
            }
        }

        if (won) {
            JOptionPane.showMessageDialog(this, "¡Ganaste! La palabra era: " + currentWord);
        } else if (lives <= 0) {
            JOptionPane.showMessageDialog(this, "Perdiste :( La palabra era: " + currentWord);
        }
    }
}

