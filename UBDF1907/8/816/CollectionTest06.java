package com.uek;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 需求：构建自定义类型对象，然后存储到List中：
 * 类：Cat ：color name , weight
 * 封装方法：1）遍历；迭代器，增强for
 * 			 2）排序；
 */
public class CollectionTest06 {
	
	public static void main(String[] args) {
		
		Cat cat1 = new Cat("黑", "小黑", 1.5);
		Cat cat2 = new Cat("黑", "小黑", 1.0);
		Cat cat3 = new Cat("黑", "小黑", 2.0);
		//1) 构建集合对象：
		List list = new ArrayList();
		//将cat对象添加到集合中：
		list.add(cat1);
		list.add(cat2);
		list.add(cat3);
	
		List list1 = new ArrayList();
		//将cat对象添加到集合中：
		list1.add(new Cat("黑", "小黑", 1.5));
		list1.add(new Cat("黑", "小黑", 1.0));
		list1.add(new Cat("黑", "小黑", 2.0));
		
		CollectionTest06 cc = new CollectionTest06();
		//cc.foreach1(list1);
		//cc.foreach2(list1);
		List list2 = cc.sort(list1);
		System.out.println(list2.toString());
		
	}
	
	/**
	 * 方法的设计：3方面： 方法的返回值 ， 方法名 ，形参
	 */
	//迭代器：
	public void foreach1(List list) {
		Iterator iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	//增强for:
	public void foreach2(List list) {
		for(Object obj : list) {
			Cat cat = (Cat) obj;
			System.out.println(cat);
		}
	}
	
	//冒泡排序：
	public List sort(List list) {
		for(int i=0;i<list.size()-1;i++) {
			for(int j=0;j<list.size()-1-i;j++) {
				Cat c1 = (Cat) list.get(j);
				Cat c2 = (Cat) list.get(j+1);
				if (c1.getWeight() > c2.getWeight()) {
					list.set(j, c2);
					list.set(j+1, c1);
				}
			}
		}
		return list;
	}
	
}





class Cat{
	private String color;
	private String name;
	private double weight;
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cat(String color, String name, double weight) {
		super();
		this.color = color;
		this.name = name;
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Cat [color=" + color + ", name=" + name + ", weight=" + weight + "]";
	}
}

