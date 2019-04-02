package area;
import java.util.Scanner;

public class RectanguloMain {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Valor de la base: ");
		int base = input.nextInt();
		System.out.print("Valor de la altura: ");
		int altura = input.nextInt();
		
		Rectangulo mensajero = new Rectangulo(base, altura);
		mensajero.Imprimir();
		
		
		
	}

}
