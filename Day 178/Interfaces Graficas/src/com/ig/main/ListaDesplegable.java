package com.ig.main;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ListaDesplegable extends JFrame implements ItemListener{
	
	private JComboBox lista;
	
	public ListaDesplegable() {
		setLayout(null);
		//Inicializacion 
		this.lista = new JComboBox();
		this.lista.setBounds(10, 10, 80, 20);
		add(this.lista);
		
		//Elementos lista
		this.lista.addItem("Azul");
		this.lista.addItem("Verde");
		this.lista.addItem("Amarillo");
		this.lista.addItem("Negro");
		//Agregar el Listener
		this.lista.addItemListener(this);
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == lista) {
			//Obtener elemento elegido como string
			String selection = lista.getSelectedItem().toString();
			this.setTitle(selection);
		}
	}
	
	public static void main(String args[]) {
		ListaDesplegable formulario = new ListaDesplegable();
		formulario.setLocationRelativeTo(null);
		formulario.setResizable(false);
		formulario.setBounds(0, 0, 300, 150);
		formulario.setVisible(true);
		
	}
}
