package com.uek.test;

import java.util.HashMap;

public class TestA{
	public static void main(String[] args){
	
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "zs");
		map.put(2, "ls");
		
		int a = 1;
		
		System.out.println(map.get(a));
		
//		String str = "1,1,2;";
//		
//		String[] strs = str.split(";");
//		
//		System.out.println(strs.length);
//		
//		for (String string : strs) {
//			System.out.println(string);
//		}
		
	}
	
}
