import java.util.Scanner;
public class TestDeposit{
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		System.out.print("�����뱾��");
		double money = input.nextDouble();
		double huo1=(0.035*money)+money;
		double ding1=(0.015*money)+money;
		double huo2=(0.007*money)+money;
		double ding2=(0.042*money)+money;
		System.out.println("����" + money);
		System.out.println("����1�걾���ܼƣ�" + huo1);
		System.out.println("����1�걾���ܼƣ�" + ding1);
		System.out.println("����2�걾���ܼƣ�" + huo2);
		System.out.println("����2�걾���ܼƣ�" + ding2);
		
	}
}