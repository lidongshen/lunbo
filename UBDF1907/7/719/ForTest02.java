package com.uek.whileTest;

import java.util.Scanner;

/**
 *  嵌套循环：一个完整的循环结构中，又包含了另外一套循环结构；
 *  语法：
 *         //外层循环，循环一次；
 *  		for(){
 *              //内层循环，循环一遍(从头到尾循环一遍)；
 *              for(){
 *              
 *              }
 *         }
 */
public class ForTest02 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//外层循环1次：2次 3次
		// 内层循环 ： 内层循环1 2 3 4次；

/*		for (int i = 1; i <= 3; i++) {
			System.out.println("外层循环"+i+"次");
			for (int j = 1; j <= 4; j++) {
				System.out.println("内层循环"+j+"次");
				for(int k =1; k<=3; k++) {
					System.out.println("最内层循环"+k+"次");
				}
			}
		}*/
		
		//需求：打印3个班，每一个班5名同学的平均分；统计总分，平均分；
		//提示：键盘输入，每位同学的分数；求每一个班的平均分；
/*		Scanner input = new Scanner(System.in);
		double sum1 = 0.0;
		int count = 0;
		for (int i = 1; i < 4 ; i++) {
			//注意: 计数器的位置；
			double sum = 0.0;
			for (int j = 1; j < 6; j++) {
				System.out.println("请输入第"+i+"个班的第"+j+"名同学的成绩：");
				double score = input.nextDouble();
				sum += score;
				sum1 += score;
				count++;
			}
			System.out.println("第"+i+"个班级的所有同学平均分" + (sum / 5));
		}
	    System.out.println(sum1 / count);*/
		
	    //需求：打印输出 3行8列的矩阵：嵌套循环
	    /**
	     *    ********
	     *    ********
	     *    ********
	     */
		//外层循环一次：
/*	    for(int i=1;i<=3;i++) {
	    	//内层循环一遍：
	    	for(int j=1;j<=8;j++) {
	    		System.out.print("*");
	    	}
	    	//换行：
	    	System.out.println();
	    }*/
	    
	    //需求：平行四边形（实心的）
	    /**
	     *         ********
	     *    ********
	     *  ********
	     *  行数        空格：  两组数据的关联关系：公式
	     *     1               5         7 - 2*行数   ：
	     *     2               3
	     *     3               1
	     */
		//行数：
/*	    for(int i=1;i<=3;i++) {
	    	//空格：7-2*i   
	    	for(int k=0;k< 7-2*i;k++) {
	    		System.out.print(" "); // " " 空格   5
	    	}
	    	//  每行*的个数：
	    	for(int j=1;j<=8;j++) {
	    		System.out.print("*");
	    	}
	    	//换行：
	    	System.out.println();
	    }*/
	    
	    //需求：直角三角形：
	    /**
	     *  *
	     *  **
	     *  ***
	     *  行数：   *
	     *    1			1
	     *    2			2
	     *    3			3
	     */
	    //行数：
	/*    for(int i=1;i<=3;i++) {
	    	//*的个数：
	    	for(int j=1;j<=i;j++) {
	    		System.out.print("*");
	    	}
	    	//换行：
	    	System.out.println();
	    }*/
	    
	    //需求：九九乘法表：
	    /**
	     *   1 * 1 = 1
	     *   2 * 1 = 2 	2 * 2 = 4
	     *   ....... 
	     */
	    //循环的次数：9次
	    for(int i=1;i<=9;i++) {
	    	//内层循环：每一个数相乘之和
	    	for(int j=1;j<=i;j++) {
	    		System.out.print(i +"*"+ j+"="+i*j+"\t");
	    	}
	    	//换行：
	    	System.out.println();
	    }
	    
	    //需求: 打印：等腰三角形
	    /**
	     *       *
	     *     ***
	     *   *****
	     *   行数   空格     *          行数和空格 ：3- 行数
	     *      1         2         1        行数和 *      ： 2 * 行数 - 1 ：  2*1-1=1
	     *      2         1         3
	     *      3         0        5
	     */
	    //行数：
	    for(int i=1;i<=3;i++) {
	    	//空格：
	    	for(int j=1;j<=3-i;j++) {
	    		System.out.print(" ");
	    	}
	    	//* 数：
	    	for(int k=1;k<=2*i-1;k++) {
	    		System.out.print("*");
	    	}
	    	//换行:
	    	System.out.println();
	    }
	}
}





























