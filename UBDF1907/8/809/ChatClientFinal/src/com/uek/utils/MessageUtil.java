package com.uek.utils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;

import com.sun.security.ntlm.Client;
import com.uek.testIO和网络编程.v8.Client08;


public class MessageUtil {

	public static void sendMessage(String line)
	{
		PrintStream ps;
		try {
			ps = new PrintStream(Client08.selfSocket.getOutputStream());
			ps.println(line);
			ps.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Object readObject()
	{
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(Client08.selfSocket.getInputStream());
			
			return ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	
}
