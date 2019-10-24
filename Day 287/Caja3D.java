import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Caja3D {
	private int x0, y0, ancho, alto;

	private int[] vxTapa, vyTapa, vxPared, vyPared;

	private Color colorFrente, colorTapa, colorPared;

	public Caja3D(int x0, int y0, Color color) {// Inicializa x0,y0,vxTapa,vyTapa,vxPared,vyPared y los 3 colores
		this.setColorFrente(color);
		this.vxPared = new int[4];
		this.vyPared = new int[4];
		this.vxTapa = new int[4];
		this.vyTapa = new int[4];
	}

	public void setColorFrente(Color color) {
		int r = color.getRed(), g = color.getGreen(), b = color.getBlue();
		this.colorFrente = color;
		this.colorPared = new Color((int) (r * 0.8), (int) (g * 0.8), (int) (b * 0.8));
		r = (int) (r * 1.2 > 255.0 ? 255 : r * 1.2);
		g = (int) (g * 1.2 > 255.0 ? 255 : g * 1.2);
		b = (int) (b * 1.2 > 255.0 ? 255 : b * 1.2);
		this.colorTapa = new Color(r, g, b);
	}

	public void setXYIni(int x0, int y0) {// Inicializar x0,y0, alto y ancho en 0
		this.x0 = x0;
		this.y0 = y0;
		this.alto = 0;
		this.ancho = 0;
	}

	public void setXYFin(int xf, int yf) {// Recibe la coordenada inferior izquierda de la caja y con eso settea ancho,
											// alto y recalculo los v�rtices

	}

	private void calculaVertices() {// Calcula el valor de cada v�rtice vxTapa, vyTapa, vxPared y vyPared

	}

	// Este m�todo pinta la caja de acuerdo al valor de sus atributos
	// Si el ancho y alto no son mayores a 0 entonces no dibuja nada
	public void pintaCaja(Graphics g) {

	}

	// Regresa el objeto en el siguiente formato
	// x0 y0 xf yf colorRGB
	// Hay un espacio en blanco entre cada valor. xf y yf se refieren a la
	// coordenada inferior derecha de la caja
	public String toString() {

	}
}