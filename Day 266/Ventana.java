import javax.swing.*;
import java.awt.event.*;
public class Ventana extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;
    private JLabel titulo;
    private JTextField textX1,textY1,
                            textX2,textY2,
                            textX3,textY3;
    private JButton submitDatos;

    public Ventana(){
        setLayout(null);

        // ------------ Titulo ----------------
        this.titulo = new JLabel("Area de un triangulo...");
        this.titulo.setBounds(500,100,300, 30);
        add(this.titulo);
        // ------------ Boton X1 --------------
        this.textX1 = new JTextField("Ingresa: X1");
        this.textX1.setBounds(350, 400, 100, 30);
        add(this.textX1);
        // ------------ Boton Y1 --------------
        this.textY1 = new JTextField("Ingresa: Y1");
        this.textY1.setBounds(500, 400, 100, 30);
        add(this.textY1);

        // ------------ Boton X2 --------------
        this.textX2 = new JTextField("Ingresa: X2");
        this.textX2.setBounds(350, 450, 100, 30);
        add(this.textX2);
        // ------------ Boton X2 --------------
        this.textY2 = new JTextField("Ingresa: Y2");
        this.textY2.setBounds(500, 450, 100, 30);
        add(this.textY2);

        // ------------ Boton X3 --------------
        this.textX3 = new JTextField("Ingresa: X3");
        this.textX3.setBounds(350, 500, 100, 30);
        add(this.textX3);
        // ------------ Boton X3 --------------
        this.textY3 = new JTextField("Ingresa: Y3");
        this.textY3.setBounds(500, 500, 100, 30);
        add(this.textY3);


        // ------------ Boton Enviar -----------
        this.submitDatos = new JButton("Calcular");
        this.submitDatos.setBounds(500, 600, 100, 30);
        add(this.submitDatos);
        this.submitDatos.addActionListener(this);

    }

        public void actionPerformed(ActionEvent e){
            if(e.getSource() == this.submitDatos){
            int x1 = 0, x2 = 0, x3 = 0, y1 = 0, y2 = 0, y3 = 0;
                    x1 = Integer.parseInt(this.textX1.getText());
                    y1 = Integer.parseInt(this.textY1.getText());
                    x2 = Integer.parseInt(this.textX2.getText());
                    y2 = Integer.parseInt(this.textY2.getText());
                    x3 = Integer.parseInt(this.textX3.getText());
                    y3 = Integer.parseInt(this.textX3.getText());

                Triangulo triangulo = new Triangulo(x1,y1,x2,y2,x3,y3);
                this.titulo.setText("El area es de : " + Double.toString(triangulo.calcularArea()));
            }
        }

    public static void main(String[] args) {
        Ventana ventanaPrincipal = new Ventana();
        ventanaPrincipal.setBounds(0, 0, 1080, 720);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setLocationRelativeTo(null);

    }


}