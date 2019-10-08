package com.uek.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class sendFileThread extends Thread{
	private Socket socket;
	private File file;
	public sendFileThread(Socket socket, File file) {
		super();
		this.socket = socket;
		this.file = file;
	}
	
	@Override
	public void run() {
		
		OutputStream fos = null;
		FileInputStream in = null;
		
		try {
			
			in = new FileInputStream(file);
			fos = socket.getOutputStream();
			byte[] buf = new byte[1024];
			int date=-1;
			while((date = in.read(buf)) != -1) {
				fos.write(buf,0,date);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
