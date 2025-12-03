import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoAhorcado extends JFrame {

    private String palabraSecreta = "JAVA"; // Luego la cambiamos
    private String palabraOculta = "____";   // Incompleto a propósito
    private int intentos = 6;

    private JLabel lblPalabra;
    private JLabel lblIntentos;
    private JTextField txtLetra;
    private JButton btnProbar;

    public JuegoAhorcado() {
        setTitle("Ahorcado");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLayout(new GridLayout(4, 1));

        lblPalabra = new JLabel("Palabra: " + palabraOculta, SwingConstants.CENTER);
        lblPalabra.setFont(new Font("Arial", Font.BOLD, 22));

        lblIntentos = new JLabel("Intentos restantes: " + intentos, SwingConstants.CENTER);

        txtLetra = new JTextField();
        btnProbar = new JButton("Probar letra");

        add(lblPalabra);
        add(lblIntentos);
        add(txtLetra);
        add(btnProbar);

        // Acción aún incompleta
        btnProbar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String letra = txtLetra.getText().toUpperCase();

                if (letra.length() == 1) {
                    // SOLO QUITAMOS INTENTOS – falta lógica
                    intentos--;
                    lblIntentos.setText("Intentos restantes: " + intentos);

                    // Falta: actualizar palabraOculta
                    // Falta: detectar derrota
                    // Falta: detectar victoria
                }

                txtLetra.setText("");
            }
        });
    }
}
