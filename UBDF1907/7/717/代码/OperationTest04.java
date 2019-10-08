public class OperationTest04{
	public static void main(String[] args){
		 //复合运算符：
		 short a = 100;
		 short b = 200;
		 // a = a + b;
		 System.out.println(a += b); //a = 300
		 //a 100 = 300 - 200;
		 System.out.println(a -= b); //-100
		 //20000 = 100 * 200;
		 System.out.println(a *= b); // 20000
		 //100 = 20000 / 200;  注意：两个int类型的操作数运算，结果还是int
		 System.out.println(a /= b); // 100
		 
		 int d = 10;
		 //在运算过程中，会自动进行类型提升（容量小-->容量大）
		 //d = (int)(d * 0.1); 
		 //System.out.println(d);// 1.0
		 //在复合运算符中：会自动进行类型转换
		 d *= 0.1; //d = (int)(d * 0.1); 
		 System.out.println(d); // 1.0
		 
		 long l1 = 100L;
		 l1 += 0.1; // l1 = (long)(l1 + 0.1);
		 System.out.println(l1); //100
		 
	}
}