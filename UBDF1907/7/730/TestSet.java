package com.uek.test.test集合框架;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
	
	public static void main(String[] args) {
		
		Set set = new HashSet();	
		set.add(1);
		set.add("zsss");
		set.add(1);//不能存储重复元素
		
		System.out.println(set);
		
		//<>是泛型语法 限定容器只能存储String类型的数据
		Set<String> set1 = new HashSet<String>();
		//set1.add(1);
		
		set1.add("aaa");
		set1.add("bbb");
		set1.add("ccc");
		set1.add("ddd");
		set1.add("ccc");
		
		System.out.println(set1);
		
		//对于集合容器，希望大家掌握 增删改查 crud create read update delete
		
		//删除bbb
		set1.remove("bbb");
		
		System.out.println(set1);
		
		//查询存不存在aaa
		System.out.println(set1.contains("aaa"));
		
		
		//遍历 查询所有 
		//通过foreach遍历
		for (String string : set1) {
			System.out.println(string);
		}
		
		System.out.println("----------------");
		
		//通过迭代器 遍历
		Iterator<String> iter = set1.iterator();
		
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		
		System.out.println(set1.size());
		
		
	}
}
