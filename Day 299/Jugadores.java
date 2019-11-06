import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


//Jorge Sanchez Diaz A01635375
//Alejandro Castro Arévalo-A01636235
public class Jugadores extends JPanel {
	private Jugador[] jugadores;
	private JLabel[] labels;
	
	public Jugadores() {
		super();
		//Crear jugadores junto con sus labels
		this.crearJugadores();
		this.crearLabels();
		this.agregarLabels();
		
	}
	
	//------------------- Metodos -----------------
	
	private void crearJugadores() {
		//Crear elemento para elegir a los jugadores
		String[] options = {"1","2","3"};
		int numJugadores = JOptionPane.showOptionDialog(null, "Cuantos jugadores son?",
														"Memorama!",
														JOptionPane.DEFAULT_OPTION, 
														JOptionPane.INFORMATION_MESSAGE, 
														null, options, options[0]);
		this.jugadores = new Jugador[numJugadores+1];
		this.labels = new JLabel[numJugadores+1];
		//Pide los nombres de la cantidad de jugadores que haya sido elegida
		for(int i = 0; i <= numJugadores; i++) {
			String nombreJugador = JOptionPane.showInputDialog("Cual es el nombre del jugador");
			this.jugadores[i] = new Jugador(nombreJugador);
		}
	}
	
	private void crearLabels() {
		//Crea los label de los jugadores que si existan
		for(int i = 0; i < this.jugadores.length; i++) {
			if(this.jugadores[i] != null) {
				Jugador jugadorTemp = this.jugadores[i];
				this.labels[i] = new JLabel( jugadorTemp.getNombre() + " : " + jugadorTemp.getScore());
			}
		}
	}
	
	private void agregarLabels() {
		//Simplemente añade los label si es que existen
		for(JLabel label: this.labels) {
			if(label != null) { this.add(label); }
		}
	}

	public Jugador[] getJugadores() {
		return this.jugadores;
	}
	
	public void actualizar() {
		if(this.jugadores.length==1) {
			this.labels[0].setText(this.jugadores[0].getNombre() + " : " + this.jugadores[0].getScore());
		}
		else if(this.jugadores.length==2) {
			this.labels[0].setText(this.jugadores[0].getNombre() + " : " + this.jugadores[0].getScore());
			this.labels[1].setText(this.jugadores[1].getNombre() + " : " + this.jugadores[1].getScore());
		}
		else {
			this.labels[0].setText(this.jugadores[0].getNombre() + " : " + this.jugadores[0].getScore());
			this.labels[1].setText(this.jugadores[1].getNombre() + " : " + this.jugadores[1].getScore());
			this.labels[2].setText(this.jugadores[2].getNombre() + " : " + this.jugadores[2].getScore());
		}
	}
}
