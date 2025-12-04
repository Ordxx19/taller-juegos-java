import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class HangmanGame extends JFrame {

    private String[] wordList = {"JAVA", "PROGRAMA", "AHORCADO", "VENTANA", "CLASE"};
    private String word;
    private char[] display;
    private int attemptsLeft;
    private java.util.List<Character> usedLetters;

    private JLabel wordLabel;
    private JLabel attemptsLabel;
    private JLabel usedLabel;
    private JTextField inputField;
    private JButton guessButton;
    private JButton backButton;

    public HangmanGame() {
        setTitle("Ahorcado");
        setSize(400, 300);
        setLayout(new GridLayout(6, 1));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        word = wordList[new Random().nextInt(wordList.length)];
        display = new char[word.length()];
        Arrays.fill(display, '_');
        attemptsLeft = 6;
        usedLetters = new ArrayList<>();

        wordLabel = new JLabel(String.valueOf(display), SwingConstants.CENTER);
        attemptsLabel = new JLabel("Intentos restantes: " + attemptsLeft, SwingConstants.CENTER);
        usedLabel = new JLabel("Letras usadas: ", SwingConstants.CENTER);

        inputField = new JTextField();
        guessButton = new JButton("Probar letra");
        backButton = new JButton("Volver al menú");

        add(wordLabel);
        add(attemptsLabel);
        add(usedLabel);
        add(inputField);
        add(guessButton);
        add(backButton);

        guessButton.addActionListener(e -> guess());
        backButton.addActionListener(e -> {
            new MainMenu().setVisible(true);
            dispose();
        });
    }

    private void guess() {
        String text = inputField.getText().toUpperCase();
        if (text.length() != 1) {
            inputField.setText("");
            return;
        }

        char letter = text.charAt(0);
        inputField.setText("");

        if (usedLetters.contains(letter)) return;

        usedLetters.add(letter);
        usedLabel.setText("Letras usadas: " + usedLetters.toString());

        if (word.indexOf(letter) >= 0) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter) {
                    display[i] = letter;
                }
            }
            wordLabel.setText(String.valueOf(display));

            if (String.valueOf(display).equals(word)) {
                JOptionPane.showMessageDialog(this, "GANASTE");
                dispose();
                new MainMenu().setVisible(true);
            }

        } else {
            attemptsLeft--;
            attemptsLabel.setText("Intentos restantes: " + attemptsLeft);

            if (attemptsLeft == 0) {
                JOptionPane.showMessageDialog(this, "PERDISTE. La palabra era: " + word);
                dispose();
                new MainMenu().setVisible(true);
            }
        }
    }
}
