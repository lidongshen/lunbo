public class OperationTest05{
	public static void main(String[] args){
		
		//比较运算符：比较的结果就是一个布尔值：true false
		byte b1 = 10;
		short s1 = 20;
		int i1 = 30;
		long l1 = 40L;
		float f1 = 3.0F;
		double d1 = 4.0;
		char c1 = 'A'; 
		boolean flag = false;
		
		System.out.println(b1 > s1); //false
		System.out.println(s1 > d1); // true
		System.out.println(i1 > f1); //true
		System.out.println(l1 > s1); //true
		
		System.out.println(i1 > c1); //false
		//boolean类型不能比较
		//System.out.println(d1 > flag); 
		//语法没有问题，浮点类型可以比较，但是不建议浮点类型比较，
		//因为可能会出现不准确的情况；
		System.out.println(f1 > d1); // false
		
		/*if(关系运算表达式){
			代码语句；
		}*/
		
		int i = 30;
		int j = 30;
		//包含两情况：大于或者等于
		System.out.println(i >= j); // true
		System.out.println(i <= j); // true
		
		System.out.println(i != j); // false
		System.out.println(i == j); // true
	}
}








