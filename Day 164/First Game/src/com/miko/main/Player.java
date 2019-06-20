package com.miko.main;

import java.awt.Color;
import java.awt.Graphics;
public class Player extends GameObject {

	
	//Valores Iniciales
	public Player(int x, int y, ID id) {
		super(x, y, id);
	}
	
	//Elementos a actualizar
	public void tick() {
		x += velX;
		y += velY;
		
		
		x = Game.clamp(x, 0, Game.WIDTH - 38);
		y = Game.clamp(y, 0, Game.HEIGHT - 68);
		
	}
	//Crear elemento grafico
	public void render(Graphics g) {
		
		g.setColor(Color.cyan);
		g.fillOval(x, y, 32, 32);
	}
}
