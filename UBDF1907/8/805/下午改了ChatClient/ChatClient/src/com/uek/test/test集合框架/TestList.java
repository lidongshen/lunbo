package com.uek.test.test集合框架;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		//增加
		list.add("aaa");
		list.add(0 , "bbb");//插入 
		list.add("bbb");	//这个地方可以加入 这是和set不一样的地方 原因是 
							//通过index可以区分 所以可以共存
		
		System.out.println(list);
		
		//删除 
		list.remove(1);
		list.remove("bbb");//删除第一个
		
		System.out.println(list);
		
		//修改
		list.set(0, "ddd");
		
		System.out.println(list);
		
		//查询
		
		//查单个
		System.out.println(list.get(0));
		//System.out.println(list.get(1));//也有越界异常
		
		list.add("ccc");
		list.add("ddd");
		list.add("eee");
		list.add("fff");
		
		//查所有 就是遍历
		//1 普通for循环 
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("----------");
		
		//2 foreach循环 
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("----------");
		
		//3 迭代器循环 
		Iterator<String> iter = list.iterator();
		
		while(iter.hasNext())
		{
			System.out.println(iter.next());
			
		}
				
	}
}
