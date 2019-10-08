package homework;
public class Test02 {
	public static boolean prime(int num) {
			boolean flag=true;
			for(int j=2;j<num;j++) 
				if(num%j==0) {
					flag=false;
					break;
				}	
				return flag;
	}	
	public static void main(String[] args) {
		//判断1-100之间有多少个素数并输出所有素数。（将判断一个数是否是素数的功能提取成方法，在循环中直接调用即可）
		int count=0;
		for(int i=1;i<=100;i++) {
			boolean flag=prime(i);
			if(flag) {
			count++;
			System.out.println(i);
			}	
		}
		System.out.println("素数有："+count);
	}
}
