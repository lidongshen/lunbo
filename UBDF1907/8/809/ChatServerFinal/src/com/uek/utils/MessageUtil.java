package com.uek.utils;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;


/**
 * 服务器和客户端发送和接收数据的工具类
 * @author 86139
 *
 */
public class MessageUtil {

	/**
	 * 对特定的客户端发送line信息
	 * @param socket
	 * @param line
	 */
	public static void sendMessage(Socket socket , String line)
	{
		PrintStream ps;
		try {
			ps = new PrintStream(socket.getOutputStream());
			ps.println(line);
			ps.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 对特定的客户端发送object
	 * @param socket
	 * @param line
	 */
	public static void sendObject(Socket socket , Object object)
	{
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(object);
			oos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
