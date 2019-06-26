package com.miko.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Player extends GameObject {
	Handler handler;
	//Valores Iniciales
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	
	
	//Elementos a actualizar
	public void tick() {
		x += velX;
		y += velY;		
		
		//Restringir movimiento en la pantalla
		x = Game.clamp(x, 0, Game.WIDTH - 38);
		y = Game.clamp(y, 0, Game.HEIGHT - 68);
		
		//Crear sombra
		handler.addObject(new Trail(x,y, ID.Trail,new Color(156, 49, 255), 32, 32, 0.1f, handler));
		//Checar por colisiones
		collision();
		
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			//Aux para recorrer
			GameObject tempObject = handler.object.get(i);
			//Depende el enemigo se aplica diferente efecto
			switch(tempObject.getID()) {	
				//Si es colisiono con el enemigo se aplica un efecto
				case BasicEnemy:
					if(this.getBounds().intersects(tempObject.getBounds()))HUD.HEALTH -=1;					
					break;					
				case FastEnemy:
					if(this.getBounds().intersects(tempObject.getBounds()))HUD.HEALTH -=8;					
					break;
				case SmartEnemy:
					if(this.getBounds().intersects(tempObject.getBounds()))HUD.HEALTH -=2;					
					break;	
				case BossEnemy:
					if(this.getBounds().intersects(tempObject.getBounds()))HUD.HEALTH -=50;					
					break;
				case BossEnemyBullets:
					if(this.getBounds().intersects(tempObject.getBounds()))HUD.HEALTH -=1;					
					break;
				default:
					HUD.HEALTH -= 0;
					
					break;
		}
 	}
}
	
	
	//Crear cuadrado
	public void render(Graphics g) {
		g.setColor(new Color(156, 49, 255));
		g.fillRect((int)x, (int)y, 32, 32);
	}
}
