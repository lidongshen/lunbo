public class OperationTest07{
	public static void main(String[] args){
		
		//运算符的优先级：
		//小括号 > 自增、自减 > 算术运算 > 比较运算 > 逻辑运算 > 赋值运算
		long a = 10L;
		long b = 20L;
		long c = 30L;
		//System.out.println(a + b > c);  // false
		//
		//System.out.println(a + b++ > c);// false
		//System.out.println(--a + b == c & true); //true
		//System.out.println(!(a + b > c | a - b < c)); //false
		
		//逻辑运算符 : 
		// 短路与： &&  特点：当第一个操作数为false时，不判断第二个操作数
		//                     如果第一个操作数为true时，还会判断第二个操作数；
		// 在开发过程中，一般是用短路与，效率高；
		System.out.println(a + b++ > c && true); // false
		System.out.println(false && false); // false
		
		//短路或：||   特点：当第一个操作数为true时，不判断第二个操作数
		//                   如果第一个操作数为false时，还会判断第二个操作数；
		System.out.println(false || false); // false
		System.out.println(true || false); // true
		
		boolean flag1 = false;
		int i = 10;
		if(flag1 & (i++ > 0)){
			System.out.println("真");
		}else{
			System.out.println("假");
		}
		
		boolean flag2 = false;
		int i1 = 10;
		if(flag1 && (i++ > 0)){
			System.out.println("真");
		}else{
			System.out.println("假");
		}
		
		
		
		
		
		
	}
}













