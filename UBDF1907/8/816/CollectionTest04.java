package com.uek;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Java集合类 ---> java.util包
 * List 接口：
 *	ArrayList ： 数组类似，有序，可以存储重复的元素 ；（底层维护了一个可变长数组）
 *  数组存储元素时，有序，无序？ 以下标 索引顺序
 */
public class CollectionTest04 {
	public static void main(String[] args) {
		
		// 接口           实现类
		List list = new ArrayList();
		list.add("abc");
		list.add(100);  // 100 =new Integer(100) 
		list.add(true);
		list.add(100);
		list.add(null);
		list.add(null);
		
		/**
		 * List接口方法：
		 */
		//按照指定的下标位，添加元素：
		//List list1 = new ArrayList();
		//list1.add(1, "范晖"); 当插入一个没有任何元素的集合时，指定的下标会出现下标越界
		
		//删除指定下标位的元素：
		list.remove(0);
		//删除指定元素：
		list.remove(new Integer(100));
		
		//指定位置的元素进行修改:
		list.set(2 , false);
		
		//指定查询元素的下标;
		int indexOf = list.indexOf(null);
		System.out.println(indexOf);
		
		//指定下标找元素;
		Object object = list.get(2);
		System.out.println(object);
		
		//遍历集合：
		System.out.println(list.toString());
		
		/*Iterator iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}*/
	}
}








