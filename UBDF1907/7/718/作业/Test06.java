package homework;
import java.util.Scanner;
public class Test06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("输入一个十进制数：");
		int number=sc.nextInt();
		System.out.println(Integer.toBinaryString(number));
	}
}
