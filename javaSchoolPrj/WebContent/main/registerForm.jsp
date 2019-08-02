<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css"/>
<script src="js/jquery-1.11.0.min.js"></script>
<script src="script/register.js"></script>
</head>
<body> 


<div id="regForm" class="box">
	<c:if test="${empty user_id}"> 	
		<form action="join.main" method="post">
		<table>
		<tr>
			<td>교직원</td>
			<td>학생</td>
		</tr>
		<tr>
			<td><input type="radio" name="type" value="A" checked="checked"></td>
			<td><input type="radio" name="type" value="S"></td>
		</tr>
		</table>
		<table border=1>
		<tr>
		<th colspan=2> 
		  회원가입
		</th>
		<tr>
		<th>아이디</th><td><input type="text" id="join_id" name="id"><input type='button' id="checkId" value = 'ID중복확인'></td>
		</tr>
		<tr> 
		<th>비밀번호</th><td><input type="password" name="pw"></td>
		</tr>
		<tr>
		<th>이름</th><td><input type="text" name="name"></td>
		</tr>
		<tr> 
		<th>주민번호</th><td><input type="text" name="jumin"></td>
		</tr>
		<tr>
		<th>주소</th><td><input type="text" name="address"></td> 
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
	</c:if>
	<c:if test="${not empty user_id }">
		<form action="member_update.main" method="post">
		<table>
		<tr>
			<td>교직원</td>
			<td>학생</td>
		</tr>
		<tr>
			<td><input type="radio" name="type" value="A" checked="checked"></td>
			<td><input type="radio" name="type" value="S"></td>
		</tr>
		</table>
		<table border=1>
		<tr> 
		<th colspan=2> 
		  회원정보수정
		</th>
		<tr>
		<tr>
		<th>아이디</th><td><input type="text" id="join_id" name="id"><input type='button' id="checkId" value = 'ID중복확인'></td>
		</tr>
		<tr> 
		<th>비밀번호</th><td><input type="password" name="pw"></td>
		</tr>
		<tr>
		<th>이름</th><td><input type="text" name="name"></td>
		</tr>
		<tr> 
		<th>주민번호</th><td><input type="text" name="jumin"></td>
		</tr>
		<tr>
		<th>주소</th><td><input type="text" name="address"></td> 
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
	</c:if> 
 
	<button id="join_cancle">취소</button> 
</div> 
</body>
</html>

