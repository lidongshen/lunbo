package ServletTest;

import service.ClassService;
import service.impl.ClassServiceImpl;

public class Test {

	public static void main(String[] args) {
		
		/**
		 * 创建两张表，班级表（cid , cname）;
		 * 			  学生表（sid ,sname ,cid）
		 * 增删改查：
		 * 
		 * 多表查询：查询学生的学号，姓名，班级号，班级名称；
		 */
		//创建一张表：班级表：
		//创建一个班级业务层接口：
		
		//调用业务层：
		ClassService classService = new ClassServiceImpl();
		//service实现的方法：
		boolean state = classService.createClassTable();
		if (state) {
			System.out.println("表创建成功");
		}else {
			System.out.println("表创建失败");
		}
		
		
	}
}
