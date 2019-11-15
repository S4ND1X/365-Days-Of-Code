
//Andrés Díaz de León
//A01620020
import java.awt.geom.Point2D;

public abstract class Euler {
	protected Point2D.Double[] puntos;
	protected double h;

	public Euler(double x0, double y0, double xf, double h) {
		this.h = h;
		this.puntos = new Point2D.Double[(int) ((xf - x0) / h + 1)];
		this.puntos[0] = new Point2D.Double(x0, y0);
	}

	public double integrar() {
		double xa, ya;

		for (int i = 1; i < this.puntos.length; i++) {
			xa = this.puntos[i - 1].x;
			ya = this.puntos[i - 1].y;

			this.puntos[i] = new Point2D.Double(xa + this.h, ya + this.h * f(xa, ya));
		}
		return this.puntos[this.puntos.length - 1].y;
	}

	protected abstract double f(double x, double y);

}