package com.uek;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 回顾;
 * 1.Java集合：
 * 	两大体型：Collection体系 ： 作为数据结构，存储的是一列元素；
 * 			  map体系：存储每一个元素都包含两部分（两个对象） ， 分为键（Key） , 值（value） 
 * 2.Collection接口：List接口、Set接口
 * 		List接口 ： 有序（支持索引）,可重复元素 ，可以存储null；
 * 			ArrayList : 可变数组（动态扩容），增删效率低，查询效率高；
 * 			LinkedList : 双向链表（一个节点由三部分构成），增删效率高，查询效率低；
 * 			Vector : 和ArrayList功能一样，但是它是线程安全的，效率低； 
 * 		Set接口：无序（没有索引，在存储元素时，是根据元素的hash值进行hash算法求出一个位置）
 * 				 可以存储null；
 *               不可重复；
 *          HashSet : 
 *          
 * 补充：按照索引查找元素的速度快，还是按照hash值查找元素的速度快？
 *       按照索引来查的时候，是需要计算的；
 *       但是hash值不需要计算，直接定位到元素；
 *       
 * 注意：JavaBean（实体类）编写规范：
 * 		在编写一个类的模板时，一般要重新toString() ,equals() , hashCode()
 */

class Stu{
	private String name;
	private int age;
	public Stu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stu(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Stu [name=" + name + ", age=" + age + "]";
	}
	
/*	@Override
	public int hashCode() {
		final int prime = 31; // 素数：只能让1和本身整除
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stu other = (Stu) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}*/
	
	/**
	 * hashCode方法：返回hash值，代表的就是对象在内存中的位置
	 *     默认情况下，所有在堆中的对象的地址都是唯一的；
	 * 重写hashCode方法的思路：
	 * 	将对象的所有属性的hash值进行累加，求出一个累加和；
	 * 
	 * 二次hash ： 就对object类实现的hashCode方法进行重写，求出一个新的hash值，
	 * 			而该hash值，并不是对象在内存中存储的地址，仅仅是使用新的hash值，
	 * 			来决定存储在哈希表中的哪一个位置；
	 */
/*	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}
	
	*//**
	 * 重写equals方法的思路;
	 * 	比较对象之间的所有属性，是否相同，如果有一个属性值不同，那么返回false;
	 * 	如果全部相同，返回true；
	 */
	@Override
	public boolean equals(Object obj) {
		/*//强制转换：
		if (obj instanceof Stu) {
			Stu s = (Stu)obj;
			//比较;
			if (this.name.equals(s.name)) {
				return true;
			}
			if (this.age == s.age) {
				return true;
			}
		}
		return false;*/
		
		return true;
	}
	
	
	
}

public class SetTest {
	
	public static void main(String[] args) {
		
		//1.创建集合对象;
		Set set = new HashSet();
		//添加元素：
		/*set.add("uek");
		set.add("uek");
		set.add(100);
		set.add(null);
		//覆盖：
		set.add(null);*/
		/**
		 *  1.当HashSet在存储元素时，首先调用该对象的hashCode方法，返回一个hash值，根据
		 *  该hash值来决定存储在哈希表中的哪个位置；
		 *  如果hashCode方法返回的hash值不同时，就调用equals方法继续比较了，hashSet直接把该元素直接添加到哈希表中
		 *  如果hashCode方法返回的hash值相同时，那么再调用equals方法来进行判断
		 *  2.当调用完hashcode方法后，还会调用equals方法，来判断集合中的元素和当前对象的属性值是否
		 *    相同，如果相同，新元素就覆盖了旧元素，如果不同，就把新元素添加进去；
		 *  补充：如果只重写hashCode方法，并没有重写equals方法，那么equals方法比较的是对象之间的地址；
		 */
		Stu s1 = new Stu("范晖" , 23);
		Stu s2 = new Stu("范晖" , 23);
		//Stu s2 = new Stu("张泽" , 22);
		System.out.println(s1.hashCode()); 
		System.out.println(s2.hashCode());
		System.out.println(s1 == s2);  // false
		
		set.add(s1);
		set.add(s2);
		
		/**
		 * 问题1：根据hashset结构的宗旨 ；存储不同的元素，但是现在多个对象封装的数据完全一样，
		 * 		理论上是不应该存储到hashset集合中的，？
		 * 答案: 1）重写hashCode方法；
		 * 		 2）重写equals方法：
		 */
		
		//迭代器遍历：
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		//注意: 作为数值型的对象，hash值就是数值本身；
/*		int num = 10;
		Integer i = num; //自动装箱
		System.out.println(i.hashCode()); // 10
*/		
		
	}
	
}










