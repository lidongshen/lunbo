package com.uek.test;

/**
 * 设计模式：是前人总结出来的某种场景下的最佳设计，最佳编程思路。
 * 
 * 单例设计模式：设计一个类，在系统中只存在一个该类的实例
 * 
 * @author UEK-N
 *
 */
public class TestSingleTon {
	
	public static void main(String[] args) {
		
		SingleTon s1 = SingleTon.getInstance();//new SingleTon();
		SingleTon s2 = SingleTon.getInstance();//new SingleTon();
		
		System.out.println(s1 == s2);
		
		SingleTon.getInstance().testMethod();
	}

}


class SingleTon
{
	//3 把内部产生的唯一的实例 缓存起来
	//private static SingleTon instance;//懒汉式单例设计模式 
	private static SingleTon instance = new SingleTon();//饿汉式
	
	//1 构造器私有化
	private SingleTon()
	{
		
	}
	
	//2 提供一个公开的方法，获取内部产生的唯一实例
	public static SingleTon getInstance()
	{
//		if(instance == null)
//		{
//			instance =  new SingleTon();
//		}
		
		return instance;
	}
	
	void testMethod()
	{
		System.out.println("单例类的实例方法被调用了");
	}
	
	
	
	
	

}