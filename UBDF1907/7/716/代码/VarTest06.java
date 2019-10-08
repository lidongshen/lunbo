public class VarTest06{
	public static void main(String[] args){
		
		//布尔类型：boolean
		//布尔类型：只有两个值：true false;
		//布尔类型：占用1个字节（只占1个字节中的一个bit位）；
		boolean flag = true;
		System.out.println(flag);
		boolean b1 = false;
		System.out.println(b1);
		
		/*
		 使用场景：
			用于流程控制；
		  if(boolean值){}
		  如果为true,代表条件是成立的，执行分支中的语句
		  如果为false,代表不成立，那么就不会执行分支语句
		*/
		//分支结构：
		//flag = true ;
		if(b1){
		   //System.out.println("看我执不执行");
		}
		
		//循环结构：内存溢出
		while(true){
			System.out.println("看我执不执行");
		}
	}
}




