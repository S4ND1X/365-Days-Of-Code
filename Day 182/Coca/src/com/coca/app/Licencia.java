package com.coca.app;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Licencia extends JFrame  implements ActionListener, ChangeListener {

	private JLabel label1, label2;
	private JCheckBox check1;
	private JButton button1, button2;
	private JScrollPane scrollpane1;
	private JTextArea textarea1;
	String nombre = "";
	public Licencia() {
		setLayout(null);
		//Poner titulo e icono de interfaz
		setTitle("Licencia de uso");
		setIconImage(new ImageIcon(getClass().getResource("./icon.png")).getImage());
		Bienvenida ventanaBienvenida = new Bienvenida();
		this.nombre = ventanaBienvenida.nombre;
		
		//Label Terminos y condiciones
		this.label1 = new JLabel("TÉRMINOS Y CONDICIONES");
		this.label1.setBounds(215, 5, 200, 30);
		this.label1.setFont(new Font("Andale Mono", 1, 14));
		this.label1.setForeground(new Color(0, 0, 0));
		add(this.label1);
		
		//Area del contrato
		this.textarea1 = new JTextArea();
		//Hacer que no se pueda editar
		this.textarea1.setEditable(false);
		this.textarea1.setFont(new Font("Andale Mono", 0, 9));	
		this.textarea1.setText("\n\n          TÉRMINOS Y CONDICIONES" +
                "\n\n            A.  PROHIBIDA SU VENTA O DISTRIBUCIÓN SIN AUTORIZACIÓN DE LA GEEKIPEDIA DE ERNESTO." +
                "\n            B.  PROHIBIDA LA ALTERACIÓN DEL CÓDIGO FUENTE O DISEÑO DE LAS INTERFACES GRÁFICAS." +
                "\n            C.  LA GEEKIPEDIA DE ERNESTO NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE." +
                "\n\n          LOS ACUERDOS LEGALES EXPUESTOS ACONTINUACIÓN RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE" +
                "\n          (LA GEEKIPEDIA DE ERNESTO Y EL AUTOR ERNESTO), NO SE RESPONSABILIZAN DEL USO QUE USTED" + 
                "\n          HAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (ACEPTO)" +
                "\n          SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE." + 
                "\n\n          PARA MAYOR INFORMACIÓN SOBRE NUESTROS PRODUCTOS O SERVICIOS, POR FAVOR VISITE" + 
                "\n          http://www.youtube.com/ernestoperezm");
		//Agregar el textarea al Scroll
		this.scrollpane1 = new JScrollPane(this.textarea1);
		this.scrollpane1.setBounds(10, 40, 575, 200);
		add(this.scrollpane1);
		
		//CheckBox
		this.check1 = new JCheckBox("Yo " + this.nombre + " acepto.");
		this.check1.setBounds(10, 250, 300, 30);
		this.check1.addChangeListener(this);
		add(this.check1);
		
		//Boton 1
		this.button1 = new JButton("Continuar");
		this.button1.setBounds(10, 290, 100, 30);
		this.button1.addActionListener(this);
		this.button1.setEnabled(false);
		add(this.button1);
		
		//Boton 2
		this.button2 = new JButton("No Acepto");
		this.button2.setBounds(120, 290, 100, 30);
		this.button2.addActionListener(this);
		this.button2.setEnabled(true);
		add(this.button2);
		
		
		//Label 2
		this.label2 = new JLabel();
		this.label2.setIcon(new ImageIcon(getClass().getResource("./coca-cola.png")));
		this.label2.setBounds(315, 135, 300, 300);
		add(this.label2);
	}
	
	public void stateChanged(ChangeEvent e) {
		if(this.check1.isSelected()) {
			this.button1.setEnabled(true);
			this.button2.setEnabled(false);
		}else {
			this.button2.setEnabled(true);
			this.button1.setEnabled(false);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.button2))System.out.println("Avanzar");
		if(e.getSource().equals(this.button1)) {
	        Principal ventanaPrincipal = new Principal();
	        ventanaPrincipal.setBounds(0,0,640,535);
	        ventanaPrincipal.setVisible(true);
	        ventanaPrincipal.setResizable(false);
	        ventanaPrincipal.setLocationRelativeTo(null);
	        this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		Licencia ventanalicencia =  new Licencia();
		ventanalicencia.setBounds(0, 0, 600, 360);
		ventanalicencia.setVisible(true);
		ventanalicencia.setLocationRelativeTo(null);
		ventanalicencia.setResizable(false);

	}

}
