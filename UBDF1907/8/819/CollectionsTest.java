package com.uek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 集合工具类：
 */
public class CollectionsTest {
	public static void main(String[] args) {
		
		Map map = new HashMap();
		map.put("1", 1);
		map.put(null, null);
		map.put(10, 1);
		
		//
		List list = new ArrayList();
		/*list.add(20);
		list.add(10);
		list.add(30);*/
		
		list.add(new Employee("张三", 3000.0, 1));
		list.add(new Employee("李四", 3000.0, 3));
		list.add(new Employee("王五", 3000.0, 2));
		
		//1) 对集合中的元素进行反转：
		Collections.reverse(list);
		
		//2) 升序排序：
		Collections.sort(list);
		//System.out.println(list);
		
		//3) 自定义排序：
		LiDanYang ldy = new LiDanYang();
		//Collections.sort(list , ldy);
		
		//匿名内部类语法：
		Collections.sort(list , new Comparator() {
			//比较策略：id 降序
			@Override
			public int compare(Object o1, Object o2) {
				Employee e1 = (Employee) o1;
				Employee e2 = (Employee) o2;
				return -e1.getId().compareTo(e2.getId());
			}
			
		});
		
		System.out.println(list);
	}
}

//封装一个独立的比较类;
class LiDanYang implements Comparator{

	//比较策略：id 降序
	@Override
	public int compare(Object o1, Object o2) {
		Employee e1 = (Employee) o1;
		Employee e2 = (Employee) o2;
		return -e1.getId().compareTo(e2.getId());
	}
	
}






