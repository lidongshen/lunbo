package com.uek;

import java.util.Arrays;

/**
 *  手写实现外部比较器，内部比较器；
 *  JDK已经提供好了，所以我们可以直接调用；
 */
class Dog1 implements Comparable{
	
	String name;
	
	/**
	 * 比较方法：自定义比较策略: 比较名字的大小，升序排序
	 *   比较字符串：compareTo();
	 *   
	 */
	@Override
	public int compareTo(Object o) {
		Dog1 d = null;
		if (o instanceof Dog1) {
			d = (Dog1) o;
		}
		//String类已经实现的比较方法；
		/**
		 * 1）this.name > d.name : 正数
		 * 2）this.name < d.name : 负数
		 * 3）this.name = d.name : 0
		 * 总结：作为内部比较器的compareTo方法，所有类的实现都是以上的规律；
		 * 		因为内部比较器本身就是一种自然排序（升序）；
		 */
		return this.name.compareTo(d.name);
	}

	public Dog1(String name) {
		super();
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}

public class StringComparer {

	public static void main(String[] args) {
		
		/*String str = "abcd";
		//String str2 = "abcd";
		String str1 = "def";
		int result = str.compareTo(str1);
		System.out.println(result);*/
		
		Dog1[] dog = {new Dog1("ab") , new Dog1("ac") , new Dog1("aa")};
		for (int i = 0; i < dog.length - 1; i++) {
			for (int j = 0; j < dog.length -i -1; j++) {
				if (dog[j].compareTo(dog[j+1])  > 0) {
					Dog1 temp = dog[j];
					dog[j] = dog[j+1];
					dog[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(dog));
		
		
	}
}








