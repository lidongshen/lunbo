package com.uek.whileTest;

import java.util.Scanner;

/**
 *  continue ： 控制循环，
 *  	当遇到continue时，结束本次循环(continue后的代码就不执行了)，
 *  继续下一次循环；
 */
public class ContinueTest {

	public static void main(String[] args) {
		
		/*for(int i=0;i<10;i++) {
			if(i == 3) {
				continue; //break; 
			}
			System.out.println(i);  
		}*/
		
/*		for(int i=1;i<=10;i++) {
			for(int j=1;j<=5;j++) {
				if(i == 3) {
					continue; // 和break一样，当嵌套循环时，continue只作用于当前循环，
										//不会影响到外层循环；
				}
				System.out.println(i +","+j);
			}
		}*/
		
		//需求: 把100-150之间不能被3整除的数进行输出：
		/*for(int i=100;i<=150;i++) {
			if (i % 3 == 0) {
				continue;
			}
			System.out.println(i);
		}*/
		
		//需求：10个数，是否正数，当999循环终止； 
		//记录状态：999退出，还是10个数都不是999正常退出；
		Scanner input = new Scanner(System.in);
		//标记标量：开关，可以在一个位置做一个标记，当发生了某种事件
		//                    我们的标记就被改变了；
		// 举例：在谍战片中，在门上，放一根头发，过一段时间，检查头发还在不在；
		boolean flag = false;  //确定一种状态
		//当发生某种事件时，false ---> true
		
		for(int i=1;i<=10;i++) {
			System.out.println("输入第"+i+"个数字：");
			int num = input.nextInt();
			//判断：
			if (num <= 0) {
				continue;
			} 
			System.out.println(num);
			if (num == 999) {
				//发生事件：状态修改
				flag = true;
				break;
			}
		}
		/**
		 * if(flag == true){}   								代替：---> if(flag){}
		 * if(flag == false){}    不建议这写        代替：---> if(!flag){}
		 */
		if (flag) { //flag == true
			System.out.println("999退出!");
		}else {//flag == false
			System.out.println("正常退出!");
		}
	}
}






