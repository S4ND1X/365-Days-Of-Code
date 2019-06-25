package com.miko.main;
import java.awt.Color;
import java.awt.Graphics;

public class HUD {	
	public static float HEALTH = 100;
	private float greenValue = 255;
	
	private int level = 1, score, cont = 0;
	private long startTime = System.currentTimeMillis(), elapsedTime = 0, seconds = 0;
	
	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, 100);
		
		//Restringir verde entre 0 y 255
		greenValue =  Game.clamp((int)greenValue, 0, 255);
		
		//Hara que el valor de verde disminuya y se haga cada vez más oscuro
		greenValue = (HEALTH * 2);
		
		//Tiempo que ha pasado desde el inicio hasta ahora
		elapsedTime = System.currentTimeMillis() - startTime;
		//Obtener tiempo en segundos
		seconds = elapsedTime / 1000;
		//Contador 60 == 1 segundo
		cont++;
		//El score seran los segundos que han pasado
		score = (int) seconds;		
	}
	
	public void render(Graphics g) {
		//Color de fondo
		g.setColor(new Color(51, 255, 226, 90));
		g.fillRect(15, 15, 200, 32);
		//Color de vida
		g.setColor(new Color(51, (int)greenValue, 226));
		g.fillRect(15, 15, (int) (HEALTH * 2), 32);
		//Borde
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		
		g.drawString("Time: " + seconds  + "." + elapsedTime, 14, 64);
		g.drawString("Level: " + level, 14, 80);
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return this.level;
	}
	
	public int getCont() {
		return this.cont;
	}
	
	
}
