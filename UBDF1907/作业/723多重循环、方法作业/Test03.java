package homework;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		//输入三个班，每班3个学生的成绩，求和并求平均分
		Scanner sc=new Scanner(System.in);
		//sum总和,count计数器
		int sum=0,count=0;
		int[][] score=new int[3][3];
		for (int i = 0; i < score.length; i++) {
			//sum1班级和
			int sum1=0;
			for (int j = 0; j < score[i].length; j++) {
				System.out.print((i+1)+"班的第"+(j+1)+"名同学的成绩：");
				score[i][j]=sc.nextInt();
				sum1+=score[i][j];
				count++;
			}
			sum+=sum1;
			System.out.println((i+1)+"班的成绩："+sum1);
			System.out.println((i+1)+"班的平均分："+sum1/score[i].length);
		}
		System.out.println("3个班的总成绩："+sum);
		System.out.println("3个班的平均分："+sum/count);
	}

}
