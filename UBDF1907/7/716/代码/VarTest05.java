public class VarTest05{
	public static void main(String[] args){
		
		//char : 字符型
		// 字符型：表示的是Unicode编码集的某一个字符：
		//编码集： 
		//1)ASCII编码集 : 
		//     美国推出，只包含了英文大小写字母，和符号；         
		//2)Unicode编码集：
		//     包含了全球所有国家的语言的字符，该编码集存储字符时
        //  长度是固定的：1个英文字母占2个字节，1个汉字占2个字节；	
		//  Unicode编码集中包含了ASCII编码集；
		//  unicode编码集中是以16进制的方式来表示每一个字符；
		//  unicode包含的字符有65536个，其中前128个就是ASCII包含的字符；
		//3）UTF-8编码集 ：在Unicode编码集之上，进行个优化，
        //  可变长度，1个英文字母占1个字节，1个汉字占3个字节；
		
		//声明char类型变量：
		char c1 = '张';
		System.out.println(c1); //
		
		//转义字符：\n : 换行
		char c2 = '\n'; 
		System.out.println(c2);
		// \t : 制表符，代表4个空格
		System.out.print("我们是\t山西人");
		
		System.out.print("我们是\"山西人\"");
		
		//直接是Unicode码值（16进制）来表示char类型：
		char c3 = '\u0012';
		System.out.print("c3:" + c3);
		
		char c4 = 'b'; // unicode编码集中字符 b
		System.out.print(c4); // b
		//获取b在Unicode编码集中的位置：
		System.out.println((int)c4); // 
		
		//数值型和char类型进行运算：
		// char类型值在存储时，先从Unicode
		//编码中找到对应的十进制数，然后再
		//转成二进制存储；
		char c5 = '2' + '5'; // 50 + 53 = 103
		System.out.println(c5); // 103 g
		//类型转换：在运算过程中，‘2’转成int类型
		//          参与十进制运算，计算出的结果，又被
		//          转成了char类型，所有最终表示
		//          的是char类型中的字符4；
		
		char c6 = 2 + '2';
		System.out.println(c6);   // 4
		System.out.println((int)c6); // 52
		
		char c7 = '3';
		String s = "abc" + c7;
		System.out.println("s:" + s);
		int i=1;   
        int j;
        j=i++; 
		System.out.println(i + j);
	}
	
	
	
	
	
	
	
}