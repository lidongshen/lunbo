package com.uek.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ReceiveFileThread extends Thread{
	private Socket socket;
	private File file;
	public ReceiveFileThread(Socket socket, File file) {
		super();
		this.socket = socket;
		this.file = file;
	}
	
	@Override
	public void run() {
		InputStream in = null;
		String fileName =file.getName();
		File file = new File("back"+fileName);
		FileOutputStream fos = null;
		
		try {
			in = socket.getInputStream();
			fos = new FileOutputStream(file);
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
