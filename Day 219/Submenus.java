package com.ig.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Submenus extends JFrame implements ActionListener {
	
	
	private JMenuBar menuBar;
	private JMenu opciones1, opciones2, opciones3;
	private JMenuItem menuItem, menuItem1, menuItem2, menuItem3;
	
	
	public Submenus() {
		setLayout(null);
		//Crear MenuBar
		this.menuBar = new JMenuBar();
		//Poner la barra
		setJMenuBar(this.menuBar);
		
		this.opciones1 = new JMenu("Opciones");
		this.menuBar.add(this.opciones1);
		//Añadir Submenu a menu
		this.opciones2 = new JMenu("Tamaño de Ventana");
		this.opciones1.add(this.opciones2);
		
		this.opciones3 = new JMenu("Color de fondo");
		this.opciones1.add(this.opciones3);
		
		//Opcion del submenu 1
		this.menuItem = new JMenuItem("300 x 200");
		this.opciones2.add(this.menuItem);
		this.menuItem.addActionListener(this);
		
		//Opcion del submenu 1
		this.menuItem1 = new JMenuItem("640 x 480");
		this.opciones2.add(this.menuItem1);
		this.menuItem1.addActionListener(this);
		
		//Opciones del submenu 2
		this.menuItem2 = new JMenuItem("Rojo");
		this.opciones3.add(this.menuItem2);
		this.menuItem2.addActionListener(this);
		
		this.menuItem3 = new JMenuItem("Verde");
		this.opciones3.add(this.menuItem3);
		this.menuItem3.addActionListener(this);		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menuItem)	this.setSize(300, 200);
		if(e.getSource() == menuItem1)	this.setSize(640, 480);
		if(e.getSource() == menuItem2) this.getContentPane().setBackground(new Color(255, 0, 0));
		if(e.getSource() == menuItem3)	this.getContentPane().setBackground(new Color(0, 255, 0));
	}

	public static void main(String[] args) {
		Submenus formulario = new Submenus();
		formulario.setBounds(0, 0, 300, 200);
		formulario.setLocationRelativeTo(null);
		formulario.setResizable(false);
		formulario.setVisible(true);
	}

}
