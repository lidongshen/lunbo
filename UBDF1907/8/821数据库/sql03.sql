
#创建表、管理表
#sql : CREATE TABLE 创建表关键字
#语法：create table 表名(字段名 数据类型(尺寸),.....);
#注意：在创建表时，必须要指定：表名、字段名、数据类型、尺寸

#sql中的常用数据类型;
#1）int : 整形数据，存储大小为4个字节；
#2）char(size) : 定长字符数据，如果没有指定尺寸，默认为1个字节，最长为255个字节；
#3）varchar(size) : 可变长字符数据，可以根据字符串的实际长度进行保存，
#										注意该类型必须要指定长度，否则报错
#4）float(m , d) : 单精度，M代表整数位+小数位，d代表小数位；
#5）double(m , d) :双精度，M代表整数位+小数位，d代表小数位；
#6）date : 日期型数据，默认格式：yyyy-MM-dd
#7）BLOB ：大对象类型，以二进制的方式来存储长文本数据（视频，音频），最大可以存储4G的单个文件
#8）text : 存储长文本数据（纯文本），最大支持4G的单个文本；

#关于数据库的日常操作：

#显示当前mysql数据库中都创建有哪些数据库：
SHOW DATABASES;

#使用指定的数据库：
USE test;

#查询当前数据库下的所有表：
show TABLES;

#创建一个自定义数据库：
CREATE DATABASE UBDF1907;

USE UBDF1907;

#案例：
#方式一：手动自定义创建
#创建一张员工表：员工号，员工名称，员工薪水，员工生日
# 命名规范：在数据库中，如果标识符有多个单词构成，使用下划线连接
CREATE TABLE t_emp(
emp_id INT,
emp_name VARCHAR(15),
emp_salary DOUBLE,
emp_brithday DATE
);

#方式二：使用子查询创建表：
# 在创建表的过程中，执行一个select操作，然后将查询结果传入到创建的表中
# AS关键字：连接创建表和查询表的操作
create table t_emp2
AS
SELECT employee_id , last_name
FROM employees;

#数据仓库 ：Hive(Hql--->SQL)

#在插入表数据的过程中，自定义新表的字段名
create table t_emp3
AS
SELECT employee_id "emp_id" , last_name "emp_name"
FROM employees;

#创建一张表，该表的表结构和数据与员工表一样（表的复制）
create table t_emp4
AS
SELECT *
FROM employees;

#创建一张表，该表的表结构与员工表一样（只复制表结构，不要数据）
CREATE TABLE t_emp5
AS
select * FROM employees WHERE 1=2;

#修改表：
#通过alter table 来对表进行修改
#给表添加一个字段：
#语法: ALTER TABLE 表名 ADD 新字段名 数据类型
ALTER TABLE t_emp5 ADD brithday DATE;

#查看表结构：
DESCRIBE t_emp5;
DESC t_emp5;

#删除一个列 ： 
#语法: ALTER TABLE 表名 DROP 新字段名 数据类型
ALTER TABLE t_emp5 DROP brithday;

#修改一个列：数据类型，数据长度
#语法: ALTER TABLE 表名 MODIFY 新字段名 数据类型
#注意：该操作，建议使用修改空表，对有数据的表不建议该操作；
ALTER TABLE t_emp5 MODIFY last_name INT;

#重命名字段名：
#语法: ALTER TABLE 表名 CHANGE 旧字段名 新字段名 数据类型
ALTER TABLE t_emp5 CHANGE last_name lastName VARCHAR(20);

#重命名表名：
#语法: ALTER TABLE 旧表名 RENAME TO 新表名；
ALTER TABLE t_emp5 RENAME TO t_emp55;

#删除表：
#语法:DROP TABLE 表名；
DROP TABLE t_emp55;

#清空表：将表中所有的数据清空
#
truncate
TRUNCATE TABLE t_emp4;

#表数据插入操作：
#方式一：按照字段默认的顺序赋值：
#语法：insert into 表名 VALUES(字段值,....);
INSERT INTO t_emp VALUES(1,'胡光奎',8000.0,'1998-01-06');

#方式二：按照指定的字段顺序赋值：
#姓名，生日 ，其它字段赋值为null;
#注意：日期类型需要添加单引号：
INSERT INTO t_emp(emp_name , emp_brithday) VALUES('胡光奎胖子','1998-01-06');

#方式三:基于现有的表，导入数据
INSERT INTO t_emp(emp_id , emp_name)
SELECT e.employee_id , e.last_name
FROM employees e;

#更新数据：update 语句
#语法：update TABLE SET 字段名=新字段值。。。。where 过滤条件；
#更新姓名为King的员工的薪水为100000；
UPDATE t_emp SET emp_salary=100000 WHERE emp_name='King';
#注意：如果没有指定过滤条件，将对全表数据进行修改；
UPDATE t_emp SET emp_salary=100000;
#更新姓名为King的员工的编号和，薪水
UPDATE t_emp SET emp_id=1000 , emp_salary=100000 WHERE emp_name='King';

#删除表数据：delete 语句
#语法：delete FROM 表名 WHERE 过滤条件
#删除姓名为King的员工数据
DELETE FROM t_emp WHERE emp_name='King';

#删除编号为1000的员工数据：
#注意：如果没有满足条件，将无法删除任何数据
DELETE FROM t_emp WHERE emp_id=1000;

















desc t_emp;














































































