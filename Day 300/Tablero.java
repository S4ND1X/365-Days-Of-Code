import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

//Jorge Sanchez Diaz A01635375
//Alejandro Castro Arévalo-A01636235
public class Tablero extends JPanel{

	private Carta[] cartas;
	private Carta carta1, carta2, cerrar1, cerrar2;
	private Jugador[] jugadores;
	private int paresEncontrados, turno;
	private Timer timer;
	private Jugadores j;
	
	public Tablero(Jugador[] jugadores, Jugadores j) {
		super();
		this.setLayout(new GridLayout(3,4));
		//Inicializar atributos
		this.paresEncontrados = 0;
		this.cartas = new Carta[12];
		this.jugadores = jugadores;
		this.turno = 0;
		this.j=j;
		//Timer para dejar que se vean las cartas diferentes antes de cerrarse
		this.timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrar1.cerrar();
				cerrar2.cerrar();
			}
		});
		this.timer.setRepeats(false);
		
		//Metodos para generar y mezclar las cartas
		this.generarCartas();
		this.mezclarCartas();
		
		this.agregarCartasATablero();

	}
	

//--------------------- Metodos ------------------
	
	private void agregarCartasATablero() {
		//Añade las cartas al tablero
		for(Carta carta : this.cartas) {
			this.add(carta);
		}
	}
	
	
	private void generarCartas() {
		//Genera las cartas usando estos nombres con sus respectiva imagen
		String[] nombres = {"Homero", "Anonymous", "Android","Flor","Oso","Tobey"};
		Image[] imagenes = {new ImageIcon("1.jpg").getImage(),
							new ImageIcon("2.jpg").getImage(),
							new ImageIcon("3.jpg").getImage(),
							new ImageIcon("4.jpg").getImage(),
							new ImageIcon("5.png").getImage(),
							new ImageIcon("6.png").getImage()};
		//Crear nuevas cartas con sus respectivos nombres e imagenes
		for(int i = 0; i < 12; i++) {
			this.cartas[i] = new Carta(nombres[i/2], imagenes[i/2], this);
		}
	}
	
	private void mezclarCartas() {
		Random ran=new Random();
		Carta cartaTemp;
		int ranPos = ran.nextInt(6);
		//Cambio de posicion
		for(int i = 0; i<this.cartas.length; i++){
			cartaTemp = this.cartas[i];
			this.cartas[i] = this.cartas[ranPos];
			this.cartas[ranPos] = cartaTemp;
			ranPos = ran.nextInt(6);
		}
	}
	
	public void set(Carta carta) {
		if(this.carta1==null) {
			this.setCarta1(carta);
			System.out.println("1 "+this.carta1.getNombre());
		}
		else {
			this.setCarta2(carta);
			System.out.println("2 "+this.carta2.getNombre());
			this.juego();
			this.resultado();
		}
		
		if(this.carta2==carta) {
			this.carta1 = null;
			this.carta2 = null;
		}
	}
	//Comparacion de las cartas y flujo de los turnos
	public void juego() {		
		if(this.carta2.equals(carta1)) {
			this.carta1.parEncontrado();
			this.carta2.parEncontrado();
			this.paresEncontrados++;
			this.jugadores[this.turno].setScore(1);
			j.actualizar();
		}else {
			this.turno++;
			if(this.turno==this.jugadores.length) {
				this.turno=0;
			}
			JOptionPane.showMessageDialog(null, "Turno de : "+this.jugadores[this.turno].getNombre());
			System.out.println(this.jugadores[this.turno].getNombre());
			System.out.println("turno="+this.turno);
			this.cerrar1=this.carta1;
			this.cerrar2=this.carta2;
			this.timer.start();
			
		}
	}
	//Genera el resultado
	public void resultado() {
		int score1,score2,score3;
		String ganador="";
		score1 =score2 = score3 = 0;
		if(this.paresEncontrados==6) {
			if(this.jugadores.length==1) {
				score1 = this.jugadores[0].getScore();
			}
			else if(this.jugadores.length==2) {
				score1 = this.jugadores[0].getScore();
				score2 = this.jugadores[1].getScore();
			}
			else {
				score1 = this.jugadores[0].getScore();
				score2 = this.jugadores[1].getScore();
				score3 = this.jugadores[2].getScore();
			}
			
			if(score1>score2 && score1>score3) {
				ganador=this.jugadores[0].getNombre();
			}
			else if(score2>score1 && score2>score3) {
				ganador=this.jugadores[1].getNombre();
			}
			else if(score3>score1 && score3>score2){
				ganador=this.jugadores[2].getNombre();
			}
			else {
				ganador="Empate.";
			}
			JOptionPane.showMessageDialog(null, "Ganador: "+ganador);
		}
	}
//--------------------- Setters ------------------
	public void setCarta1(Carta carta) {
		this.carta1=carta;
	}
	
	public void setCarta2(Carta carta) {
		this.carta2=carta;
	}
	
//--------------------- Getters ------------------
	public Carta getCarta1() {
		return this.carta1;
	}
	
	public Carta getCarta2() {
		return this.carta2;
	}
}
