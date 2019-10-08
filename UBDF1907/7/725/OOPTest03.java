package com.uek.java;

//圆类
class Circle{
	double r; //半径
	Point p;  // null对象
	final double PI = 3.1415; //常量，值不可修改
	public Circle() {
		
	}
	public Circle(double _r , Point _p) {
		r = _r;
		p = _p;
	}
	
	public void setP(Point  _p) {
		p = _p;
	}
	
	public void setR(double _r) {
		r = _r;
	}
	
	//周长：
	public void getC() {
		System.out.println("周长：" + (2 * r * PI));
	}
	//面积：
	public void getS() {
		System.out.println("面积：" + (r * r * PI));
	}
	//是否在：
	public void isIn(Point _p) {
		//思路：
		double distance = Math.sqrt( 
				// null.x   null.y 相当于在操作空对象；
				(p.x - _p.x) * (p.x - _p.x) + (p.y - _p.y) *  (p.y - _p.y));
		if (distance > r) {
			System.out.println("不在圆内");
		}else if(distance < r) {
			System.out.println("在圆内");
		}else {
			System.out.println("在圆上");
		}
	}
	/*
	 * 在类的模板中，存放main方法：
	 */
	public static void main(String[] args) {
		//构建圆对象;
		Circle c = new Circle();
		//构建圆心对象：
		Point p = new Point(5, 6);
		//赋值:
		c.setP(p);
		//c.r = 3.5;
		c.setR(5);
		
		c.getC();
		c.getS();
		
		Point p1 = new Point(6, 8);
		c.isIn(p1);
		
	}
	
}

/**
 *   main方法属于一个特殊方法，它和主类从代码结构上来说，属于
 *   依存关系；
 *   但是从功能上来说，二者之间没有关系；
 */
/*class Test{
	public static void main(String[] args) {
		
	}
}*/











public class OOPTest03 {

}
