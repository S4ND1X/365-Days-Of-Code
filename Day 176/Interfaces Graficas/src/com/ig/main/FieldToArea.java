package com.ig.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FieldToArea extends JFrame implements ActionListener{
	
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JButton button;
	
	private String text = "";
	
	public FieldToArea() {
		setLayout(null);
		//Linea de texto
		this.textField = new JTextField();
		this.textField.setBounds(10, 10, 200, 30);
		add(this.textField);	
		
		//Area de Texto y scroll
		this.textArea = new JTextArea();
		this.scrollPane = new JScrollPane(textArea);
		this.scrollPane.setBounds(10, 50, 300, 400);
		add(this.scrollPane);
		
		//Boton
		this.button = new JButton("Agregar");
		this.button.setBounds(250,10, 100,30);
		this.button.addActionListener(this);
		add(this.button);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.button) {
			text += textField.getText() + "\n";
			textArea.setText(text);
			textField.setText("");
		}
	}

	public static void main(String[] args) {
		
		FieldToArea formulario = new FieldToArea();
		formulario.setBounds(0, 0, 540, 400);
		formulario.setLocationRelativeTo(null);
		formulario.setResizable(false);
		formulario.setVisible(true);
		

	}

}
