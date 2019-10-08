
package com.uek.testIO和网络编程.v7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server07 {
	
	public static Map<String , Socket> nameAndSockets = new HashMap<String ,Socket>();
	
	public static void main(String[] args) throws IOException  {
		
		ServerSocket  ss = new ServerSocket(8888);
		
		System.out.println("服务器已经启动，准备等待客户端的连接。。。");
		System.out.println("ss.accept() 会线程阻塞 ，没有客户端连接 程序卡在这里 等待客户端连接");
		
	
		
		//不停的接收客户端的连接 并且读取客户端的输入 输出到自己的控制台
		while(true)
		{
			//接收客户端的连接
			Socket socket = ss.accept();
			
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
				
				String[] strs = line.split(",");
				
				//客户端要注册 1,zs
				if("1".equals(strs[0]))
				{
					String name = strs[1];
					
					String returnMessage = null;
					
					if(Server07.nameAndSockets.containsKey(name))
					{
						returnMessage = "1,nook";
						
					}else
					{
						//登录成功 服务器把新加入的用户 用户名和对应的socket存好hashmap
						Server07.nameAndSockets.put(name, socket);
						
						System.out.println("欢迎"+name+"登录聊天室！");
						returnMessage = "1,ok";
					}
					

					ps.println(returnMessage);
					ps.flush();
				}
				
				//客户端要群聊
				//2,zs,hello everyone
				if("2".equals(strs[0]))
				{
					//遍历服务器中存储的所有的客户端的Socket
					for(Socket s : Server07.nameAndSockets.values() )
					{
						ps = new PrintStream(s.getOutputStream());
						ps.println(line);
						ps.flush();
					}
					
				}
				
				//客户端要私聊
				//3,zs,ls,hello ls
				if("3".equals(strs[0]))
				{
					Socket toSocket = Server07.nameAndSockets.get(strs[2]);
					
					ps = new PrintStream(toSocket.getOutputStream());
					ps.println(line);
					ps.flush();
				}
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}