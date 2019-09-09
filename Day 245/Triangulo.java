public class Triangulo{
    private Vertice vertice1,
                    vertice2,
                    vertice3;

    public Triangulo(double x1,double y1,double x2,double y2,double x3,double y3){
        this.vertice1 = new Vertice(x1,y1);
        this.vertice2 = new Vertice(x2,y2);
        this.vertice3 = new Vertice(x3,y3);
    }

    public double calcularArea(){
        // [(x1 * y3) + (x3 * y2) + (x2 * y1)]
        double numerador = vertice1.getI() * vertice2.getJ() + vertice2.getI() * vertice3.getJ() + vertice3.getI() *vertice1.getJ();
        double denominador = vertice1.getI() * vertice3.getJ() + vertice3.getI() * vertice2.getJ() + vertice2.getI() * vertice1.getJ();
        return  Math.abs(numerador - denominador) / 2;
    }

    public static void main(String[] args) {
        Triangulo triangulo = new Triangulo(-2,4,5,8,8,-1);
        System.out.printf("%f u^2", triangulo.calcularArea());
    }

}


