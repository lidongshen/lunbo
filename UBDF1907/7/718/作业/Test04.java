package homework;
import java.util.Scanner;
public class Test04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("输入一个数：");
		int number=sc.nextInt();
		for(int i=2;i<=number;i++) 
			if(number%i==0) {
				System.out.println(number+"不是素数");
				break;
			}
			else {
				System.out.println(number+"是素数");
				break;
			}
	}
}
