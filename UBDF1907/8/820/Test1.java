package com.uek;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 泛型语法：
 */
public class Test1 {
	
	public static void main(String[] args) {
		
		/**
		 * 泛型的4种语法：
		 */
		//JDK1.7之前的语法： 最规范的语法 , 推荐使用
		Set<String> set = new HashSet<String>();
		Map<String , String> map = new HashMap<String , String>();
		
		//JDK1.7之后的语法： 对于泛型添加了 自动推断类型的功能
		Set<String> set1 = new HashSet<>();
		set1.add("uek");
		//set1.add(100);
		
		//了解即可;
		Set<String> set2 = new HashSet();
		set2.add("uek");
		//set2.add(100);
		
		//该语法虽然添加了泛型的类型，但是无效；该语法了解即可；
		Set set3 = new HashSet<String>();
		set3.add("uek");
		set3.add(100);
		System.out.println(set3);
		
	}
}
