package com.uek;

/**
 * Java比较器：
 * 需求：定义一个实体类（学生：name , age , score）
 * 		封装一个对象两两比较的方法（比较的策略：按照分数的高低进行比较，
 *      如果第一个对象比较第二个对象的分数，返回分数相减的结果，
 *      高 ： 高
 *      低 ： 低
 *      相等 : 相等）
 *      
 * 对代码进行重构：
 * 
 * Java比较器：
 * 	1) 内部比较器：将比较的方法，在比较类中实现；
 * 		实现步骤：（1）创建一个比较接口，在该接口中，设计一个比较方法：
 * 						public int compareTo(Object obj);
 * 				（2）让准备实现比较功能的类 ，实现比较接口，从而实现compareTo比较方法；
 * 				（3）在比较的过程中，使用冒泡排序来实现对所有对象的排序（升序，降序）；
 * 				（4）不管是比较方法、排序方法，都应该使用多态的语法，从而避免方法的大量重载；
 *
 * 需求：
 * 	学生的年龄降序排序；
 *  汽车的重量升序排序；
 *
 */

interface MyComparable{
	//抽象方法：
	public int compareTo(Object obj);
}

class Stu1 implements MyComparable{
	private String name;
	private int age;
	private int score;
	
	/**
	 * 比较方法：compareTo()
	 */
	public int compareTo(Object obj) {
		if (obj instanceof Stu1) {
			Stu1 s = (Stu1)obj;
			if (this.score - s.score > 0) {
				return this.score - s.score;
			}else if(this.score - s.score < 0) {
				return this.score - s.score;
			}
		}
		return 0;
	}
	
	public Stu1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stu1(String name, int age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	//重写三个Object方法：
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stu1 other = (Stu1) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Stu1 [name=" + name + ", age=" + age + ", score=" + score + "]";
	}
}


class Car implements MyComparable{
	private String name;
	private int price;
	private int weight; //重量
	
	/**
	 * 比较方法：比较策略是按照价格的高低
	 */
	public int compareTo(Object obj) {
		if (obj instanceof Car) {
			Car c = (Car)obj;
			if(this.price > c.price) {
				return this.price - c.price;
			}else if(this.price < c.price) {
				return this.price - c.price;
			}
		}
		return 0;
	}
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + "]";
	}
	
}

public class JavaEqualsTest {
	/**
	 * 优化：
	 */
/*	public static void sort(Stu1[] s) {
		for(int i=0;i<s.length-1;i++) {
			for(int j=0;j<s.length-i-1;j++) {
				//两两比较策略：分数高低进行升序
				if (s[j].compareTo(s[j+1]) > 0) {
					Stu1 temp = s[j];
					s[j] = s[j+1];
					s[j+1] = temp;
				}
			}
		}
	}
	
	public static void sort(Car[] s) {
		for(int i=0;i<s.length-1;i++) {
			for(int j=0;j<s.length-i-1;j++) {
				//两两比较策略：分数高低进行升序
				if (s[j].compareTo(s[j+1]) > 0) {
					Car temp = s[j];
					s[j] = s[j+1];
					s[j+1] = temp;
				}
			}
		}
	}*/
	
	/**
	 * 优化：可以满足实现了MyComparable接口下的所有实现类的比较功能：
	 */
	public static void sort(MyComparable[] s) {
		for(int i=0;i<s.length-1;i++) {
			for(int j=0;j<s.length-i-1;j++) {
				//两两比较策略：分数高低进行升序
				if (s[j].compareTo(s[j+1]) > 0) {
					MyComparable temp = s[j];
					s[j] = s[j+1];
					s[j+1] = temp;
				}
			}
		}
	}
	

	public static void main(String[] args) {
		
		Stu1 s1 = new Stu1("张三", 20, 90);
		Stu1 s2 = new Stu1("李四", 21, 80);
		
		//对象两两之间比较：
		int result = s1.compareTo(s2);
		if (result > 0) {
			System.out.println("s1的分数高于s2");
		}else if(result < 0) {
			System.out.println("s1的分数低于s2");
		}else {
			System.out.println("s1的分数等于s2");
		}
		
		Car c1 = new Car("奥迪" , 500000) ;
		Car c2 = new Car("宝马" , 800000) ;
		result = c1.compareTo(c2);
		if (result > 0) {
			System.out.println("c1的价格高于c2");
		}else if(result < 0) {
			System.out.println("c1的价格低于c2");
		}else {
			System.out.println("c1的价格等于c2");
		}
		
		/**
		 * 对数组中的元素按照指定的条件进行排序（升序）：
		 * 
		 */
		Stu1[] s = new Stu1[] {new Stu1("张三",20,90) , new Stu1("李四",20,80) , new Stu1("王五",20,100)};
		sort(s);
		Car[] c = new Car[] {new Car("奥迪", 200000) , new Car("宝马", 500000) , new Car("奔驰", 550000)};
		sort(c);
		for(Car temp : c) {
			System.out.println(temp);
		}
	}
}


















