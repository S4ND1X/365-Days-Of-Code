package com.coca.app;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Bienvenida extends JFrame implements ActionListener {

	
	private JTextField text1;
	private JLabel label1, label2, label3, label4;
	private JButton button1;
	public static String nombre = "";
	
	public Bienvenida() {
		setLayout(null);
		
		this.setTitle("Bienvenido");
		//Cambiar el fondo a color rojo
		this.getContentPane().setBackground(new Color(255, 0, 0));
		//Poner imagen de icono, obtiene la ruta, la carga y se pone en la clase indicada
		setIconImage(new ImageIcon(getClass().getResource("./icon.png")).getImage());
		
		//Label 1
		this.label1 = new JLabel();
		this.label1.setIcon(new ImageIcon(getClass().getResource("./logo-coca.png")));
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
		this.label3.setBounds(45, 212, 200, 30);
		this.label3.setFont(new Font("Andale Mono", 1, 12));
		this.label3.setForeground(new Color(255, 255, 255));
		add(this.label3);
		
		//Label 4
		this.label4 = new JLabel("©2017 The Coca-Cola Company ");
		this.label4.setBounds(85, 375, 300, 30);
		this.label4.setFont(new Font("Andale Mono", 1, 12));
		this.label4.setForeground(new Color(255, 255, 255));
		add(this.label4);
		
		//Linea de texto
		this.text1 = new JTextField();
		this.text1.setBounds(45, 240, 255, 25);
		this.text1.setBackground(new Color(224, 224, 224));
		this.text1.setFont(new Font("Andale Mono", 1, 14));
		this.text1.setForeground(new Color(255, 0, 0));
		add(this.text1);
		
		//Boton
		this.button1 = new JButton("Ingresar");
		this.button1.setBounds(125, 280, 100, 30);
		this.button1.setBackground(new Color(255, 255, 255));
		this.button1.setFont(new Font("Andale Mono", 1, 14));
		this.button1.setForeground(new Color(255, 0, 0));
		this.button1.addActionListener(this);
		add(this.button1);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.button1)) {
			nombre = this.text1.getText().trim();
			if(nombre.equals("")) {
				JOptionPane.showMessageDialog(null, "Ingresa un nombre.");
			}
			else {
				Licencia ventanalicencia = new Licencia();
				ventanalicencia.setBounds(0, 0, 600, 360);
				ventanalicencia.setVisible(true);
				ventanalicencia.setLocationRelativeTo(null);
				ventanalicencia.setResizable(false);
				this.setVisible(false);
		}
	}		
}
	
	public static void main(String args[]) {
		Bienvenida ventanaBienvenida = new Bienvenida();
		ventanaBienvenida.setBounds(0, 0, 350, 450);
		ventanaBienvenida.setLocationRelativeTo(null);
		ventanaBienvenida.setResizable(false);
		ventanaBienvenida.setVisible(true);
	}
	
}
