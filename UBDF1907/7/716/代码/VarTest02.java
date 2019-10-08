public class VarTest02{
	public static void main(String[] args){
		
		//数据类型：基本数据类型：
		//整数类型：
		//byte : 占用1个字节，表示的数字范围：-128-0-127
		byte b1 = -128;
		byte b2 = 127;
		//字符串拼接：+
		//注意：中文模式和英文模式的符号，要求使用英文模式
		System.out.println(b1+","+b2); 
		//1、超出了byte类型的表示范围;
		//2、byte变量的表示的变量值，默认的数据类型为int类型；
		//byte b3 = 200;
		//System.out.println(b3); 
		
		//short : 占用2个字节，表示的范围：-2的15次方 ---> 2的15次方-1
		short s1 = 100;
		System.out.println(b1+","+b2);   //字符串拼接
		
		//int : 占用4个字节，表示的范围：正负21亿；
		//在开发过程中，使用最多的就是int类型；
		//而且byte,short表示的数值也是int类型；
		int i1 = 100000;
		System.out.println(i1);  
		
		//long : 占用8个字节，表示范围：2的正负63次方左右
		// 声明long类型变量时，如果变量是一个数值，没有任何修饰，
		//那么该变量值仍然表示的是int类型值；
		long l1 = 10000000; //int类型值 --赋值-> long类型
		//如果想声明一个long类型变量，必须要在数值后添加：“L” , "l";
		long l2 = 1000000L;
		System.out.println(l2);  
	}
}
