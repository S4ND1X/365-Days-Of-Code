import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EjemploFileWriter {
	
	
	public static void main(String[] args) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter("nuevo.txt"));
			pw.println("Este es mi primer archivo creado desde java");
			pw.println("Espero que todo salga bien");
			pw.flush();
			pw.println("Esto no se va a guardar");
			pw.flush();
			pw.close();
		}catch(IOException ex){
			System.out.println("No se pudo crear el archivo");
		}
		finally {
			pw.close();
		}
	}
}
