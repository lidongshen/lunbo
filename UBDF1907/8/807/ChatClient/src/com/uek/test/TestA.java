package com.uek.test;

public class TestA{
	public static void main(String[] args){
	
		String str = "1,1,2;";
		
		String[] strs = str.split(";");
		
		System.out.println(strs.length);
		
		for (String string : strs) {
			System.out.println(string);
		}
		
	}
	
}
