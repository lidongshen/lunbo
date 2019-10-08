import java.util.Scanner; 
public class OperationTest{
	public static void main(String[] args){
	    Scanner sc=new Scanner(System.in);
		/*
		System.out.print("请输入一个数字：");
		
		System.out.print("请输入一个数字：");
		int b=sc.nextInt();
		System.out.print("请输入一个数字：");
		int c=sc.nextInt();
		if(a>b&&a>c)
		System.out.println(a);
		else if(b>c)
		System.out.println(b);
		else
		System.out.println(c);
		System.out.println((a>b?a:b)>c?(a>b?a:b):c);
		*/
		//需求：当成绩大于90，输出有奖品；
		System.out.print("请输入成绩：");
		double score=sc.nextDouble();
		if(score>90)
			System.out.println("有奖品");
		//需求：声明2个int类型变量并赋值。判断两数之和，如果大于等于50，打印“50”；
		System.out.print("请输入a：");
		int a=sc.nextInt();
		System.out.print("请输入b：");
		int b=sc.nextInt();
		if(a+b>=50)
			System.out.println("50");
		//需求：声明2个double类型变量并赋值。判断第一个数大于10.0 ， 且第2个数小于20.0 ，打印两数之和；
		System.out.print("请输入c：");
		double c=sc.nextDouble();
		System.out.print("请输入d：");
		double d=sc.nextDouble();
		if(c>10.0&&d<20.0)
			System.out.println(c+d);
		//需求：定义两个变量，判断二者的和，是否既可以被3又能被5整除(取余结果为0)，打印提示信息：
		System.out.print("请输入e：");
		double e=sc.nextDouble();
		System.out.print("请输入g：");
		double g=sc.nextDouble();
		if((e+g)%3==0&&(e+g)%5==0)
			System.out.println(e+","+g);
	}
}