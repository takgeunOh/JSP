<%@page import="java.util.ArrayList"%>
<%@page import="org.comstudy21.saram.SaramStrListController"%>
<%@page import="javax.swing.event.ListDataListener"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- WEB-INF에 있는 view 페이지는 서블릿에서 forward 해야 한다. -->
<h1>사람 목록 페이지</h1>
<hr />

<%!
// 필드 선언부 (서비스 메소드 외부 - 필드영역)
// 함수 선언 가능
%>

<%
// 로컬스크립트 릿 (서비스 메소드 내부 - 로컬영역)
// 함수 선언 불가능
String message = (String)request.getAttribute("message");
String user = (String)request.getAttribute("user");
ArrayList<String> list = (ArrayList<String>) request.getAttribute("dataList");

for(int i=0;i<list.size();i++) {
	String data = list.get(i);
%>
	<!-- 여기는 HTML -->
	<%= data %>
<%
}
%>


<!-- 위에서 받은 데이터를 html에서 쓰기 -->
<h3>Message : <%=message %></h3>
<h3>User : <%=user %></h3>

<h3>데이터리스트 사람들 : </h3>
<h3><%=list.get(0) %></h3>
<h3><%=list.get(1) %></h3>
<h3><%=list.get(2) %></h3>
<h3><%=list.get(3) %></h3>
</body>
</html>