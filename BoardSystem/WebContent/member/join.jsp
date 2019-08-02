<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="member" method="post">
<input type="hidden" name="command" value="join">
<table border=1>
<tr>
<th>아이디</th><td><input type="text" name="id"></td>
</tr>
<tr>
<th>비밀번호</th><td><input type="password" name="pw"></td>
</tr>
<tr>
<th>이름</th><td><input type="text" name="name"></td>
</tr>
<tr>
<th>성별</th>
	<td>
	남<input type="radio" name="gender" value="M">
	여<input type="radio" name="gender" value="F">
	</td>
</tr>
<tr>
<th>주소</th><td><input type="text" name="addr"></td>
</tr>
<tr>
<th>연락처</th><td><input type="text" name="tel"></td>
</tr>
<tr>
<td colspan=2>
<input type="submit" value="join">
<input type="reset" value="reset">
</td>
</tr>
</table>
</form>
</body>
</html>