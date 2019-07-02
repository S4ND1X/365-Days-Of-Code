package com.ig.main;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AreaTexto extends JFrame {

	private JTextArea textBox;
	private JTextField textLine;
	
	public AreaTexto() {
		setLayout(null);
		//Linea texto
		textLine = new JTextField();
		textLine.setBounds(10, 10, 200, 30);
		add(textLine);
		//Caja de Texto
		textBox = new JTextArea();
		textBox.setBounds(10, 50, 400, 300);
		add(textBox);
	}
	
	
	public static void main(String[] args) {
		
		AreaTexto formulario = new AreaTexto();
		formulario.setLocationRelativeTo(null);
		formulario.setBounds(0, 0, 540, 400 );
		formulario.setResizable(false);
		formulario.setVisible(true);
		

	}

}
