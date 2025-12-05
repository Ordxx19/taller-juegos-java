import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AhorcadoGame extends JFrame {
    private String[] palabras = {"JAVA", "CODIGO", "MENU", "AHORCADO"};
    private String palabra;
    private char[] progreso;
    private int errores = 0;

    private JLabel lblProgreso;
    private JTextField txtLetra;
    private JLabel lblErrores;

    public AhorcadoGame() {
        setTitle("Ahorcado");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        palabra = palabras[(int)(Math.random() * palabras.length)];
        progreso = new char[palabra.length()];
        for (int i = 0; i < progreso.length; i++) progreso[i] = '_';

        lblProgreso = new JLabel(String.valueOf(progreso));
        lblProgreso.setFont(new Font("Arial", Font.BOLD, 28));
        lblProgreso.setHorizontalAlignment(SwingConstants.CENTER);

        lblErrores = new JLabel("Errores: 0/6");
        lblErrores.setHorizontalAlignment(SwingConstants.CENTER);

        txtLetra = new JTextField();
        txtLetra.addActionListener(e -> intentar());

        add(lblProgreso, BorderLayout.NORTH);
        add(txtLetra, BorderLayout.CENTER);
        add(lblErrores, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void intentar() {
        String entrada = txtLetra.getText().toUpperCase();
        txtLetra.setText("");

        if (entrada.length() != 1) return;

        char letra = entrada.charAt(0);
        boolean acierto = false;

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                progreso[i] = letra;
                acierto = true;
            }
        }

        if (!acierto) {
            errores++;
            lblErrores.setText("Errores: " + errores + "/6");
            if (errores == 6) {
                JOptionPane.showMessageDialog(this, "Perdiste. La palabra era: " + palabra);
                dispose();
            }
        }

        lblProgreso.setText(String.valueOf(progreso));

        if (String.valueOf(progreso).equals(palabra)) {
            JOptionPane.showMessageDialog(this, "Ganaste");
            dispose();
        }
    }
}
