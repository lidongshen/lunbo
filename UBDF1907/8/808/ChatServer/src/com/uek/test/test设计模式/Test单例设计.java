package com.uek.test.test设计模式;

public class Test单例设计 {
	
	public static void main(String[] args) {
		
		SingleTon s1 = SingleTon.getInstance(); 
		SingleTon s2 = SingleTon.getInstance(); 
		
		System.out.println(s1 == s2);
	}
}

class SingleTon
{
	//3 缓存
	private static SingleTon instance;
		
	//1 私有化构造器
	private SingleTon() {
		
	}
	//2 内部new唯一实例，提供给外部使用
	public static SingleTon getInstance()
	{
		if(instance == null)
		{
			instance = new SingleTon();
		}
		
		return instance;
	}
	
	
}
