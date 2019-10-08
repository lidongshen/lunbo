package com.uek.java;
/**
 * 需求：书
 * 			属性：名字，价格，读者，出版社
 * 			方法: 类方法（对类成员进行赋值：读者：18岁以下，出版社：人民出版社）
 *                   成员方法介绍：
 *          5个对象：前三个对象 ，后两个对象（读者：猥琐男 ，出版社：地下出版社）
 */
//类的模板：
class Book{
	//1. 成员变量
	String name;
	double price;
	//2. 类变量:
	static String reader;
	static String press;
	//3.构造方法
	public Book() {
		
	}
	//谨记 ：  所有的对象共享类变量：
	public Book(String _name , double _price) {
		name = _name;
		price = _price;
	}
	
	//4 .类方法：功能是给类变量赋值
	public static void setField(String _reader , String _press) {
		reader =  _reader;
		press = _press;
	}
	
	//5. 成员方法：打印输出：
	public void print() {
		System.out.println(name +","+ price +","+reader+","+press);
	}
}

public class StaticTest02 {
	public static void main(String[] args) {
		
		//1. 给类变量进行赋值：
		/**
		 * 语法：
		 * 1）类名.类属性；    类级别，
		 *       类名.类方法();
		 * 2) 对象名.类属性；     不建议对象级别调用
		 *       对象名.类方法();
		 */
		Book.setField("18以下读者" ,  "人民出版社");
		System.out.println(Book.reader+","+Book.press);
		Book b1 = new Book("金瓶梅" , 50.0);
		Book b2 = new Book("西游记" , 50.0);
		b1.print();
		b2.print();
		//类变量赋值：
		Book.setField("猥琐男", "地下出版社");
		Book b3 = new Book("java编程思想"  , 50.5);
		Book b4 = new Book("疯狂Java"  , 90.0);
		b3.print();
		b4.print();
	}
}







