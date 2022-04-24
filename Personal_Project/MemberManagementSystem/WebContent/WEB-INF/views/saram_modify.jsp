<%@page import="java.util.ArrayList"%>
<%@page import="org.comstudy21.model.MemberDto"%>
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
	ArrayList<MemberDto> list = (ArrayList<MemberDto>)request.getAttribute("updateList");
MemberDto dto = (MemberDto)request.getAttribute("detail_dto");
System.out.println(dto.toString());
%>


<h1>고객 데이터 수정</h1>
<hr />
<h2>선택한 고객의 데이터는 다음과 같습니다.</h2>
<table border="1" width="600">
	<th>NO</th>
	<th>ID</th>
	<th>PW</th>
	<th>EMAIL</th>
	<th>REGIDATE</th>
	<tr>
		<td><%= dto.getNo() %></td>
		<td><%= dto.getId() %></td>
		<td><%= dto.getPw() %></td>
		<td><%= dto.getEmail() %></td>
		<td><%= dto.getRegidate() %></td>
	</tr>
</table>

<h2>수정하실 내용을 입력해주세요.</h2>
<form action="resultmodify.saram" method="POST">
	<table border="1" width="600">
		<tr>
			<th>NO</th>
			<td><input type="text" name="no" value="<%=dto.getNo()%>"/></td>
		</tr>
		<tr>
			<th>ID</th>
			<td><input type="text" name="id" value=""/></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="text" name="pw" value=""/></td>
		</tr>
		<tr>
			<th>EMAIL</th>
			<td><input type="text" name="email" value=""/></td>
		</tr>
		<tr>
			<th>REGIDATE</th>
			<td><input type="text" name="regidate" value=""/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정완료" />
				<input type="reset" value="취소" />
			</td>
		</tr>
	</table>
</form>

<a href="list.saram">목록으로 돌아가기</a></p>


</body>
</html>