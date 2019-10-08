package com.uek1;

import java.util.Arrays;

public class StringTest01 {

	public static void main(String[] args) {
		
		//案例1：保存一个邮箱字符串，
		//进行验证：长度>6 并且里面包含@和. 并且@在.的前面
		String s = "wergh@126.com";
		//思路:
		int index1 = s.indexOf("@"); // -1
		int index2 = s.indexOf(".");
		if (s.length() > 6 && index1 > -1 && index2 > -1 && index1 < index2 ) {
			System.out.println("邮箱合法");
		} else {
			System.out.println("邮箱不合法");
		}
		
		//输入一个姓名 ，形式为zhang_san_feng，最终转换成 zhangSanFeng
		String str = "zhang_san_feng";
		//将字符串转成大写：
		System.out.println(str.toUpperCase());
		//将字符串转成小写：
		System.out.println(str.toLowerCase());
		
		//思路：（1）分隔；（2）遍历：修改元素；（3）拼接；
		String[] split = str.split("_");
		//以字符串的形式，显示元素
		System.out.println(Arrays.toString(split)); //[zhang, san, feng]\
		
		String str1 = "";
		for (int i = 0; i < split.length; i++) {
			if (i == 0) {
				str1 += split[i];
			}else {
				split[i] = split[i].substring(0, 1).toUpperCase().concat(
						split[i].substring(1));
				str1 += split[i];
			}
		}
		System.out.println(str1); //zhangSanFeng
		
	}
}







