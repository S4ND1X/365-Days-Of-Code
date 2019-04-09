package blackjack;

public class Baraja {
	
	
	
	protected Carta[] deck;
	
	public Baraja(){
		this.deck = new Carta[52];
		int k = 0;
		for(int i = 0; i<13; i++) {
			for(int j = 0; j < 4; j++) {
				
				this.deck[k++] = new Carta(i,j);
			}			
		}
	}
	
	
	
	
	
	

}

