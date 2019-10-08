package com.uek.javaSE;
/**
 * 了解数组：
 * 需求：
 * 		记录全班30位同学的成绩；
 * 			int 张三的分数 = 90;
 *    		int 李四。。。。。
 *   数组：一个数组可以理解为一个表格，在这个表格中，一次性可以存储多个值；
 *   
 *   数组定义：是多个相同类型数据按一定顺序排列的集合，
 *              并使用一个名字命名，并通过编号的方式对这些数据进行统一管理。 
 *    
 *    数组的特点：
 *    1）一个数组中，只能存储相同数据类型的数据；	
 *    2）在数组中，有“索引/下标”的概念，索引表示的范围从0开始，到数组的长度-1；
 *           每一个元素按照索引的顺序，来进行存储；
 *    3）在数组中存储的每一份数据，叫做元素；
 *
 */
public class ArrayTest01 {
	public static void main(String[] args) {
		
		//1. 该数组只能存储int类型数据；
		// 声明一个int类型，长度为2的数组；
		int num = 10;
		
		int[] arr = new int[2];
		//数组元素赋值：
		// arr[0]  = 数组中的第一个元素,在编写代码的过程，使用该方式来操作数组中的元素;
		arr[0] = 10;  // 赋数组下标为0的元素值，也就是数组中的第一个元素；
		//arr[1] = "abc";  // 报语法错误，在编写代码的过程中，编译器会编写的程序，
		                               // 当发现语法错误，编译器会提示；（前面的红色小错号）；
		arr[1] = 20; //
		//arr[2] = 30; //错误，因为数组长度一旦确定，就不能修改了；
		
		//数组四要素：
		// 1.char类型数组；
		//2.数组名/引用；
		//3. 在创建数组时，要求要指定该数组的容量（长度）；
		//4.下标：从0开始；
		char[] charArr = new char[6]; //该数组能够存储 ：索引 ，长度
		//索引：代表的是，数组中的每一个元素的位置，从0开始到数组长度-1结束；
		//长度：当前数组的容量（能够存储几个元素）；
		//数组元素的赋值：
		charArr[5] = 100;
		
	}
}

















