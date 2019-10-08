package com.uek.java;
/**
 * 1.设计类的模板：
 * 2.创建类的对象；（2个）
 * 需求：狗类
 * 属性：颜色、身高、重量、年龄（相同：2岁）
 * 方法：eat方法(String food)
 *             show方法()
 */
public class Dog {
	//成员变量/成员属性:
	public String color;
	public double height;
	public double weight;
	public int age = 2 ; //特殊情况，该类所有对象的属性值都一样
	//成员方法：
	//一个方法的设计需要考虑三方面：返回值、方法名、形参列表
	public void eat(String food) {
		System.out.println("我家的狗，爱吃" + food);
	}
	
	public void show() {
		System.out.println("狗的颜色："+color+",身高:"+height+",体重:"+weight);
	}
}

//测试类：
class DogTest{
	public static void main(String[] args) {
		
		//创建对象：
		Dog dog1 = new Dog();
		//赋属性值；
		dog1.color = "黑色";
		dog1.height = 13.5;
		dog1.weight = 20.4;
		//调用方法;
		dog1.eat("骨头");
		dog1.show();
	}
}








