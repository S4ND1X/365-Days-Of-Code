import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Bienvenida extends JFrame implements ActionListener {

	
	private JTextField text1;
	private JLabel label1, label2, label3, label4;
	private JButton button1;
	
	public Bienvenida() {
		setLayout(null);
		
		this.setTitle("Bienvenido");
		//Cambiar el fondo a color rojo
		this.getContentPane().setBackground(new Color(255, 0, 0));
		//Poner imagen de icono, obtiene la ruta, la carga y se pone en la clase indicada
		this.setIconImage(new ImageIcon(getClass().getResource("../images/icon.png")).getImage());
		
		ImageIcon imagen = new ImageIcon("../images/logo-coca.png");
		
		//Label 1
		this.label1 = new JLabel(imagen);
		this.label1.setBounds(25, 15, 300, 150);
		add(this.label1);
		
		//Label 2
		this.label2 = new JLabel("Sistema De Control Vacacional");
		this.label2.setBounds(35, 135, 300, 30);
		//Cambiar fuente y tamaño
		this.label2.setFont(new Font("Andale Mono", 3, 18));
		//Cambiar color de letra
		this.label2.setForeground(new Color(255, 255, 255));
		add(this.label2);
		//Label 3
		this.label3 = new JLabel("Ingrese su nombre:");
		this.label3.setBounds(45, 212, 300, 30);
		this.label3.setFont(new Font("Andale Mono", 1, 12));
		this.label3.setForeground(new Color(255, 255, 255));
		add(this.label3);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
