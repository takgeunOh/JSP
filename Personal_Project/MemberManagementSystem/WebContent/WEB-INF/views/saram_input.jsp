<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>고객 데이터 추가</h1>
<form action="input.saram" method="POST">
	<table>
		<tr>
			<th>NO</th>
			<td><input type="text" name="no" value="2"/></td>
		</tr>
		<tr>
			<th>ID</th>
			<td><input type="text" name="name" value="양만춘" /></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="text"  name="phone" value="1234"/></td>
		</tr>
		<tr>
			<th>EMAIL</th>
			<td><input type="text"  name="email" value="test@test.com"/></td>
		</tr>
		<tr>
			<th>REGIDATE</th>
			<td><input type="text"  name="regidate" value="22/04/25"/></td>
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="전송" /></th>
		</tr>
	</table>
</form>
</body>
</html>