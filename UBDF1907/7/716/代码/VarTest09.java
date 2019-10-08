
//导类：
import java.util.Scanner;

public class VarTest09{
	public static void main(String[] args){
		
		//补充：+ -
		// + ：（1）加号；
		int i = 2 + 3;
		// (2) 字符串拼接: 运算符左右两边，只要有一个操作数是字符串，
		//                 那么结果就是字符串拼接；
		String str = 2 + "3";
		//(3) + 正号
		System.out.println(10); //+10
		//- ：减法，负号
		System.out.println(-10);
		
		//案例：13中的3抽取出来：
		System.out.println(13 % 10); // 3
		
		// 1234 : 分别取出每一位上的数字；4 3 2 1
		System.out.println(1234 % 10); // 4 
		//int类型运算，结果还是int类型：
		System.out.println(1234 / 10 % 10); //int类型-->123 3
		System.out.println(1234 / 100 % 10); //2
		System.out.println(1234 / 1000); //1
		
		//声明几个需要的变量，求圆的周长和面积；
		//周长：2pi * r
		//面积：pi * r * r
		//接收键盘输入：
		//Java中 扫描类:scanner类
		//(1)导入包；
		//(2)创建一个接收数据的变量；
		//（3）将读取到的数据存储在该变量中：
		Scanner input = new Scanner(System.in); //System.in代表输入
		// println : 先输出，然后再换行
		// print ： 只有输出
		System.out.print("请输入半径：");
		//使用scanner的方法：next()方法来接收数据；
		double r = input.nextDouble();
		//周长：2pi
		double l=2*3.14*r;
		double s=3.14*r*r;
		System.out.println("周长："+ l +"面积:" + s);
		
	
	}
}


