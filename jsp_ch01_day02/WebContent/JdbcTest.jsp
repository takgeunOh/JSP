<%@page import="org.comstudy21.saram.model.SaramDao"%>
<%@page import="org.comstudy21.saram.model.SaramDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.comstudy21.saram.dbcp.JdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
Connection conn = JdbcUtil.getConnection();
out.println(conn);
out.println("<hr>");

SaramDao dao = new SaramDao();
ArrayList<SaramDto> saramList = (ArrayList<SaramDto>)dao.selectAll();
out.println(saramList);
%>

</body>
</html>