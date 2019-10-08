package homework;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		/*根据成绩输出对应的等级，使用if多分支和switch语句分别实现。
		A级   [90,100]
		B级   [80,90)
		C级   [70,80)
		D级   [60,70)
		E级   [0,60)*/
		System.out.print("请输入成绩："); 
		int score=sc.nextInt();
		//if结构
		if(score<60) 
				System.out.println("E级"); 
			else if(score<70) 
				System.out.println("D级"); 
			else if(score<80)
				System.out.println("C级"); 
			else if(score<90)
				System.out.println("B级");
			else if(score<=100)
				System.out.println("A级");
		//switch结构
		switch (score/10) {
		case 10:
		case 9:
			System.out.println("A级");
			break;
		case 8:
			System.out.println("B级");
			break;
		case 7:
			System.out.println("C级");
			break;
		case 6:
			System.out.println("D级");
			break;
		default:
			System.out.println("E级");
			break;
		}


	}

}
