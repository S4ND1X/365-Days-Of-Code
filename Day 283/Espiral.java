import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Espiral extends JPanel{
	
	private int anchoEspiral, anchoDelta;
	
	public Espiral() {
		super();
		//Dimensiones,hilo
		this.setPreferredSize(new Dimension(800,800));
		this.setBackground(Color.CYAN);
		this.setAnchoDelta(10);
		this.setAnchoEspiral(50);
	}
	
	//Setters
	public void setAnchoEspiral(int anchoEspiral) {
		this.anchoEspiral = anchoEspiral;
		this.repaint();
	}
	
	public void setAnchoDelta(int anchoDelta) {
		this.anchoDelta = anchoDelta;
		this.repaint();
	}
	
	private void dibujaEspiral(Graphics g) {
		int centerX = getWidth() / 2;
	    int centerY = getHeight() / 2;
        for (int i = 0; i < 5; i++) {
            g.drawArc(centerX - this.anchoEspiral, centerY - this.anchoEspiral, 2 * this.anchoEspiral, 2 * this.anchoEspiral, 0, 180);
            this.anchoEspiral += this.anchoDelta;
            g.drawArc(centerX - this.anchoEspiral, centerY - this.anchoEspiral, 2 * this.anchoEspiral - this.anchoDelta, 2 * this.anchoEspiral, 180, 180);
        }
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.dibujaEspiral(g);
	}
	

 

		
	
}
