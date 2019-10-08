package homework;
    /*请定义一个交通工具(Vehicle)的类其中有:  
	属性： 速度(speed)、 体积(size)等，
	方法：移动(move())、设置速度(setSpeed(int speed))、
	加速 speedUp()、减速 speedDown()等。
	最后在测试类 Vehicle 中的 main()中实例化一个交通工具对象
	并通过方法给它初始化 speed,size 的值并且通过打印出来。
	另外调用加速、减速的方法对速度进行改变。*/
public class Vehicle {
	double speed;
	double size;
	public Vehicle(double speed, double size) {
		super();
		this.speed = speed;
		this.size = size;
	}
	public void move() {
		System.out.println("速度是："+speed+","+"体积是："+size);
	}
	public void setSpeed(double speed) {
		this.speed =speed;
	}
	public void speedUp() {
		System.out.println("速度增加成为："+(speed+=20));
	}
	public void speedDown() {
		System.out.println("速度减少成为："+(speed-=30));
	}
	public static void main(String[] args) {
		Vehicle  c = new Vehicle(120.0,50);
		c.move();
		c.speedUp();
		c.setSpeed(70);
		c.speedDown();
	}
}
