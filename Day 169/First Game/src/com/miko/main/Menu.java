package com.miko.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.miko.main.Game.STATE;

public class Menu extends MouseAdapter {
	
	
	private Game game;
	private Handler handler;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	
	public void MousePressed(MouseEvent e) {
		//Posicion del mouse en X & Y
		int mx = e.getX();
		int my = e.getY();

		if(MouseOver(mx, my, 400, 375, 300, 80)) {
			game.gameState = STATE.Game;
			handler.addObject(new Player(Game.WIDTH / 2 - 64, Game.HEIGHT / 2 - 32, ID.Player, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
		}
		
	}
	
	public void MouseReleased(MouseEvent e) {
		
		
		
	}
	
	private boolean MouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	
	public void render (Graphics g){
	Font fnt = new Font("arial", 1, 50);
		//"Menu" String
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Menu", 490, 300);
		//First Button
		g.setFont(fnt);
		g.setColor(Color.CYAN);
		g.drawString("Play", 500, 432);
		g.setColor(Color.white);
		g.drawRect(400, 375, 300, 80);
		//Second Button
		g.setFont(fnt);
		g.setColor(Color.PINK);
		g.drawString("Help", 500, 555);
		g.setColor(Color.white);
		g.drawRect(400, 500, 300, 80);
		//Third Button
		g.setFont(fnt);
		g.setColor(Color.orange);
		g.drawString("Quit", 500, 682);
		g.setColor(Color.white);
		g.drawRect(400, 625, 300, 80);
		
	}
	
	
	public void tick() {
		
		
	}
	
	
	
}
