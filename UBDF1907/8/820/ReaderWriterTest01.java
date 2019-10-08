package com.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 文件字符流：
 *	
 */
public class ReaderWriterTest01 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		
		//1.构建字符输入流对象： 字符 = 2个字节（“a”,"李"）
		String inputPath = "C:/Users/UEK-N/Desktop/test.txt";
		FileReader fr = null;
		try {
			fr = new FileReader(inputPath);
			
		//2.读取数据：
			//一次读取一个字符：
			//int c = fr.read();
			//System.out.println((char)c);
			
			//循环读取：效率低
			/**
			 * 注意：对于字符流来说，要求数据源和程序的编码格式必须一致
			 * 		否则出现乱码；
			 */
			/*int temp = 0;//临时变量，临时的接收读取到的数据
			while((temp = fr.read()) != -1) {
				System.out.print((char)temp);
			}*/
			
			//添加一个缓冲区，效率高，推荐使用的
			//构建缓冲区：注意：字符流的缓冲数组的类型是char类型；
			char[] buf = new char[1024];
			int temp = 0;//临时变量，临时的接收读取到的数据
			
			//int length = fr.read(buf); //length代表的是数组中读取到的字符的个数
			//System.out.println(length);
			
			while((temp = fr.read(buf)) != -1) {
				//使用String类来进行封装
				//String str = new String(buf);
				String str = new String(buf, 0, temp);
				System.out.print(str);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}
