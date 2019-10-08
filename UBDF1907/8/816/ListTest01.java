package com.uek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * List接口：
 * 	LinkedList : 底层维护的一个两向链表结构；
 *
 */
public class ListTest01 {
	public static void main(String[] args) {
		
		//构建集合：多态的好处：让程序更加灵活，具有扩展性
		//List list = new ArrayList();
		LinkedList list = new LinkedList();
		list.add("abc");
		list.add(new Integer(100));
		list.add("abc");
		
		//在首节点的位置添加元素：
		list.addFirst("张泽");
		//在末尾节点的位置添加元素：
		list.addLast("范晖");
		//获取首节点元素：
		System.out.println(list.getFirst());
		//获取尾节点元素：
		System.out.println(list.getLast());
		//删除首节点元素：同时返回该元素：
		Object first = list.removeFirst();
		System.out.println(first);
		//删除尾节点元素：同时返回该元素：
		Object last = list.removeLast();
		System.out.println(last);
		
		//将指定的元素插入在列表首节点的位置
		list.push("胡光奎");
		// poll() ； 获取并移除此列表的头（第一个元素）
		list.poll();
		/**
		 * JDBC : Connection
		 *  连接池 : LinkedList 
		 *  push() : 
		 *  poll() ;
		 */
		
		System.out.println(list.toString());
		
	}
}






