public class VarTest04{
	public static void main(String[] args){
		
		//浮点类型：
		// 十进制表示形式，科学计数法：
		// 5.12  5.12f
		// 5.12e2  5.12E2  e:小数点往前推几位，E：小数点往后推几位；
		//1)float : 占用4个字节，单精度（保留小数点后的7位）
		//2)double : 占用8个字节，双精度（15位）
		// 对于浮点类型，默认表示是double类型；
		//float f1 = 3.14; //3.14 --> double类型；
		//如果表示float变量的值时，数值后必须要加“F”，“f”
		float f2 = 3.14F; 
		double d1 = 3.1415; 
		
		float f3 = 3.123456789F;
		System.out.println("f3 :" + f3);
		double d2 = 3.123456789123456789;
		System.out.println("d2 :" + d2);
		
	}
}