package com.miko.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class BossEnemy extends GameObject {
	
	private Handler handler;
	private int timer = 120;
	private int timer2= 60;
	private int numBullets = 0;
	Random r = new Random();

	
	
	//Valores Iniciales
	public BossEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);			
		this.handler = handler;		
		velX = 0;
		velY = 2;
	}	
	
	public Rectangle getBounds() {
		//Regresa un cuadrado para saber en que posicion esta a la hora de colisionar
		return new Rectangle((int)x, (int) y, 128, 128);	
	}
	
	//Elementos a actualizar
	public void tick() {
		x += velX;
		y += velY;
		
		//Ir bajando en la pantalla y detenerse
		if(timer <= 0)velY = 0;
		else timer--;
		//Si ya se detuvo empieza el otro contador
		if(timer <= 0)timer2--;
		//Si ya se detuvo unos momentos empezara a moverse a los lados y  rebotar
		if(timer2 <= 0) {
			if(velX == 0)velX = 10;
			//Aumentar su velocidad progresivamente 
			//Spawnear random si es 0
			int spawn = r.nextInt(3);
			if(spawn == 0) {
				//Se spawnea una nueva bala
				handler.addObject(new BossEnemyBullet((int)x + 64 , (int)y + 64, ID.BossEnemyBullets, handler));
				//Se suma uno al contador de balas
				numBullets++;
			}
			//Si ya disparo X balas, desaparece
			if(numBullets >= 200)handler.removeObject(this);
			
		}
		
		//Hacer que los enemigo reboten
		//if(y <= 0 || y >= Game.HEIGHT - 128) velY *= -1;		
		if(x <= 0 || x >= Game.WIDTH - 128) velX *= -1;
		
		//Crear la sombra
		handler.addObject(new Trail((int)x,(int) y, ID.Trail, new Color(235, 112, 116), 128, 128, 0.08f, handler ));
		
	}
	//Crear elemento grafico
	public void render(Graphics g) {
		g.setColor(new Color(235, 112, 116));		
		g.fillRect((int)x,(int) y, 128, 128);
	} 

}
