package homework;



/*定义一个圆类——Circle，在类的内部提供2个属性：半径(r) 和圆心Point point，
 * 同时 提供 两个 方 法 ： 计算 面积 （ getArea() ） 和 计算 周长（getPerimeter()） 。 
 * 通过两个方法计算圆的周长和面积并且对计算结果进行输出。
 * 最后定义一个测试类对 Circle 类进行使用。
 */
public class Circle {
	double r;
	final double PI=3.1415;
	Point point;
	public Circle(double r) {
		super();
		this.r = r;
	}
	public void getArea() {
		System.out.println("面积为："+PI*r*r);
	}
	public void getPerimeter() {
		System.out.println("周长为："+PI*r*2);
	}
	public void getPoint() {
		System.out.println("圆心为"+point.x+","+point.y);
	}
	public void inCircle(Point p) {
		if((p.x-point.x)*(p.x-point.x)+(p.y-point.y)*(p.y-point.y)>r*r)
			System.out.println("点"+p.x+","+p.y+"在圆外");
		else if((p.x-point.x)*(p.x-point.x)+(p.y-point.y)*(p.y-point.y)==r*r)
			System.out.println("点"+p.x+","+p.y+"在圆上");
		else
			System.out.println("点"+p.x+","+p.y+"在圆内");
	}
	public static void main(String[] args) {
		Circle c = new Circle(5);
		Point p=new Point(2,5);
		c.point=new Point(1,2);
		c.getPerimeter();
		c.getArea();
		c.getPoint();
		c.inCircle(p);
	}
}
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}