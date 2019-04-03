/*
 * Clase para las funciones logicas de un programa  
 */
package llfunciones;




public class LLFunciones{
	
	//Variables solo para nosotros, private hace que solo se puedan acceder desde esta clase
	private int kilos = 0, llenadoCompleto = 0, TipoDeRopa = 0, LavadoCompleto = 0, SecadoCompleto = 0;
	
	public LLFunciones(int kilos, int TipoDeRopa) {
		//Se asginan los valores del objeto a los de la clase
		this.kilos = kilos;
		this.TipoDeRopa = TipoDeRopa;
	}
	
	private void Llenado() {//Este programa llena
		if(kilos <= 12) {
			llenadoCompleto = 1;
			System.out.println("Llenando...");
			System.out.println("Llenado completo");
		} else {
			System.out.println("La carga de ropa es muy pesada, reduce la carga");
		}
	}
	
	private void Lavado(){ //Este programa lava
		Llenado();
		if(llenadoCompleto == 1){
			if(TipoDeRopa == 1){
				System.out.println("Ropa blanca / Lavado Suave");
				System.out.println("Lavando...");
				LavadoCompleto = 1;
			} else if(TipoDeRopa == 2){
				System.out.println("Ropa De Color / Lavado Intenso");
				System.out.println("Lavando...");
				LavadoCompleto = 1;
			} else {
				System.out.println("El tipo de ropa no esta disponible");
				System.out.println("Se lavara como ropa de color / Lavado Intenso");
				LavadoCompleto = 1;
			}
		}
	}
	
	private void Secado() {//Este programa seca
		Lavado();
		if(LavadoCompleto == 1){
			System.out.println("Secando...");
			SecadoCompleto = 1;
		}
	}
	
	public void CicloFinalizado(){
		Secado();
		if(SecadoCompleto == 1) {
			System.out.println("El ciclo ha finalizado con exito");		
			
		}
	}
	
	//Get es para obtener el valor 
	public int getTipoDeRopa(){
		return this.TipoDeRopa;
	}
	
	//Es para asignarle un valor
	public void setTipoDeRopa(int TipoDeRopa){
		this.TipoDeRopa = TipoDeRopa;
	}

}
