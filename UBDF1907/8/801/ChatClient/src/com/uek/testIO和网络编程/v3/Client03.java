package com.uek.testIO和网络编程.v3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client03 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("localhost" , 8888);
		
		OutputStream os = socket.getOutputStream();
		
		PrintStream ps = new PrintStream(os);
		
		//System.in就是标准输入就是键盘 （没有重定向的情况下）
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		while( (line = br.readLine()) != null )
		{
			
			ps.println(line);
			
			ps.flush();
		}
		
		
		
	}
}
