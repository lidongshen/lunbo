package com.uek.domain;

public class Crowd {
	//变量
	private int id;
	private int createrId;
	private String createrTime;
	private String name;
	private String description;
	private String logo;
	//构造方法
	public Crowd(int id, int createrId, String createrTime, String name, String description, String logo) {
		super();
		this.id = id;
		this.createrId = createrId;
		this.createrTime = createrTime;
		this.name = name;
		this.description = description;
		this.logo = logo;
	}
	public Crowd(int createrId, String createrTime, String name, String description, String logo) {
		super();
		this.createrId = createrId;
		this.createrTime = createrTime;
		this.name = name;
		this.description = description;
		this.logo = logo;
	}
	public Crowd() {
		super();
	}
	//get和set方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCreaterId() {
		return createrId;
	}
	public void setCreaterId(int createrId) {
		this.createrId = createrId;
	}
	public String getCreaterTime() {
		return createrTime;
	}
	public void setCreaterTime(String createrTime) {
		this.createrTime = createrTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	//toString方法
	@Override
	public String toString() {
		return  id + "," + createrId + "," + createrTime + "," + name + "," + description + "," + logo;
	}
	
	
	
}
