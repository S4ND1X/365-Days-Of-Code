import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	private int enemySize;
	private Handler handler;

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.enemySize = 32;
		this.handler = handler;
	}

	@Override
	public void tick() {
		this.x += velX;
		this.y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - this.enemySize);
		y = Game.clamp(y, 0, Game.HEIGHT - this.enemySize * 2);
		
		collision();
	}
	
	private void collision() {
		for(GameObject tempGameObject : this.handler.gameObjects) {
			if(getBounds().intersects(tempGameObject.getBounds()) && tempGameObject.getId() == ID.BasicEnemy) {
				System.out.println("Collision of " + tempGameObject + " with " + this);
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, this.enemySize, this.enemySize);
	}

	@Override
	public Rectangle getBounds() {	
		return new Rectangle(this.x,this.y, this.enemySize, this.enemySize);
	}
	
}
