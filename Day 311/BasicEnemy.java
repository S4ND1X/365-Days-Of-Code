import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{
	
	private int enemySize;
	
	public BasicEnemy(int x, int y, ID id) {
		super(x, y, id);
		this.velX = 5;
		this.velY = 5;
		this.enemySize = 16;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if(this.y <= 0 || this.y >= Game.HEIGHT - this.enemySize) {this.velY *=-1; }
		if(this.x <= 0 || this.x >= Game.WIDTH - this.enemySize) {this.velX *=-1; }
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}
	
	@Override
	public Rectangle getBounds() {	
		return new Rectangle(this.x,this.y, this.enemySize, this.enemySize);
	}
	
	public void setEnemySize(int enemySize) {
		this.enemySize = enemySize;
	}
	

}
