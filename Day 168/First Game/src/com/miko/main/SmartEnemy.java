package com.miko.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class SmartEnemy extends GameObject {
	
	private Handler handler;
	private GameObject player;
	
	
	//Valores Iniciales
	public SmartEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);			
		this.handler = handler;	
		//Obtener el objeto de jugador
		for(int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getID() == ID.Player) {
				player = handler.object.get(i);
			}
		}
		
	}	
	
	public Rectangle getBounds() {
		//Regresa un cuadrado para saber en que posicion esta a la hora de colisionar
		return new Rectangle((int)x, (int)y, 16, 16);	
	}
	
	//Elementos a actualizar
	public void tick() {
		 int diffX = (int) (x - player.getX() - 8);
		 int diffY = (int) (y - player.getY() - 8);

		//Edit the number that -diffX or -diffY are divided by in order to control speed.  

		 if(diffX < 0) velX = (-diffX/80 + 1);
		 else if(diffX > 0) velX = (-diffX/80 - 1);
		//This else if line tells the enemy to stop moving if already in player on x axis
		 else if(diffX == 0) velX = 0;
		 if(diffY < 0) velY = (-diffY/80 + 1);
		 else if(diffY > 0) velY = (-diffY/80 - 1);
		//This  else if line tells the enemy to stop moving if already in player on y axis
		 else if(diffY == 0) velY = 0;
		  
		//Add velocity AFTER we've analyzed where the cube should move
		 x += velX;
		 y += velY;  
		//Crear la sombra
		handler.addObject(new Trail(x, y, ID.Trail, new Color(224, 255, 77), 16, 16, 0.01f, handler));
		
	}
	//Crear elemento grafico
	public void render(Graphics g) {
		g.setColor(new Color(224, 255, 77));		
		g.fillRect((int)x, (int)y, 16, 16);
	} 

}
