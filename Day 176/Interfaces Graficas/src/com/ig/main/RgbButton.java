
package com.ig.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RgbButton extends JFrame implements ActionListener {

	
	private JLabel label1, label2, label3;
	private JComboBox lista1, lista2, lista3;
	private JButton button1;
	
	public RgbButton() {
		setLayout(null);
		//Label 1
		this.label1 = new JLabel("Rojo:");
		this.label1.setBounds(10, 10, 100, 10);
		add(this.label1);
		//Lista 1
		this.lista1 = new JComboBox();
		this.lista1.setBounds(120, 10, 50, 30);
		for(int i = 0; i <= 255; i++) this.lista1.addItem(String.valueOf(i));
		add(this.lista1);
		//Label 2
		this.label2 = new JLabel("Verde:");
		this.label2.setBounds(10, 50, 100, 10);
		add(this.label2);
		//Lista 2
		this.lista2 = new JComboBox();
		this.lista2.setBounds(120, 50, 50, 30);
		for(int i = 0; i <= 255; i++) this.lista2.addItem(String.valueOf(i));
		add(this.lista2);
		//Label 3
		this.label3 = new JLabel("Azul:");
		this.label3.setBounds(10, 90, 100, 10);
		add(this.label3);
		//Lista 3
		this.lista3 = new JComboBox();
		this.lista3.setBounds(120, 90, 50, 30);
		for(int i = 0; i <= 255; i++) this.lista3.addItem(String.valueOf(i));
		add(this.lista3);
		
		//Boton 1
		
		this.button1 = new JButton("Generar");
		this.button1.setBounds(10, 130, 100, 30);
		add(this.button1);
		this.button1.addActionListener(this);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.button1) {
			int rojo = Integer.parseInt(this.lista1.getSelectedItem().toString());
			int verde = Integer.parseInt(this.lista2.getSelectedItem().toString());
			int azul = Integer.parseInt(this.lista3.getSelectedItem().toString());
			//Crear nuevo color y establecer el color			
			this.button1.setBackground(new Color(rojo, verde, azul));
		}
		
	}
	

	public static void main(String[] args) {
		RgbButton formulario = new RgbButton();
		formulario.setBounds(0, 0, 190, 200);
		formulario.setVisible(true);
		formulario.setResizable(false);
		formulario.setLocationRelativeTo(null);
		
	}


}
