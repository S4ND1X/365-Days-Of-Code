package com.coca.app;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Principal extends JFrame implements ActionListener {

	private JMenuBar mb;
	private JMenu menuOpciones, menuCalcular, menuAcercaDe, menuColorFondo;
	private JMenuItem miCalculo, miRojo, miNegro, miMorado, miElCreador, miSalir, miNuevo;
	private JLabel labellogo, labelBienvenida, labelTitle, labelNombre, labelAPaterno, labelAMaterno,
					labelDepartamento, labelAntiguedad, labelResultado, labelfooter;
	private JTextField txtNombreTrabajador, txtAPaternoTrabajador, txtAMaternoTrabajador;
	private JComboBox comboDepartamento, comboAntiguedad;
	private JScrollPane scrollpane1;
	private JTextArea textarea1;
	String nombreAdministrador = "";
	
	public Principal() {
		Font font = new Font("Andale Mono", 1, 14);
		Color blanco = new Color(255, 255, 255);
		Color rojo = new Color(255, 0, 0);
		setLayout(null);
		//Ventana Principal
		setTitle("Pantalla Principal");
		getContentPane().setBackground(new Color(255, 0, 0));
		setIconImage(new ImageIcon(getClass().getResource("./icon.png")).getImage());
		
		Licencia ventanaLicencia = new Licencia();
		this.nombreAdministrador = ventanaLicencia.nombre;
		
		//Barra de menu
		this.mb = new JMenuBar();
		this.mb.setBackground(new Color(255, 0, 0));
		setJMenuBar(mb);
		//Menu Opciones
		this.menuOpciones = new JMenu("Opciones");
		this.menuOpciones.setBackground(blanco);
		this.menuOpciones.setFont(font);
		this.menuOpciones.setForeground(blanco);
		this.mb.add(this.menuOpciones);
		//Menu Calcular
		this.menuCalcular = new JMenu("Calcular");
		this.menuCalcular.setBackground(blanco);
		this.menuCalcular.setFont(font);
		this.menuCalcular.setForeground(blanco);
		this.mb.add(this.menuCalcular);
		//Menu Acerca De
		this.menuAcercaDe = new JMenu("Acerca De");
		this.menuAcercaDe.setBackground(blanco);
		this.menuAcercaDe.setFont(font);
		this.menuAcercaDe.setForeground(blanco);
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
		this.labellogo = new JLabel();
		this.labellogo.setIcon(new ImageIcon(getClass().getResource("./logo-coca.png")));
		this.labellogo.setBounds(5, 5, 250, 100);
		add(this.labellogo);
		
		//Bienvenida
		this.labelBienvenida = new JLabel("Bienvenido " + this.nombreAdministrador);
		this.labelBienvenida.setBounds(280, 30, 300, 50);
		this.labelBienvenida.setFont(new Font("Andale Mono", 1, 32));
		this.labelBienvenida.setForeground(blanco);
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
		this.labelNombre.setForeground(blanco);
		add(this.labelNombre);
		
		/* Linea de texto */
		//Nombre
		this.txtNombreTrabajador = new JTextField();
		this.txtNombreTrabajador.setBounds(25, 213, 150, 25);
		this.txtNombreTrabajador.setBackground(new Color(224, 224, 224));
		this.txtNombreTrabajador.setFont(font);
		this.txtNombreTrabajador.setForeground(rojo);
		add(this.txtNombreTrabajador);
		
		
		this.labelAPaterno = new JLabel("Apellido Paterno:");
		this.labelAPaterno.setBounds(25,248,180,25);
		this.labelAPaterno.setFont(new Font("Andale Mono", 1, 12));
		this.labelAPaterno.setForeground(new Color(255, 255, 255));
		add(this.labelAPaterno);
	
		this.txtAPaternoTrabajador = new JTextField();
		this.txtAPaternoTrabajador.setBounds(25,273,150,25);
		this.txtAPaternoTrabajador.setBackground(new Color(224, 224, 224));
		this.txtAPaternoTrabajador.setFont(font);
		this.txtAPaternoTrabajador.setForeground(rojo);
	     add(this.txtAPaternoTrabajador);
	
	     this.labelAMaterno = new JLabel("Apellido Materno:");
	     this.labelAMaterno.setBounds(25,308,180,25);
	     this.labelAMaterno.setFont(new Font("Andale Mono", 1, 12));
	     this.labelAMaterno.setForeground(blanco);
	      add(this.labelAMaterno);
	
	      this.txtAMaternoTrabajador = new JTextField();
	      this.txtAMaternoTrabajador.setBounds(25,334,150,25);
	      this.txtAMaternoTrabajador.setBackground(new Color(224, 224, 224));
	      this.txtAMaternoTrabajador.setFont(font);
	      this.txtAMaternoTrabajador.setForeground(rojo);
	      add(txtAMaternoTrabajador);
	
	      this.labelDepartamento = new JLabel("Selecciona el Departamento:");
	      this.labelDepartamento.setBounds(220,188,180,25);
	      this.labelDepartamento.setFont(new Font("Andale Mono", 1, 12));
	      this.labelDepartamento.setForeground(blanco);
	      add(this.labelDepartamento);
	
	      this.comboDepartamento = new JComboBox();
	      this.comboDepartamento.setBounds(220,213,220,25);
	      this.comboDepartamento.setBackground(new java.awt.Color(224, 224, 224));
	      this.comboDepartamento.setFont(font);
	      this.comboDepartamento.setForeground(rojo);
	      add(this.comboDepartamento);
	      this.comboDepartamento.addItem("");
	      this.comboDepartamento.addItem("Atención al Cliente");
	      this.comboDepartamento.addItem("Departamento de Logística");
	      this.comboDepartamento.addItem("Departamento de Gerencia");
	
	      this.labelAntiguedad = new JLabel("Selecciona la Antigüedad:");
	      this.labelAntiguedad.setBounds(220,248,180,25);
	      this.labelAntiguedad.setFont(new Font("Andale Mono", 1, 12));
	      this.labelAntiguedad.setForeground(blanco);
	      add(this.labelAntiguedad);
	
	      this.comboAntiguedad = new JComboBox();
	      this.comboAntiguedad.setBounds(220,273,220,25);
	      this.comboAntiguedad.setBackground(new java.awt.Color(224, 224, 224));
	      this.comboAntiguedad.setFont(font);
	      this.comboAntiguedad.setForeground(rojo);
	      this.add(comboAntiguedad);
	      this.comboAntiguedad.addItem("");
	      this.comboAntiguedad.addItem("1 año de servicio");
	      this.comboAntiguedad.addItem("2 a 6 años de servicio");
	      this.comboAntiguedad.addItem("7 años o más de servicio");
	
	      this.labelResultado = new JLabel("Resultado del Cálculo:");
	      this.labelResultado.setBounds(220,307,180,25);
	      this.labelResultado.setFont(new Font("Andale Mono", 1, 12));
	      this.labelResultado.setForeground(blanco);
	      add(this.labelResultado);
	
	      this.textarea1 = new JTextArea();
	      this.textarea1.setEditable(false);
	      this.textarea1.setBackground(new Color(224, 224, 224));
	      this.textarea1.setFont(new Font("Andale Mono", 1, 11));
	      this.textarea1.setForeground(rojo);
	      this.textarea1.setText("\n   Aquí aparece el resultado del cálculo de las vacaciones.");
	      this.scrollpane1 = new JScrollPane(this.textarea1);
	      this.scrollpane1.setBounds(220,333,385,90);
	      add(this.scrollpane1); 
	
	      this.labelfooter = new JLabel("©2017 The Coca-Cola Company | Todos los derechos reservados");
	      this.labelfooter.setBounds(135,445,500,30);
	      this.labelfooter.setFont(new Font("Andale Mono", 1, 12));
	      this.labelfooter.setForeground(blanco);
	      add(this.labelfooter);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == miCalculo) {
   	        String nombreTrabajador = txtNombreTrabajador.getText();
   	        String AP = txtAPaternoTrabajador.getText();
   	        String AM = txtAMaternoTrabajador.getText();
   	        String Departamento = comboDepartamento.getSelectedItem().toString();
   	        String Antiguedad = comboAntiguedad.getSelectedItem().toString();
   	        
   	        if(	nombreTrabajador.equals("") || AP.equals("") || AM.equals("") || Departamento.equals("") || Antiguedad .equals("")) {
   	        	JOptionPane.showMessageDialog(null, "Llene todos  los campos.");
   	        }else {

	            if(Departamento.equals("Atención al Cliente")){
	
	                            if(Antiguedad.equals("1 año de servicio")){
					this.textarea1.setText("\n   El trabajador " + nombreTrabajador + " " + AP + " " + AM + 
	                                                      "\n   quien labora en " + Departamento + " con " + Antiguedad + 
	                                                      "\n   recibe 6 d�as de vacaciones.");
				}
				if(Antiguedad.equals("2 a 6 años de servicio")){
					this.textarea1.setText("\n   El trabajador " + nombreTrabajador + " " + AP + " " + AM + 
	                                                      "\n   quien labora en " + Departamento + " con " + Antiguedad + 
	                                                      "\n   recibe 14 días de vacaciones.");
				}
				if(Antiguedad.equals("7 años o más de servicio")){
					this.textarea1.setText("\n   El trabajador " + nombreTrabajador + " " + AP + " " + AM + 
	                                                      "\n   quien labora en " + Departamento + " con " + Antiguedad + 
	                                                      "\n   recibe 20 días de vacaciones.");
				}
	                 
	            }
	        if(Departamento.equals("Departamento de Logística")){
	
				if(Antiguedad.equals("1 a�o de servicio")){
					this.textarea1.setText("\n   El trabajador " + nombreTrabajador + " " + AP + " " + AM + 
	                                                      "\n   quien labora en " + Departamento + " con " + Antiguedad + 
	                                                      "\n   recibe 7 d�as de vacaciones.");
				}
				if(Antiguedad.equals("2 a 6 a�os de servicio")){
					this.textarea1.setText("\n   El trabajador " + nombreTrabajador + " " + AP + " " + AM + 
	                                                      "\n   quien labora en " + Departamento + " con " + Antiguedad + 
	                                                      "\n   recibe 15 días de vacaciones.");
				}
				if(Antiguedad.equals("7 a�os o m�s de servicio")){
					this.textarea1.setText("\n   El trabajador " + nombreTrabajador + " " + AP + " " + AM + 
	                                                      "\n   quien labora en " + Departamento + " con " + Antiguedad + 
	                                                      "\n   recibe 22 días de vacaciones.");
				}
	    	}
	    	if(Departamento.equals("Departamento de Gerencia")){
	
				if(Antiguedad.equals("1 a�o de servicio")){
					this.textarea1.setText("\n   El trabajador " + nombreTrabajador + " " + AP + " " + AM + 
	                                                      "\n   quien labora en " + Departamento + " con " + Antiguedad + 
	                                                      "\n   recibe 10 d�as de vacaciones.");
				}
				if(Antiguedad.equals("2 a 6 a�os de servicio")){
					this.textarea1.setText("\n   El trabajador " + nombreTrabajador + " " + AP + " " + AM + 
	                                                      "\n   quien labora en " + Departamento + " con " + Antiguedad + 
	                                                      "\n   recibe 20 d�as de vacaciones.");
				}
				if(Antiguedad.equals("7 a�os o m�s de servicio")){
					this.textarea1.setText("\n   El trabajador " + nombreTrabajador + " " + AP + " " + AM + 
	                                                      "\n   quien labora en " + Departamento + " con " + Antiguedad + 
	                                                      "\n   recibe 30 d�as de vacaciones.");
				}
    		}
        }
  }
        if (e.getSource() == miRojo){
        	this.getContentPane().setBackground(new Color(255, 0, 0));
        }
        if (e.getSource() == miNegro){
        	this.getContentPane().setBackground(new Color(0, 0, 0));
        }
        if (e.getSource() == miMorado){
		this.getContentPane().setBackground(new Color(180, 0, 255));
        }
        if (e.getSource() == miNuevo){	
        	this.txtNombreTrabajador.setText("");
    	    this.txtAPaternoTrabajador.setText("");
    	    this.txtAMaternoTrabajador.setText("");
            this.comboDepartamento.setSelectedIndex(0);
    	    this.comboAntiguedad.setSelectedIndex(0);
    	    this.textarea1.setText("\n   Aqu� aparece el resultado del c�lculo de las vacaciones.");	 
        }
	if (e.getSource() == miSalir){
   	    Bienvenida ventanabienvenida = new Bienvenida();
        ventanabienvenida.setBounds(0,0,350,450);
        ventanabienvenida.setVisible(true);
        ventanabienvenida.setResizable(false);
        ventanabienvenida.setLocationRelativeTo(null);
        this.setVisible(false);
	}
        if (e.getSource() == miElCreador){
            JOptionPane.showMessageDialog(null,"Desarrollado por La Geekipedia de Ernesto\n"+
                    "       www.youtube.com/ErnestoPerezM");
        }
  }

    public static void main(String args[]) {
        Principal ventanaPrincipal = new Principal();
        ventanaPrincipal.setBounds(0,0,640,535);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setLocationRelativeTo(null);
	}

}
