/*Programa Realizado por 
 * Jorge Sanchez Diaz A01635375
 * Andres Diaz De Leon A01620020
*/
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;


public class HealthToken extends GameObject {

    private Handler handler;
    private Random rand = new Random();

    private int timer = 50;

    public HealthToken(int x, int y, ID id, Handler handler){
        super(x, y, id);

        this.handler = handler;

        velX = 0; 
        velY = 3;
        
        this.color = new Color(138,255,154);
    }

    @Override
    public void tick(){

        x += velX;
        y += velY;

        if(y >= Game.HEIGHT) handler.removeObject(this);
        
        
        
        

    }

    @Override
    public void render(Graphics g) {
    	int[] xP = {x,x+10,x+20,x+30,x+10, x-10};
    	int[] yP = {y, y+10, y, y+15,y+20,y+15};
        g.setColor(color);
        g.fillPolygon(xP, yP,4);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle(x,y,10,20);
    }

	@Override
	public void setColorHit() {

		
	}

	@Override
	public void setColorHealed() {

		
	}
    
}