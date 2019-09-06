public class Habitacion{

	// ------------------------------------- Atributos de la clase ------------------
	private int numero,
		    adultos,
		    infantes;

	private double credito,
				cargo;

	private String nombre;

	private boolean disponible;


	// ------------------------------------- Constrcutores -------------------------------------
	public Habitacion(){
		this(0);
	}

	//Constructor con parametros
	public Habitacion(int numero){
		this.numero = numero;
		this.disponible = true;
	}

	// ------------------------------------- Metodos -------------------------------------
	public int getNumero(){ return this.numero; }

	public boolean getDisponible()  { return this.disponible; }

	public void checkIn(String nombre, int adultos, int infantes, double credito){
		this.nombre = nombre;
		this.adultos = adultos;
		this.infantes = infantes;
		this.credito = credito;
		this.disponible = !this.disponible; //Preguntar salinas
	}

	public boolean checkOut(){
		if(!this.disponible){
			this.nombre = "";
			this.adultos = 0;
			this.infantes = 0;
			this.credito = 0.0;
			this.disponible = true;
			return true;
		}else { return false; }
	}

	public int getTarifaBase(){
		return this.infantes*100 + this.adultos*350;
	}

	public boolean realizarCargo(double cargo){
		if(cargo > 0 && cargo < this.credito){
			this.cargo += cargo;
			return true;
		}else {
			return false;
		}
	}

	public String toString(){
		return this.numero + " de habitacion, Huesped: " + this.nombre + ", TarifaBase: " + getTarifaBase() + ", Credito: " +this.credito + ", Cargos: " + this.cargo;
	}

}

