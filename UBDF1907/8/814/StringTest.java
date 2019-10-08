package com.uek1;

import javax.sound.midi.Synthesizer;

public class StringTest {
	public static void main(String[] args) {
		
		String s1 = "java";
		String s2 = "java";
		String s3 = new String("java");
		String s4 = new String("java");
		System.out.println(s2 == s3); // false
		System.out.println(s1 == s2); // true
		System.out.println(s1.equals(s3)); //true
		System.out.println(s3 == s4); //false
		
		/**
		 * 特殊情况;
		 */
		//如果两个字符串常量在拼接过程中，编译器会进行优化："ab" + "cd" = ”abcd“;
		String s5 = "ab" + "cd"; 
		String s55 = "ab";
		//如果字符串变量在做拼接，底层会构成StringBuffer对象来进行拼接
		//StringBuffer sb = new StringBuffer("ab");
		//sb.append("cd"); ---> abcd 可变字符串 
		String s56 = s55 + "cd";
		String s6 = "abcd";
		System.out.println(s5 == s6); //true
		System.out.println(s56 == s6);//false
		
		String s7 = "hello"; // final value[] = {'h','e','l','l','o'}
		String s8 = "world";
		String s9 = "helloworld";
		System.out.println(s9 == (s7 + s8)); //false
		System.out.println(s9.equals(s7 + s8)); //true
		System.out.println(s9 == "hello" + "world"); //true
		System.out.println(s9.equals("hello" + "world"));//true
		
		
	}
}
