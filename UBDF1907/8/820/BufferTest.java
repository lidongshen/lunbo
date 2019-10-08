package com.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲流（处理流）：
 *	需求：通过缓冲字节流实现，对图片的拷贝；
 */
public class BufferTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//1.构建对象：
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream("QQ.png");
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream("QQ1.png");
			bos = new BufferedOutputStream(fos);
			
		//2.数据传输：
			/*int i = bis.read();
			System.out.println((char)i);*/
			
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = bis.read(buf)) != -1) {
				bos.write(buf, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				//注意：
				//1)在关闭流时，只需要关闭处理流即可，
				//因为在关闭处理流的同时，就自动把节点流关闭了；
				//2) 关闭的顺序；后开的流，先关闭(保证数据在传输过程中，数据的零丢失)
				bos.close();
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}











