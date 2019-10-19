import java.awt.BorderLayout;

import javax.swing.JFrame;

public class EspiralMain extends JFrame {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public EspiralMain() {
		super("Espiral Prueba");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Espiral espiral = new Espiral();
		//Agregar todo lo que llevara
		this.add(espiral);
		this.add(new EspiralControles(espiral), BorderLayout.WEST);
		this.pack();
		//Definir como aparecera la ventana
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	

	public static void main(String[] args) {
		EspiralMain ventanaPri =new EspiralMain();
	}

}
