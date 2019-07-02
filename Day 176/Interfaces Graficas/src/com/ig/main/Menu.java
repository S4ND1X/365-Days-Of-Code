package com.ig.main;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JFrame implements ActionListener {
	
	//Barra de menu
	private JMenuBar menuBar;
	//Pestañas
	private JMenu menu;
	//Elementos
	private JMenuItem menuItem1, menuItem2,  menuItem3;
	
	public Menu() {
		setLayout(null);
		//Crear Menu
		this.menuBar = new JMenuBar();
		setJMenuBar(this.menuBar);
		
		//Crear Desplegable
		this.menu = new JMenu("Opciones");
		this.menuBar.add(this.menu);
		
		//Crear opciones
		this.menuItem1 = new JMenuItem("Rojo");
		this.menuItem1.addActionListener(this);
		
		this.menu.add(this.menuItem1);
		
		//Crear opciones
		this.menuItem2 = new JMenuItem("Verde");
		this.menuItem2.addActionListener(this);
		
		this.menu.add(this.menuItem2);
		
		//Crear opciones
		this.menuItem3 = new JMenuItem("Azul");
		this.menuItem3.addActionListener(this);
		
		this.menu.add(this.menuItem3);
	}
	
	public void actionPerformed(ActionEvent e) {
		//El fondo se iguala a todo el panel
		Container fondo = this.getContentPane();
		if(e.getSource() == this.menuItem1)fondo.setBackground(new Color(255, 0, 0));
		if(e.getSource() == this.menuItem2)fondo.setBackground(new Color(0, 255, 0));
		if(e.getSource() == this.menuItem3)fondo.setBackground(new Color(0, 0, 255));
		
	}
	
	public static void main(String[] args) {
		
		Menu formulario = new Menu();
		formulario.setBounds(0, 0, 300, 150);
		formulario.setLocationRelativeTo(null);
		formulario.setVisible(true);
	}

}
