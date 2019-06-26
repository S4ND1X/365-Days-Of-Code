package com.miko.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject {
	
	private float alpha = 1;
	private Handler handler;
	private Color color;
	
	private int width, height;
	private float life;

	public Trail(float x, float y, ID id,Color color, int width, int height, float life, Handler handler) {
		super(x, y, id);
		//Iniciar variables
		this.color = color;
		this.life = life;
		this.width = width;
		this.height = height;
		this.handler = handler;
	}
	
	public void tick() {
		//Vida del trail
		if(alpha > life) {
			alpha -= life - 0.001f;
		}else handler.removeObject(this);
	}
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		
		g.setColor(color);
		g.fillRect((int)x,(int) y, width, height);
		
		g2d.setComposite(makeTransparent(1));
		
	}
	
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}
	
	//No tiene colision
	public Rectangle getBounds() {
		return null;
	}
	
	

}
