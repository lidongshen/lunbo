package com.uek.java2;

public class OOPTest03 {

	/**
	 * 一个学生类：
	 * 		属性：编号，学校，
	 * 		方法：学习
	 * 一个张三类：
	 * 		独有属性：名字，
	 * 		方法：玩耍
	 * 一个李四类：
	 * 		属性：书
	 * 		方法：看书
	 * 
	 * 测试类中：
	 * 		方法1：多态的方式打印方法不同的输出结果
	 * 		方法2：以父类类型作为形参，接收不同的子类对象，打印输出结果
	 * 		方法3：以父类作为方法的返回值，返回不同的子类对象，然后调用方法
	 */
	public static void test1() {
		Student s1 = new ZhangSan(1, "山西工商学院", "张三");
		s1.study(); //
		//s1.play();  父类看不到
		s1 = new LiSi("西厢记");
		s1.study();//
	}
	
/*	public void test2(ZhangSan zs) {
		zs.study();
	}
	public void test2(LiSi ls) {
		ls.study();
	}*/
	
	public void test2(Student stu) {
		stu.study();
	}
	
	/**
	 * 设计模式：工厂模式：生产不同的对象
	 */
	public Student test3(String str) {
		if (str.equals("张三")) {
			return new ZhangSan("张三");
		} else if(str.equals("李四")){
			return new LiSi("三国演义");
		}else {
			System.out.println("输入错误！");
		}
		return null;
	}
	
	public static void main(String[] args) {
		/**
		 * 方法调用：
		 * 1）static方法： 类名.方法名      对象名.方法名
		 * 2）先构建对象，然后再用对象调用成员方法：
		 * 			对象名.成员方法名
		 */
		//OOPTest03.test1();
		//因为static方法和main方法属于同一个类，所以类名可以省略；
		//test1();
		
		OOPTest03 oop = new OOPTest03();
		oop.test1();
		
		ZhangSan zhangSan = new ZhangSan("张三");
		oop.test2(zhangSan);
		LiSi liSi = new LiSi("西游记");
		oop.test2(liSi);
		
		Student student = oop.test3("张三");
		student.study(); 
		student = oop.test3("李四");
		student.study();
	}
	
}

class Student{
	private int id;
	private String school;
	public Student() {
		super();
	}
	public Student(int id, String school) {
		super();
		this.id = id;
		this.school = school;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", school=" + school + "]";
	}
	//成员方法;
	public void study() {
		System.out.println(this.getId()+","+this.getSchool()+" ,在学习");
	}
}

class ZhangSan extends Student{
	private String name;
	public ZhangSan() {
		super();
	}
/*	public ZhangSan(int id , String school , String name) {
		this(name); //调用重载的构造方法，要求必须是第一句？
		//super(id , school); 注意：在构造方法中，this 和super不能同时出现，
		//因为语法要求，必须都第一句，所以把谁放到第二行都报错。
		this.setId(id);
		this.setSchool(school);
	}*/
	
	public ZhangSan(int id , String school , String name) {
		super(id, school);
		this.name = name;
	}
	
	public ZhangSan(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		// 父类属性+子类属性：
		return this.getId()+","+this.getName()+","+this.getSchool();
	}
	//成员方法：
	public void play() {
		System.out.println(this.getId()+","+this.getSchool()+this.getName()+"在玩耍！");
	}
	//成员方法;
	public void study() {
		System.out.println("子类张三重写过的方法");
	}
}

class LiSi extends Student{
	private String book;

	public LiSi() {
		super();
	}

	public LiSi(String book) {
		super();
		this.book = book;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}
	@Override
	public String toString() {
		// 父类属性+子类属性：
		return this.getId()+","+this.getBook()+","+this.getSchool();
	}
	//成员方法：
	public void book() {
		System.out.println(this.getId()+","+this.getBook()+","+this.getSchool());
	}
	//成员方法;
	public void study() {
		System.out.println("子类李四重写过的方法");
	}
}





