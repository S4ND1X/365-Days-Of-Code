public class Naipe{

    private int figura; // 0 -> espadas, 1 -> corazones, 2 -> treboles 3 -> diamantes
    private int valor;
    private static final String[] figuras = {"Espadas","Corazones", "Treboles", "Diamantes"};
    private static final String[] valores = {"As","Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete","Ocho", "Nueve", "Diez", "Jota", "Queen", "Rey"};

    public Naipe(int figura, int valor){
        this.figura = figura;
        this.valor = valor;
    }

    public String toString(){
        return valores[this.valor] + " de " + figuras[this.figura];
    }


    public static void main(String[] args) {
        int cont = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                naipes[cont++] = new Naipe(j, i);
            }
        }
    }

}