package com.uek;

/**
 * 外部比较器：将比较的方法提取到接口中，然后让比较的类来实现：
 *  步骤: 1.构建比较方法的接口（注意该方法有两个接口）；
 */
interface MyCompartor {
	//比较方法：
	public int compare(Object obj1 , Object obj2);
}

//2. 构建具有比较功能的类
class StuCompartor implements MyCompartor{

	//重写比较方法：比较分数，按照高低升序
	@Override
	public int compare(Object obj1, Object obj2) {
		if (obj1 instanceof Stu1 && obj2 instanceof Stu1) {
			Stu1 s1 = (Stu1) obj1;
			Stu1 s2 = (Stu1) obj2;
			if (s1.getScore() > s2.getScore()) {
				//可以返回两个属性值相减的结果，也可以直接返回值一个标记：
				return 1;//标记
			}else if (s1.getScore() < s2.getScore()) {
				return -1; //标记
			}
		}
		return 0;
	}
}

class Test{
	public static void main(String[] args) {
		
		Stu1 s1 = new Stu1("张三", 20, 90);
		Stu1 s2 = new Stu1("李四", 20, 90);
		
		//比较功能：构建外部比较器对象
		StuCompartor sc = new StuCompartor();
		int result = sc.compare(s1, s2);
		if (result > 0) {
			System.out.println("s1的分数高");
		}else if(result < 0) {
			System.out.println("s2的分数高");
		}else {
			System.out.println("一样");
		}
		
		Stu1[] s = new Stu1[] {new Stu1("张三",20,90) , new Stu1("李四",20,80) , new Stu1("王五",20,100)};
		Car[] c = new Car[] {new Car("奥迪", 200000) , new Car("宝马", 500000) , new Car("奔驰", 550000)};
		
	}
}








