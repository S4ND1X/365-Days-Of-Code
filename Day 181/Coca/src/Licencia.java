import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class Licencia extends JFrame  implements ActionListener, ChangeListener {

	private JLabel label1, label2;
	private JCheckBox check1;
	private JButton button1, button2;
	private JScrollPane scrollpane1;
	private JTextArea textarea1;
	public Licencia() {
		setLayout(null);
		//Poner titulo e icono de interfaz
		setTitle("Licencia de uso");
		setIconImage(new ImageIcon(getClass().getResource("./icon.png")).getImage());
		
		//Label Terminos y condiciones
		this.label1 = new JLabel("TÉRMINOS Y CONDICIONES");
		this.label1.setBounds(215, 5, 200, 30);
		this.label1.setFont(new Font("Andale Mono", 1, 14));
		this.label1.setForeground(new Color(0, 0, 0));
		add(this.label1);
		
		//Area del contrato
		this.textarea1 = new JTextArea();
		//Hacer que no se pueda editar
		this.textarea1.setEditable(false);
		this.textarea1.setFont(new Font("Andale Mono", 0, 9));	
		this.textarea1.setText("\n\n          TÉRMINOS Y CONDICIONES" +
                "\n\n            A.  PROHIBIDA SU VENTA O DISTRIBUCIÓN SIN AUTORIZACIÓN DE LA GEEKIPEDIA DE ERNESTO." +
                "\n            B.  PROHIBIDA LA ALTERACI�N DEL CÓDIGO FUENTE O DISEÑO DE LAS INTERFACES GRÁFICAS." +
                "\n            C.  LA GEEKIPEDIA DE ERNESTO NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE." +
                "\n\n          LOS ACUERDOS LEGALES EXPUESTOS ACONTINUACIÓN RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE" +
                "\n          (LA GEEKIPEDIA DE ERNESTO Y EL AUTOR ERNESTO), NO SE RESPONSABILIZAN DEL USO QUE USTED" + 
                "\n          HAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (ACEPTO)" +
                "\n          SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE." + 
                "\n\n          PARA MAYOR INFORMACIÓN SOBRE NUESTROS PRODUCTOS O SERVICIOS, POR FAVOR VISITE" + 
                "\n          http://www.youtube.com/ernestoperezm");
		//Agregar el textarea al Scroll
		this.scrollpane1 = new JScrollPane(this.textarea1);
		this.scrollpane1.setBounds(10, 40, 575, 200);
		add(this.scrollpane1);
		
		//CheckBox
		this.check1 = new JCheckBox("Aceptar");
		this.check1.setBounds(10, 250, 300, 30);
		this.check1.addChangeListener(this);
		add(this.check1);
		
		//Boton 1
		this.button1 = new JButton("Continuar");
		this.button1.setBounds(10, 290, 100, 30);
		this.button1.addActionListener(this);
		this.button1.setEnabled(false);
		add(this.button1);
		
		//Boton 2
		this.button2 = new JButton("No Acepto");
		this.button2.setBounds(120, 290, 100, 30);
		this.button2.addActionListener(this);
		this.button2.setEnabled(true);
		add(this.button2);
		
		
		//Label 2
		ImageIcon imagen = new ImageIcon("./logo-coca.png");
		this.label2 = new JLabel(imagen);
		this.label2.setBounds(315, 135, 300, 300);
		add(this.label2);
	}
	
	public void stateChanged(ChangeEvent e) {
		if(this.check1.isSelected()) {
			this.button1.setEnabled(true);
			//this.button2.setEnabled(false);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.button1))System.out.println("Avanzar");
	}

	public static void main(String[] args) {
		Licencia ventanalicencia =  new Licencia();
		ventanalicencia.setBounds(0, 0, 600, 360);
		ventanalicencia.setVisible(true);
		ventanalicencia.setLocationRelativeTo(null);
		ventanalicencia.setResizable(false);

	}

}
