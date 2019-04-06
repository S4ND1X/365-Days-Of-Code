package main;
import operaciones.ClaseHija_Suma;
import operaciones.ClaseHija_Resta;

public class ClasePrincipal {
	public static void main(String[] args) {
		
		
		ClaseHija_Suma objetoSuma = new ClaseHija_Suma();
		ClaseHija_Resta objetoResta = new ClaseHija_Resta();
		objetoSuma.PedirDatos();
		objetoResta.PedirDatos();
		
		objetoSuma.Sumar();
		objetoResta.Restar();
		
		objetoSuma.MostrarResultado();
		objetoResta.MostrarResultado();

		
	}

}
