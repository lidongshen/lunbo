package com.uek.test.test匿名内部类;

public class Test匿名内部类 {
	
	
	static void test1(InterfaceA interfaceA)
	{
		interfaceA.testA();
	}
	
	static void test2(AbstractClassA abstractClassA)
	{
		abstractClassA.testAbstractClassAz();
	}
	
	public static void main(String[] args) {
		
		//定义接口不定义实现
		InterfaceA interfaceA = new AClass(); 
		test1(interfaceA);
		
		test1(new InterfaceA() {
			
			@Override
			public void testA() {
				
				System.out.println("匿名内部类 testA is invoked...");
			}
		});
		
		AbstractClassA abstractClassA = new BClass();
		test2(abstractClassA);
		
		test2(new AbstractClassA() {
			
			@Override
			void testAbstractClassAz() {
				
				System.out.println("匿名内部类 testAbstractClassAz is invoked...");
			}
		});
		
		
	}
	
}

class AClass implements InterfaceA
{

	@Override
	public void testA() {
		
		System.out.println("testA is invoked...");
		
	}
	

}

class BClass extends AbstractClassA
{

	@Override
	void testAbstractClassAz() {
		
		System.out.println("testAbstractClassAz is invoked...");
	}

	

}

