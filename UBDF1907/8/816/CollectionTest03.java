package com.uek;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 迭代器：
 *
 */
public class CollectionTest03 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("uek");
		c.add("UEK");
		//使用迭代器来遍历集合中的元素：
		//1)获取迭代器的对象：
		Iterator iter = c.iterator();
		//2) 添加判断的条件; 集合中是否还有元素：
		//iter.hasNext() : 游标所在位置，还有没有下一个元素存在
		while(iter.hasNext()) {
			//3) 将游标移动到下一个位置的同时，获取游标所在位置的前一个元素：
			System.out.println(iter.next());
		}
		
		Collection c1 = new ArrayList();
		c1.add(new String("abc"));
		c1.add(new String("def"));
		c1.add(new String("xyz"));
		
		Iterator iterator = c1.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		List c2 = new ArrayList();
		c2.add(new Book("金瓶梅" , 49.5));
		c2.add(new Book("三国演义" , 80.6));
		c2.add(new Book("西游记" , 90.6));
		c2.add(new Book("红楼梦" , 60.6));
		
		/**
		 * 1) 对当前集合的元素进行遍历：迭代器
		 * 2）对元素进行排序: 价格降序
		 * get(int index) 
              返回此列表中指定位置上的元素。
           set(int index, E element) 
          	用指定的元素替代此列表中指定位置上的元素；
		 */
		for(int i=0;i<c2.size() - 1;i++) {
			for (int j=0;j<c2.size()-i-1;j++) {
				//比较策略：
				Book b1 = (Book)c2.get(j);
				Book b2 = (Book)c2.get(j+1);
				if (b1.getPrice() < b2.getPrice()) {
					//位置交换：
					c2.set(j, b2);
					c2.set(j+1 ,b1);
				}
			}
		}
		
		Iterator iter1 = c2.iterator();
		while(iter1.hasNext()) {
			System.out.println(iter1.next());
		}
		
		/**
		 * 注意点：集合特点
		 * 	1）在没有指定泛型的情况下，集合中存储元素时，都以Object类型对待;
		 * 	2）在集合存储元素时，如果元素的类型是基本类型，那么会自动装箱；
		 *	3）在集合中，存储的元素都是引用类型；
		 */
		List list = new ArrayList();
		list.add("uek"); //"uek" --->Object
		list.add(true); // boolean ---> Boolean ---> Object
		list.add(100); // int ---> Integer ---> Object
		//get(int index):
		Object object = list.get(0);
		
		
		
		
	}
}
