package com.uek;
/**
 * 子线程打印1-100
 * @author UEK-N
 *
 */
//1. 1）定义子类，实现Runnable接口。
//继承 ： is a  : 子类是父类的一种；
//实现： has a : 接口有一种实现类； 接口：多个实现类
class MyThread6 implements Runnable{
	//2）子类中重写Runnable接口中的run方法。
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+" , "+i);
		}
	}
	
}

public class RunnableTest {
	public static void main(String[] args) {
		
		/**
		 * 
			3)创建实现Runnable接口的类的对象，然后创建Thread类对象，通过有参构造器
			将自定义的类传递给Thread类对象；
		 */
		MyThread6 m = new MyThread6();
		//m.start(); //因为start启动线程的方式是Thread类的，
		//所以必须要依赖于Thread类的start方法才能启动子线程；
		//创建了一个线程类对象：
		Thread t = new Thread(m);
		//4 )调用Thread类的start方法：开启线程，调用Runnable子类接口的run方法。
		t.start();
	}
}
