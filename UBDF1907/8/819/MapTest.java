package com.uek;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author UEK-N
 *
 */
public class MapTest {

	public static void main(String[] args) {
		
		/**
		 * map接口的常用方法：
		 */
		//1.构建map集合：
		Map map = new HashMap();
		//2.添加元素：
		map.put("null", 100);
		map.put(10, 100); 
		map.put(null, null);
		map.put(10, 10); //当key相同时，会覆盖旧的元素
		map.put("stu1", new Stu1("张三", 20, 90));
/*		//3.删除一个元素：
		map.remove(10);
		//4.根据key,获取对应的value:
		Object obj = map.get("stu1");
		//多态特点; 如果子类重写了父类的方法，父类调用方法时，调用的是子类重写过的方法：
		System.out.println(obj); //
		//5.判断map中，是否包含指定的key:
		boolean flag = map.containsKey(null);
		System.out.println(flag);
		//6.判断map中，是否包含指定的value:
		boolean flag1 = map.containsValue(null);
		System.out.println(flag1);
		//7.情况map集合：
		//map.clear();
		//8.获取map的长度：
		System.out.println(map.size());
		//9.判断map是否为空：
		boolean flag2 = map.isEmpty();
		//10.以字符串的形式显示map中的元素：
		//方式一：
		System.out.println(map.toString());*/
		
		/**
		 * 遍历map：
		 */
		//方式二：使用映射关系来遍历;
		//1） 获取到map中所有的映射关系：entry对象（包含了一个元素中的key和value）
		/*Set entrySet = map.entrySet();
		//2）遍历所有的映射关系;
		Iterator iter = entrySet.iterator();
		while(iter.hasNext()) {
			//Entry属于Map类中的一个内容类：
			Map.Entry entry = (Map.Entry)iter.next();
			//获取映射关系对象中的key和value:
			System.out.println(entry.getKey() +" , "+entry.getValue());
		}*/
		
		//方式三：使用set结构获取所有的key
		Set keySet = map.keySet();
		Iterator iter = keySet.iterator();
		while(iter.hasNext()) {
			Object key = iter.next();
			System.out.println(key +","+map.get(key));
		}
		
	}
}







