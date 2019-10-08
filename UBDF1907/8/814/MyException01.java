package com.uek;

import java.util.Scanner;

/**
 * 异常抛出;
 * @author UEK-N
 *
 */

public class MyException01 {
	
	public static void main(String[] args) {
		try {
			int i = 10/0;
		//注意：当有多个catch块时，不可以将父类类型的异常类对象放到子类的前面，否则直接报错；
		} /*catch (Exception e) {
			System.out.println("异常的父类！");
		} */catch (ArithmeticException e) { // 语法错误！
			System.out.println("除数不能为0");
		//注意: 当异常对象匹配到catch块后，将不会往下匹配其它的catch块；
		} catch (Exception e) {
			System.out.println("异常的父类！");
		}finally {
			System.out.println("收尾工作");
		}
	}
}
