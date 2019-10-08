package homework;
import java.util.Scanner;
public class Test05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double sum=0.0;
		int i=1;
		while(i<=5) {
		System.out.print("输入第"+i+"个学生的分数：");
		double number=sc.nextDouble();
		sum+=number;
		i++;
		}
		System.out.println("5个学生的分数是："+sum);
	}
}
