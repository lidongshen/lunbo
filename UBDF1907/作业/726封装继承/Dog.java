package homework;

 /* 使用面向对象的思想，编写自定义描述狗的信息。设定属性包括：品种，年龄，心情，名字；
  * 方法包括：叫，跑。
	要求：
	设置属性的私有访问权限，通过公有的get,set方法实现对属性的访问
	限定心情只能有“心情好”和“心情不好”两种情况，如果无效输入进行提示，默认设置“心情好”。
	设置构造函数实现对属性赋值
	叫和跑的方法，需要根据心情好坏，描述不同的行为方式。
	编写测试类，测试狗类的对象及相关方法（测试数据信息自定义）
 */
public class Dog {
	private String breed;
	private int age;
	private String mood;
	private String name;
	public Dog(String breed, int age, String mood, String name) {
		super();
		this.breed = breed;
		this.age = age;
		this.mood = mood;
		this.name = name;
	}
	public Dog() {
		super();
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMood() {
		
		return mood;
	}
	public void setMood(String mood) {
		if(mood.equals("心情好")||mood.equals("心情不好"))	
			 this.mood = mood;
		else
			System.out.println("无效输入");
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//叫和跑的方法，需要根据心情好坏，描述不同的行为方式。
	public void cry() {
		if(mood.equals("心情好"))
			System.out.println("名字叫"+name+"的"+breed+"心情很好，"+"开心的旺旺叫");
		else if(mood.equals("心情不好"))
			System.out.println("名字叫"+name+"的"+breed+"心情不好，"+"伤心的呜呜叫");
		else
			System.out.println("输入信息错误，这只狗心情很好");
	}
	public void run() {
		if(mood.equals("心情好"))
			System.out.println("名字叫"+name+"的"+breed+"心情很好，"+"开心的围着主人身边转");
		else if(mood.equals("心情不好"))
			System.out.println("名字叫"+name+"的"+breed+"心情不好，"+"伤心的一动不动");
		else
			System.out.println("输入信息错误，这只狗心情很好");
	}
	public static void main(String[] args) {
		//String breed, int age, String mood, String name
		Dog dog = new Dog("贵宾犬",2,"心情好","甜心");
		Dog dog1 = new Dog("德国牧羊犬",2,"心情不好","太子");
		Dog dog3 = new Dog("德国牧羊犬",2,"1","太子");
		dog.cry();
		dog.run();
		dog1.cry();
		dog1.run();
		dog3.cry();
		dog3.run();
	}
}
