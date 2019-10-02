import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyPanelControles extends JPanel implements ActionListener {
	
	private JTextField tfNombre;
	private JButton btNombre, btFondo;
	private JRadioButton rbRojo,
						rbVerde,
						rbAzul;
	
	public MyPanelControles() {
		super();
		this.setSize(new Dimension(200, 600));
		
		this.tfNombre = new JTextField(10);
		this.btNombre = new JButton("Cambiar");
		this.btFondo = new JButton("Color Fondo");
		this.rbRojo = new JRadioButton("Color Rojo");
		this.rbRojo = new JRadioButton("Color Verde");
		this.rbRojo = new JRadioButton("Color Azul");
		
		ButtonGroup rbGroup = new ButtonGroup();
		rbGroup.add(this.rbRojo);
		rbGroup.add(this.rbVerde);
		rbGroup.add(this.rbAzul);
		
		this.btNombre.addActionListener(this);
		this.add(this.tfNombre);
		this.add(this.btNombre);
		this.add(this.rbRojo);
		this.add(this.rbVerde);
		this.add(this.rbAzul);
				
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btNombre) {
			
		}
		else if (e.getSource() == this.btFondo) {
			if(this.rbAzul.isSelected()) {
				this.setBackground(Color.blue);
			}
			else if(this.rbRojo.isSelected()) {
				this.setBackground(Color.red);
			}
			else {
				this.setBackground(Color.yellow);
			}
		}
		
	}
	
}
