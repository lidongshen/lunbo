package com.uek1;

public class CommonClassTest01 {

	public static void main(String[] args) {
		
		int i = 10;

		/**
		 * 一 、 基本数据类型 ---> 引用类型
		 */
		/**
		 * JDK1.5 之前API
		 */
		//第一种：通过构建器：
		Integer interger = new Integer(i);
		System.out.println(interger.MAX_VALUE);
		System.out.println(interger.MIN_VALUE);
		System.out.println(interger.toString()); 
		Double d = new Double(3.14);
		
		//第二种：通过静态功能方法：valueOf（）；
		Integer inter = Integer.valueOf(i);
		System.out.println(inter);
		Float f = Float.valueOf(3.14F);
		
		/**
		 * jdk1.5 之后API
		 */
		//自动装箱：将基本数据类型包装成引用类型
		Integer num = 20; // Integer num = new Integer(20);
		Double dd = 3.14; // Double d = new Double(3.14);
		
		
		/**
		 * 二、引用类型 ----> 基本类型：
		 */
		/**
		 * JDK1.5 之前API
		 */
		Integer num1 = 30;
		//intValue() : 将包装类对象转变成基本类型：
		int num2 = num1.intValue();
		Long l = 50L;
		long ll = l.longValue();
		System.out.println(ll);
		System.out.println(num2);
		
		/**
		 * JDK1.5 之后API:
		 */
		//（1）自动拆箱：将包装类中的value属性值获取，然后赋值
		int num4 = num1; 
		Integer i1 = 30;
		Integer i2 = 5;
		//（2）当包装类对象在进行运算,或者比较时，会自动拆箱（先转成基本类型，然后再参与运算）；
		int num5 = i1 / i2;
		if(i1 > 30) {
			System.out.println("i1");
		}
		
		/**
		 * 三、字符串转成包装类对象：
		 */
		//字符串100--->Integer;
		String str = "100";
		//通过构造器：
		Integer num3 = new Integer(str);
		//自动拆箱：
		int i4 = new Integer(str);
		System.out.println(num3);
		
		/**
		 * 四、字符串转成基本数据类型：
		 * parseXXX（） ：
		 */
		//使用静态方法：
		int i3 = Integer.parseInt("200");
		String str1 = "3.1415";
		double d1 = Double.parseDouble(str1);
		String str2 = "true";
		boolean flag = Boolean.parseBoolean(str2);
		
		/**
		 * 五、基本数据类型转成字符串：
		 * String类的方法：valueOf()
		 */
		// 1)
		String str3 = String.valueOf(300);
		// 2)
		int i5 = 10;
		String str4 = i5 + ""; //"" 空字符串
		
	}
}













