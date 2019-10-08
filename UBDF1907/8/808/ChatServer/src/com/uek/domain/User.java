package com.uek.domain;

/**
 * 数据库中的一张表table一般都会对应java中的一个class
 * column对应java的field
 * 
 * @author UEK-N
 *
 */
public class User {
	private int id;
	private String name;
	private String password;
	private String signature;
	private String header;
	
	
	
	//无参构造
	public User() {
		super();
	}
	
	//除了id全部参数
	public User(String name, String password, String signature, String header) {
		super();
		this.name = name;
		this.password = password;
		this.signature = signature;
		this.header = header;
	}
	

	public User(int id, String name, String signature, String header) {
		super();
		this.id = id;
		this.name = name;
		this.signature = signature;
		this.header = header;
	}
	
	//全部参数
	public User(int id, String name, String password, String signature, String header) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.signature = signature;
		this.header = header;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", signature=" + signature + ", header="
				+ header + "]";
	}
	
	
	
}
