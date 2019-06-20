package com.miko.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8780103315116510763L;
	
	
	public Window(int width, int height, String	title, Game game) {
		JFrame frame = new JFrame(title);
		
		//Recibe un argumento de dimension con anch y altura
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		
		//Parar el thread de Java al usar el boton de cerrar de la esquina
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Usuario puede cambiar la ventana
		frame.setResizable(false);
		//Para que aparezca en medio de la pantalla
		frame.setLocationRelativeTo(null);
		//Se añade a la pantalla la clase game
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
	
} 
