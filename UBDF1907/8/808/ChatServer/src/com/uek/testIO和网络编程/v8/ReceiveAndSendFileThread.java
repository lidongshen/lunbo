package com.uek.testIO和网络编程.v8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//读取任意时刻任意客户端给另外客户端发送的文件数据
//先落地到服务器一份，文件名规则(不严谨) zs-ls-hello.txt
class ReceiveAndSendFileThread extends Thread {
	private Socket selfSocket;
	private String selfUsername;
	private Socket friendSocket;
	private String friendUsername;

	private File file;

	public ReceiveAndSendFileThread(Socket selfSocket, String selfUsername,
			Socket friendSocket, String friendUsername, File file) {
		
		this.selfSocket = selfSocket;
		this.selfUsername = selfUsername;
		this.friendSocket = friendSocket;
		this.friendUsername = friendUsername;
		this.file = file;
	}

	// 读socket发送过来的数据,写到本地磁盘fileName
	public void run() {

		System.out.println("服务器开始工作，接受A传输过来的数据一边落本地磁盘，一遍给B");
		
		InputStream in = null;
		OutputStream out = null;

		String fileName = file.getName();

		File file = new File("serverback" + selfUsername + "-"
				+ friendUsername + fileName);

		FileOutputStream fos = null;

		try {

			in = selfSocket.getInputStream();//输入关联网络 也就是读网络数据
			out = friendSocket.getOutputStream();//输出也是网络 就是给好友网络

			fos = new FileOutputStream(file);//输出是本地磁盘 服务器做备份的

			byte[] buf = new byte[1024];

			int length = -1;

			while ((length = in.read(buf)) != -1) {
				// 因为最后一次读的时候字节数组不能读满
				// fos.write(buf);
				// 落服务器本地磁盘
				fos.write(buf, 0, length);

				// 传接受者网络
				out.write(buf, 0, length);
			}

			System.out.println("服务器结束工作，接受A传输过来的数据一遍落本地磁盘，一遍给B");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("文件传输完毕，这个线程也要结束了");

	}
}