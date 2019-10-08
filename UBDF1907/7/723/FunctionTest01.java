package com.uek.java;
/**
 *  方法/函数：
 *  定义：把一些完成一个业务功能的代码进行封装，直接调用；
 *  封装的方法，只有在调用时，才会执行；如果在main方法中，调用了其它方法，
 *  那么当其它方法执行完毕后，才会再次回到main方法中，程序继续往下执行；	
 */
public class FunctionTest01 {	
	
	public static void main(String[] args) {
		//在main可以编写各种各种各样的业务逻辑；
		/**
		 * main()   1000行；
		 * 功能需求改变 ---> 修改大量的代码
		 * 功能与功能之间的分离 ---> 功能需求变更 ---> 对应的方法的代码
		 */
		/**
		 * 语法:
		 * [访问修饰符]  方法的返回值类型  方法名([形参列表]){
		 *                       方法体（业务逻辑、功能代码）；
		 *                       return 返回值；
		 * }
		 * 
		 * public static : 访问修饰符
		 * void: 方法的返回值类型 ,void指的是空，作为一个方法，如果没有返回值，就void来代替；
		 *方法名 : 标识符
		 *形参列表 ： 形式参数，就是外界在调用该方法时，传递进来的值；可以有多个参数；
		 * return ： 返回当前方法的返回值，外界调用该方法时，该方法交给外界的一个结果；
		 */
		
		int[] arr = new int[] {5,4,7,8,3};
		
		//2）方法的调用：
		//实参：实际参数，传入参数时，只需要将变量名，或者值传入即刻；
		print(arr);
		System.out.println("看我什么时候执行！");
		
		show();
		
		int i = 10;
		int j = 20;
		add(i , j);
		
		int sum = add(10, 20);
		System.out.println(sum);
	}
	
	//1) 封装一个方法：
	//功能：遍历数组
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
	
	//方法的声明：
	public static void show() {
		System.out.println("我是谁！");
	}
	
	//方法的声明;
/*	public static void add(int a , int b) {
		System.out.println(a + b);
	}*/
	
	//方法的声明;
	public static int add(int a , int b) {
		int c = a + b;
		return c;
	}
}








