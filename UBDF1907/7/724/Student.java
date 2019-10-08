package com.uek.java;

//学生类：
public class Student {
	//成员属性：
	String name;
	String gender;
	int age;
	Computer computer; //计算机类的对象作为学生的一个属性而存在；
	//成员方法：
	public String info() {
		return name+","+gender+","+age+","+computer.brand
				+","+computer.price+","+computer.color;
	}
}
//计算机类：
class Computer{
	String brand; //品牌
	double price;
	String color;
}

//
class StuTest{
	public static void main(String[] args) {
		//创建对象：
		Student stu = new Student();
		//赋值：
		stu.name="李佳妮";
		stu.gender = "女";
		stu.age = 21;
		
		Computer c = new Computer();
		c.brand = "联想";
		c.price = 5000;
		c.color = "黑色";
		
		stu.computer = c;
	}
}





