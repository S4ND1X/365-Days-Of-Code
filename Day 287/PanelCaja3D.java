import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

//Esta clase debe ser un panel capaz de controlar los eventos requiridos para dar 
//la funcionalidad al programa
public class PanelCaja3D {
	private Caja3D caja;
	
	//Inicializa el panel y el objeto caja en x y y en 0 y con color frontal RGB(91,155,231)
	//En caso de ser necesario hacer otra acción lo puedes realizar
	public PanelCaja3D() {
	}
	
	//Aquí escribe el método que va a encargarse de pintar la caja en el panel
	
	
	//Getter del atributo caja
	public Caja3D getCaja() {
		return this.caja;
	}
	
	//Setter del atributo caja. 
	public void setCaja(Caja3D caja) {
	}
	
	
	//Métodos para controlar los eventos del mouse
	//Pon primero aquellos que no están vacios.
}
