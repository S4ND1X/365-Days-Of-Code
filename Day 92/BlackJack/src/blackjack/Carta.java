package blackjack;

public class Carta {

	private int val;
	private int figura;
	
	
	//0 == diamantes, 1 == picas, 2 == corazones, 3 == Trebol
	
	public Carta(int val, int figura) {
		
		this.val = val;
		this.figura = figura;		
		
	}
	
	public String toString() {
		String[] myFiguras = {"Corazón","Diamantes","Treboles","Picas"};
		String[] myValues = {"As","2","3","4","5","6","7","8","9","10","Joto","Queena"};
		//Se le da el valor que tiene figura, con el for de la clase baraja
		return "Valor de la carta: " + myValues[this.val] + ", figura: " + myFiguras[this.figura];
	}
	
	
	
	
	
}
   