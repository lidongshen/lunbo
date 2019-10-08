package com.uek.extendsTest;
/**
 *  我 类 ：
 *  属性：钱 ，房子
 *  方法：赚钱
 *  
 *  小花 类：
 *	 属性：钱 ，房子
 *  方法：赚钱 ， 花钱
 *  
 *  小丽 类：
 *  属性：钱 ，房子
 *  方法：赚钱 ， 化妆
 */
public class Me {
	int money;
	int house;
	public Me() {}
	public Me(int money , int house) {
		this.money = money;
		this.house = house;
	}
	public void makeMoney() {
		System.out.println("我是程序员" +",工资："+
					this.money+",房子有："+this.house);
	}
}

/*
 * 继承：构建子类对象时，先构建父类对象，再构建子类对象
 */
class XiaoHua extends Me{
	
	public XiaoHua() {
		
	}
	public XiaoHua(int money , int house) {
		this.money = money;
		this.house = house;
	}
	
	public void spendMoney() {
		System.out.println("大家好，我是Me的一号女友，"
	         +this.money+","+this.house);
	}
	
	public static void main(String[] args) {
		//构建对象：
		Me me = new Me(11000, 0);
		me.makeMoney();
		
		XiaoHua xiaoHua = new XiaoHua(5000 , 0);
		xiaoHua.makeMoney();
		xiaoHua.spendMoney();
		
		XiaoHua xiaoHua1 = new XiaoHua();
		xiaoHua1.makeMoney();
		xiaoHua1.spendMoney();
	}
}



