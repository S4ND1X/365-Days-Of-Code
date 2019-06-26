package com.miko.main;

import java.util.Random;

public class Spawner {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	private int level;
	
	//Constructor
	public Spawner(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
	}	
	
	public void tick() 
	{
		//600 == 10 segundos
		if(hud.getCont() % 300 == 0) 
		{
			//Si han pasado x segundos se aumenta un nivel
			hud.setLevel(hud.getLevel() + 1);
			//Enemigos segun los niveles
			level = hud.getLevel();
			//Enemigos segun los niveles
			switch(level) 
			{
			case 2:
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
					break;
			case 3:
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
					break;
			case 4:
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
					break;
				
			case 5:
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
				break;
				
			case 6:
				handler.clearEnemys();
				handler.addObject(new BossEnemy((Game.WIDTH / 2) - 64, -140, ID.BossEnemy, handler));
				break;
			}
		}
	}
	
	

}
