package circle;
import java.util.Scanner;


public class CircleMain {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		double radius = input.nextDouble();
		
		
		Circle mensajero = new Circle(radius);
		
		System.out.println(mensajero.getArea());
		

	}

}
