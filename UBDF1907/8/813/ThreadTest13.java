package com.uek;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Threads extends Thread{
	public Threads() {}
	public Threads(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+" , "+i);
		}
	}
}

class MyThread15 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("子线程！");
		}
		
	}
} 

public class ThreadTest13 {

	public static void main(String[] args) {
		
		//第一种:添加继承Thread类的线程对象：
		/*Threads t1 = new Threads("子线程1");
		Threads t2 = new Threads("子线程2");
		Threads t3 = new Threads("子线程3");*/
		
		//第二种：实现runnable接口的实现类的线程类对象;
		MyThread15 m = new MyThread15();
		Thread t1 = new Thread(m);
		Thread t2 = new Thread(m);
		Thread t3 = new Thread(m);
		
		//1. 线程池特点;可以存放5个线程：
		//newFixedThreadPool(int num) ； 构建指定线程数量的线程池
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		//通过调用线程池父类的executor方法来为当前线程池中添加线程：
		// execute ：在该方法中会调用submit方法，submit方法中会调用每一个
		//线程池中的线程的start方法，从而启动每一个线程；
		threadPool.execute(t1);
		threadPool.execute(t2);
		threadPool.execute(t3);
		//关闭线程池：
		threadPool.shutdown();
		
		//2. newCachedThreadPool() : 构建一个可以存放无限线程的线程池；
		/*ExecutorService threadPool2 = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			threadPool2.execute(new Threads());
		}*/

		//3. newScheduledThreadPool(int corePoolSize) : 构建一个可以定时执行线程的线程池：
		//int corePoolSize  ：线程数
	/*	ScheduledExecutorService threadPool2 = Executors.newScheduledThreadPool(5);
		for (int i = 0; i < 5; i++) {
			threadPool2.schedule(new Threads() , 3, TimeUnit.SECONDS);
		}*/
		
		/**
		 * 4. 创建一个单线程化的线程池，
		 *  它只会用唯一的工作线程来执行任务，
		 *  保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
		 *  执行结果：只存在一个线程，顺序执行;
		 */
		
	 /*ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
     singleThreadExecutor.execute(new Threads());
     singleThreadExecutor.execute(t1);*/
     
		
		
	}
}
