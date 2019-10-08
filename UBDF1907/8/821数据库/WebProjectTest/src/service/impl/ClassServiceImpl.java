package service.impl;

import dao.ClassDao;
import dao.impl.ClassDaoImpl;
import service.ClassService;
/**
 * 班级业务层的实现类：
 * 	主要负责业务逻辑：
 */
public class ClassServiceImpl implements ClassService{

	//在业务层中去调用Dao层：
	ClassDao classDao = new ClassDaoImpl();
	
	@Override
	public boolean createClassTable() {
		//在持久层实现的方法：
		return classDao.createClassTable();
	}

}
