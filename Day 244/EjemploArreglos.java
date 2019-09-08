// Jorge Sanchez
// A01635375
// Clase EjemploArreglos.java
/* Al inicio tuve problemas sobre todo pensando como agregar los elementos porque se me salía
 * del rango, pero después ya fue cuando pensé en un contador para hacerlo e irle sumando por lo
 * al final se sumaría la cantidad de veces necesaria para agregar todas las letras. Fuera de 
 * eso, en general está bastante normal el tema, ya que arreglos es algo muy común en cualquier
 * lenguaje.
 */ 
public class EjemploArreglos {

	EjemploArreglos(){
		
	}
	
	//Obtiene la suma de los numeros
	public int suma(int[] arr) {
		int suma = 0;
		for(int i:arr) { suma+=i; } 
		return suma;
	}
	
	//Obtiene el numero maximo
	public int maximo(int[] arr) {
		int max = arr[0];
		for(int i:arr) { if(i > max) {max = i;} }
		return max;
	}
	//Obtiene el numero minimo
	public int minimo(int[] arr) {
		int min = arr[0];
		for(int i:arr) { if(i < min) { min = i;} }
		return min;
	}
	//Obtiene  el promedio
	public double promedio(int[] arr) {
		return suma(arr) / arr.length;
	}
	
	//Imprime un array bidimensional
	public void imprime(String[][] matr) {
		for(int i = 0; i < matr.length; i++) {
			for(int j = 0; j < matr[i].length; j++) {
				System.out.printf("%s ", matr[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EjemploArreglos ea = new EjemploArreglos();
		
		int[] valores = {1,2,3,4,5,6,7,8,9};
		System.out.println(ea.suma(valores));
		System.out.println(ea.maximo(valores));
		System.out.println(ea.minimo(valores));
		System.out.println(ea.promedio(valores));
		
		String[][] matr = {{"cat","dog", "lizard"},
							{"bear", "shark", "snake"}};
		ea.imprime(matr);

		//Llenar matriz con letras y despues llama al metodo para que lo imprima
		int filas = Integer.parseInt(args[0]);
        int columnas = Integer.parseInt(args[1]);
        
        int cont = 0;
        
        String[][] letras = new String [filas][columnas];
        
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++ ){
                letras[i][j] = args[cont + 2];
                cont++;
            }
        }
		
		ea.imprime(letras);
		
	}

}
