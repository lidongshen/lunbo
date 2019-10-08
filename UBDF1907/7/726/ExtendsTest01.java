package com.uek.extendsTest;
/**
 * 1、动物：	属性：眼睛 ， 名字
 * 						方法：叫
 * 2、哺乳动物：属性：眼睛 ， 名字 ， 
 * 							  方法：哺乳 ， 叫
 * 3、爬行动物： 属性：眼睛，名字
 *                           方法：卵生，叫
 *                       
 *     动物：     animal                    
 *   哺乳动物：mammal
 *   爬行动物:  reptail
 *    哺乳：lactation
 *    卵生：oviparity
 *    
 *    设计问题：冗余 ： 大量重复代码
 *    java语言 ---设计---> "继承"语义 ： 一个类可以去继承另外一个类，
 *    			继承之后的好处，就可以使用继承类中的代码（属性，方法）；
 */
/*class Animal{
	String eye;
	String name;
	public Animal() {
		
	}
	public Animal(String eye , String name) {
		this.eye = eye;
		this.name = name;
	}
	public void cry() {
		System.out.println("动物在叫！");
	}
}
//哺乳动物：
class Mammal{
	String eye;
	String name;
	public Mammal() {
		
	}
	public Mammal(String eye , String name) {
		this.eye = eye;
		this.name = name;
	}
	public void cry() {
		System.out.println("哺乳动物在叫！");
	}
	//哺乳：
	public void lactation() {
		System.out.println("哺乳动物在吃奶！");
	}
}
//爬行动物
class Reptail{
	String eye;
	String name;
	
	public Reptail(String eye, String name) {
		super();
		this.eye = eye;
		this.name = name;
	}
	public void cry() {
		System.out.println("爬行动物在叫！");
	}
	public void oviparity() {
		System.out.println("一只小蛇，破壳而出！");
		
	}
}*/
/**
 * 使用继承来对代码进行重构：
 */
// 抽象概念：动物类--->父类     继承关系
class Animal{
	String eye;
	String name;
	public Animal() {
		
	}
	public Animal(String eye , String name) {
		this.eye = eye;
		this.name = name;
	}
	public void cry() {
		System.out.println("动物在叫！"+eye+","+name);
	}
}
//哺乳动物类 --->子类    extends Animal : 当前类和动物类创建了继承关系
class Mammal extends Animal{
	public Mammal(String eye , String name) {
		super(eye, name);
	}
	//哺乳：
	public void lactation() {
		System.out.println("哺乳动物在吃奶！ "+eye+","+name);
	}
}
//爬行动物类 --->子类
class Reptail extends Animal{
	public Reptail(String eye, String name) {
		super(eye, name);
	}
	public void oviparity() {
		System.out.println("一只小蛇，破壳而出！"+eye+","+name);
	}
}

public class ExtendsTest01 {
	public static void main(String[] args) {
		
		Animal animal = new Animal("蓝色", "动物");
		animal.cry();
		
		Mammal mammal = new Mammal("绿色" , "狼");
		mammal.cry();
		mammal.lactation();
		
		Reptail reptail = new Reptail("黑色", "蛇");
		reptail.cry();
		reptail.oviparity();
	}
}











