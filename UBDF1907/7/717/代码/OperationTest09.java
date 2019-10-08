
import java.util.*;
public class OperationTest09{
	public static void main(String[] args){
		
		//三元运算符：
		//语法：表达式 ？表达式 ：表达式
		//需求：找出两个数字中较大的一个：
		//int a = 10;
		//int b = 20;
		/*if(a > b){
			System.out.println('是');
		}else{
			System.out.println('否');
		}*/
		
		//如果a > b表达式成立，将执行 ‘是’ ，否则执行‘否’ 
		//System.out.println(a > b ? '是' : '否'); 
		
		//需求：键盘输入三个int类型数字，然后选择出最大值；
		Scanner input = new Scanner(System.in);
		System.out.print("第一个数：");
		int a = input.nextInt();
		System.out.print("第二个数：");
		int b = input.nextInt();
		System.out.print("第三个数：");
		int c = input.nextInt();
		
		//if else:
		int max; //中间变量（存储值）
		if(a > b){
			max = a;
		}else{
			max = b;
		}
		
		if(max > c){
			System.out.print("最大值："+max);
		}else{
			System.out.print("最大值："+c);
		}
		System.out.print("===================");
		//三元：
		//int max = a > b ? a : b;
		//max = max > c ? max : c;
		//System.out.print("最大值："+max);
		
		//三元嵌套：
		System.out.println((a > b ? a : b) > c ? (a > b ? a : b) : c);
	}
}






