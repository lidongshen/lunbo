package com.uek.domain;


//1 定义一个和数据库t_crowd对应的一个class 
public class Crowd {
	
	//2 table的一个column对应java的一个field
	private int id;
	private String name;
	private String logo;
	private int createrId;//creater_id
	private String createTime;
	private String description;
	
	//3 3个构造器 五参数 全部field 缺id的全部field
	
	public Crowd(int id, String name, String logo, int createrId, String createTime, String description) {
		super();
		this.id = id;
		this.name = name;
		this.logo = logo;
		this.createrId = createrId;
		this.createTime = createTime;
		this.description = description;
	}
	
	

	public Crowd(String name, String logo, int createrId, String createTime, String description) {
		super();
		this.name = name;
		this.logo = logo;
		this.createrId = createrId;
		this.createTime = createTime;
		this.description = description;
	}


	
	public Crowd() {
		super();
	}

	//get set方法
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public int getCreaterId() {
		return createrId;
	}
	public void setCreaterId(int createrId) {
		this.createrId = createrId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	//5 toString
	@Override
	public String toString() {
		return "Crowd [id=" + id + ", name=" + name + ", logo=" + logo + ", createrId=" + createrId + ", createTime="
				+ createTime + ", description=" + description + "]";
	}
	
	
	
	
	
}
