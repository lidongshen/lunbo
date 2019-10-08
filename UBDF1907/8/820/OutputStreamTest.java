package com.IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 1) fileinputStream : 文件输入流
 * 2）fileOutputStream : 文件输出流
 */
public class OutputStreamTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		//1.构建输出流对象：指定程序输出数据的路径
		FileOutputStream fos = new FileOutputStream("C:\\Users\\UEK-N\\Desktop\\test.txt");
	
		//2.输出：
		//1)一次性写出一个字节；
		//fos.write('a');
		//2)一次性写出一个字节数组：
		//String str = "abc";
		//将一个字符串转成一个字节数组：
		//byte[] arr = str.getBytes();
		//fos.write("abc".getBytes());
		//3) 按照指定的范围，将字节数组中的元素写出；“abcdefg”
		fos.write("abcdefg".getBytes() , 0, 3);
		
		
		
		//3.关闭流；
		fos.close();
	
	
	
	}
}
