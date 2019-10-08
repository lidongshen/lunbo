<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,uek.*"%>
<%@ page import="com.alibaba.fastjson.JSON"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	Thread.sleep(1000);
	String uid=session.getAttribute("uid")+"";
	
	jdbc db = new jdbc();
	Statement stat=db.get();
	int num = stat.executeUpdate("insert into student(name,age,sex,score,uid) values('',0,0,0,'"+uid+"')");
	ResultSet rs = stat.executeQuery("select max(id) as id from student");
	rs.next();
	int id=rs.getInt("id");
	rs.close();
	db.close();
	
	
	if(num>0){
		out.println(id+","+uid);
	}
	
	
		
	
	
%>