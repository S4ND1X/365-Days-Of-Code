public class Cuadrado extends Rectangulo{

    public Cuadrado(double lado){
        super(lado,lado);
    }

    public Cuadrado(){
        this(5);
    }

    public String toString(){
        return "Cuadrado de lado " + this.largo;
    }
}