package com.uek;

import java.util.Scanner;

import com.sun.istack.internal.localization.NullLocalizable;

/**
 * 
 * throws ：在方法的声明时，抛出异常类对象的类型;
 * throw ； 在方法中，抛出异常类对象；
 *        结合自定义异常类来进行使用；
 *步骤：
 *1）继承异常类（编译时异常，运行时异常）；
 *2）需要生成一个对象序列号：serialVersionUID
 *3) 设计自定义类的构造方法：无参，有参； 
 *
 *使用自定义异常类对象：
 *1）通过throw关键字来抛出自定义异常类对象； 
 *
 * try: 监听异常
 * catch ；处理异常
 * finally ：收尾工作
 * throws : 抛出异常类对象的类型，供调用者来处理异常
 * throw ； 抛出异常类对象（jdk支持的异常类型，自定义异常类型）
 */

//运行时异常类：检查年龄是否合法：
class ageException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ageException() {
		
	}
	public ageException(String msg) {
		super(msg);
	}
}

public class MyException04 {
	public static void main(String[] args) /* throws ageException*/{
		
		Scanner input = new Scanner(System.in);
		System.out.println("输入年龄：");
		int age = input.nextInt();
		try {
			if (age < 0) {
				ageException ageException = new ageException("年龄不合法！");
				throw ageException;
			}
		} catch (ageException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("年龄是："+age);
	}
}







































