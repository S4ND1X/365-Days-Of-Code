public class Triangulo{
    //El triangulo tiene 3 vertices
    private Vertice vertice1,
                    vertice2,
                    vertice3;

    //Crea los vertices del triangulo
    public Triangulo(double x1,double y1,double x2,double y2,double x3,double y3){
        this.vertice1 = new Vertice(x1,y1);
        this.vertice2 = new Vertice(x2,y2);
        this.vertice3 = new Vertice(x3,y3);
    }
    //Calcula el area usando matrices
    public double calcularArea(){
        return  Math.abs((this.vertice1.getX() * this.vertice2.getY() + this.vertice2.getX() * this.vertice3.getY() + this.vertice3.getX() * this.vertice1.getY()) -  (this.vertice1.getY() * this.vertice3.getY() + this.vertice3.getX() * this.vertice2.getY() + this.vertice2.getY() * this.vertice1.getY())) / 2;
    }


    public static void main(String[] args) {
        Triangulo triangulo = new Triangulo(0,0,0,0,0,0);
        System.out.printf("%f u^2", triangulo.calcularArea());
    }

}


