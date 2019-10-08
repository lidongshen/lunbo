package com.uek;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * 员工类：
 */
public class Employee implements Comparable{
	private String name;
	private Double salary;
	private Integer id;
	
	/**
	 * 比较策略：按照薪资 ，降序
	 */
	@Override
	public int compareTo(Object o) {
		
		int result = 0;
		if (o instanceof Employee) {
			Employee e = (Employee) o;
			//方式一：
			/*if (this.getSalary() > e.getSalary()) {
				return -1;
			}else if (this.getSalary() < e.getSalary()) {
				return 1;
			}*/
			//方式二：
			result = this.salary.compareTo(e.salary);
		}
		//默认是升序，降序所以要取反
		return -result;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, Double salary, Integer id) {
		super();
		this.name = name;
		this.salary = salary;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return name+","+id;
	}
}

class Test1{
	public static void main(String[] args) {
		
		//1.构建集合对象：
		Map map = new TreeMap();
		//添加元素：
		map.put(new Employee("张三", 3000.0, 1) , 3000);
		map.put(new Employee("李四", 2000.0, 1) , 2000);
		map.put(new Employee("王五", 4000.0, 1) , 4000);
		//遍历map:
		/*Set entrySet = map.entrySet();
		//使用增强for:
		for(Object obj : entrySet) {
			Map.Entry entry = (Entry) obj;
			System.out.println("员工信息：" + entry.getKey() +" ,薪资;"+ entry.getValue());
		}*/
		
		Set keySet = map.keySet();
		Iterator iter = keySet.iterator();
		while(iter.hasNext()) {
			Employee e = (Employee)iter.next();
			System.out.println("员工信息：" +e +" ,薪资;"+ map.get(e));
		}
	}
}






























