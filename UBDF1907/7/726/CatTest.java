package com.uek.extendsTest;
/**
 * 继承练习：
 * 		1、父类：猫
 * 					属性 : 眼睛   颜色
 * 					方法：抓老鼠
 * 		2、子类：小猫
 * 					属性：眼睛  颜色   玩具
 * 					方法：抓老鼠 ，玩耍
 * 注意：在继承条件下，子类对象构建时，先构建子类对象中的父类
 * 				对象，然后才构建子类自己的对象；
 */
class Cat{
	int eye;
	String color;
	public Cat() {}
	public Cat(int eye , String color) {
		this.eye = eye;
		this.color = color;
	}
	public void catchMouse() {
		System.out.println(this.eye +","+this.color+","+"大猫在抓老鼠！");
	}
}
// 继承关系：
class SmallCat extends Cat{
	//子类独有属性：玩具：
	String toy;
	public SmallCat() {
		
	}
	public SmallCat(int eye , String color , String toy) {
		this.eye = eye;
		this.color = color;
		this.toy = toy;
	}
	//子类独有的方法：
	public void play() {
		System.out.println(this.eye +","+this.color+","+this.toy+"小猫在玩耍!");
	}
}

public class CatTest {
	public static void main(String[] args) {
		//构建父类对象：
		Cat cat = new Cat(2 , "黄色");
		cat.catchMouse();
		/**
		 * 独立创建的父类对象，和创建子类时创建的父类对象，二者之间没有任何关系：
		 */
		SmallCat sc = new SmallCat(1 , "黑色" , "小汽车");
		sc.catchMouse();
		sc.play();
		
	}
}










