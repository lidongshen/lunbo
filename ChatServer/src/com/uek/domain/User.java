package com.uek.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String name;
	private String passWord;
	private String signature;
	private String heared;
	public User(int id, String name, String passWord, String signature, String heared) {
		super();
		this.id = id;
		this.name = name;
		this.passWord = passWord;
		this.signature = signature;
		this.heared = heared;
	}
	public User(String name, String passWord, String signature, String heared) {
		super();
		this.name = name;
		this.passWord = passWord;
		this.signature = signature;
		this.heared = heared;
	}
	public User() {
		super();
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
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getHeared() {
		return heared;
	}
	public void setHeared(String heared) {
		this.heared = heared;
	}
	@Override
	public String toString() {
		return id + "," + name + "," + passWord + "," + signature + ","
				+ heared;
	}
	
	public static void main(String[] args) {
		List arrayList = new ArrayList();
		User user = new User("name", "passWord", "signature", "heared");
		User user1 = new User("name", "passWord", "signature", "heared");
//		arrayList.add(user);
//		arrayList.add(user1);
		if(arrayList.isEmpty()) {
		System.out.println(arrayList);}
		else {
			System.out.println("1");
		}
//		StringBuffer sb = new StringBuffer();
//		for (User user2 : arrayList) {
//			sb.append(user2);
//			sb.append(";");
//		}
//		System.out.println(sb);
	}
}
