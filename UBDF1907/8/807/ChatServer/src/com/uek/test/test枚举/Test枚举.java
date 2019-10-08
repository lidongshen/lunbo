package com.uek.test.test枚举;

import java.util.Scanner;

public class Test枚举 {

	public static void main(String[] args) {
		
		//new SEASON();
		
		SEASON s = SEASON.SPRING;
		
		switch (s) {
		case SPRING:
			System.out.println("春暖花开");
			break;
		case SUMMER:
			System.out.println("太热了");
			break;
		case AUTUMN:
			System.out.println("果实成熟了");
			break;
		case WINTER:
			System.out.println("冬日暖阳");
			break;
		default:
			break;
		} 
		
		
	}
	
}


