<%@page import="org.comstudy21.saram.HelloWorld"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>길동이의 홈페이지</h1>
<hr />

<%
HelloWorld hello = new HelloWorld();
hello.sayHello();
%>


<!--  구글링하기 : 젠코딩 또는 emmet 단축키 -->
<h3>오신 것을 환영합니다!</h3>

<ul>
	<li><a href="list.saram">사람 정보 목록</li>
	<li><a href="list.saram">사람 정보 입력</li>
	<li><a href="login.saram">로그인</li>
</ul>
</body>
</html>