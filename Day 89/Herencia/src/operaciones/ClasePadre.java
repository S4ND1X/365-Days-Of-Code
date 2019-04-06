package operaciones;
import java.util.Scanner;

public class ClasePadre {
		//Si es herencia se usa protected
		protected int	valor1, 
						valor2, 
						resultado;
		Scanner input = new Scanner(System.in);
		
		//Pide valores
		public void PedirDatos() {
			System.out.println("Dame el primer valor: ");
			this.valor1 = input.nextInt(); 
			
			System.out.println("Dame el segundo valor: ");
			this.valor2 = input.nextInt();
		}
	
		//Muestra el resultado
		public void MostrarResultado() {
			System.out.println("El resultado es: " + this.resultado);
		}
		
}
