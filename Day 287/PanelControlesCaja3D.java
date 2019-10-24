import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JPanel;

//Esta clase es un Panel capaz de controlar los eventos de los botones que contiene
public class PanelControlesCaja3D{
	private PanelCaja3D pCaja;
	private JButton btGuardar;
	private JButton btAbrir;
	
	//Completa el contructor de manera que inicialice el panel y cada uno de sus atributos.
	//Es posible que tengas que modificar la firma del constructor
	public PanelControlesCaja3D() {
	}

	//Método para controlar los eventos de los botones
	//Si se oprime el botón guardar deberá escribir en un archivo de texto llamado caja.txt
	//en la carpeta default la información de la caja que está en el panel y deberá hacerlo con el siguiebnte formato
	//x0 y0 xf yf colorRGB
	//Hay un espacio en blanco entre cada valor. xf y yf se refieren a la coordenada inferior derecha de la caja	
	//Si se oprime el botón abrir deberá crear la caja que esta representada en el archivo caja.txt
	//Y que se muestre en el PanelCaja3D
	public void XXX(YYY evt) {
	}
}