package com.uek.java2;
/**
 *   使用接口：
 *   创建一个汽车接口：
 *   	方法：驾驶，价格
 *   一个大众；一个奥迪
 *   
 *   测试类进行测试；
 */
//声明一个接口：
interface Car{
	//抽象方法:
	public abstract void drive(); //驾驶
	public abstract void price();
}

//当前类实现了Car接口：
class DaZhong implements Car{
	//方法的实现:
	public void drive() {
		System.out.println("大众汽车在行驶！");
	}
	public void price() {
		System.out.println("150000");
	}
}

class AoDi implements Car{
	//方法的实现:
	public void drive() {
		System.out.println("奥迪汽车在行驶！");
	}
	public void price() {
		System.out.println("300000");
	}
}

class Test{
	public static void main(String[] args) {
		/**
		 * 原生的方式构建对象：
		 */
		DaZhong daZhong = new DaZhong();
		daZhong.drive();
		daZhong.price();
		
		AoDi a =  new AoDi();
		a.drive();
		a.price();
		
		/**
		 * 改良：程序变的更加灵活，具有可扩展性；----多态技术
		 */
		// 接口多态的应用场景1 ：接口引用指向实现类对象；
		Car car = new DaZhong();
		car.drive();
		car.price();
	}
}





public class OOPTest06 {

}
