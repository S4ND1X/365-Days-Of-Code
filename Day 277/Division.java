/*Jorge Sanchez Diaz
 * 24/09/2019
 * Division.java
 *  Tengo una pregunta, sobretodo no sé que tan bien este el hecho de poner una bandera para saber si ya se hizo
 *  la operacion o se tiene que hacer de alguna otra manera.
 */
import javax.swing.JOptionPane;
public class Division {
	public static int  divisonEntera(int num, int den) {
		return num/den;
	}
	public static void main(String[] args) {
	boolean isDone = false;
	int numerador, denominador;
	do {			
		try {
			numerador=Integer.parseInt(JOptionPane.showInputDialog("Escribe el numerador "));
			denominador=Integer.parseInt(JOptionPane.showInputDialog("Escribe el denominador "));
			JOptionPane.showMessageDialog(null, "La division entre ambos números es "+ divisonEntera(numerador,denominador));
			isDone = true;
		}catch(ArithmeticException ex) {
			JOptionPane.showMessageDialog(null, "No se puede dividir un numero entre 0");
		}catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,"Ingresa datos validos");
		}
	}while(!isDone);

	
	}
}