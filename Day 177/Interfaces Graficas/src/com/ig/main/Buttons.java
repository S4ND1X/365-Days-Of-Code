package com.ig.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Buttons extends JFrame implements ActionListener {
	
	private JButton button1, button2, button3;
	private JLabel label;
	
	public Buttons() {
		//Poder usar coordenadas
		setLayout(null);
		//Boton 1
		this.button1 = new JButton("Boton 1");
		this.button1.setBounds(10, 100, 90, 30);
		add(this.button1);
		button1.addActionListener(this);
		//Boton 2
		this.button2 = new JButton("Boton 2");
		this.button2.setBounds(110, 100, 90, 30);
		add(this.button2);
		button2.addActionListener(this);
		//Boton 3
		this.button3 = new JButton("Boton 3");
		this.button3.setBounds(210, 100, 90, 30);
		add(this.button3);
		button3.addActionListener(this);
		
		//Creando etiquet
		this.label = new JLabel("Esperando");
		this.label.setBounds(10, 10, 300, 30);
		add(label);
		
	}
	
	public void actionPerformed (ActionEvent e) {
		//Obteniendo el evento
		if(e.getSource() == this.button1)this.label.setText("Has presionado el boton 1");
		if(e.getSource() == this.button2)this.label.setText("Has presionado el boton 2");
		if(e.getSource() == this.button3)this.label.setText("Has presionado el boton 3");
	}
	
	public static void main(String[] args) {
		//Creando JFrame
		Buttons formulario = new Buttons();
		formulario.setResizable(false);
		formulario.setLocationRelativeTo(null);
		formulario.setBounds(0,0, 1080, 720);
		formulario.setVisible(true);
	}


}
