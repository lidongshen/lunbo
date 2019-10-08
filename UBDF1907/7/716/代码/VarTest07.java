public class VarTest07{
	public static void main(String[] args){
		
		//自动转换：容量小---> 容量大
		int i = 10;
		long l = i;
		System.out.println("l:"+l);
		
		//强转转换：容量大--->容量小，就需要强转转换
		//语法:(要强转成那种类型)值
		int j = (int)l;
		int k = (int)10000L;
		System.out.println("j:" + j);
		
		//注意：布尔类型不能和其它类型进行强转
		boolean flag = true;
		int a = (int)flag;
		System.out.println("a:" + a);
		
		//String ： 字符串类型,所有的字符串表示的都是常量；
		String str = "abc";
		//String s1 = new String("abc");
		System.out.println(str);
		
		//变量：值是可以更改的；
		int ii = 10;
		ii = 100;
		//常量：值一旦声明，就不能再修改了；
		final int i1 = 100;
		i1 = 200; //不容许修改值
		
		final PI = 3.14;
		
	}
}