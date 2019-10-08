import java.util.Scanner;
public class OperationTest11{
	public static void main(String[] args){
		
		/*if(true){
			//代码行数可以有任意行；
			System.out.println("张三");	
	    }*/
		
		//需求1：
		int score = 92;
		if(score > 90){
			System.out.println("奖品");
		}
		
		//需求2：
		int a = 10;
		int b = 20;
		if(a + b >= 50){
			System.out.println(50);
		}
		
		//需求3：
		Scanner scann = new Scanner(System.in);
		System.out.println("输入1：");
		double d1 = scann.nextDouble();
		System.out.println("输入2：");
		double d2 = scann.nextDouble();
		//逻辑代码：
		/*if(d1 > 10.0 & d2 < 20.0){
			System.out.println(d1 + d2);
		}*/
		/*if(d1 > 10.0 && d2 < 20.0){
			System.out.println(d1 + d2);
		}*/
		//嵌套结构：
		if(d1 > 10.0){
			if(d2 < 20.0){
				System.out.println(d1 + d2);
			}
		}
		
		
		
		
		
		//需求4： 能被3整除：15 % 3 == 0
		short s1 = 100;
		short s2 = 30;
		if((s1+s2) % 3 == 0 && (s1+s2) % 5 == 0){
			System.out.println("被5和3整除！");
		}
		
		//需求5：小赌博
		// static : 类方法 可以使用类名直接调用的方法
		double d = Math.random(); // d [0.0 - 1.0) 0.9999.... 
		//[0.0 - 6.0) 随机数
		double d3 = Math.random() * 6; 
		double d4 = Math.random() * 6; 
		double d5 = Math.random() * 6; 
		//转换int类型； 
		int num  = (int)(d3 + d4 + d5); // [0.0 - 17.9999999999...]
		System.out.println(num);
		//业务逻辑:
		if(num > 15){
			System.out.println("不错！");
		}
		if(num > 10 && num <= 15){
			System.out.println("一般");
		}
		if(num <= 10){
			System.out.println("很差！");
		}
	}
}






