package com.uek.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.sun.org.apache.xalan.internal.xsltc.trax.OutputSettings;

public class ReceiceAndSendFileThread extends Thread{
	private Socket selfSocket;
	private Socket friendSocket;
	private String selfId;
	private String friendId;
	private File file;
	public ReceiceAndSendFileThread(Socket selfSocket, Socket friendSocket, String selfId, String friendId, File file) {
		super();
		this.selfSocket = selfSocket;
		this.friendSocket = friendSocket;
		this.selfId = selfId;
		this.friendId = friendId;
		this.file = file;
	}
	@Override
	public void run() {
		InputStream in = null;
		OutputStream out = null;
		String fileName = file.getName();
		File file = new File("serverback"+selfId+"-"+friendId+fileName);
		FileOutputStream fos = null;
		try {
			in = selfSocket.getInputStream();
			out = friendSocket.getOutputStream();
			
			fos = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int date=-1;
			while((date = in.read(buf)) != -1) {
				fos.write(buf,0,date);
				out.write(buf,0,date);
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
