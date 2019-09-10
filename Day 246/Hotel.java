public class Hotel {

	private String nombre;
	private Habitacion[] habitaciones;

	// ----------------- Constructor ------------------
	public Hotel(String nombre, int numHabitaciones) {
		this.nombre = nombre;
		// Reservar memoria del array
		this.habitaciones = new Habitacion[numHabitaciones];
		// Asignar numero de habitaciones
		for (int i = 0; i < numHabitaciones; i++) {
			habitaciones[i] = new Habitacion(100 + i);
		}
	}

	// ----------------- Metodos -----------------------
	//Hace check in a esa habitacion
	public int checkIn(String nombre, int adultos, int infantes, double credito){
		for (int i = 0; i < habitaciones.length; i++) {
				//En la primera habitacion disponible hace check in y regresa en que habitacion lo hizo.
			if (this.habitaciones[i].getDisponible()) {
				this.habitaciones[i].checkIn(nombre, adultos, infantes, credito);
				return this.habitaciones[i].getNumero();
			}
		}
		return -1;

}

	//Comprueba que sea una habitacion valida y si es hace checkOut
	public boolean checkOut(int numero) {
		if(numero >= 100 && numero < habitaciones.length + 100){
			this.habitaciones[numero].checkOut();
			return true;
		}
		return false;
	}

	//Suma cuanto dinero se recaudara ese dia.
	public int getTotalXTarifaBase(){
		int totalDia = 0;
		for(Habitacion habitacion: this.habitaciones){
			if(!habitacion.getDisponible()){
				totalDia += habitacion.getTarifaBase();
			}
		}
		return totalDia;
	}
	// Hacer cargo a la habitacion si esta ocupada
	public boolean	realizarCargosHabitaciones(int numero, double cargo){
		if(!this.habitaciones[numero - 100].getDisponible()){
			this.habitaciones[numero - 100].realizarCargo(cargo);
			return true;
		}
		return false;
	}

	public void ImprimeOcupacion(){
		String ocupacionStr = "Ocupacion en " + this.nombre +"\n";
		for(Habitacion habitacion: this.habitaciones){
			if(!habitacion.getDisponible()) { ocupacionStr += habitacion.toString() + "\n"; }
		}
		System.out.printf("%s", ocupacionStr);

	}


	public static void main(String[] args) {
		Hotel trivago = new Hotel("Hotel", 10);

		trivago.checkIn("Jorgito", 3, 0, 200);
	}


}