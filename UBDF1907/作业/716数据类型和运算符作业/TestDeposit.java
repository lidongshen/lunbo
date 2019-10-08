import java.util.Scanner;
public class TestDeposit{
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		System.out.print("请输入本金：");
		double money = input.nextDouble();
		double huo1=(0.035*money)+money;
		double ding1=(0.015*money)+money;
		double huo2=(0.007*money)+money;
		double ding2=(0.042*money)+money;
		System.out.println("本金：" + money);
		System.out.println("活期1年本金总计：" + huo1);
		System.out.println("定期1年本金总计：" + ding1);
		System.out.println("活期2年本金总计：" + huo2);
		System.out.println("定期2年本金总计：" + ding2);
		
	}
}