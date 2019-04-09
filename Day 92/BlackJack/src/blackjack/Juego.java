package blackjack;

public class Juego {

	public static void main(String[] args) {
		
		Baraja myBaraja = new Baraja();
		
		for(int i = 0; i<52; i++) {
			System.out.println("Tu carta es: " + myBaraja.deck[i]);
		}
		
		
		

	}

}
