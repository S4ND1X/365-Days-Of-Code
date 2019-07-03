package com.ig.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TerminosYCondiciones extends JFrame implements ActionListener, ChangeListener {

	private JLabel label1;
	private JCheckBox checkBox;
	private JButton button1;
	
	public TerminosYCondiciones() {
		setLayout(null);
		//Mensaje terminos y condiciones
		this.label1 = new JLabel("Aceptar terminos y condiciones");
		this.label1.setBounds(10, 10, 400, 30);
		add(this.label1);
		
		//Checkbox
		this.checkBox = new JCheckBox("Aceptar");
		this.checkBox.setBounds(10, 50, 100, 30);
		this.checkBox.addChangeListener(this);
		add(this.checkBox);
		
		//Boton
		this.button1 = new JButton("Continuar");
		this.button1.setBounds(10, 100, 100, 30);
		add(this.button1);
		this.button1.addActionListener(this);
		this.button1.setEnabled(false);		
	}
	
	public void stateChanged(ChangeEvent e) {
		if(this.checkBox.isSelected())this.button1.setEnabled(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.button1))System.exit(0);
	}
	
	public static void main(String args[]) {
		TerminosYCondiciones formulario = new TerminosYCondiciones();
		formulario.setBounds(0, 0, 350, 200);
		formulario.setLocationRelativeTo(null);
		formulario.setResizable(true);
		formulario.setVisible(true);
	}
	
	
	
}
