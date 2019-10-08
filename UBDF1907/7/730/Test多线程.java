package com.uek.test.test多线程;

/**
 * 多线程编程
 *   多线程类比多进程：cpu在同时运行多个程序，但是实际上cpu不可能同时运行多个
 *   程序，你看到的同时，实际是cpu在不同的程序之间进行切换，只不过切换的比较
 *   快，人类根本感觉不到。所以以为是同时。
 *   
 *   现在电脑可能多cpu，这个时候确实可能并行，4核cpu，同时最多4个程序运行
 *   这个是正在的并行（真正的同时 多cpu），实际上更多的是并发（假象 切换）。
 *   	
 * 	java程序启动 至少2条线程 main线程和垃圾回收线程
 * 
 * 
 *   线程的状态
 *   									阻塞状态blocked 
 *   
 *   	新建状态new--runable等待状态（可以获取cpu）-----running正在运行----死亡
 *   
 * @author UEK-N
 *
 */
public class Test多线程 {
	public static void main(String[] args) {
		
		//创建一个线程类
		Thread t1 = new SingThread();
		
		//启动线程
		t1.start();
		
		t1.run();//直接调用run方法，是不能够启动线程的
		
		for (int i = 0; i < 1000; i++) {
			System.out.println(i+"-------打游戏！！！");
		}
		
//		//创建一个线程类
//		Thread t1 = new SingThread();
//		
//		//启动线程
//		t1.start();
	}
}

class SingThread extends Thread
{
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(i+"=======听歌！！！");
		}
	}
}
