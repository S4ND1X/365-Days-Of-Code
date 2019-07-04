package com.ig.main;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CheckBox extends JFrame implements ChangeListener {

	
	private JCheckBox opcion1, opcion2, opcion3;
	
	public CheckBox() {
		setLayout(null);
		this.opcion1 = new JCheckBox("Inglés");
		this.opcion1.setBounds(10, 10, 200 , 30);
		this.opcion1.addChangeListener(this);
		add(this.opcion1);
		
		this.opcion2 = new JCheckBox("Pito");
		this.opcion2.setBounds(10, 60, 200 , 30);
		this.opcion2.addChangeListener(this);
		add(this.opcion2);

		this.opcion3 = new JCheckBox("Francés");
		this.opcion3.setBounds(10, 110, 200 , 30);
		this.opcion3.addChangeListener(this);
		add(this.opcion3);	
	}
	
	
	public void stateChanged(ChangeEvent e) {
		String wea = "";
		if(this.opcion1.isSelected())wea += "Inglés-";
		if(this.opcion2.isSelected())wea += "Pito-";
		if(this.opcion2.isSelected())wea += "Francés-";
		this.setTitle(wea);
		
	}
	
	
	public static void main(String[] args) {
		CheckBox formulario = new CheckBox();
		formulario.setBounds(0, 0, 300, 200);
		formulario.setLocationRelativeTo(null);
		formulario.setResizable(false);
		formulario.setVisible(true);
		

	}


}
