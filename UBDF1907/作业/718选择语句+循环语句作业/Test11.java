package homework;
import java.util.Scanner;
public class Test11 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入成绩："); 
		int score=sc.nextInt();
			if(score<60) 
				System.out.println("爸爸给买学习资料");
			else if(score<80)
				System.out.println("爸爸请吃一顿大餐");
			else if(score<90)
				System.out.println("爸爸给买手机"); 
			else 
				System.out.println("爸爸给买电脑"); 
	}
}
