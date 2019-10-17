import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanelDibujo extends JPanel implements Runnable, MouseListener, MouseMotionListener {
	private int xV,
				yV,
				xTexto,
				yTexto;
	private Image fondo;
	private Image pocoyo;
	private String nombre;
	private boolean mover;
	private Color cGlobo;
	private Asteroide[] asteroides;
	
	
	
	public MyPanelDibujo() {
		super();
		Random ran = new Random();
		this.setPreferredSize(new Dimension(800,600));
		this.xV=this.yV=0;
		this.xTexto = 110;
		this.yTexto = 475;
		this.cGlobo = Color.red;
		this.fondo= new ImageIcon("fondo.jpg").getImage();
		this.pocoyo=new ImageIcon("pocoyo.png").getImage();
		this.nombre="Pocoyo";
		this.mover = false;
		this.asteroides = new Asteroide[20];
		for(int i = 0; i <  20; i ++) {
			this.asteroides[i] = new Asteroide(ran.nextInt(750), ran.nextInt(550));
		}
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		Thread hilo=new Thread(this);
		hilo.start();
		this.setBackground(Color.DARK_GRAY);
	}
	
	private void dibujaCabina(Graphics g) {
		g.setColor(Color.orange);
		g.fillOval(50+this.xV, 400+this.yV, 200, 100);
		g.setColor(Color.cyan);
		g.fillArc(50+this.xV, 400+this.yV, 200, 100, 0, 90);
	}
	private void dibujaGlobo(Graphics g) {
		g.setColor(Color.black);
		g.drawLine(100+this.xV, 407+this.yV, 100+this.xV, 300+this.yV);
		g.setColor(cGlobo);
		g.fillOval(50+this.xV, 200+this.yV, 100, 100);
	}
	
	private void dibujaFondo(Graphics g) {
		g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	private void dibujaPocoyo(Graphics g) {
		g.drawImage(this.pocoyo, 180+this.xV, 408+this.yV, 40, 40, this);
	}
	
	private void dibujaString(Graphics g) {
		g.drawString("Vamos "+this.nombre+"!!", this.xTexto, this.yTexto);
	}
	
	private void dibujaAsteroides(Graphics g) {
		for(Asteroide it: asteroides) {
			it.render(g);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.dibujaFondo(g);
		this.dibujaCabina(g);
		this.dibujaGlobo(g);
		this.dibujaPocoyo(g);
		this.dibujaString(g);
		this.dibujaAsteroides(g);
		
		
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
		this.repaint();
    }
	
	public void setColorGlobo(Color cGlobo) {
		this.cGlobo = cGlobo;
		this.repaint();
	}
    

	@Override //
	public void run() {
		while(this.xV<550) {
			try {
				Thread.sleep(20);
				if(this.mover) {
					this.xV+=2;
					this.yV--;
					this.repaint();
				}
				
			}catch(InterruptedException ex){
				System.out.println("No pude despertar al vamoosh");
			}
			
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.mover = true;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		this.xTexto = e.getX();
		this.yTexto = e.getY();
		repaint();
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}