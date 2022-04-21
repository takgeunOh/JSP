<%@page import="org.comstudy21.saram.model.SaramDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="modify.saram" method="POST">
<%

/* SaramDto dto = new SaramDto();
dto = (SaramDto)request.getAttribute("saramUpdate");
out.println("수정 이름 확인 >> " + dto.getName()); */

String no = request.getParameter("no");
out.println(no); // 정상 출력 확인
%>
	<table>
		<tr>
			<th>NO</th>
			<td><input type="text" name="no" value=<%=no %>/></td>
			<!-- value 값으로 / 가 자동으로 입력이 된다.
			이 부분 질문할 것. -->
		</tr>
		<tr>
			<th>NAME</th>
			<td><input type="text" name="name" value="" /></td>
		</tr>
		<tr>
			<th>PHONE</th>
			<td><input type="text"  name="phone" value=""/></td>
		</tr>
		<tr>
			<th>EMAIL</th>
			<td><input type="text"  name="email" value=""/></td>
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="수정" /></th>
		</tr>
	</table>
</form>
</body>
</html>