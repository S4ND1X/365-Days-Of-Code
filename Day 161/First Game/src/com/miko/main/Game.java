package com.miko.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -735169705092086816L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	
	public Game() {
		new Window(WIDTH, HEIGHT, "First Game", this);
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
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]) {
		new Game();			
	}
}
