package com.uek.test;

import java.util.HashMap;

public class TestA{
	public static void main(String[] args){
	
		HashMap<Integer, String> testMap = new HashMap<>();
		testMap.put(1, "zs");
		testMap.put(2, "ls");
		testMap.put(3, "ww");
		
		System.out.println(testMap.get(1));
		
		System.out.println(testMap.get("1"));
		
	}
	
}
