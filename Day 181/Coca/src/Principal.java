import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Principal extends JFrame implements ActionListener {

	private JMenuBar mb;
	private JMenu menuOpciones, menuCalcular, menuAcercaDe, menuColorFondo;
	private JMenuItem miCalculo, miRojo, miNegro, miMorado, miElCreador, miSalir, miNuevo;
	private JLabel labellogo, labelBienvenida, labelTitle, labelNombre, labelAPterno, labelAMaterno,
					labelDepartamento, labelAntiguedad, labelResultado, labelFooter;
	private JTextField txtNombreTrabajador, txtAPaternoTrabajador, txtAMaternoTrabajador;
	private JComboBox comboDepartamento, comboAntiguedad;
	private JScrollPane scrollpane1;
	private JTextArea textarea1;
	
	public Principal() {
		Font font = new Font("Andale Mono", 1, 14);
		Color blanco = new Color(255, 255, 255);
		Color rojo = new Color(255, 0, 0);
		setLayout(null);
		//Ventana Principal
		setTitle("Pantalla Principal");
		getContentPane().setBackground(new Color(255, 0, 0));
		setIconImage(new ImageIcon(getClass().getResource("./icon.png")).getImage());
		//Barra de menu
		this.mb = new JMenuBar();
		this.mb.setBackground(new Color(255, 0, 0));
		setJMenuBar(mb);
		//Menu Opciones
		this.menuOpciones = new JMenu("Opciones");
		this.menuOpciones.setBackground(blanco);
		this.menuOpciones.setFont(font);
		this.menuOpciones.setForeground(rojo);
		this.mb.add(this.menuOpciones);
		//Menu Calcular
		this.menuCalcular = new JMenu("Calcular");
		this.menuCalcular.setBackground(blanco);
		this.menuCalcular.setFont(font);
		this.menuCalcular.setForeground(rojo);
		this.mb.add(this.menuCalcular);
		//Menu Acerca De
		this.menuAcercaDe = new JMenu("Acerca De");
		this.menuAcercaDe.setBackground(blanco);
		this.menuAcercaDe.setFont(font);
		this.menuAcercaDe.setForeground(rojo);
		this.mb.add(this.menuAcercaDe);
		//Menu Color Fondo
		this.menuColorFondo = new JMenu("Color de fondo");
		this.menuColorFondo.setFont(font);
		this.menuColorFondo.setForeground(blanco);
		this.mb.add(this.menuColorFondo);
		
		//Calcular
		this.miCalculo = new JMenuItem("Vacaciones");
		this.miCalculo.setFont(font);
		this.miCalculo.setForeground(blanco);
		this.menuCalcular.add(this.miCalculo);
		this.miCalculo.addActionListener(this);
		
		/* Colores Fondo Item's */
			//Rojo
		this.miRojo = new JMenuItem("Rojo");
		this.miRojo.setFont(font);
		this.miRojo.setForeground(blanco);
		this.menuColorFondo.add(this.miRojo);
		this.miRojo.addActionListener(this);
		
			//Negro
		this.miNegro = new JMenuItem("Negro");
		this.miNegro.setFont(font);
		this.miNegro.setForeground(blanco);
		this.menuColorFondo.add(this.miNegro);
		this.miNegro.addActionListener(this);
			//Morado
		this.miMorado = new JMenuItem("Morado");
		this.miMorado.setFont(font);
		this.miMorado.setForeground(blanco);
		this.menuColorFondo.add(this.miMorado);
		this.miMorado.addActionListener(this);
		
		//Funciones
		this.miNuevo = new JMenuItem("Nuevo");
		this.miNuevo.setFont(font);
		this.miNuevo.setForeground(blanco);
		this.menuOpciones.add(this.miNuevo);
		this.miNuevo.addActionListener(this);
		//Creador
		this.miElCreador = new JMenuItem("El creador");
		this.miElCreador.setFont(font);
		this.miElCreador.setForeground(blanco);
		this.menuOpciones.add(this.miElCreador);
		this.miElCreador.addActionListener(this);
		//Salir
		this.miSalir = new JMenuItem("Salir");
		this.miSalir.setFont(font);
		this.miSalir.setForeground(blanco);
		this.menuOpciones.add(this.miSalir);
		this.miSalir.addActionListener(this);
		
		/* Label's */
		
		//Logo Coca
		ImageIcon imagen = new ImageIcon("./logo-coca.png");
		this.labellogo = new JLabel(imagen);
		this.labellogo.setBounds(5, 5, 250, 100);
		add(this.labellogo);
		
		//Bienvenida
		this.labelBienvenida = new JLabel("Bienvenido");
		this.labelBienvenida.setBounds(280, 30, 300, 50);
		this.labelBienvenida.setFont(new Font("Andale Mono", 1, 32));
		this.labelBienvenida.setForeground(rojo);
		add(this.labelBienvenida);
		
		//Titutlo
		this.labelTitle = new JLabel("Datos del trabajador para cálculo de vacaciones");
		this.labelTitle.setBounds(45, 140, 900, 25);
		this.labelTitle.setFont(new Font("Andale Mono", 0, 24));
		this.labelTitle.setForeground(rojo);
		add(this.labelTitle);
		
		//Nombre
		this.labelNombre = new JLabel("Nombre completo:");
		this.labelNombre.setBounds(25, 188, 180, 25);
		this.labelNombre.setFont(new Font("Andale Mono", 0, 12));
		this.labelNombre.setForeground(rojo);
		add(this.labelNombre);
		
		/* Linea de texto */
		//Nombre
		this.txtNombreTrabajador = new JTextField();
		this.txtNombreTrabajador.setBounds(25, 213, 150, 25);
		this.txtNombreTrabajador.setBackground(new Color(224, 224, 224));
		this.txtNombreTrabajador.setFont(new Font("Andale Mono", 0, 14));
		this.txtNombreTrabajador.setForeground(rojo);
		add(this.txtNombreTrabajador);
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		
	}

}
