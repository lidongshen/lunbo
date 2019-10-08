package homework;
import java.util.Scanner;
public class Test05 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入矩阵的行：");
		int hang=sc.nextInt();
		System.out.print("请输入矩阵的列：");
		int lie=sc.nextInt();
		int[][] arr=new int[hang][lie];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) { 
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
