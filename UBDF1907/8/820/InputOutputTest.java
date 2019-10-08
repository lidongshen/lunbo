package com.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 需求：对一个图片的文件进行拷贝：
 * 	C:\Users\UEK-N\Desktop\qq.png
 *  拷贝到指定的目录下：当前项目的根目录下：QQ.png
 */
public class InputOutputTest {
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		//思路：
		//1)构建输入输出流对象；
		String inputPath = "C:\\Users\\UEK-N\\Desktop\\qq.png";
		String outputPath = "QQ.png"; //相对路径，代表的就是当前项目的根目录
		try {
			fis = new FileInputStream(inputPath);
			fos = new FileOutputStream(outputPath);
		//2) 一边读取数据，一边写出数据（批量读取）
		    //注意：字节流操作时，缓冲数组的类型是Byte类型
			byte[] buf = new byte[1024];
			int tmp; //临时变量 , 读取字节的个数
			while((tmp = fis.read(buf)) != -1) {
				//fos.write(buf); // 1024 : 100  效率低 
				fos.write(buf , 0 , tmp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			//3)关闭流；
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
	}
}













