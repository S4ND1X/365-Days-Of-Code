public class Calendario{

	public static String imprimeMes(int inicio, int numDias){

		String calendario = " D  L Ma Mi  J  V  S\n";
		int contDias = 1;

		for(int i = 0; i < inicio; i++){
			calendario += "   ";
			contDias++;
		}

		for(int i = 0; i < numDias; i++){
			if(i >= 9)
			{
				if(contDias % 7 == 0){
					calendario += i + 1 + "\n";
				}
				else{
					calendario += i + 1 + " ";
				}
			}
			else
			{
				if(contDias % 7 == 0){
					calendario += " " + (i + 1) + "\n";
				}
				else{
					calendario += " " + (i + 1) + " ";
				}
			}
			contDias++;
		}

		return calendario;
	}

	public static void main(String[] args){
		System.out.println(imprimeMes(3,31));
	}
}
