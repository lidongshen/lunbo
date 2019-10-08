/*
需求：使用键盘输入，接收键盘输入的数据；
      完成对圆的周长和面积的计算；
	 扫描类:Scanner;
	 在java中，所有的类都是以不同的包来进行组织的；
	 常用到的一些核心的类，如String,system等，这些类
	 都有java.lang包来进行管理，该包下的所有的类，在
	 使用时不需要额外导入，其它包下的类要求在使用时，必须
	 先导入包才能使用类的源码；
*/
//将scanner类的代码导入到当前.java文件中；
import java.util.Scanner;
//将java.util包下所有的类的代码导入到当前文件中；
import java.util.*;

public class OperationTest01{
	public static void main(String[] args){
		
		/**
		* scanner类的使用步骤：
		  1）导入对应的包；
		  2）创建scanner对象；
		     new 构造方法();
		  3）接收键盘输入的内容，然后赋值给一个变量存储；
		*/
		Scanner input = new Scanner(System.in);
		System.out.print("输入半径：");
		// input.next() ： 调用方法的语法：
		double r = input.nextDouble();
		//常量：一旦声明赋值后，不可改变；
		//使用final关键词修饰的变量，就是常量；
		//常量名要求大写；
		final double PI = 3.14; 
		//求周长：
		double zhouChang;
		zhouChang = 2 * PI * r;
		//面积：
		double area = PI * r * r;
		System.out.println("周长：" + zhouChang +",面积："+area);
	}
}






