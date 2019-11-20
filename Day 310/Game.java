import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.ImageIcon;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -1442798787354930462L;

	public static final int WIDTH = 1080, HEIGHT = WIDTH / 12 * 9;

	private Thread thread;
	private boolean running = false;
	private Handler handler;

	public Game() {
		this.handler = new Handler();
		this.addKeyListener(new KeyInput(this.handler));
		// Crear ventana nueva
		new Window(WIDTH, HEIGHT, "Cornville", this);

		Random ran = new Random();

		this.handler.addGameObject(new Player(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), ID.Player));

	}

	public synchronized void start() {

		this.thread = new Thread(this);
		thread.start();
		this.running = true;
	}

	public synchronized void stop() {
		try {
			this.thread.join();
			this.running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		this.handler.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.pink);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		this.handler.render(g);

		g.dispose();
		bs.show();

	}

	// Metodo para restringir el movimiento
	public static int clamp(int var, int min, int max) {
		if (var >= max) {
			return var = max;
		} else if (var <= min) {
			return var = min;
		} else {
			return var;
		}
	}

	public static void main(String[] args) {
		new Game();
	}
}
