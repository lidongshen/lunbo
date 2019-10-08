package com.uek.test.test异常;

public class Test编译型异常和运行时异常 {
	
	public static void main(String[] args)  {
		
		//运行时异常 一般是一些编程可以避免的一些较为低级的问题
//		System.out.println(args[1]);

		System.out.println(1/0);
		
		throw new ArithmeticException();
		
//		//编译时异常时 编程时候可能避免不了的，由于文件不存在 挪动了位置
//		//这种情况要求程序员预先定义好应急的方案，如果发生了该异常如何处理
//		//编译时异常又叫做受监测异常 checkedException
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			
//			
//			System.out.println(22);
//		} /*catch (Exception e) {//catch块有大小的，前边的不能比后边的大
//							   //还有一个catch可以没有 但是catch没有finally一定要有
//							   //try不能单独存在
//			e.printStackTrace();
//			
//		} */catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			
//			return;
//			//System.exit(-1);//虚拟机退出
//			
//		} catch (NullPointerException e) {//catch可以让运行时异常作为参数
//			e.printStackTrace();
//			
//		}finally{//只要虚拟机不退出一定执行 return都阻止不了finally
//				  //finally一般用于try块打开了一些资源 比如文件数据库连接
//				  //关闭的代码放这里
//			System.out.println(33);
//		}
//		
//		
//		System.out.println(11);
	}
	
}
