/*Programa Realizado por 
 * Jorge Sanchez Diaz A01635375
 * Andres Diaz De Leon A01620020
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

//Abstract class that will be the father of the player class and the enemy class
public abstract class GameObject {

    protected int x, y;
    protected ID id;
    protected int velX, velY;
    protected int shoot;
    protected int health;
    protected Color color;

    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    public abstract void setColorHit();
    public abstract void setColorHealed();
    
    public void setColor(Color color) {
    	this.color = color;
    }
    public Color getColor() {
    	return this.color;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getX(){
        return x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getY(){
        return y;
    }

    public void setID(ID id){
        this.id = id;
    }

    public ID getID(){
        return id;
    }

    public void setVelX(int velX){
        this.velX = velX;
    }

    public int getVelX(){
        return velX;
    }

    public void setVelY(int velY){
        this.velY = velY;
    }

    public int getVelY(){
        return velY;
    }

    public void setShooting(int shoot){
        this.shoot = shoot;
    }
    
    public void setHealth(int health) {
    	this.health = health;
    }
    public int getHealth() {
    	return this.health;
    }

}