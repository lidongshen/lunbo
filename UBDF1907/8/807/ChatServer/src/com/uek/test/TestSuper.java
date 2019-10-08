package com.uek.test;

public class TestSuper {
	public static void main(String[] args) {
		X v1 = new Y();
		System.out.println(v1.count);//100
		
//		Y v2 = new Y();
//		System.out.println(v2.count);//1000
	}
}

class X
{
	int count = 100;
}

class Y extends X
{
	//field是不会重写父类的 有2个，看申明的类型是父类还是子类
	int count = 1000;
}