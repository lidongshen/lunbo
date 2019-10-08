package com.uek;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 *
 */
public class TreeSetTest {

	public static void main(String[] args) {
		
		//1.构建集合对象;
		/**
		 * TreeSet() : 在存储元素时，会调用该元素的CompareTo()方法，通过方法的返回值来决定排序的顺序；
		 */
		Set set = new TreeSet();
		/*set.add(50); // Integer类 Comparable接口 ， compareTo()????
		set.add(20);
		set.add(40);*/
		
/*		set.add("ab");
		set.add("aa");
		set.add("ac");*/
		/**
		 * ava.lang.ClassCastException: com.uek.Stu1 cannot be cast to java.lang.Comparable
		 * 注意：TreeSet要求所有的元素必须要实现Comparable接口，否则就报该异常
		 */
		/**
		 * 1.自然排序;
		 */
/*		set.add(new Stu1("程文盛", 22, 90));
		set.add(new Stu1("李静", 22, 80));
		set.add(new Stu1("庞晓宇", 22, 100));*/
		
		/**
		 * 2.自定义排序;
		 */
		MyCompartor1 m = new MyCompartor1();
		set = new TreeSet(m);
		set.add(new Stu1("程文盛", 22, 90));
		set.add(new Stu1("李静", 28, 80));
		set.add(new Stu1("庞晓宇", 15, 100));
		
		System.out.println(set);
	}
}


//封装一个实现了JDK外部比较器接口的类
class MyCompartor1 implements Comparator{

	/**
	 * 比较策略：学生的年龄，降序
	 */
	@Override
	public int compare(Object o1, Object o2) {
		Stu1 s1 = (Stu1) o1;
		Stu1 s2 = (Stu1) o2;
		/**
		 * 默认情况是升序：this  > other  : 正数
		 * 			降序： this < other : 正数
		 */
		//方式一：
//		if (s1.getAge() > s2.getAge()) {
//			return -1;
//		}else if (s1.getAge() < s2.getAge()) {
//			return 1;
//		}else {
//			return 0;
//		}
		//方式二：默认是升序，所以取反就变成了降序：
		return -Integer.valueOf(s1.getAge()).compareTo(Integer.valueOf(s2.getAge()));
	}
}






