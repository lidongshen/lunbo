package com.uek.java2;
/**
 * 面向对象之多态：
 * 	   
 *
 */
class Aniaml{
	private String color;
	private int age;
	private String name;
	//功能：以字符串的形式返回对象封装的数据：
	@Override
	public String toString() {
		return "Aniaml [color=" + color + ", age=" + age + ", name=" + name + "]";
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Aniaml(String color, int age, String name) {
		super();
		this.color = color;
		this.age = age;
		this.name = name;
	}

	public Aniaml() {
		super();
	}

	public void eat() {
		System.out.println(name+",吃！");
	}
	
	public void sleep() {
		System.out.println("为"+color+"颜色的动物在睡觉");
	}
}

class Dog extends Aniaml{
	private String eyeColor;
	public String getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public Dog(String color, int age, String name, String eyeColor) {
		//调用父类构造方法：
		super(color, age, name);
		this.eyeColor = eyeColor;
	}

	public Dog() {
		super();
	}

	public void cry() {
		System.out.println(this.getName()+"的狗正在叫！");
	}
	
	@Override
	public void eat() {
		System.out.println("小黑狗在吃肉！");
	}
	@Override
	public void sleep() {
		System.out.println("小黑狗在睡觉");
	}
	
	@Override
	public String toString() {
		return "Dog:"+this.getColor()+","+this.getAge()
		     +","+this.getName()+","+eyeColor;
	}
}

class Cat extends Aniaml{
	private int length;

	public Cat() {
		super();
	}
	public Cat(String color, int age, String name, int length) {
		super(color, age, name);
		this.length = length;
	}

	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	@Override
	public String toString() {
		return "Cat:"+this.getColor()+","+this.getAge()
		     +","+this.getName()+","+length;
	}
	
	public void run() {
		System.out.println(length+"的花猫在活蹦乱跳！");
	}
	@Override
	public void eat() {
		System.out.println("小花猫在吃肉！");
	}
	@Override
	public void sleep() {
		System.out.println("小花猫在睡觉");
	}
}


public class OOPTest01 {
	
	/**
	 *  在多态的语法下，调用不同的子类对象重写过的方法：
	 *  多态的应用场景2：以父类类型的引用，作为方法的形参来接收不同的子类对象
	 */
/*	public static void test(Dog dog) {
		dog.eat();
		dog.sleep();
	}
	
	public static void test(Cat cat) {
		cat.eat();
		cat.sleep();
	}*/
	
	public static void test(Aniaml aniaml) {
		aniaml.eat();
		aniaml.sleep();
	}

	//特点：父类类型作为方法的返回值类型：
	public static Aniaml product() {
		Dog dog = new Dog("黑色", 1, "小黑", "黑色");
		Cat cat = new Cat("黄色",2,"小黄",20);
		return cat;
	}
	
	
	public static void main(String[] args) {
		//需求:构建两个子类对象，同时赋值，然后调用相应的方法：
/*		Dog dog = new Dog("黑色", 3, "小黑狗", "红色");
		dog.cry(); //调用独有方法
		dog.eat();
		dog.sleep();
		System.out.println(dog);
		
		Cat cat = new Cat("棕色", 2, "小花猫", 10);
		cat.run();//调用独有方法
		cat.eat();
		cat.sleep();
		System.out.println(cat);
		*/
		//构建对象：
		//使用多态的语法来实现：
		//多态语法使用场景：1）父类引用指向子类对象；
	/*	Aniaml a1 = new Dog("黑色", 2, "小花", "黑红色");
		a1.eat();
		a1 = new Cat("黄色" , 3 , "小黄" , 20);
		a1.eat();*/
		
		//2) 父类引用不能调用子类独有的成员，
		//因为在内存中，父类引用是看不见子类独有成员；
	//	a1.run();
	//	a1.getlength();
		
		//1)  动物类：
		/*Aniaml aniaml = new Aniaml("黑色", 5, "大牛");
		test(aniaml);*/
		//2)Dog类：eat()   sleep();
		/*Dog dog = new Dog("黑色", 3, "大狗", "黑色");
		test(dog);
		
		Cat cat = new Cat("黄色",2,"小黄",20);
		test(cat);*/
		
		Aniaml aniaml = product();
		aniaml.eat(); 
		
	}
}






