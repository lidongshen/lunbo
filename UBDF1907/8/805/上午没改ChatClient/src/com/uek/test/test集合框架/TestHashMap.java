package com.uek.test.test集合框架;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 有一些场景，单列的数据结构 比如set list就不够了，要用双列的数据结构
 * 
 * 比如 菜单 菜名 和 价格 成绩表 名字和成绩
 * 
 * java的解决就是Map<key , value>
 * 
 * @author UEK-N
 *
 */
public class TestHashMap {
	
	public static void main(String[] args) {
		
		//泛型 左侧有 右侧可以省略 这个是1.7的新语法  菱形语法
		Map<String, Integer> map = new HashMap<>();
		
		//增加
		map.put("张三", 100);
		map.put("李四", 100);
		map.put("王五", 100);
		map.put("赵六", 100);
		map.put("张三", 80);//注意这里是修改 不是新增 因为key不能重复 唯一
		
		
		
		
		//删除
		map.remove("赵六");
		
		//修改
		map.put("张三", 70);
		map.replace("李四", 80);
		
		//查询
		//查单个
		System.out.println(map.get("李四"));
		
		System.out.println("------------");
		
		//查所有
		Set<String> keys = map.keySet();//返回所有的key组成的Set
		
		for (String string : keys) {
			System.out.println(string + "\t" + map.get(string));
		}
		
		System.out.println("------------");
		
		//查所有
		keys = map.keySet();//返回所有的key组成的Set
		
		Iterator<String> iter = keys.iterator();
		
		while(iter.hasNext())
		{
			String key = iter.next();
			System.out.println( key + "\t" + map.get(key));
		}
		
		System.out.println("------------");
		
		//查所有
		Set<Entry<String, Integer>> entrys = map.entrySet();//entry 是条目 一个key-value就是一个entry
		
		Iterator<Entry<String, Integer>> entryIter = entrys.iterator();
		
		while(entryIter.hasNext())
		{
			Entry<String, Integer> entry = entryIter.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			System.out.println( key + "\t" + value);
		}
			
	
		//补充map其它重要的API
		
		map.clear();				//清空
		map.containsKey("张三");		//判断是否有key张三
		map.containsValue(100);		//判断是和否有100分value
		
		map.isEmpty();				//是否为空
		map.size();					//判断size
		map.values();				//所有的值
				
		
		
	}
	
}
