package com.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 需求：使用缓冲字符流实现纯文本的拷贝；
 * 新内容：在读的过程中：一次性读取一行方法：readLine；
 * 			如果读取完毕，该方法返回null;
 */
public class BufferedReaderWriterTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//提升变量的作用域：
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader("test.txt"));
			bw = new BufferedWriter(new FileWriter("test2.txt"));
			
			//在读的过程中：一次性读取一行方法：readLine；
			/*System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());*/
			
			/*char[] buf = new char[1024];
			int len = 0;
			while((len = br.read(buf)) != -1) {
				bw.write(buf, 0, len);
			}*/
			String str = "";
			while((str = br.readLine()) != null) {
				//System.out.print(str+'\n');
				bw.write(str);
				bw.newLine(); // 换行
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (br != null) {
					br.close();
				}
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
