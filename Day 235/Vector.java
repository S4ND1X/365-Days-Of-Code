// Jorge Sanchez
// A01635375
// Clase Vector.java

public class Vector {

    private double i, j, k;

    // Constructor Default
    public Vector() {
        this.i = 0.0;
        this.j = 0.0;
        this.k = 0.0;
    }

    // Constructor parametros
    public Vector(double i, double j, double k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    // Regresa la magnitud del vector
    public double magnitud() {
        return Math.sqrt((Math.pow(this.i, 2) + Math.pow(this.j, 2) + Math.pow(this.i, 2)));
    }

    // Suma los elementos de este vector con los del vector que fue pasado y regresa
    // el nuevo vector
    public Vector suma(Vector vector) {
        return new Vector(this.i + vector.i,
                        this.j + vector.j,
                        this.k + vector.k);
    }

    // Resta los elementos de ambos vectores
    public Vector resta(Vector vector) {
        return new Vector(this.i - vector.i,
                        this.j - vector.j,
                        this.k - vector.k);
    }

    // Calcula el prodcuto punto de un vector
    public double productoPunto(Vector vector) {
        return this.i * vector.i + this.j * vector.j + this.k * vector.k;
    }

    // calcula el producto cruz y crea el nuevo vector pasando i, j, k
    public Vector productoCruz(Vector vector) {

        return new Vector(this.j * vector.k - this.k * vector.j,
                        this.k * vector.i - this.i * vector.k,
                        this.i * vector.j - this.j * vector.i);
    }

    // Este metodo modifica el vector actual y asigna los componentes del vector
    // pasado.
    public void agregar(Vector vector) {
        this.i = vector.i;
        this.j = vector.j;
        this.k = vector.k;
    }

    public void imprimeVector() {
        System.out.printf("(%.2fi , %.2fj , %.2fk)\n", this.i, this.j, this.k);
    }

    public static void main(String[] args) {
        Vector vector1 = new Vector(1.0, 1.0, 1.0);
        Vector vector2 = new Vector(2.0, 2.0, 2.0);
        
       System.out.print("Suma de vectores => ");
       vector1.suma(vector2).imprimeVector();
       System.out.print("Resta de vectores => ");
       vector1.resta(vector2).imprimeVector();
        
       System.out.printf("Magnitud => %.2f\n",vector1.magnitud());   
       
       System.out.printf("Producto punto => %.2f\n",vector1.productoPunto(vector2));
       
       System.out.print("Producto cruz => ");
       vector1.productoCruz(vector2).imprimeVector();
       
       System.out.print("Reemplazo de valores => ");
       vector1.agregar(vector2);
       vector1.imprimeVector();
        
    }
    

}