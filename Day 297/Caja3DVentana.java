import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Caja3DVentana extends JFrame {

	public Caja3DVentana() {
		super("Examen 2do Parcial POO");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		PanelCaja3D panelCaja3D= new PanelCaja3D();
		this.add(panelCaja3D);
		this.add(new PanelControlesCaja3D(panelCaja3D),BorderLayout.WEST);
		this.pack();
		this.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		Caja3DVentana ventana = new Caja3DVentana();

	}

}
