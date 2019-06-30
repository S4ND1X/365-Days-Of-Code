package com.ig.main;

import javax.swing.*;

public class LabelAndFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6120318176597869058L;
	//Creando etiqueta
	private JLabel label1;
	private JLabel label2;
	
	public LabelAndFrame() {
		//Asignando un mensaje y sus coordenadas
		setLayout(null);
		this.label1 = new JLabel("Label 1");
		label1.setBounds(10, 20, 300, 30);
		add(label1);
		this.label2 = new JLabel("Label 2");
		label2.setBounds(10, 100, 100, 30);
		add(label2);
	}
	
	public static void main(String args[]) {
		//Nuevo frame
		LabelAndFrame formulario = new LabelAndFrame();
		//Asignando coordenas y propiedades
		formulario.setBounds(0,0, 300, 200);
		formulario.setResizable(false);
		formulario.setLocationRelativeTo(null);
		formulario.setVisible(true);		
		
	}
	
}