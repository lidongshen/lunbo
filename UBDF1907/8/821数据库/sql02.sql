
#单行函数：
# 1）大小转换
# 2）字符操作
# 3）数值函数
# 123.456 ---> 四舍五入
SELECT ROUND(123.856) , ROUND(123.456,1) , ROUND(123.456,-1)
FROM DUAL;

#截断：
SELECT TRUNCATE(123.456 , 0) , TRUNCATE(123.456,1)
FROM DUAL;

#求余数：
SELECT MOD(12,5) , MOD(12,-5)
FROM DUAL;

#通用函数：
# 查询员工奖金时，如果员工的奖金为null, 用0代替
SELECT IFNULL(commission_pct,0)
FROM employees;

#多行函数（分组函数）：
#  把多个字段的值，传递到该函数中，返回一个结果
SELECT AVG(e.salary) , SUM(e.salary) / COUNT(e.salary)
FROM employees e;

#分组数据：group BY
# 含义：可以使用group by 子句将表中的数据分成若干组；
# 语法：1)group by 是 声明在where关键字后面
#			  2)在select查询的字段列表中，所有未包含在分组函数中的字段
#          必须要放在group by 后面，作为分组条件存在；
#SELECT
#FROM
JOIN
ON
WHERE
GROUP BY 分组条件
ORDER BY;

#部门id , 员工编号，部门平均薪资
SELECT department_id , employee_id , avg(salary)
FROM employees
GROUP BY department_id , employee_id;

#查询员工表中各部门的部门名称，最高薪资
SELECT d.department_id , d.department_name , MAX(e.salary)
FROM employees e , departments d
WHERE e.department_id = d.department_id
GROUP BY d.department_id;

#查询不同部门，不同job_id的员工平均薪资
SELECT e.department_id , e.job_id , AVG(e.salary)
FROM employees e
GROUP BY e.department_id , e.job_id;

SELECT e.department_id , e.job_id , AVG(e.salary)
FROM employees e
GROUP BY e.job_id,e.department_id;

#组过滤：过滤平均薪资大于5000；
SELECT e.department_id , e.job_id , AVG(e.salary)
FROM employees e
#在where后面不能使用组函数；
#WHERE AVG(e.salary) > 5000
GROUP BY e.job_id,e.department_id
#having 对分组后的数据进行过滤
#having : 在group by 后进行声明，然后添加组过滤条件
HAVING AVG(e.salary) > 5000;

#部门最高工资比10000高的部门的id ,name
SELECT d.department_id , d.department_name , MAX(e.salary) "maxSalary"
FROM employees e
JOIN departments d
ON e.department_id = d.department_id
GROUP BY d.department_id
#having 后可以使用列的别名（where不行）
HAVING maxSalary > 10000 ;

#从10,20,30 部门中，查找部门最高工资比10000高的部门的id,name,max
#方式一：
SELECT d.department_id , d.department_name , MAX(e.salary) "maxSalary"
FROM employees e
JOIN departments d
ON e.department_id = d.department_id
GROUP BY d.department_id
#having 后可以使用列的别名（where不行）
HAVING d.department_id IN(10,20,30)
AND maxSalary > 10000 ;

#方式二：效率更高，先执行where可以将不符合条件的数据就过滤掉了，
#sql优化：再进行分组操作，此时对于sql底层引擎的工作量就降低了；
SELECT d.department_id , d.department_name , MAX(e.salary) "maxSalary"
FROM employees e
JOIN departments d
ON e.department_id = d.department_id
WHERE d.department_id IN(10,20,30)
GROUP BY d.department_id
#having 后可以使用列的别名（where不行）
HAVING maxSalary > 10000 ;

#查询各工种的最低薪资；
SELECT e.job_id , MIN(e.salary)
FROM employees e
GROUP BY e.job_id;

#查询各部门的总工资,部门名称；
SELECT d.department_name , SUM(e.salary) 
FROM employees e
JOIN departments d
ON e.department_id = d.department_id
GROUP BY e.department_id;

#查询各工种的员工人数；
SELECT e.job_id , COUNT(*)
FROM employees e
GROUP BY e.job_id;

#查询平均薪资高于8000的部门的最高薪资
SELECT e.department_id , MAX(e.salary)
FROM employees e
GROUP BY e.department_id
HAVING AVG(e.salary) > 8000;

#统计公司中，经理的人数
# count : 返回的是不为空数据的条数
SELECT COUNT(DISTINCT manager_id)
FROM employees;

#多表子查询：

#查询员工中有谁的工资比‘King’高
#方式一：
SELECT e.salary
FROM employees e
where e.last_name = 'King';

SELECT e.last_name
FROM employees e
WHERE e.salary > 24000;

#方式二：自连接  Kochhar表 其它人表  
SELECT e1.last_name , e1.salary , e2.last_name , e2.salary
FROM employees e1
JOIN employees e2
ON e1.salary < e2.salary #非等值连接条件
WHERE e1.last_name = 'Kochhar';

#方式三:子查询
#概念：在查询过程中，子查询在主查询之前一次执行完成，子查询的结果
# 		会被主查询调用；
#语法：（1）子查询必须要包含在括号内；
#			 （2）将子查询放在比较条件的右侧；
#多表子查询分类：
#   1）单行子查询：子查询返回的结果只有一行，使用单行比较操作符
#		2）多行子查询：
SELECT e.last_name
FROM employees e
WHERE e.salary > (
	SELECT e.salary
	FROM employees e
	where e.last_name = 'King'
);

SELECT e.last_name
FROM employees e
WHERE (
	SELECT e.salary
	FROM employees e
	where e.last_name = 'Kochhar'
) < e.salary;

#返回job_id与141号员工相同，salary比143号员工多的员工姓名，
#工种，薪水
select e.last_name , e.job_id , e.salary
FROM employees e
WHERE job_id = (
	SELECT job_id
	FROM employees
	WHERE employee_id = 141
)
AND e.salary > (
	SELECT salary
	FROM employees
	WHERE employee_id = 143
);

#查询公司工资最少的员工的姓名，工种，薪水
#子查询中使用组函数：
SELECT e.last_name , e.job_id , e.salary 
FROM employees e
WHERE e.salary = (
	SELECT MIN(salary)
	FROM employees
);

#查询最低薪水大于60号部门最低薪水的部门编号和最低薪水
SELECT e.department_id , MIN(e.salary) "minSalary"
FROM employees e
GROUP BY e.department_id
HAVING minSalary > (
	SELECT MIN(salary)
	FROM employees
	WHERE department_id = 60
);

#查询工种和‘'Haas'’的工种相同的员工的信息；
#关于子查询中空值问题：因为子查询并没有返回任何行，所以主查询为空；
SELECT e.last_name , e.job_id
FROM employees e
WHERE e.job_id = (
	SELECT job_id
	FROM employees
	WHERE last_name = 'Haas'
);

#查询薪水和各部门中的最低薪水相同的员工信息
SELECT e.last_name , e.salary
FROM employees e
WHERE e.salary = (
	SELECT MIN(salary)
	FROM employees
	GROUP BY department_id
);

# 多行子查询：子查询返回的结果是多行，使用比较操作符
#  IN : 等于子查询返回结果中的任意一个；
#  ANY : 和子查询返回结果中的某一个值比较；
#  ALL : 和子查询返回结果中的所有值比较；

#查询薪水和各部门中的最低薪水相同的员工信息
SELECT e.last_name , e.salary
FROM employees e
WHERE e.salary IN(
	SELECT MIN(salary)
	FROM employees
	GROUP BY department_id
);

#查询其它部门比工种为‘IT_PROG’部门中任一薪水低的员工
#的员工号，姓名，工种， 薪水
SELECT e.employee_id , e.last_name , e.job_id , e.salary
FROM employees e
WHERE e.salary < ANY( 
	SELECT salary     # 随便 最低 ，最高
	FROM employees
	WHERE job_id = 'IT_PROG'
)
AND e.job_id != 'IT_PROG';

#查询其它部门比工种为‘IT_PROG’部门中所有薪水低的员工
SELECT e.employee_id , e.last_name , e.job_id , e.salary
FROM employees e
WHERE e.salary < ALL( 
	SELECT salary     # 随便 最低 ，最高
	FROM employees
	WHERE job_id = 'IT_PROG'
)
AND e.job_id != 'IT_PROG';

#查询和Zlotkey相同部门的员工姓名和薪水
SELECT e.last_name , e.salary
FROM employees e
WHERE e.department_id = (
 SELECT department_id
 FROM employees
 WHERE last_name = 'Zlotkey'
);

#查询薪水比公司平均薪水高的员工的员工号，姓名，薪水
SELECT employees.employee_id , employees.last_name , employees.salary
FROM employees
WHERE employees.salary > (
	SELECT AVG(salary)
	FROM employees
);

#查询各部门中薪水比本部门平均薪水高的员工的员工号，姓名，薪水
# 部门 ： 90  1000（平均）
#         90  2000
#         90  500
# 自连接 : 部门平均薪资表:e2，部门员工薪资表:e1
SELECT e1.department_id , e1.last_name , e1.salary 
FROM employees e1
WHERE e1.salary > (
	SELECT AVG(salary)
	FROM employees e2
	WHERE e2.department_id = e1.department_id
);

#查询和姓名中包含字母u的员工在相同部门的员工的员工号，姓名
SELECT e.employee_id , e.last_name
FROM employees e
WHERE e.department_id IN(
	SELECT DISTINCT department_id
	FROM employees 
	WHERE last_name LIKE '%u%'
);

#查询出公司所有经理的详细信息：
SELECT e.last_name , e.employee_id
FROM employees e
WHERE e.employee_id IN(
	SELECT DISTINCT manager_id
	FROM employees
);

SELECT e.last_name , e.employee_id
FROM employees e
WHERE e.employee_id = ANY(
	SELECT DISTINCT manager_id
	FROM employees
);

#查询平均工资高于公司平均工资的部门有哪些
SELECT e.department_id , AVG(e.salary) "avg"
FROM employees e
GROUP BY e.department_id
HAVING avg > (
	SELECT AVG(salary)
  FROM employees
);

#查询管理者是King的员工姓名和工资
SELECT e.last_name ,e.salary
FROM employees e
WHERE e.manager_id IN(
  SELECT employee_id
  FROM employees
  WHERE last_name = 'King'
);

#总结：
# 1)语法：
# SELECT  字段 ， 字段， 单行函数 ， 组函数（多行函数）case结构
# FROM 表
# JOIN 表
# ON  连接条件（等值连接，非等值连接）
# WHERE 行过滤条件
# AND  多个行过滤条件
# GROUP BY 分组字段（1个或多个）
# HAVING 组过滤条件
# AND 多个组过滤条件
# ORDER BY 排序字段（1个或多个）
# limit 限制输出（mysql分页）

#2)select语句的执行顺序：
# 1）from子句组装来自不同表（数据源）中数据；
# 2）where子句基于指定的条件对数据进行过滤；
# 3）group by子句将数据划分成多个组；
# 4）执行分组函数（聚合函数）进行计算；
# 5）having子句对分组后的数据进行过滤；
# 6）执行表达式（case结构）
# 7）select子句进行对数据进行展示；
# 8）order by子句对指定条件的数据进行排序；
# 9）limit子句对数据的输出进行限制；

#创建表、管理表
#sql：create table 创建表关键字
#语法：create table 表名（字段名 数据类型）
#至于在创建表时，必须要指定：表名、字段名、数据类型

#sql中常用的数据类型
#int:长度为4整形数据
#char（size）：定长的字符数据，如果没有指定，默认为1个字节，最长为255个字节
#varchar(size):可变长字符数据，可以根据字符串的实际长度进行保存该类型必须指定长度否则报错
#float(m,d):单精度，m代表的是整数位+小数位，d代表的是小数位
#double(m，d):双精度，m代表的是整数位+小数位，d代表的是小数位
#date：日期类型，默认格式：yyyy-MM-dd
#blob：大对象类型，以二进制的方式来存储长文本数据（视频，音频）
#text：存储长文本数据，最大支持存储4G的单个文本

#关于数据库的日常操作
#显示当前mysql数据库中都有哪些数据库
show database；
#使用指定的数据库
use test；
#查询当前数据库下的所有表
show tables；
#创建一个自定义的数据库
create database UBDF1907；






























































 








































































