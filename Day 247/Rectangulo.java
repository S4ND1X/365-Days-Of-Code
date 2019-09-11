public class Rectangulo extends Figura{

	protected double largo,
				    ancho;

	public double perimetro() {
		return (largo + ancho) * 2.0;
	}

	public double area() {
		return this.largo * this.ancho;
	}

	public Rectangulo() {
		this(10,4);
	}
	public Rectangulo(double largo, double ancho) {
		this.largo = largo;
		this.ancho = ancho;
	}

	public String toString() {
		return "Rectangulo";
	}

}
