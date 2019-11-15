//Andrés Díaz de León
//A01620020

public class EulerXC extends Euler {

	public EulerXC(double x0, double y0, double xf, double h) {
		super(x0, y0, xf, h);
	}

	@Override
	protected double f(double x, double y) {
		return x * x;
	}

	public static void main(String args[]) {
		EulerXC exc = new EulerXC(0, 0, 5, 0.01);
		System.out.println(exc.integrar());
	}
}
