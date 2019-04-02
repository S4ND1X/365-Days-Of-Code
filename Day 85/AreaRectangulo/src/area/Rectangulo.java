package area;


public class Rectangulo {
	//Las que tiene la clase
	private int base, altura, area;
	
	//Las que recibe el constructor del objeto
	public Rectangulo(int base, int altura){
		//Asigna a la CLASE, los valores enviados por el objeto
		this.base = base;
		this.altura = altura;
	}
	
	public void CalculoArea() {
		area = base * altura;
	}
	
	public void Imprimir() {
		CalculoArea();
		System.out.println("El area es " + area);
	}

}
