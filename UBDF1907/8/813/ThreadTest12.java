package com.uek;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//1.创建实现类，实现callable接口
class MyThreads implements Callable{

	//2.call() : 实现类重写callable接口的方法：
	@Override
	public Object call() throws Exception {
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				sum += i;
				System.out.println(sum);
			}
		}
		return sum; //自动装箱 int --> Integer 引用类型
	}
	
/*	@Override
	public Object call() throws Exception {
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
		return null; 
	}*/
}

public class ThreadTest12 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//3.创建实现类对象：
		MyThreads m = new MyThreads();
		//4.实现类依赖于FutureTask对象，才能够将call方法的返回值获取；
		FutureTask futureTask = new FutureTask(m);
		//5. 依赖于Thread类对象才能真正构建一个线程;
		Thread t1 = new Thread(futureTask);
		t1.start();
		
/*		//6.对方法的返回值进行操作，可以缺省的；
		//多态：Object -》 Integer
		Object object = futureTask.get();
		System.out.println(object.toString()); //地址
*/	}
}





