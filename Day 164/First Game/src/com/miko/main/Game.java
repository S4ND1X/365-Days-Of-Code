package com.miko.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -735169705092086816L;
	
	public static final int WIDTH = 1080, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private HUD hud;
	
	public Game() {
		//Crear nuevo Handler
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		new Window(WIDTH, HEIGHT, "First Game", this);	
		//Crear nuevo objeto
		handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player));
		handler.addObject(new BasicEnemy(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.BasicEnemy));
		
		hud = new HUD();
		
	}

	public synchronized void start() {
		//Nuevo thread
		thread = new Thread(this);
		//Iniciar Therad
		thread.start();
		running = true;
	}
	public synchronized void stop() {		
		try{
			thread.join();
			running = false;			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void run() {	
		this.requestFocus();
		/* 	Game Loop 
		 * 	https://stackoverflow.com/questions/26706134/need-explanation-about-a-java-game-loop
		 * 
		 * Basicamente controla cada cuanto se actualiza dependiendo en la computadora que se ejecute
		 * es como si fuera el time.deltaTime de Unity
		*/
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running) 
				render();
			frames++;		
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("Frames: " + frames);
				frames = 0;
			}
		}
		
		stop();				
	}
	
	private void tick() {
		handler.tick();
		hud.tick();
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		//Poder dibujar
		Graphics g = bs.getDrawGraphics();
			 
		g.setColor(Color.pink);
		g.fillRect(0, 0, WIDTH, HEIGHT );
		
		handler.render(g);
		hud.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max) {
		if(var >= max) return var = max;
		else if(var <= min) return var = min;
		else return var;
	}
	
	public static void main(String args[]) {
		new Game();			
	}
}
