package com.uek.java;

/**
 *  static关键字：
 * 需求：学生类：
 *                      属性：学号：
 *                      			名字：
 *                                  性别：
 *                                  系：     计算系
 *                                  学校：山西工商学院
 *             10个对象：自我介绍                               
 */
class Stu{
	int id;
	String name;
	char sex;
	static String xi;   //成员变量 ---> 类变量   （类属性（静态属性））
	static String school; //类属性（静态属性）
	
	public Stu() {
		
	}
	
	public Stu(int _id , String _name , char _sex ) {
		id = _id;
		name = _name;
		sex = _sex;
	}
	
	public Stu(int _id , String _name , char _sex , String _xi , String _school) {
		id = _id;
		name = _name;
		sex = _sex;
		xi = _xi;
		school = _school;
	}
	public void info() {
		System.out.println(id+","+name+","+sex+","+xi+","+school);
	}
	
	//类方法:
	public static void test() {
		System.out.println("我是静态方法/类方法");
	}
	
}

//测试类
public class StaticTest {

	public static void main(String[] args) {
		
		Stu.xi = "计算机系";
		Stu.school = "山西工商学院";
		Stu s1 = new Stu(1 , "张泽1" , '男' ); //考研失败
		s1.info();
		Stu s2 = new Stu(2 , "张泽2" , '男' );
		Stu.school = "中北大学";
		Stu s3 = new Stu(3 , "张泽3" , '男'  );
		Stu s4 = new Stu(4 , "张泽4" , '男' );
		Stu s5 = new Stu(5 , "张泽5" , '男' );
		s2.info();
		s3.info();
		s4.info();
		s5.info();
	}
}
