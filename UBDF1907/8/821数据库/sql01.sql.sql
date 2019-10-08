
#查询员工表的所有员工的信息：
# * : 通配，代表所有字段
SELECT * 
FROM employees;

#查询员工表中员工的编号和薪水；
SELECT employee_id , 
SALARYFROM employees;

select *
from employees;

#列的别名：
#AS : 标准的别名语法
# 别名 ：一般使用双引号标识
SELECT employee_id AS "员工编号", last_name AS "员工姓名", salary
FROM employees;

#简写
SELECT employee_id 员工编号, last_name 员工姓名, salary
FROM employees;

#字符串: 在sql语法规范中，要求使用单引号来表示字符串
#查询员工表中，姓名为King的员工信息；
SELECT *
FROM employees
WHERE last_name = 'King'; #在mysql中，对于字符串中的大小写也不区分
#但是在oracle数据库中，报错；

#查询员工表的表结构：
DESCRIBE employees;
desc employees;

#SQL语句中的过滤功能：
# 在sql中，是使用where关键字来实现对不满足条件的数据进行过滤；
#语法：select 字段。。。 from 表 where 过滤条件
#注意：where关键字的位置必须紧随from子句；

#查询90号部门的所有员工信息：
SELECT *
FROM employees
WHERE department_id = 90;#过滤条件

#查询薪资为6000的员工的姓名，薪水（别名）
SELECT last_name , salary AS "薪水"
FROM employees
WHERE salary = 6000;

#注意：在过滤条件时，不可以使用别名
SELECT last_name , salary AS "薪水"
FROM employees
WHERE "薪水" = 6000;

#过滤：比较运算符 ：= > < >= <=  !=
#查询员工薪资大于6000的员工姓名，薪水，部门信息
SELECT last_name , salary "薪水" , department_id
FROM employees
WHERE salary > 6000;

#查询员工薪资不是6000的员工姓名，薪水，部门信息
SELECT last_name , salary "薪水" , department_id
FROM employees
WHERE salary != 6000;

#查询薪资在3000到6000之间的员工信息：
#方式一：
# and : 连接条件, 并且的语义，要求所有条件全部满足
SELECT last_name , salary
FROM employees
WHERE salary > 3000 AND salary < 6000;

#方式二：between 值 and 值 ： 区间范围 ,
#注意：包含边界 ，不能把区间范围的小值放到前面
SELECT last_name , salary
FROM employees
WHERE salary BETWEEN 3000 AND 6000;

#查询部门在50或者60的员工信息；
# or : 连接条件，或者的语义，要求条件满足其一即可
#方式一：
SELECT *
FROM employees
WHERE department_id = 50 OR department_id = 60;

#方式二 ： in : 使用in运算来显示列表中的值
SELECT *
FROM employees
WHERE department_id IN(50,60);

#查询员工姓名中包含有’a‘的员工信息：
# 模糊查询：like 匹配条件（字符串）
# 匹配字符：% ：0个或者多个字符
#           _ ： 1个字符
SELECT last_name , salary
FROM employees
WHERE last_name LIKE '%a%';

#查询员工姓名中第一个字符是’a‘的员工信息
SELECT last_name , salary
FROM employees
WHERE last_name LIKE 'a%';

#查询员工姓名中最后一个字符是’a‘的员工信息
SELECT last_name , salary
FROM employees
WHERE last_name LIKE '%a';

#查询员工姓名中第三个字符是’a‘的员工信息
SELECT last_name , salary
FROM employees
WHERE last_name LIKE '__a%';

#查询员工姓名中包含有a和e,或者包含有e和a的员工信息
SELECT last_name ,salary
FROM employees
WHERE last_name LIKE '%a%e%' 
OR last_name LIKE '%e%a%';

SELECT * from employees;

#查询没有领导的员工信息：
# IS NULL : 是空
# IS NOT NULL : 不是空
SELECT last_name , salary
FROM employees
WHERE manager_id IS NULL;

SELECT last_name , salary
FROM employees
WHERE manager_id IS NOT NULL;

#查询每一个员工的薪水和津贴相乘的结果：
# 注意：凡是空值参与运算，结果也为空；
SELECT salary * commission_pct "月总薪水"
FROM employees;

#查询每一个员工的年薪：
select last_name , salary * 12 "年薪"
FROM employees;

SELECT * from employees;

#查询不在50或者60部门的员工的姓名，部门编号
SELECT last_name , department_id
FROM employees
WHERE department_id NOT IN(50,60);

#表别名：表名 别名
SELECT e.last_name , e.department_id
FROM employees e
WHERE e.department_id NOT IN(50,60);

#总结：逻辑运算符：AND OR NOT

#查询每一位员工的姓名，薪水，按照薪水升序进行排序；
# order by ：排序，asc 升序（默认）  desc 降序
#注意：在排序时可以使用别名；
SELECT e.last_name , e.salary "薪水"
FROM employees e
ORDER BY 薪水 ASC;

SELECT e.last_name , e.salary "薪水"
FROM employees e
ORDER BY 薪水;

SELECT e.last_name , e.salary "薪水"
FROM employees e
ORDER BY 薪水 desc;

#查询员工的薪水，和编号，按照薪水降序排序，只查询薪水大于10000
#如果薪水一样，按照编号升序排序；
#二次排序：先排序第一个条件，当第一个条件相同时，再排序第二个条件
SELECT salary , employee_id
FROM employees
WHERE salary > 10000
ORDER BY salary DESC , employee_id DESC;

#查询部门50,60，按照部门编号，姓名升序显示员工信息；
SELECT department_id , last_name
FROM employees
WHERE department_id IN(50,60)
ORDER BY department_id ASC, last_name ASC;

#查询公司中的员工的工种有哪些？
#DISTINCT : 去重，在字段前使用
SELECT DISTINCT job_id
FROM employees;

#查询员工的全名信息
#CONCAT(参数 ， 参数) ： 字符串拼接
SELECT CONCAT(last_name,first_name) "全名"
FROM employees;

#查询工资不在5000和12000的员工的姓名和工资
SELECT e.last_name , e.salary
FROM employees e
WHERE e.salary < 5000 OR e.salary > 12000;

#查询公司中没有管理者的员工姓名和工种
SELECT last_name , job_id
FROM employees
WHERE manager_id IS NULL;

#查询所有姓名是由六个字符组成，并且包含字母D的员工姓名，薪水；
SELECT last_name , salary
FROM employees
WHERE last_name LIKE '%D%'
AND last_name LIKE '______';

#length(字符串) ： 返回字符串的长度
SELECT last_name , salary
FROM employees
WHERE last_name LIKE '%D%'
AND LENGTH(last_name) = 6;

#多表查询：
#查询员工的姓名，部门编号，部门名称；
# 笛卡尔积：所有表中的所有记录相互之间进行连接；
#出现笛卡尔积的场景：
# 1）缺省了连接条件；
# 2）连接条件无效；
SELECT e.employee_id , e.department_id , d.department_name
FROM employees e , departments d;

SELECT e.employee_id , e.department_id , d.department_name
FROM employees e , departments d
WHERE 1!=2;

#特殊情况：
# 因为表中的所有数据不满足过滤条件（1=2），所以查询结果为空；
select * FROM employees 
WHERE 1=2;
# 因为表中的所有数据满足过滤条件（1!=2），所以查询结果所有数据；
select * FROM employees 
WHERE 1!=2;

#注意：在多表查询时，如果独立存在的字段，可以省略表别名，
#      如果有重复字段，必须要添加表别名来标识
SELECT employee_id , e.department_id , department_name
FROM employees e , departments d;

#多表查询：分为内连接，外连接；
#内连接：只查询多个表中相互之间能够匹配的行；
#   1）等值连接
# sql语法 ---> sql92标准
SELECT e.employee_id , e.department_id , d.department_name
FROM employees e , departments d
WHERE e.department_id = d.department_id;

#sql语法 ---> sql99标准：
#sql优化: 在查询的过程中给字段添加前缀，可以提高查询效率；
SELECT e.employee_id , e.department_id , d.department_name
FROM employees e
INNER JOIN departments d
ON (e.department_id = d.department_id);

# ` : 反单引号，sql中有一些保留字和关键字，当你的字段名和
#     保留字和关键字重名时，使用``来区别；
#查询员工姓名和工种
select last_name , job_id
FROM employees e
WHERE e.`salary` > 6000;

#查询部门所在地为1700的部门的部门名称，街道信息,
#同时查询出员工的编号，和姓名
SELECT d.location_id , d.department_name , l.street_address
FROM departments d , locations l
WHERE d.location_id = l.location_id
AND d.location_id = 1700;

SELECT d.location_id , d.department_name , l.street_address
FROM departments d
INNER JOIN locations l
ON d.location_id = l.location_id
WHERE d.location_id = 1700;

SELECT e.last_name , e.employee_id,d.location_id , d.department_name , l.street_address
FROM departments d
INNER JOIN locations l
ON d.location_id = l.location_id
INNER JOIN employees e
ON d.department_id = e.department_id
WHERE d.location_id = 1700;

#查询工种为AD_VP的员工的部门编号，
#部门名称，部门所在地的城市id;
SELECT e.department_id , d.department_name , l.country_id
FROM employees e , departments d , locations l
WHERE e.department_id = d.department_id
AND d.location_id = l.location_id
AND e.job_id = 'AD_VP';

# INNER JOIN = JOIN
SELECT e.department_id , d.department_name , l.country_id
FROM employees e
JOIN departments d  
ON  e.department_id = d.department_id
JOIN locations l
ON d.location_id = l.location_id
WHERE e.job_id = 'AD_VP';

#多表连接：以上属于内连接（等值连接）

#多表连接：以下属于内连接（非等值连接）
#查询员工薪水等级，显示姓名，薪资 ，薪水等级
SELECT e.last_name , e.salary , j.GRADE
FROM employees e
JOIN job_grades j
ON e.salary BETWEEN j.LOWEST_SAL AND j.HIGHEST_SAL;

#自连接：自己跟自己进行连接，把一张表当做两张表来进行操作：
#自连接虚拟出的两张表中的字段和数据是一样的；
#查询员工的员工编号，姓名及其管理者的员工编号，姓名
# 可以把一张员工表--》一张员工表，另一张管理者表
SELECT e1.employee_id , e1.last_name , e2.employee_id , e2.last_name
FROM employees e1
JOIN employees e2
ON e1.manager_id = e2.employee_id;

# 学生表：姓名 ， 分数
# 使用自连接的方式，查询分数小于100同学的信息；
#SELECT id , score FROM stu WHERE score < 100;
SELECT t1.id , t2.score
FROM t_stu t1
JOIN t_stu t2
ON t1.id = t2.id
WHERE t2.score < 100;

#外连接：多张表之间进行关联查询，除了返回满足连接条件的记录
#        还会返回不满足连接条件的记录；
# 外连接：左外连接 : 除了返回满足连接条件的记录,还会返回左表不满足连接条件的记录；
#         右外连接 ： 除了返回满足连接条件的记录,还会返回右表不满足连接条件的记录；
#         满外连接

#查询所有员工的姓名，部门编码， 部门名称
SELECT e.last_name , e.department_id , d.department_name
FROM employees e
LEFT OUTER JOIN departments d
ON e.department_id = d.department_id;

#查询部门没有员工的部门信息：
SELECT e.employee_id ,e.last_name , d.department_id , d.department_name
FROM employees e         #左表
RIGHT JOIN departments d #右表
ON e.department_id = d.department_id;

#查询所有学生的编号，分数，班级名称；
SELECT t1.id , t1.score , t1.cid , t2.cname
FROM t_stu t1         #join左边的表，左表
LEFT JOIN t_class t2  #join右边的表，右表
ON t1.cid = t2.cid;

SELECT t1.id , t1.score , t1.cid , t2.cname
FROM t_class t2       #join左边的表，左表
RIGHT JOIN t_stu t1  #join右边的表，右表
ON t1.cid = t2.cid;

#查询两张表中所有的数据；
#满外连接：Mysql中不支持,一般使用UNION关键字代替
#UNION : 获取查询结果的并集（全部）
#Oracle支持 ：
SELECT t1.id , t1.score , t1.cid , t2.cname
FROM t_class t2       #join左边的表，左表
FULL JOIN t_stu t1    #join右边的表，右表
ON t1.cid = t2.cid;

SELECT t1.id ,t1.score , t1.cid , t2.cname
FROM t_stu t1
LEFT JOIN t_class t2
ON t1.cid = t2.cid
UNION
SELECT t1.id ,t1.score , t1.cid , t2.cname
FROM t_stu t1
RIGHT JOIN t_class t2
ON t1.cid = t2.cid;

#SQL 函数 ： 单行函数，多行函数
#单行函数：
#（1）大小写控制函数
# “abc” ---> "ABC"
#注意;在数据库中有一张虚拟的空表：dual
SELECT UPPER('abc')
FROM DUAL;

SELECT LOWER('ABC')
FROM DUAL;

#(2)字符控制函数：
# “abcdef” --> "abc"
#注意：在sql语句中，所有索引是从1开始的
SELECT SUBSTRING('abcdef',1,3)
FROM DUAL;
# 'abcdef' ’d‘的索引
SELECT INSTR('abcdef','d')
FROM DUAL;

# 字符串拼接：concat();
SELECT CONCAT('abc','def')
FROM dual;

# "abc" -> "abC"
SELECT REPLACE('abc' , 'c' , 'C')
FROM DUAL;

#多行函数：多进一出
#数据库的常用类型：数值型、字符型、日期型

#查询所有员工的平均薪资；
# avg(字段[多个字段])
SELECT AVG(salary)
FROM employees;

#查询所有员工的最高薪资的员工的姓名，编号；
#max(字段)
SELECT last_name , employee_id , MAX(salary)
FROM employees;

#查询所有员工的最高薪资的员工的姓名，编号；
#min（字段）
SELECT last_name , employee_id , MIN(salary)
FROM employees;

#查询公司一个月工资的开销：
SELECT SUM(salary) "开销"
FROM employees;

#查询公司现有员工人数; 
SELECT COUNT(last_name)
FROM employees;

SELECT COUNT(*)
FROM employees;

SELECT COUNT(2)
FROM employees;

SELECT * FROM employees;





























































