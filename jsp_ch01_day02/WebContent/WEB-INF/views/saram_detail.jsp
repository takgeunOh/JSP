<%@page import="org.comstudy21.saram.model.SaramDto"%>
<%@page import="org.comstudy21.saram.model.SaramDao"%>
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
<h1>사람 정보 상세 보기</h1>
<%
String no = request.getParameter("no");
/* out.println(no);  선택 시 no 정상 출력 확인 */

SaramDto SelectDto = (SaramDto)request.getAttribute("saramDetail");

/* out.println(SelectDto);  정상 출력 확인 */
%>

<table>
<tr>
	<th>NO</th>
	<th>NAME</th>
	<th>PHONE</th>
	<th>EMAIL</th>
</tr>
<tr>
	<td><%=SelectDto.getNo() %></td>
	<td><%=SelectDto.getName() %></td>
	<td><%=SelectDto.getPhone() %></td>
	<td><%=SelectDto.getEmail() %></td>
</tr>
</table>

<hr>
<p>
	<a href="modify.saram?no=<%=SelectDto.getNo() %>">수정</a> | 
	<a href="delete.saram?no=<%=SelectDto.getNo() %>">삭제</a> | 
	<a href="list.saram">목록</a></p>
</body>
</html>