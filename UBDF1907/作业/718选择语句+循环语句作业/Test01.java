package homework;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		//输入一个数，判断是奇数还是偶数
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入一个数：");
		double number=sc.nextDouble();
		if(number%2==0)
			System.out.println(number+"是偶数");
		else
			System.out.println(number+"是奇数");

		
		
		
	}

}
