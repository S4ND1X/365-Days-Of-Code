import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	// --------------- Atributos ------------------
	protected int x,
				  y;
	protected ID id;
	protected int velX, 
				 velY;
	
	
	// ----------------- Constructores -------------
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	
	// ----------------- Metodos Abstractos ----------
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	// -------------------- Getters y Setters --------------------

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
	
}
