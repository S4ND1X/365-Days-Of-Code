package com.ig.main;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RadioButton extends JFrame implements ChangeListener{
	
	
	private JRadioButton opcion1, opcion2, opcion3;
	private ButtonGroup bg;
	
	public RadioButton() {
		setLayout(null);
		this.bg = new ButtonGroup();
		
		this.opcion1 = new JRadioButton("640 x 480");
		this.opcion1.setBounds(10, 20, 100, 30);
		this.opcion1.addChangeListener(this);
		add(this.opcion1);
		this.bg.add(this.opcion1);
		
		this.opcion2 = new JRadioButton("800 x 600");
		this.opcion2.setBounds(10, 70, 100, 30);
		this.opcion2.addChangeListener(this);
		add(this.opcion2);
		this.bg.add(this.opcion2);
		
		this.opcion3 = new JRadioButton("1024 x 768");
		this.opcion3.setBounds(10, 120, 100, 30);
		this.opcion3.addChangeListener(this);
		add(this.opcion3);
		this.bg.add(this.opcion3);
	}
	
	
	public void stateChanged(ChangeEvent e) {
		if(this.opcion1.isSelected())this.setSize(640, 480);
		if(this.opcion2.isSelected())this.setSize(800, 600);
		if(this.opcion3.isSelected())this.setSize(1024, 768);
	}
	

	public static void main(String[] args) {
		RadioButton formulario = new RadioButton();
		formulario.setBounds(0, 0, 350, 230);
		formulario.setLocationRelativeTo(null);
		formulario.setResizable(false);
		formulario.setVisible(true);
		

	}

}
