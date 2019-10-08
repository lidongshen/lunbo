
package com.uek.testIO和网络编程.v3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server02 {
	
	public static void main(String[] args) throws IOException  {
		
		ServerSocket  ss = new ServerSocket(8888);
		
		System.out.println("服务器已经启动，准备等待客户端的连接。。。");
		System.out.println("ss.accept() 会线程阻塞 ，没有客户端连接 程序卡在这里 等待客户端连接");
		
		Socket socket = ss.accept();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		String line = null;
		
		while( (line = br.readLine()) != null )
		{
			
			System.out.println("服务器收到客户端的数据: " + line);
			
		}
		
		
	}
}
