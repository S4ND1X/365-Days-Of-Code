package com.ig.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Button extends JFrame implements ActionListener {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -32147717356895274L;
	private JButton button1;
	
	public Button() {
		//Creando el boton, con su mensaje, coordenadas y agregando el ActionListener
		setLayout(null);
		this.button1 = new JButton("Boton1");
		this.button1.setBounds(300, 250, 100, 30);
		add(this.button1);
		this.button1.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		//Evento si es igual al boton
		if(e.getSource() == this.button1)System.exit(1);
	}
	

	public static void main(String[] args) {
		//Creando frame
		Button formulario = new Button();
		formulario.setBounds(0,0, 720, 420);
		formulario.setLocationRelativeTo(null);
		formulario.setResizable(false);
		formulario.setVisible(true);
		
	}

}
