package com.miko.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import com.miko.main.Game.STATE;

public class Game extends Canvas implements Runnable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -735169705092086816L;
	
	public static final int WIDTH = 1080, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private Random r;
	private HUD hud;
	private Spawner spawner;	
	
	private Menu menu;
	
	//Estados que contiene state
	public enum STATE{
		Menu,
		Credits,
		End,
		Game
	};

	//Crear el estado del juego
	public static STATE gameState = STATE.Menu;
	
	//Estado del juego
	
	public Game() {
		
		//Crear nuevo Handler
		handler = new Handler();
		menu = new Menu(this, handler, hud);
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);

		//Crear ventana
		new Window(WIDTH, HEIGHT, "First Game", this);			
		//Crear el HUD
		hud = new HUD();
		//Crear Spawner
		spawner = new Spawner(handler, hud);
		//Crear objeto Menu
		menu = new Menu(this, handler, hud);
		r = new Random();
		
		if(gameState == STATE.Game) {
			handler.addObject(new Player(Game.WIDTH / 2 - 64, Game.HEIGHT / 2 - 32, ID.Player, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
		}else {			
			for(int i = 0; i < 6; i++) {
				handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.MenuParticle, handler));
				handler.addObject(new MenuParticle2(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.MenuParticle2, handler));
			}
		}
		
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
				//System.out.println("Frames: " + frames);
				frames = 0;
			}
		}
		
		stop();				
	}
	
	private void tick() 
	{
		//Administrador de objetos
		handler.tick();
		
		//Si esta en estado de juego se actualizan los componentes del juego
		if(gameState == STATE.Game) {
			//Actualizar los enemigos			
			spawner.tick();
			//Actualizar el hud
			hud.tick();
			if(HUD.HEALTH <= 0) {
				HUD.HEALTH = 100;
				
				gameState = STATE.End;
				handler.clearEnemys();
				for(int i = 0; i < 6; i++) {
					handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.MenuParticle, handler));
					handler.addObject(new MenuParticle2(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.MenuParticle2, handler));
				}
				
			}
		}else if(gameState == STATE.Menu) {
			menu.tick();
			
		}
		
		
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		//Poder dibujar
		Graphics g = bs.getDrawGraphics();
		
		//Dibujar el tablero encima del Jframe	 
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT );
		
		//Renderizar los objetos
		handler.render(g);
		//Si esta en estado de juego se crea un juego si no es el menu
		if(gameState == STATE.Game) {
			//Renderizar el HUD 
			hud.render(g);
		}else if(gameState == STATE.Menu || gameState == STATE.Credits || gameState == STATE.End) {
			menu.render(g);
		}
		
		
		g.dispose();
		bs.show();
	}
	
	//Funcion para restringir rangos
	public static float clamp(float var, float min, float max) {
		if(var >= max) return var = max;
		else if(var <= min) return var = min;
		else return var;
	}
	
	public static void main(String args[]) {
		new Game();			
	}
}
