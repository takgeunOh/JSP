<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>사람 정보 입력</h1>
<hr />
<form action="input.saram" method="POST">
	<table>
		<tr>
			<th>NO</th>
			<td><input type="text" name="no" value=""/></td>
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
			<th colspan="2"><input type="submit" value="추가" /></th>
		</tr>
	</table>
</form>
</body>
</html>