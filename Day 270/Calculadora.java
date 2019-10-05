import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Calculadora extends JFrame {

    /**
     * generado
     */
    private static final long serialVersionUID = 1583724102189855698L;

    /** numero tecleado */
    JTextField pantalla;

    /** guarda el resultado de la operacion anterior o el número tecleado */
    double resultado;

    double resultado2;
    /** para guardar la operacion a realizar */
    String operacion;

    /** Los paneles donde colocaremos los botones */
    JPanel panelNumeros, panelOperaciones;

    /** Indica si estamos iniciando o no una operación */
    boolean nuevaOperacion = true;

    /**
     * Constructor. Crea los botones y componentes de la calculadora
     */
    public Calculadora() {
        super();
        setSize(500, 600);
        setTitle("Calculadora Simple");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        // Vamos a dibujar sobre el panel
        JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(new BorderLayout());

        pantalla = new JTextField("0", 20);
        pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
        pantalla.setFont(new Font("Arial", Font.BOLD, 25));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        pantalla.setBackground(Color.WHITE);
        panel.add("North", pantalla);

        panelNumeros = new JPanel();
        panelNumeros.setLayout(new GridLayout(4, 3));
        panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));

        for (int n = 9; n >= 0; n--) {
            nuevoBotonNumerico("" + n);
        }

        nuevoBotonNumerico(".");

        panel.add("Center", panelNumeros);

        panelOperaciones = new JPanel();
        panelOperaciones.setLayout(new GridLayout(6, 1));
        panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));

        nuevoBotonOperacion("+");
        nuevoBotonOperacion("-");
        nuevoBotonOperacion("*");
        nuevoBotonOperacion("/");
        nuevoBotonOperacion("Sqrt");
        nuevoBotonOperacion("^2");
        nuevoBotonOperacion("^x");
        nuevoBotonOperacion("=");
        nuevoBotonOperacion("CE");

        panel.add("East", panelOperaciones);

        validate();
    }

    /**
     * Crea un boton del teclado numérico y enlaza sus eventos con el listener
     * correspondiente
     *
     *
     */
    private void nuevoBotonNumerico(String digito) {
        JButton btn = new JButton();
        btn.setText(digito);
        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                numeroPulsado(btn.getText());
            }
        });

        panelNumeros.add(btn);
    }

    /**
     * Crea un botón de operacion y lo enlaza con sus eventos.
     *
     *
     */
    private void nuevoBotonOperacion(String operacion) {
        JButton btn = new JButton(operacion);
        btn.setForeground(Color.ORANGE);

        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                operacionPulsado(btn.getText());
            }
        });

        panelOperaciones.add(btn);
    }

    /**
     * Gestiona las pulsaciones de teclas numéricas
     *
     *
     */
    private void numeroPulsado(String digito) {
        if (pantalla.getText().equals("0") || nuevaOperacion) {
            pantalla.setText(digito);
        } else {
            pantalla.setText(pantalla.getText() + digito);
        }
        nuevaOperacion = false;
    }

    /**
     * Gestiona el gestiona las pulsaciones de teclas de operación
     *
     *
     */
    private void operacionPulsado(String tecla) {
        if (tecla.equals("=")) {
            calcularResultado();
        } else if (tecla.equals("CE")) {
            resultado = 0;
            pantalla.setText("");
            nuevaOperacion = true;
        } else {
            operacion = tecla;
            if ((resultado > 0) && !nuevaOperacion) {
                calcularResultado();
            } else {
                resultado = new Double(pantalla.getText());
            }
        }

        nuevaOperacion = true;
    }

    /**
     * Calcula el resultado y lo muestra por pantalla
     */
    private void calcularResultado() {
        Double i = new Double(pantalla.getText());
        /**
         * Operaciones que realiza la calculadora
         */
        if (operacion.equals("+")) { // suma
            resultado += new Double(pantalla.getText());
        } else if (operacion.equals("-")) { // resta
            resultado -= new Double(pantalla.getText());
        } else if (operacion.equals("/")) { // division
            resultado /= new Double(pantalla.getText());
        } else if (operacion.equals("*")) { // multiplicacion
            resultado *= new Double(pantalla.getText());
        } else if (operacion.equals("√")) { // raiz cuadrada
            resultado = Math.sqrt(i);

        } else if (operacion.equals("^2")) { // elevado a la 2
            resultado = (int) Math.pow(i, 2);
        } else if (operacion.equals("^x")) { // elevado a la x
            resultado = (int) Math.pow(resultado, i);
        }
        pantalla.setText("" + resultado);
        operacion = "";
    }
}