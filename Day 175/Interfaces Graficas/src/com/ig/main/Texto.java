package com.ig.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Texto extends JFrame implements ActionListener {

	
	private JTextField textfield1;
	private JLabel label1;
	private JButton button1;
	
	public Texto() {
		setLayout(null);
		//Etiqueta
		label1 = new JLabel("Usuario:");
		label1.setBounds(10, 10, 100, 30);
		add(label1);
		//Linea de texto
		textfield1 = new JTextField();
		textfield1.setBounds(120,17,150,20);
		add(textfield1);
		//Boton
		button1 = new JButton("Ingresar");
		button1.setBounds(10, 80, 100, 30);
		add(button1);
		button1.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			//Obtener el texto del field
			String t = textfield1.getText();
			//Funcion para cambiar el texto
			setTitle(t);
		}
	}
	
	
	public static void main(String[] args) {
		Texto formulario = new Texto();
		formulario.setResizable(false);
		formulario.setLocationRelativeTo(null);
		formulario.setBounds(0,0, 300, 200);
		formulario.setVisible(true);
	}

	



}
