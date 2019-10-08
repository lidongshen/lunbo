package homework;

public class Circle {
	private double radius;
	final double PI=3.1415;
	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	public Circle() {
	}
	public double getArea() {
		return radius*PI*radius;
	}
	public double getPerimeter() {
		return radius*PI*2;
	}
	public void show() {
		System.err.println("半径："+radius+",周长"+getPerimeter()+",面积"+getArea());
	}

}
class Cylinder extends Circle{
	private double hight;
	public Cylinder(double radius,double hight) {
		super(radius);
		this.hight=hight;
	}
	public Cylinder() {
		
    }
	public double getVolume(){
		return getArea()*hight;
	}
	public void showVolume() {
		System.err.println("圆柱体的面积："+getVolume());
	}
	
}
class Test{
	public static void main(String[] args) {
			Circle circle = new Circle(2);
			circle.show();
			Cylinder cylinder = new Cylinder(2,5);
			cylinder.showVolume();
		}
	
}