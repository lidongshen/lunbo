package homework;

public class Car {
	String vehicleModel;
	String plateNumber;
	public Car(String vehicleModel, String plateNumber) {
		super();
		this.vehicleModel = vehicleModel;
		this.plateNumber = plateNumber;
	}
	public Car() {
	}
	public void start() {
		System.out.println("我是车，我启动");
	}
	public void stop() {
		System.out.println("我是车，我停止");
	}
}
class Taxi extends Car{
	String  taxiCompany;
	public Taxi() {
		
	}
	public Taxi(String vehicleModel, String plateNumber, String taxiCompany) {
		super(vehicleModel, plateNumber);
		this.taxiCompany = taxiCompany;
	}
	public  void  start() {
		System.out.println("乘客您好我是"+taxiCompany+"的，我的车牌是"+plateNumber+",您要去哪里");
	}
	public void stop() {
		System.out.println("目的地已到，请您付费下车，欢迎再次乘坐");
	}
}
class FamilCar extends Car{
	String name;
	public FamilCar() {
		
	}
	public FamilCar(String vehicleModel, String plateNumber,String name) {
		super(vehicleModel, plateNumber);
		this.name = name;
	}
	public  void  start() {
		System.out.println("我是"+name+",我的汽车我做主");
	}
	public void stop() {
		System.out.println("目的地了，我门去玩吧");
	}
}
class CarTest{
	public static void main(String[] args) {
		Car car = new Car();
		FamilCar familCar = new FamilCar("北京现代","12345","武大郎");
		Taxi taxi = new Taxi("大众","京B123","景顺出租车公司");
		car.start();
		car.stop();
		familCar.start();
		familCar.stop();
		taxi.start();
		taxi.stop();
	}
}