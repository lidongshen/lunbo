package com.uek.test.test设计模式;

/**
 * abstract
 * 	class		抽象类		
 * 					有得有失（和普通类相比）
 * 					得到了拥有抽象方法的能力，失去了new的能力
 * 
 *  method		抽象方法
 *  				只有方法签名没有方法体 注意{}即使不写代码也是方法体
 *  
 * 到底什么时候使用abstract呢？典型场景模板设计模式
 * 
 * 模板设计模式
 * 	A类中有一个方法用到了B方法，但是B方法在当前的类还没有办法确定，这样
 *  B方法只能定义成抽象的，这样A类只能定义成抽象类
 * 
 * @author UEK-N
 *
 */
public class Test模板设计模式 {
	
	public static void main(String[] args) {
		CommonSpeeder cs1 = new CarSpeeder(1000 , 10);
		System.out.println(cs1.computerSpeed());
		
		CommonSpeeder cs2 = new TankSpeeder(1000 , 10);
		System.out.println(cs2.computerSpeed());
	}
}


/**
 * 通用的测速仪 
 * 	可以测小轿车
 *  可以测坦克
 *  
 *  规定速度公式 速度 = 周长/转速
 *  
 * @author UEK-N
 *
 */
abstract class CommonSpeeder
{
	private double turnRate;
	
	public CommonSpeeder()
	{
		
	}
	
	public CommonSpeeder(double turnRate)
	{
		this.turnRate = turnRate;
	}
	
	public double computerSpeed()
	{
		return computerZC() / turnRate;
	}
	
	//计算周长的方法在当前的通用测速仪确定不了 
	//如果是小轿车 2*pi*r
	//如果是坦克   6*bc
	public abstract double computerZC();
}


class CarSpeeder extends CommonSpeeder
{
	private double r;
	
	public CarSpeeder()
	{
		
	}
	
	public CarSpeeder(double turnRate , double r)
	{
		super(turnRate);
		this.r = r;
	}
	
	@Override
	public double computerZC() {
		
		return 2*Math.PI*r;
	}
	

}

class TankSpeeder extends CommonSpeeder
{
	private double bc;
	
	public TankSpeeder()
	{
		
	}
	
	public TankSpeeder(double turnRate , double bc)
	{
		super(turnRate);
		this.bc = bc;
	}
	
	@Override
	public double computerZC() {
		
		return 6*bc;
	}
	

}

