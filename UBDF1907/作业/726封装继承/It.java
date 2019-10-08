package homework;

import java.util.Scanner;

/*以面向对象的思想，编写自定义类描述IT从业者。
 * 设定属性包括：姓名，年龄，技术方向，工作年限；
 * 方法包括：工作
要求：
 设置属性的私有访问权限，通过公有的get,set方法实现对属性的访问
 限定IT从业人员必须年满15岁，无效信息需提示，并设置默认年龄为15。
工作方法通过输入参数，接收工作单位和职务，输出个人工作信息
 编写测试类，测试IT从业者类的对象及相关方法（测试数据信息自定义）
运行效果图:
*/
public class It {
	Scanner sc= new Scanner(System.in);
	private String name;
	private int age;
	private String technologyTo;
	private int year;
	public It(String name, int age, String technologyTo, int year) {
		super();
		this.name = name;
		this.age = age;
		this.technologyTo = technologyTo;
		this.year = year;
	}
	public It() {
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
		//限定IT从业人员必须年满15岁，无效信息需提示，并设置默认年龄为15。
		if(age>=15)
			this.age = age;
		else {
			
			System.out.println("无效信息");
			
		}
		}
	public String getTechnologyTo() {
		return technologyTo;
	}
	public void setTechnologyTo(String technologyTo) {
		this.technologyTo = technologyTo;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	//工作方法通过输入参数，接收工作单位和职务，输出个人工作信息
	public void work() {
		System.out.println("目前就职：");
		String workIn=sc.next();
		System.out.println("职务是：");
		String duty=sc.next();
		if(age>=15) {
		System.out.println("姓名："+name+",年龄："+age+",技术方向："+technologyTo+",工作年限："+year+",目前就职："+workIn+",职务是："+duty);
		}else {
			age=15;
			System.out.println("年龄信息无效，已修改为默认的15");
			System.out.println("姓名："+name+",年龄："+age+",技术方向："+technologyTo+",工作年限："+year+",目前就职："+workIn+",职务是："+duty);
		}
		}
	public static void main(String[] args) {
		//String name, int age, String technologyTo, int year
		It it = new It("马维龙",15,"数据库维护",10);
		it.work();
		It it1 = new It("张凯",10,"Java开发",1);
		it1.work();
	}
}
