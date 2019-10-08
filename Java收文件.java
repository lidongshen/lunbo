package com.uek.v5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Java收文件 {

	public static void main(String[] args) throws Exception, IOException {
		ServerSocket ss = new ServerSocket(8888);
		Socket socket = ss.accept();
		InputStream is = socket.getInputStream();
		FileOutputStream fos = new FileOutputStream("src/1(2).txt"); 
		int size = 0;
		byte[] by = new byte[1024];
		while((size=is.read(by))!=-1){
			System.out.println(size);
			fos.write(by, 0, size);
		}
		
	}
}
