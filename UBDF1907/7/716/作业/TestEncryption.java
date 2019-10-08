import java.util.Scanner;
public class TestEncryption{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		System.out.print("请输入一个4位正整数：");
		int a = input.nextInt();
		int b=(a/1000)%10;
		int c=(a/100)%10;
		int d=(a/10)%10;
		int e=a%10;
		int f=(b+5)%10 + (c+5)%10*10 + (d+5)%10*100 + (e+5)%10*1000;
		System.out.print("加密后的数字为："+f);			
	}
}
