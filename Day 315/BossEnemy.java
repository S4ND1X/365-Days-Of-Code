/*Programa Realizado por 
 * Jorge Sanchez Diaz A01635375
 * Andres Diaz De Leon A01620020
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.Random;

public class BossEnemy extends GameObject {
	
	private Handler handler;
	private int timer = 120;
	private int timer2= 60;
	private Random ran;
	
	
	//Valores Iniciales
	public BossEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);			
		this.handler = handler;		
		velX = -2;
		velY = 0;
		this.health = 100;
		this.ran = new Random();
		this.color = new Color(156,209,255);
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
		if(timer <= 0)velX = 0;
		else timer--;
		//Si ya se detuvo empieza el otro contador
		if(timer <= 0)timer2--;
		//Si ya se detuvo unos momentos empezara a moverse a los lados y  rebotar
		if(timer2 <= 0) {
			if(velY == 0)velY = 8;
			//Aumentar su velocidad progresivamente 
			//Spawnear random si es 0
			int spawn = this.ran.nextInt(5);
			if(spawn == 0) {
				//Se spawnea una nueva bala
				handler.addObject(new BossEnemyBullet((int)x + 64 , (int)y + 64, ID.BossEnemyBullets, handler));
			}
			//Si ya disparo X balas, desaparece
			if(this.health <= 0) {
				this.handler.removeObject(this);
				this.handler.clearEnemies();
			}	
		}
		
		
		//Hacer que los enemigo reboten
		//if(y <= 0 || y >= Game.HEIGHT - 128) velY *= -1;		
		if(y <= 0 || y >= Game.HEIGHT - 128) velY *= -1;
		
		//Crear la sombra
		//handler.addObject(new Trail((int)x,(int) y, ID.Trail, new Color(235, 112, 116), 128, 128, 0.08f, handler ));

	}
	//Crear elemento grafico
	public void render(Graphics g) {
		g.setColor(color);		
		g.fillRect((int)x,(int) y, 128, 128);
	}

	public void setColorHit() {
		int r = this.color.getRed(),g = this.getColor().getGreen(), b = this.getColor().getBlue();
		r*=0.95;
		g*=0.95;
		b*=0.95;
		this.color = new Color(r,g,b);
	}

	@Override
	public void setColorHealed() {
		// TODO Auto-generated method stub
		
	}

			
}
