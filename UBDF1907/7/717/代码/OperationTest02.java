public class OperationTest02{
	public static void main(String[] args){
		//赋值运算符:
		//1) =  : 等号在赋值时，从右往左的；
		int a = 10;
		int b = 20;
		int c = 30;
		a = b = c; //赋值的结合性：
		System.out.println(a+","+b+","+c);
		
		//需求：交换左右手中的两扑克牌：
		byte left = 13;
		byte right = 1;
		byte temp = 0;
		//交换：
		temp = left;
		left = right;
		right = temp;
		System.out.println(left+","+right);
	}
}



