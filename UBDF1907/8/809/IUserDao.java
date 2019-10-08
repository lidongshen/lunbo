package com.uek.dao.inter;

import java.util.List;

import com.uek.domain.User;

/**
 * dao接口规定了可以对t_user这张表做什么操作
 * 最常用的操作时CRUD 增删改查 但是查有3个 查单个 查所有 查分页暂不考虑
 * 
 * 单纯的对数据库进行操作 不考虑业务合不合理 比如delete 就删掉了
 * 
 * @author UEK-N
 *
 */
public interface IUserDao {
	void add(User user);//给我一个user对象 调用add 我就往t_user插入记录
	void delete(int id);//一般都是根据主键id删除
	void update(User user);//更新注意也是根据id跟新某些字段 有一些字段不能更新
	User load(int id);//一般根据id查询单个对象
	List<User> list();
}
