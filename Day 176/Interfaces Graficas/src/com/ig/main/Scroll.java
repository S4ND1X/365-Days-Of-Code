package com.ig.main;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Scroll extends JFrame {
	
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	public Scroll() {
		setLayout(null);
		//Linea de texto
		this.textField = new JTextField();
		this.textField.setBounds(10, 10, 200, 30);
		add(this.textField);
		
		//Scroll
		//Se crea el area de texto y esta se adapta al diseño del pane
		this.textArea = new JTextArea();
		this.scrollPane = new JScrollPane(this.textArea);
		this.scrollPane.setBounds(10, 50, 400, 300);
		add(this.scrollPane);
		
		
	}
	

	public static void main(String[] args) {
		Scroll formulario = new Scroll();
		formulario.setBounds(0, 0, 540, 400);
		formulario.setResizable(false);
		formulario.setLocationRelativeTo(null);
		formulario.setVisible(true);

	}

}
