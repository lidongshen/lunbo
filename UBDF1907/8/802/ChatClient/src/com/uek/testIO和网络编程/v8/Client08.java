package com.uek.testIO和网络编程.v8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import javax.swing.JOptionPane;

import com.uek.view.RegisterView;

public class Client08 {
	
	//客户端任意时刻想要和服务器通信，都可以拿这个socket
	public static Socket selfSocket;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("localhost" , 8888);
		
		Client08.selfSocket = socket;
		
		//启动一条线程负责读取服务器任意时刻的返回信息
		Thread t = new ClientThread(socket);
		t.start();
		
		
		RegisterView rv = new RegisterView();
		rv.init();
		
	}
}

class ClientThread extends Thread
{
	private Socket socket;
	
	public ClientThread(Socket socket)
	{
		this.socket = socket;
		
	}
	
	@Override
	public void run() {
		//不停的读取网络（服务器）发送过来的数据 echo+原本的信息
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String line = null;
			
			while( (line = br.readLine()) != null )
			{
				
				System.out.println("客户端收到服务器的数据: "+line);
				
				String[] strs = line.split(",");
				
				//客户端要注册 1,ok 或 1,nook
				if("1".equals(strs[0]))
				{
					if("ok".equals(strs[1]))
					{
						JOptionPane.showMessageDialog(null, "注册成功!");
						
					}else
					{
						JOptionPane.showMessageDialog(null, "注册失败!");
					}
				}
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
