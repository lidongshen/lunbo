import java.util.Scanner;
public class TestCircle{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in); 
		System.out.print("请输入半径：");
		double r = input.nextDouble();
		double c=2*3.14*r;
		double s=3.14*r*r;
		System.out.println("该圆半径为：R="+r);	
		System.out.println("该圆周长为：C=2*3.14"+"*"+r+"="+c);
		System.out.println("该圆面积为：S=3.14"+"*"+r+"*"+r+"="+s);
	}
}