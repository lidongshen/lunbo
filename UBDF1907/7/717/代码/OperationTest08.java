public class OperationTest08{
	public static void main(String[] args){
		
		//位运算：在程序中，十进制的数值在进行运算时，先将
		//十进制数，转换成对应的二进制数，然后再进行运算；
		//位运算：
		//按位与 : & 同1，为1，其他为0；
		System.out.println(6&3);
		System.out.println(9&4);
		//按位或 : |   有一个1，就是1；
		System.out.println(6|3);
		//按位异或 : ^ 相同为0，不同为1；
		System.out.println(6^3);
		//面试题：十进制运算的效率高，还是位运算的效率高；
		// 位运算效率高，因为十进制运算，在运算时，先转成二进制，再运算
		
		/**
		12 & 2
		6 | 2
		5 ^ 2
		8 << 2
		18 >> 2
		16 >>> 2
		*/
		
	}
}






