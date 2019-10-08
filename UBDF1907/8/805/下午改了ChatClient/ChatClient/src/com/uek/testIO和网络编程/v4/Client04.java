package com.uek.testIO和网络编程.v4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client04 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("localhost" , 8888);
		
		OutputStream os = socket.getOutputStream();
		
		PrintStream ps = new PrintStream(os);
		
		//System.in就是标准输入就是键盘 （没有重定向的情况下）
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		//线程阻塞
		while( (line = br.readLine()) != null )
		{
			ps.println(line);
			
			ps.flush();
		}
		
		//不停的读取网络（服务器）发送过来的数据 echo+原本的信息
		BufferedReader br1;
		try {
			br1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String line1 = null;
			
			while( (line1 = br1.readLine()) != null )
			{
				
				System.out.println("客户端收到服务器的数据: "+line1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

