package com.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;

/**
 * IO流：
 * 	IO : input(输入) , output（输出）
 * 		作为输入输出是针对于程序来说的；
 * 	
 * IO流分类：
 * 	1）按照流的方向不同：
 * 		输入流：从外界（文件，数据库，网络）将数据输入到程序；
 * 		输出流：数据从程序输出到外界；
 *  2）按照流的单位不同：
 * 		字节流：在数据传输的过程中，一个字节一个字节的进行传输；
 * 		字符流：在数据传输的过程中，一个字符一个字符的进行传输；
 *  3）按照功能的不同：
 *  	节点流：最基础的流，功能比较单一；
 *      处理流：在节点流的基础上进行功能增强；
 *  
 *  IO API 流的体系：
 *  	在jdk中，IO流的所有的类都封装在java.io包；
 *   在IO流中由四个抽象类来进行组织；
 *   1）inputStream: 字节输入流的所有类的父类；
 *   	 FileInputStream  ： 从文件系统中的某个文件中获得输入字节；
 *       ObjectInputStream ： 将已经序列化后的数据，进行反序列化；
 *       BufferinputStream ：自带一个缓冲区的字节输入流；
 *   2）outputStream: 字节输出流的所有类的父类；
 *   	FileoutputStream  ： 从文件系统中的某个文件中获得输出字节；
 *      ObjectoutputStream ： 将对象的数据进行序列化，从内存中持久化到磁盘；
 *      BufferoutputStream ：自带一个缓冲区的字节输出流；
 *   3）Reader ; 用于读取字符流的抽象类;
 *   	FileReader : 文件字符输入流；
 *      BufferedReader : 自带一个缓冲区的字符输入流；
 *    4）Writer ： 用于输入字符流的抽象类;
 *    	FileWriter : 文件字符输出流；
 *      BufferedWriter : 自带一个缓冲区的字符输入流；
 */
public class Test {
	
	public static void main(String[] args) throws IOException {
	
		/**
		 * FileInputStream: 字节输入流：
		 */
		//1.构建对象：
		//FileInputStream(String name)  : name,程序要读取文件的路径
		//路径分为：绝对路径，相对路径
		// 注意：在字符串中编写路径时：(1)\ 需要转义: \\ = \ (2) \ = /(跨平台的，所有系统都识别)
		//编译时异常：
		FileInputStream fis = new FileInputStream("C:/Users/UEK-N/Desktop/test.txt");
		//FileInputStream fis = new FileInputStream("C:/Users/UEK-N/Desktop");
		
		//2.读取数据;
		//read() : 从此输入流中读取一个数据字节,返回的是该值的对应的十进制数
		//一个字节一个字节读取;
		//System.out.println(fis.read());
		//System.out.println(fis.read());
		//System.out.println(fis.read()); 
		
		//第一种方式：
		/*int date = 0; //临时变量，临时存储数据
		//当文件中还有数据，就循环读取
		//(date = fis.read())!= -1 ； 首先通过read方法将数据获取到然后赋值给临时变量date,
		//然后来判断read方法返回的结果是否为-1,如果是-1，则代表数据已经读取完毕
		//一个字节一个字节读取;
		while((date = fis.read())!= -1) {
			System.out.print((char)date);
		}*/
	
		//第二种方式：手动添加一个缓冲区 , 推荐使用
		//缓冲区;
		byte[] buf = new byte[7]; //缓冲区的大小是根据读取读取数据量的大小来决定
		int date = 0;
		while((date = fis.read(buf)) != -1) {
			//将一个字节数组中的指定的范围内的元素转成字符串：
			String str = new String(buf , 0 , buf.length);
			System.out.println(str);
		}
		
		//第三种方式：手动添加一个缓冲区
		fis.read(buf, 0, 3);
		System.out.println(new String(buf));
		
		
		
		//3.关闭流：
		fis.close();
	}
}





















