package com.miko.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import com.sun.javafx.geom.Rectangle;
public class Player extends GameObject {
	Handler handler;
	//Valores Iniciales
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	//Elementos a actualizar
	public void tick() {
		x += velX;
		y += velY;		
		
		x = Game.clamp(x, 0, Game.WIDTH - 38);
		y = Game.clamp(y, 0, Game.HEIGHT - 68);
		
		collision();
		
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID() == ID.BasicEnemy) {
				//Colision
				if(getBounds().intersects(tempObject.getBounds())) {
					
				}
			}
 		}
	}
	
	//Crear elemento grafico
	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(x, y, 32, 32);
	}
}
