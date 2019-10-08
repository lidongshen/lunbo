package com.uek.test01;

import java.util.Scanner;

/**
 * 多分支结构：Switch
 * 分支：1）单分支 ： if
 * 				2) 双分支： if else
 *             3)  多分支： if else if else
 *                                    switch（使用场景：用来替代比较简单的多分支）；
 *             4) 嵌套分支：
 *    swtich结构的特点：
 *    	1）case后面必须跟常量；
 *    2）case后的常量不能重复；
 *    3) break如果省略会造成case穿透；
 *    4）default是可以省略的，但是注意业务逻辑；
 */
public class SwitchTest01 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
		
    	//接收键盘输入：
    	// 1 :   刘岩在等你回家！
    	//2 :   范冰冰在等你请客！
    	//3 :   迪丽热巴在请你跳舞！
    	//4 :   古力娜扎在等你一起王者荣耀！
    	Scanner input = new Scanner(System.in);
    	System.out.println("输入");
    	//  1  2 3 4 
    	//拓展：String底层就是一个char类型的数组；
    	// “迪丽热巴”  = ['迪' , '丽' , '热' ,'巴']     数组
    	//  索引（下标）： 0       1     2      3
    	
/*    	String str = input.next();  // 1
    	//String普通方法： charAt(索引、下标)       charAt(0) 
    	char num = str.charAt(0); //   '1'
    	if(num == '1') {
    		System.out.println();
    	}*/
    	
    	//switch结构：
    	String str = input.next();
    	char num = str.charAt(0);   // 9
    	char temp = '1';
    	//switch --> char 
    	switch(num) {
    		//分支：case 常量：
    		case  '1': 
    			//代码块：
    			System.out.println("1");
    			//break; //代表一个分支的结束；
    		case '2' : 
    			//代码块：
    			System.out.println("2");
    			break; //代表一个分支的结束；
    		case '3' : 
    			//代码块：
    			System.out.println("3");
    			break; //代表一个分支的结束；
/*    		default : // 收尾
    			//代码块：
    			System.out.println("4");
    			break; //代表一个分支的结束；
*/    	}
    	
    	
    	
	}
}
