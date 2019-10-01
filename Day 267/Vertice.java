public class Vertice{
    private double   x,
                    y;

    public Vertice(){
        this(0.0,0.0);
    }

    public Vertice(double x, double y){
        setVertice(x,y);
    }

    public void setVertice(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }
}