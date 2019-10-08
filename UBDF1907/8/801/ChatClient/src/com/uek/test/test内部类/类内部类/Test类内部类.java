package com.uek.test.test内部类.类内部类;

import com.uek.test.test内部类.类内部类.Outer.Inner;
import com.uek.test.test内部类.类内部类.Outer.Inner2;

public class Test类内部类 {
	
	public static void main(String[] args) {
		
		Inner inner = new Outer.Inner();
		
		inner.test();
		
		Inner2 inner2 = new Outer().new Inner2();
		
		inner2.test();
	}
}

class Outer
{	
	boolean abc;
	
	public boolean isAbc() {
		return abc;
	}

	public void setAbc(boolean abc) {
		this.abc = abc;
	}

	static class Inner
	{
		void test()
		{
			System.out.println("test");
		}
		
	}
	
	class Inner2
	{
		void test()
		{
			System.out.println("test");
		}
		
	}
}