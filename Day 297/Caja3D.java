import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Caja3D {
	private int x0, y0, ancho, alto;

	private int[] vxTapa, vyTapa, vxPared, vyPared;

	private Color colorFrente, colorTapa, colorPared;

	public Caja3D(int x0, int y0, Color color) {// Inicializa x0,y0,vxTapa,vyTapa,vxPared,vyPared y los 3 colores
		this.setXYIni(x0, y0);
		this.vxPared = new int[4];
		this.vyPared = new int[4];
		this.vxTapa = new int[4];
		this.vyTapa = new int[4];
		this.setColorFrente(color);
	}

	public void setXYIni(int x0, int y0) {// Inicializar x0,y0, alto y ancho en 0
		this.x0 = x0;
		this.y0 = y0;
		this.alto = 0;
		this.ancho = 0;
	}

	public void setXYFin(int xf, int yf) {// Recibe la coordenada inferior izquierda de la caja y con eso settea ancho,
		// alto y recalculo los v�rtices
		this.alto = yf - this.y0;
		this.ancho = xf - this.x0;
		this.calculaVertices();
	}

	private void calculaVertices() {// Calcula el valor de cada v�rtice vxTapa, vyTapa, vxPared y vyPared
		int p15Ancho = (int) (this.ancho * 0.15);
		// <--------------- TAPA ----------------->
		// Coordenadas en X
		this.vxTapa[0] = this.x0;
		this.vxTapa[1] = this.x0 + p15Ancho;
		this.vxTapa[2] = this.x0 + this.ancho;
		this.vxTapa[3] = (this.x0 + this.ancho) - p15Ancho;

		// Coordenadas en Y
		this.vyTapa[0] = this.y0 + p15Ancho;
		this.vyTapa[1] = this.y0;
		this.vyTapa[2] = this.y0;
		this.vyTapa[3] = this.y0 + p15Ancho;

		// <--------------- PARED ----------------->

		// Coordenadas en X
		this.vxPared[0] = this.vxTapa[3];
		this.vxPared[1] = this.vxTapa[2];
		this.vxPared[2] = this.vxTapa[2];
		this.vxPared[3] = this.vxTapa[3];

		// Coordenadas en Y
		this.vyPared[0] = this.vyTapa[3];
		this.vyPared[1] = this.vyTapa[2];
		this.vyPared[2] = this.y0 + this.alto - p15Ancho;
		this.vyPared[3] = this.y0 + this.alto;

	}

	public void setColorFrente(Color color) {
		int r = color.getRed(), g = color.getGreen(), b = color.getBlue();
		this.colorFrente = color;
		this.colorPared = new Color((int) (r * .8), (int) (g * .8), (int) (b * .8));
		r = (int) (r * 1.2 < 255.0 ? r * 1.2 : 255);
		g = (int) (g * 1.2 < 255.0 ? g * 1.2 : 255);
		b = (int) (b * 1.2 < 255.0 ? b * 1.2 : 255);
		this.colorTapa = new Color(r, g, b);

	}

	// Este m�todo pinta la caja de acuerdo al valor de sus atributos
	// Si el ancho y alto no son mayores a 0 entonces no dibuja nada
	public void pintaCaja(Graphics g) {
		if (this.ancho > 0 && this.alto > 0) {
			// <--------------- FRENTE --------------->
			int[] xFrente = new int[4], yFrente = new int[4];

			// --------- Coordenadas en X ----------
			xFrente[0] = this.vxPared[3];
			xFrente[1] = this.x0;
			xFrente[2] = this.vxTapa[0];
			xFrente[3] = this.vxTapa[3];

			// --------- Coordenadas en Y ----------
			yFrente[0] = this.vyPared[3];
			yFrente[1] = this.y0 + this.alto;
			yFrente[2] = this.vyTapa[0];
			yFrente[3] = this.vyTapa[3];

			// Frente
			g.setColor(this.colorFrente);
			g.fillPolygon(xFrente, yFrente, 4);
			// Tapa
			g.setColor(this.colorTapa);
			g.fillPolygon(this.vxTapa, this.vyTapa, 4);
			// Pared
			g.setColor(this.colorPared);
			g.fillPolygon(this.vxPared, this.vyPared, 4);

		}
	}

	// Regresa el objeto en el siguiente formato
	// x0 y0 xf yf colorRGB
	// Hay un espacio en blanco entre cada valor. xf y yf se refieren a la
	// coordenada inferior derecha de la caja
	public String toString() {
		return this.x0 + " " + this.y0 + " " + (this.x0 + this.ancho) + " " + (this.y0 + this.alto) + " "
				+ this.colorFrente.getRGB();
	}
}