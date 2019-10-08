package com.uek1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class DateTest01 {
	public static void main(String[] args) throws ParseException {
		/**
		 * JDK1.8 之前：时间相关类
		 */
		/**
		 * 1）System.currentTimeMillis() ： 以毫秒数来表示当前系统时间：
		 * 当前时间与协调世界时 1970 年 1 月 1 日午夜之间的时间差（以毫秒为单位测量）。
		 *	时间戳 ： 毫秒数；
		 */
		long timeMillis = System.currentTimeMillis();
		String str = "";
		/*for (int i = 0; i < 10000000; i++) {
			str += i;
		}*/
		long timeMillis1 = System.currentTimeMillis();
		System.out.println(timeMillis1 - timeMillis); 
		
		/**
		 * 2） Java.util.Date类：以对象的方式，来表示当前系统时间
		 * 	   Java.sql.Date类（子类） ： 对应着数据库中的日期类型
		 * 
		 * 两个构造方法：
		 * 	(1)new Date(); 构建当前系统时间对象
		 * 	（1）new Date(long time); 通过long值指定构建系统时间对象
		 * 两个功能方法：
		 * 	(1)date.getTime() ；返回当前date表示时间对应的时间戳
		 * （2）toString() : 显示对象格式：dow mon dd hh:mm:ss zzz yyyy
		 */
		//构建date对象；
		Date date = new Date();
		System.out.println(date.toString()); //
		long time = date.getTime();
		System.out.println(time); //1565856555557
		Date date2 = new Date(1560000000L);
		System.out.println(date2); //
		
		/**
		 * 3) SimpleDateFormat : 对日期date类对象进行格式化，解析；
		 * 构造方法：
		 * 	（1） 无参 : 使用默认格式来对日期进行格式化
		 *  （2）有参 : 可以指定日期格式化的正则匹配格式
		 * 方法：
		 *  格式化：  String format(Date date)
		 *  解析：    Date parse(String time)
		 */
		//构建时间格式化对象;
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date date3 = new Date();
		//使用format() 对date对象进行默认的格式化；
		// format : date ---> 时间字符串
		String timeStr = sdf.format(date3);
		System.out.println("=================");
		System.out.println(timeStr); //默认时间格式 ：19-8-15 下午4:21
		//解析parse()：时间字符串 ---> date对象
		//注意; 在解析时间字符串的过程中，可能出现解析不了
		Date date4 = sdf.parse(timeStr);
		System.out.println(date4);
		
		/*Date date5 = sdf.parse("2019-08-15");
		System.out.println(date5);*/
		
		//有参构造：按照指定的正则进行对日期对象格式化，或者解析：
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH/mm/ss");
		String format = sdf1.format(new Date());
		System.out.println(format);
		Date date5 = sdf1.parse(format);
		System.out.println(date5);
		//注意:在解析时，必须按照指定好的日期格式来进行解析：
		Date date6 = sdf1.parse("2019/08/15 16/37/00");
		System.out.println(date6);
		System.out.println("******************************");
		/**
		 * 4) Calendar ：日历类
		 */
		//通过方法调用创建日历对象：
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.toString());
		//get() : 需求：指定的条件，返回属性；
		//年：
		System.out.println(calendar.get(Calendar.YEAR));
		//月：
		System.out.println(calendar.get(Calendar.MONTH));
		//日;
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		//小时：
		System.out.println(calendar.get(Calendar.HOUR));
		//分钟：
		System.out.println(calendar.get(Calendar.MINUTE));
		//秒：
		System.out.println(calendar.get(Calendar.SECOND));
		
		//set() 设置属性值：
		calendar.set( Calendar.YEAR , 2020);
		System.out.println(calendar.get(Calendar.YEAR));
		
		//需求：2020年 - 1 = 2019年：
		//add() : 
		calendar.add( Calendar.YEAR  , -1);
		System.out.println(calendar.get(Calendar.YEAR));
		calendar.add(Calendar.MONTH , 3);
		System.out.println(calendar.get(Calendar.MONTH));
		
		//需求;日历类 ---> Date类
		Date date7 = calendar.getTime();
		System.out.println(date7);
		
		//需求;Date类 ---> 日历类
		calendar.setTime(new Date());
		System.out.println(calendar);
		
		/**
		 * JDK1.8 之后：时间相关类
		 * LocalDateTime , LocalDate , LocalTime
		 */
		//获取当前日期对象：---> Date类
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime); //2019-08-15T17:30:36.296
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate); //2019-08-15
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime); //17:31:23.322
		
		//通过方法，设置指定时间; of()
		LocalDateTime dateTime = localDateTime.of(2020 , 8 , 15 , 17 , 30 , 30);
		System.out.println(dateTime);
		
		//从日期对象中，获取某一个属性：
		System.out.println(dateTime.getYear());
		System.out.println(dateTime.getHour());
	
		//累加：2020 -> 2021
		LocalDateTime plusYears = dateTime.plusYears(1);
		System.out.println(plusYears);
		
		//减：
		LocalDateTime dateTime2 = dateTime.minusYears(5);
		System.out.println(dateTime2);
		
		
	}
}



























