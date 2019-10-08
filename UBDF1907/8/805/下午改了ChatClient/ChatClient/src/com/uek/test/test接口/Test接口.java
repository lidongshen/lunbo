package com.uek.test.test接口;

public class Test接口 {
	
	public static void main(String[] args) {
		Cat cat = new Cat();
		Dog dog = new Dog();
		
		House house = new House();
		
		house.catchMouse(cat);
		house.keepHouse(cat);
		
		
	}
}

class House
{
	//定义抽象不要定义具体，定义接口不要定义实现 程序扩展性好很多，实现多态
	//这种定义是非常合理的，考虑一个场景 ，夏天很热，降温，降温需要给你什么呢？
	//空调？风扇？扇子 其实不是需要具体的事物，实际需要的是能力，是降温能力
	//多态的一个很重要的应用场景
	//多态：同样类型变量，执行同一个方法，但是表现出来的行为特征是不一样的
	void keepHouse(/*Dog dog*/ KeepHouseAble a)
	{
		a.keepHouse();
	}
	
	void catchMouse(Cat cat)
	{
		cat.catchMouse();
	}
}

//extends 是 is a的关系 cat愿意她妈也不愿意 因为改了种族了
//给Cat 报班 培训下看家
class Cat /*extends Dog*/ implements KeepHouseAble
{
	void catchMouse()
	{
		System.out.println("猫天生会抓老鼠！");
	}

	@Override
	public void keepHouse() {
		
		System.out.println("猫经过培训，会用猫的方式看家！");
		
	}
	
	
}

class Dog implements KeepHouseAble
{
	public void keepHouse()
	{
		System.out.println("狗天生会看家！");
	}
}

//办了一个培训班，培训抓老鼠
//接口是has a 的关系
interface KeepHouseAble
{
	void keepHouse();

}
