package com.miko.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class BossEnemyBullet extends GameObject {
	
	private Handler handler;
	Random r = new Random();
	
	
	//Valores Iniciales
	public BossEnemyBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);			
		this.handler = handler;	
		//Velocidad random de -5 a 5
		velX = (r.nextInt(5 - -5) + -5);
		velY = 5;
	}	
	
	public Rectangle getBounds() {
		//Regresa un cuadrado para saber en que posicion esta a la hora de colisionar
		return new Rectangle((int)x, (int) y, 16, 16);	
	}
	
	//Elementos a actualizar
	public void tick() {
		x += velX;
		y += velY;
		
		
		
		//Si ya salio de pantalla se destruye el objeto
		if(y >= Game.HEIGHT)handler.removeObject(this);
		
		//Crear la sombra
		handler.addObject(new Trail((int)x,(int) y, ID.Trail, Color.white, 16, 16, 0.09f, handler ));
		
	}
	//Crear elemento grafico
	public void render(Graphics g) {
		g.setColor(Color.white);		
		g.fillRect((int)x,(int) y, 16, 16);
	} 

}
