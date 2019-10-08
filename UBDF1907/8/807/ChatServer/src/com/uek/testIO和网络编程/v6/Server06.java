
package com.uek.testIO和网络编程.v6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Server06 {
	
	//用集合存储所有连接到服务器的客户端对应的socket A撇 B撇 C撇
	//之所以不用数组，是因为数组长度有限
	//之所有用set没有用list，因为set不能重复 万一代码中写错了重复加，也加不进去
	public static Set<Socket> clientSockets = new HashSet<Socket>();
	
	
	public static void main(String[] args) throws IOException  {
		
		ServerSocket  ss = new ServerSocket(8888);
		
		System.out.println("服务器已经启动，准备等待客户端的连接。。。");
		System.out.println("ss.accept() 会线程阻塞 ，没有客户端连接 程序卡在这里 等待客户端连接");
		
	
		
		//不停的接收客户端的连接 并且读取客户端的输入 输出到自己的控制台
		while(true)
		{
			//接收客户端的连接
			Socket socket = ss.accept();
			
			clientSockets.add(socket);
			
			Thread t = new ServerThread(socket);
			t.start();
			
		}
		
		
	}
}


class ServerThread extends Thread
{
	private Socket socket;
	
	public ServerThread(Socket socket)
	{
		this.socket = socket;
	}
	
	@Override
	public void run() /*throws IOException 子类不能比父类抛出更多的异常*/  {
		
		PrintStream ps;
		try {
			
			ps = new PrintStream(socket.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String line = null;
			
			while( (line = br.readLine()) != null )
			{
//				socket.getInetAddress()
//				socket.getPort()
				System.out.println("服务器收到某个客户端的数据: " + line);
				
				for (Socket s : Server06.clientSockets) {
					
					PrintStream p = new PrintStream(s.getOutputStream());
					p.println("echo " + line);
					p.flush();
					
				}
				
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}