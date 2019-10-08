package com.uek.packaging2;

/**
 *  图书：
 *  
 */
class Book{
	//成员变量
	private String name;
	private String author;
	private String press;
	private double price;
	
	public Book() {
		
	}
	
	public Book(String name , String author , String press , double price) {
		this.name = name;
		this.author = author;
		this.press = press;
		//可以在构建对象的过程中，添加业务逻辑
		if (price > 50 || price < 10) {
			System.out.println("提示：输入有误");
		}
		this.price = price;
	}
	
	//set方法：
	public void setName(String name) {
		//业务逻辑，来进行控制：
		if (name.length() > 10) {
			System.out.println("提示：输入有误");
		}
		this.name = name;
	}
	
	public void setAuthor(String author) {
		System.out.println("要求作者是著名编辑人员");
		this.author = author;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public void setPrice(double price) {
		if (price > 50 || price < 10) {
			System.out.println("提示：输入有误");
		}
		this.price = price;
	}
	
	//成员方法：
	public void info() {
		System.out.println("书名:" +this.name+",作者："+author+","
					+",出版社："+press+",价格："+price);
	}
}

public class PackagingTest1 {
	public static void main(String[] args) {
		
		//两种方式来为对象的属性赋值：
		Book b1 = new Book();
		//外界使用类暴露出来的接口，来为当前创建的对象的属性赋值：
		b1.setName("金瓶梅");
		b1.setAuthor("范晖");
		b1.setPress("地下出版社");
		b1.setPrice(50.5);
		
		b1.info();
		
		Book b2 = new Book("三体", "刘子新", "人民出版社", 40);
		b2.info();
	}
}
































