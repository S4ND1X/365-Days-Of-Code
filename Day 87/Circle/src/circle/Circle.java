package circle;

public class Circle {
	
/*Two private instance variables: radius (of the type double) and color (of the type String), with default value of 1.0 and "red", respectively.
Two overloaded constructors - a default constructor with no argument, and a constructor which takes a double argument for radius.
Two public methods: getRadius() and getArea(), which return the radius and area of this instance, respectively.*/

	
	private double radius;
	private String color;
	
	public Circle() {
		this.radius = 1.0;
		this.color = "red";		
	}
	
	public Circle(double radius) {
		this.radius = radius;
		this.color = "red";	
	}
	
	//Se define del tipo que vas a regresar
	public double getRadius() {
		return this.radius;
	}
	public double getArea() {		 
		return Math.PI * Math.pow(this.radius, 2);
	}

}
