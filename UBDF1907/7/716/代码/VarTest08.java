public class VarTest08{
	public static void main(String[] args){
		
		//算术运算符：
		// 属于二元运算----> 两个操作数
		System.out.println(2 + 3); //2 3 分别代表两个操作数
		
		//常用算术运算符：
		// 因为是基于int类型在计算，所以结果还是int类型，它会把小数位截断，不会四舍五入
		System.out.println(10 / 3); // 3
		System.out.println(10 * 3); // 30
		System.out.println(10 % 3); // 1
		//只要有一个操作数是负数，结果就是负数
		System.out.println(-10 / 3); // -3 
		System.out.println(10 / -3); // -3
		//类型转换：
		//两操作数都是整形，结果取整；
		//只要有一个操作数为浮点型，那么首先会进行类型自动转换
		//然后再进行计算；
		System.out.println(18.06 / 2); // 9.03
		
		//特殊情况：前++ ， 后++ ， 前-- ， 后--；
		//不管是后++ ，还是后--；
		//有两情况：第一种：如果单独运算，直接自增或自减；
		//			第二种：如果和其它语句参与运算，先参与运算，再自增或自减；
		//不管是前++ ， 或是前--：只有一种情况，先自增或自减，然后再参与运算；
		int i = 1;
		i++;   // 独立存在，所以自增 ：2
		System.out.println(1 + i); // 3
		
		int j = 1;
		int k = j++; //先赋值，再自增
		System.out.println("参与运算："+(1 + k));
		System.out.println(j); // 2
		System.out.println("参与运算："+(1 +(j++))); // 3
		
		int i1 = 10;
		i1--; //独立
		System.out.println(i1); // 9
		System.out.println(1 + (i1--)); // 10
		System.out.println(i1); // 8
		
		int i2 = 1;
		++i2; // == i2++；
		System.out.println(i2); // 2
		System.out.println(10 + (i2++) + (++i2)); //16
		                   //      2   +    4
	}
}



