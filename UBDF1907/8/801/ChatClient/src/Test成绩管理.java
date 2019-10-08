import java.util.*;
import java.util.Scanner;
public class Test成绩管理 {
    public static void main(String[] args) {
    	String name;
    	int grade;
    	System.out.println("请输入姓名：");
    	Scanner student = new Scanner(System.in);
        name=student.next();
        System.out.println("请输入成绩：");
        grade=student.nextInt();
        System.out.println("姓名"+name);
        System.out.println("成绩"+grade);
        System.out.println("------------");
        Map<String, Integer> map = new HashMap<>();
        map.put("张三", 100);
		map.put("李四", 100);
		map.put("王五", 100);
		map.put("赵六", 100);
		map.put("张三", 80);
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
				

					
			
				//补充map其它重要的API
				
				map.clear();				//清空
				map.containsKey("张三");		//判断是否有key张三
				map.containsValue(100);		//判断是和否有100分value
				
				map.isEmpty();				//是否为空
				map.size();					//判断size
				map.values();				//所有的值
						
				
				
			}
			
}