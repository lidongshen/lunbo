package com.uek1;

public class StringBufferTest {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		//增
		/*sb.append(100);
		sb.append(true); // String + true
		sb.append('李');
		sb.append("优逸客");*/
		sb.append(100).append(true).append('李').append("优逸客");
		System.out.println(sb.toString());
		//改:
		StringBuffer sb1 = new StringBuffer("山西省优逸客");
		StringBuffer sb2 = sb1.replace(0, 1, "陕");
		System.out.println(sb2);
		//查：
		int indexOf = sb1.indexOf("优逸客");
		System.out.println(indexOf);
		//删除：
		StringBuffer sb3 = sb1.delete(0, 3);
		System.out.println(sb3);
		
		/**
		 * StringBuffer <---> String 切换：
		 */
		StringBuffer sb4 = new StringBuffer("UEK");
		//1）
		String str1 = sb4.toString();
		System.out.println(str1);
		
		//2）
		String str2 = new String(sb4);
		System.out.println(str2);
		
		/**
		 * String <---> StringBuffer 切换：
		 */
		String ss = "UEK";
		//1)
		StringBuffer sb5 = new StringBuffer(ss);
		System.out.println(sb5);
		//2)
		StringBuffer sb6 = sb5.append(ss);
		System.out.println(sb6);
		
		
	}
}
