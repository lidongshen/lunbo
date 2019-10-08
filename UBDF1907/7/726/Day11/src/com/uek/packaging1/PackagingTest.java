package com.uek.packaging1;

import com.uek.packaging.BigDog;
import com.uek.packaging.Student;

public class PackagingTest {
	public static void main(String[] args) {
		
		Student s = new Student();
		//因为已经不是属于同一个包下，所以，当前外界就不可以操作默认的
		//访问权限修饰的对象成员（成员变量，成员方法）
/*		s.age = 50;
		s.info();*/
		s.length = 175;
		s.say();
		
		
		
		BigDog bigDog = new BigDog("黑色" , 3 , "公");
		bigDog.sleep();
	}
}
