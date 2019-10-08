# 数据库中的约束：
#约束：对表中的字段进行一种强制的规定
#常用的约束：
# 1）非空约束（not null）
# 2）唯一性约束（unique）
# 3）主键约束（primary KEY） 主键 = 非空+唯一
# 4）外键约束（foreign KEY）
# 5）检查约束（check） 
# 6）默认值约束 （default）

# 约束API
# 非空约束
#创建一张学生表：学号，姓名，性别，年龄，分数，生日，班级号
#指定当前表创建在哪一个数据库下，该语句可以在任意数据库下执行
#添加约束有两种方式: 列级约束、表级约束
drop TABLE t_stu;
#在创建表时添加约束：
CREATE TABLE ubdf1907.t_stu(
sid INT,
sname VARCHAR(20) NOT NULL, #列级约束
sex CHAR(3),
age INT,
score DOUBLE,
brithday DATE,
cid INT
);
#在创建表后，添加约束：
#语法：alter table 表名 MODIFY 字段名 数据类型 约束;
ALTER TABLE t_stu MODIFY score DOUBLE not NULL;

#在创建表后，删除约束：
#语法：alter table 表名 MODIFY 字段名 数据类型 约束;
ALTER TABLE t_stu MODIFY score DOUBLE NULL;


#成功：
INSERT INTO ubdf1907.t_stu VALUES(1,'张泽组长','男',20,90.5,'1997-12-08',101);

INSERT INTO ubdf1907.t_stu VALUES(1,NULL,'男',20,90.5,'1997-12-08',101);

INSERT INTO ubdf1907.t_stu VALUES(1,'张泽组长','男',20,NULL,'1997-12-08',101);

DESC t_stu;

#唯一约束：
CREATE TABLE t_stu1(
sid INT NOT NULL,
sname VARCHAR(20) NOT NULL,
email VARCHAR(50) NOT NULL,
brithday DATE NOT NULL,
#需求：邮箱必须保证唯一：
#表级约束：
# 语法：CONSTRAINT 约束名称 约束类型(字段名)
CONSTRAINT t_stu1_email_uk UNIQUE(email)
);

ALTER TABLE t_stu1
MODIFY email VARCHAR(30) NULL;

INSERT INTO t_stu1 VALUES(1,'张三','123456@qq.com','2020-01-01');
INSERT INTO t_stu1 VALUES(1, '李四' ,'123456@qq.com','2020-01-01');
#注意：在唯一约束下，null值可以插入多次；
INSERT INTO t_stu1 VALUES(1, '李四' ,null,'2020-01-01');
INSERT INTO t_stu1 VALUES(1, '李四' ,null,'2020-01-01');

#主键约束：非空约束+唯一约束 ，用来表示表中的唯一的一条记录，不容许有重复
CREATE TABLE t_stu2(
sid INT ,                      #PRIMARY KEY
sname VARCHAR(20) NOT NULL,
email VARCHAR(50) NOT NULL,
brithday DATE NOT NULL,
#创建主键表级约束：
CONSTRAINT t_stu1_sid_pk PRIMARY KEY(sid)
);

INSERT INTO t_stu2 VALUES(1, '李四' ,'@qq.com','2020-01-01');
INSERT INTO t_stu2 VALUES(NULL, '李四' ,'@qq.com','2020-01-01');

#外键约束：
# 学生表 ，有一个cid, 班级表也有一个cid,当学生表在插入数据时
# 要求学生表的cid字段赋的值必须是班级表中cid字段存在的值；
#注意：主表在创建外键时，主表字段引用的其它表对应的这个字段，
#      要求必须该表的主键 ，否则主表无法创建外键
create TABLE t_stu6(
sid INT PRIMARY KEY,
sname VARCHAR(20) NOT NULL,
cid INT,
#表级约束，创建外键
#语法：CONSTRAINT 外键名 foreign key(当前的外键字段)REFERENCES 关联表名（关联字段）
CONSTRAINT t_stu6_cid_fk FOREIGN KEY(cid) REFERENCES t_class(cid)
);

INSERT INTO t_stu6 VALUES(1,'张三',101);

DELETE FROM t_class WHERE cid=101;
#注意：在外键约束下，被引用的数据，无法直接删除，
#      只能先删除引用数据，然后再删除被引用数据
#第一步:
DELETE FROM t_stu6 WHERE cid=101;
#第二步:
DELETE FROM t_class WHERE cid=101;

#检查约束：
# 对某个字段进行条件约束
# 注意：检查约束在mysql中无效（mysql第8版支持），在oracle中有效
create table emp(
id int,
name VARCHAR(20) NOT NULL,
salary DOUBLE(10,2) CHECK(salary > 3000),
CONSTRAINT emp_id_pk PRIMARY KEY(id) 
);

INSERT INTO emp VALUES(1,'张泽',2000);

#默认值约束：
# 如果在添加数据时，没有给指定默认值的字段添加数据，则为默认值，反之以添加数据为准
CREATE TABLE Person(
id INT PRIMARY KEY,
NAME VARCHAR(20) NOT NULL,
sex CHAR(3) DEFAULT '男'
);
INSERT INTO Person VALUES(1,'胡光奎','女');
INSERT INTO Person(id , name) VALUES(2,'范晖');

#MySQL 分页
#查询员工表中的薪资按照降序排序,显示1-20条（第一页）
# 分页语法：limit 数字1 ，数字2
# 数字1 ： 每页显示的数据的起始位置
# 数字2 ： 每页显示的数据的条数
#公式：limit (当前页-1)*每页条数 , 每页条数
#      LIMIT 2-1*20=20 , 20 （21-40）
SELECT *
FROM employees
ORDER BY salary desc
LIMIT 0,20; #第一页（1-20条）

#显示第三页：（41-60）
SELECT *
FROM employees
ORDER BY salary desc
LIMIT 40 , 20;


















