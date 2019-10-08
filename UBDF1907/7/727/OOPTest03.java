package com.uek.java2;
/**
 *  基本数据类型的类型转换：
 *  	1）向上自动转换：容量小 ---> 容量大
 *  	2）向下强制转换: 容量大 ---> 容量小（精度损失）
 *  
 *   引用类型的类型转换：
 *  	1）向上自动转换：子类类型 ---> 父类类型;
 *  	2)  向下强制转换:   父类引用 --->子类类型;
 */
public class OOPTest03 {
	public static void main(String[] args) {
		//向上自动转换:
		Aniaml a = new Dog();
		//向下强制转换:
		Dog dog = (Dog)a;
		
		a = new Cat();
		//转换吗？ 猫变成一只狗
		//一般在强制转换之前，都要进行类型判断，防止出现类型转换异常：
		/**
		 * ClassCastException : 类型转换异常：
		 */
		if (a instanceof Dog) {
			Dog dog1 = (Dog)a;
			System.out.println(dog1);
		}
		
		Cat cat = new Cat();
		
		/**
		 *  instanceof : 判断类型的关键字：
		 *  例：cat instanceof Dog :  cat 是Dog的类型吗？ true  false
		 */
		System.out.println(cat instanceof Aniaml); // 因为继承，true
		System.out.println(cat instanceof Cat); //true
		//System.out.println(cat instanceof Dog); // false
	}
}
