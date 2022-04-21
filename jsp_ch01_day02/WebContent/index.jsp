<%@page import="org.comstudy21.saram.model.SaramDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
ServletContext application;
ArrayList<SaramDto> saramList = new ArrayList<SaramDto>();
{
	saramList.add(new SaramDto(1, "kim", "010-0111-1111", "kim@naver.com"));
	saramList.add(new SaramDto(2, "lee", "010-0111-2222", "lee@naver.com"));
	saramList.add(new SaramDto(3, "park", "010-0111-3333", "park@naver.com"));
}
%>
<%
application.setAttribute("saramList", saramList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사람 정보 관리</title>
</head>
<body>
<h1>사람 정보 관리 프로그램</h1>
<hr>
<ul>
	<li><a href="list.saram">사람 목록</a></li>
</ul>
</body>
</html>