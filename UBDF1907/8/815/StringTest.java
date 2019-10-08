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
		
		/**
		 * String类方法：
		 */
		String str1 = "shanxishengyouyike";
		//长度：length()
		System.out.println(str1.length());
		//获取指定下标位置的字符：charAt(int index)
		/**
		 * "abc"  == char[] arr{'a' , 'b' , 'c'}
		 */
		System.out.println(str1.charAt(2)); //a
		//判断两个字符串内容是否一样:equals()
		System.out.println(str1.equals("abc"));
		//忽略大小写判断：
		System.out.println(str1.equalsIgnoreCase("abc"));
		//比较两个字符串的内容的大小：abc < abcd
		System.out.println("abcde".compareTo("abc")); 
		//在字符串中查找指定的子字符串,返回索引：sheng
		//如果查到，返回第一次出现的下标 ，如果没有返回-1
		System.out.println(str1.indexOf("sheng")); //
		//查找指定的子字符串最后出现的位置：
		System.out.println(str1.lastIndexOf("sheng"));
		//判断是否以xxx为开始的字符串：
		System.out.println(str1.startsWith("shan"));
		//判断是否以xxx为结束的字符串：
		System.out.println(str1.endsWith("youyike"));
		
		str1 = "shanxishengyouyikeshanxi";
		//从源字符串中，截取子字符串：subString();
		System.out.println(str1.substring(11));
		//指定起始位置和结束位置; 
		//注意：指定的下标位：含头不含尾  [6,10)
		System.out.println(str1.substring(6, 11));
		//替换：youyike --> UEK
		//System.out.println(str1.replace('s', 'S'));
		//可以直接替换一个字符串:
		System.out.println(str1.replace("youyike", "UEK"));
		//可以将匹配到的字符串全部更换：SHANXIshengyouyikeSHANXI
		System.out.println(str1.replace("shanxi", "SHANXI"));
		
		String str2 = "  abc  ";
		//去掉字符串前后的空格：
		System.out.println(str2.trim());
		// "abc" , "def" : 字符串拼接；
		System.out.println("abc" + "def");
		System.out.println("abc".concat("def"));
		//判断一个字符串中是否包含有某一个子字符串：
		str1 = "shanxishengyouyike";
		if (str1.contains("sheng")) {
			System.out.println("包含");
		}
		str1 = "张三=20,李四=30";
		//获取“张三=20” ， “李四=30”子串：
		String[] split = str1.split(",");
		for(String str : split) {
			//str = 张三=20
			String[] split2 = str.split("=");
			for (String str11 : split2) {
				System.out.println(str11);
			}
		}
		
		
		
	}
}









