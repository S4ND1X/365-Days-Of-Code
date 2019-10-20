import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CuboPrueba extends JPanel {
	int[] xs, ys;
	public CuboPrueba(int[] xs, int[]ys) {
		super();
		this.xs = xs;
		this.ys = ys;
		this.setPreferredSize(new Dimension(900,900));
	}
	
	public void paintComponent(Graphics g) {
		int[] wea = {300,200,500,600}, wea2 = {300,250,250,300};
		super.paintComponent(g);
		Color nuevoColor = new Color(164,28,0);
		Color colorClaro = new Color((int) (nuevoColor.getRed() * 1.2),
									(int)(nuevoColor.getGreen()*1.2),
									(int)(nuevoColor.getBlue()*1.2));
		g.setColor(nuevoColor);
		g.fillPolygon(this.xs, this.ys, 6);
		g.setColor(colorClaro);
		g.fillPolygon(wea, wea2,4);
		
	}
	
}
