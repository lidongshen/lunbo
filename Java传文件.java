package com.uek.v5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFileChooser;

public class Java传文件 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost",8888);
		OutputStream os = socket.getOutputStream();
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(null);
		File file = jfc.getSelectedFile();
		FileInputStream fis = new FileInputStream(file);
		byte[] by = new byte[1024];
		int data=0;
		while((data = fis.read(by))!=-1) {
			os.write(by, 0, data);
		}
		System.out.println("发送成功");
		fis.close();
	}
}
