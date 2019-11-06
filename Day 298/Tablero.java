import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tablero extends JPanel{
	private Carta[] cartas;
	private Carta carta1, carta2;
	private Jugador[] jugadores;
	private int paresEncontrados;

	public Tablero(Jugador[] jugadores) {
		super();
		this.setLayout(new GridLayout(3,4));
		//Inicializar atributos
		this.paresEncontrados = 0;
		this.cartas = new Carta[12];
		this.jugadores = jugadores;
		//Metodos para generar y mezclar las cartas
		this.generarCartas();
		this.mezclarCartas();
		this.agregarCartasATablero();
	}
//--------------------- Metodos ------------------

	private void agregarCartasATablero() {
		//A�ade las cartas al tablero
		for(Carta carta : this.cartas) { this.add(carta); }
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
			this.cartas[i] = new Carta(nombres[i/2], imagenes[i/2]);
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
//--------------------- Setters ------------------
	public void setCarta1(Carta carta) {
		this.carta1=carta;
	}

	public void setCarta2(Carta carta) {
		this.carta2=carta;
	}
}