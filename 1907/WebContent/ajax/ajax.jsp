<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,uek.*"%>
<%@ page import="com.alibaba.fastjson.JSON"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%
	Thread.sleep(1000);
	String uid=session.getAttribute("uid")+"";
	jdbc db = new jdbc();
	Statement stat=db.get();
	ResultSet rs = stat.executeQuery("select * from student where uid = '"+uid+"'");
	List<Data> list = new ArrayList<Data>(); 
	while(rs.next()){
		Data data = new Data();
		data.setId(rs.getString("id"));
		data.setName(rs.getString("name"));
		data.setSex(rs.getString("sex"));
		data.setAge(rs.getString("age"));
		data.setScore(rs.getString("score"));
		data.setUid(rs.getString("uid"));
		list.add(data);
	}
	Data sessionData = new Data();
	sessionData.setSessionname(session.getAttribute("username")+"");
	sessionData.setSessionuid(session.getAttribute("uid")+"");
	list.add(sessionData);
	rs.close();
	db.close();
	out.println(JSON.toJSONString(list));

%>