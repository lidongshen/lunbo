package com.uek.packaging2;

/**
 * 产品类：
 * 产品种类类：
 */
class ProductType{
	private int id;
	private String ptName;
	public ProductType() {
		
	}
	public ProductType(int id , String ptName) {
		this.id = id;
		this.ptName = ptName;
	}
	public void setId(int id) {
		this.id = id;
	}
	//get方法：[修饰符] 返回值类型 get+属性名(){
	//                                    方法体（return 属性名）；
	//                  }
	public int getId() {
		return id;
	}
	public void setPtName(String ptName) {
		this.ptName = ptName;
	}
	public String getPtName() {
		return ptName;
	}
	/**
	 * set方法： 外界通过该方法为对象的属性赋值；
	 * get方法：外界获取对象的属性值；
	 */
	
}

class Product{
	private int pid;
	private String pname;
	private int amount;
	private double price;
	private ProductType pt;   //产品种类 ,引用类型
	
	public Product() {}
	public Product(int pid , String pname , int amount , double price , ProductType pt) {
		this.pid = pid;
		this.pname = pname;
		this.amount = amount;
		this.price = price;
		this.pt = pt;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setAmount(int amount) {
		if (this.amount < 0) {
			System.out.println("库存没有，需要添加货物！");
		}
		this.amount = amount;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setPt(ProductType pt) {
		this.pt = pt;
	}
	public int getPid() {
		return pid;
	}
	public String getPname() {
		return pname;
	}
	public int getAmount() {
		return amount;
	}
	public double getPrice() {
		return price;
	}
	public ProductType getPt() {
		return pt;
	}
	
	public void info() {
		//产品压货的总价：
		System.out.println("产品编号" + this.pid+",产品名称"+pname
				+",库存："+amount +",种类名称："+pt.getPtName()
				+",种类编号:"+ pt.getId() +",价格："+this.price
				+"产品压货的总价：" + amount * price);
	}
}

public class PackagingTest2 {
	public static void main(String[] args) {
		
		ProductType pt = new ProductType();
		pt.setId(10);
		pt.setPtName("生活用品");
		
		Product p1 = new Product(1, "洗发露", 100, 40.5 , pt);
		p1.info();
		
		Product p2 = new Product();
		p2.setPid(2);
		p2.setPname("机械键盘");
		p2.setAmount(10);
		p2.setPrice(200);
		//p2.setPt();
		
		p2.info();
		
		
	}
}




