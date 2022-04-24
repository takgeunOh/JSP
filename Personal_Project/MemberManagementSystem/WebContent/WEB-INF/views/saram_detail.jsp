<%@page import="org.comstudy21.model.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>고객 데이터 검색</h1>
<hr />

<%
	MemberDto saram = (MemberDto)request.getAttribute("detail_dto");
%>


<h2>검색하신 고객의 상세 데이터는 다음과 같습니다.</h2>
<table border="1" width="600">
	<tr>
		<th>NO</th>
		<td><%=saram.getNo() %></td>
	</tr>
	<tr>
		<th>ID</th>
		<td><%=saram.getId() %></td>
	</tr>
	<tr>
		<th>PW</th>
		<td><%=saram.getPw() %></td>
	</tr>
	<tr>
		<th>EMAIL</th>
		<td><%=saram.getEmail() %></td>
	</tr>
	<tr>
		<th>REGIDATE</th>
		<td><%=saram.getRegidate() %></td>
	</tr>
</table>

<a href="list.saram">목록으로 돌아가기</a>
</body>
</html>