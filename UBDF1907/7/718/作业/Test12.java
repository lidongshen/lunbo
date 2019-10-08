package homework;

import java.util.Scanner;

public class Test12 {
	public static void main(String[] args) {
		//把100~150之间不能被3整除的数输出。
		int i=100;
		while(i<=150) {
			if(i%3!=0)
				System.out.println(i);
			i++;
		}

	}

}
