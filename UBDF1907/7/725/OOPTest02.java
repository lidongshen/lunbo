package com.uek.java;
/**
 *  需求：求两点之间的距离；
 *         勾股定理 ：
 *    两个点：
 *    		x1 x2   y1 y2
 *     (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)  开方  = 两点距离
 *   提示Java API : math . 开方 
 *  
 */
//类的模板：
class Point{
	int x;
	int y;
	public Point() {
		
	}
	public Point(int _x , int _y) {
		x = _x;
		y = _y;
	}
	//通过set方法给当前对象的属性赋值：
	public void setX(int _x) {
		x = _x;
	}
	public void setY(int _y) {
		y = _y;
	}
	
	//成员方法：求两点之间的距离：
	public double getDistance(int _x , int _y) {
		//开方方法：Math.sqrt()
		return Math.sqrt((x - _x) * (x - _x) + (y - _y) * (y - _y));
	}
	
	// 重载方法：接收一个对象，来作为当前方法的形参
	public double getDistance(Point p) {
		//开方方法：Math.sqrt()
		return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
	}
}

public class OOPTest02 {
	public static void main(String[] args) {
		
		//第一个点对象：
		Point p1 = new Point(5 , 6);
		//第二个点对象：
		Point p2 = new Point();
		p2.setX(8); //赋值
		p2.setY(10);
		
		int x = p2.x;
		int y = p2.y;
		//用第一个点对象调用方法，传递进第二个点对象的x 和y值；
		//double distance = p1.getDistance(x , y);
		//给方法传递的是一个对象的引用；
		/**
		 * p2 : 仅仅是一个对象引用(地址) ， 并不是p2对象传递给了方法；
		 *      操作对象，其实就是操作对象的地址；
		 */
		double distance = p1.getDistance(p2);
		System.out.println("两点之间的距离是"+distance);
	}
}
