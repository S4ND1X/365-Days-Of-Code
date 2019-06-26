package com.miko.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class MenuParticle2 extends GameObject {
	
	private Handler handler;
	private Random r = new Random();
	private Color color = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
	
	//Valores Iniciales
	public MenuParticle2(int x, int y, ID id, Handler handler) {
		super(x, y, id);			
		this.handler = handler;	
		
		velX = 5;
		velY = 5;		
	}	
	
	public Rectangle getBounds() {
		//Regresa un cuadrado para saber en que posicion esta a la hora de colisionar
		return new Rectangle((int)x, (int)y, 16, 16);	
	}
	
	//Elementos a actualizar
	public void tick() {
		x += velX;
		y += velY;
		//Hacer que los enemigo reboten
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;		
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		//Crear la sombra
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, color, 16, 16, 0.01f, handler));
		
	}
	//Crear elemento grafico
	public void render(Graphics g) {
		g.setColor(color);		
		g.fillRect((int)x, (int)y, 16, 16);
	} 

}
