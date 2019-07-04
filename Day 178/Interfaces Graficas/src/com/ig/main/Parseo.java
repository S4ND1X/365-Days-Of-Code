package com.ig.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Parseo extends JFrame implements ActionListener{

	private JButton button1;
	private JLabel label1, label2, label3;
	private JTextField textField1, textField2;
	
	public Parseo() {
		setLayout(null);
		//Label 1
		this.label1 = new JLabel("Valor 1:");
		this.label1.setBounds(50, 5, 100, 30);
		add(this.label1);
		//Label 2
		this.label2 = new JLabel("Valor 2:");
		this.label2.setBounds(50, 35, 100, 30);
		add(this.label2);
		//Label 3
		this.label3 = new JLabel("Resultado:");
		this.label3.setBounds(120, 80, 100, 30);
		add(this.label3);
		
		//Linea de texto uno
		this.textField1 = new JTextField();
		this.textField1.setBounds(120, 10, 150, 20);
		add(this.textField1);
		//Linea de texto dos
		this.textField2 = new JTextField();
		this.textField2.setBounds(120, 40, 150, 20);
		add(this.textField2);
		
		//Boton
		this.button1 = new JButton("Sumar");
		this.button1.setBounds(10, 80, 100, 30);
		add(this.button1);
		this.button1.addActionListener(this);
			
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.button1) {
			int val1 = 0, val2 = 0, res = 0;
			//Parsear
			val1 = Integer.parseInt(this.textField1.getText());
			val2 = Integer.parseInt(this.textField2.getText());
			res = val1 + val2;
			
			this.label3.setText("El resultado: " + res);
		}
	}
	
	public static void main(String args[]) {
		
		Parseo formulario = new Parseo();
		formulario.setResizable(false);
		formulario.setLocationRelativeTo(null);
		formulario.setBounds(0, 0, 300, 150);
		formulario.setVisible(true);
		
	}
	
}
