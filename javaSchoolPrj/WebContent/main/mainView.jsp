<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/style.css"/>
<script src=js/jquery-3.3.1.min.js"></script>
<script src=script/main.js"></script>
<!DOCTYPE html>
<html>


	
 


<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
<c:if test="${msg=='success'}">
<script>
alert("회원가입성공");
</script>
</c:if>

<c:if test="${msg=='error'}">
<script>
alert("회원가입실패");
</script>  
</c:if>

자바중학교홈페이지
<c:if test="${not empty user_id }">
 ${user_name} 환영합니다.
</c:if>

<nav class="main-navi">
	<div class="navi-item" style='background-color: blue'>
		<a href="#" >홈</a> 
	</div>
					  
    <div class="navi-item" style='background-color: blue'>
		<a href="#" onclick="login_open()">
		<c:if test="${empty user_id}"> 	
		   로그인
		</c:if>
		<c:if test="${not empty user_id }">
		  로그아웃
		</c:if>
		</a> 
	</div>
	 
	  <div class="navi-item" style='background-color: blue'>
		
		 <a href="" onclick="join_open()">
			 <c:if test="${empty user_id}"> 	
			      회원가입
			 </c:if>
			 <c:if test="${not empty user_id }">
			     회원정보변경
		     </c:if> 
		 </a> 
	  </div>
		 
</nav> 

<table  border=1>
<tr>
<th colspan="2">방문자수</th>
</tr>
<tr>
<td>Today</td><td>Total</td>
</tr>
<tr>
<td>0명</td><td>0명</td>
</tr>
</table> 

<div id="login-popup" class="login-popup"> 
		<div id="login-window" class="login-window">
		  	<jsp:include page="loginForm.jsp"/> 
      </div>
</div>

<div id="join-popup" class="join-popup"> 
		<div id="join-window" class="join-window">
		  	<jsp:include page="registerForm.jsp"/> 
      </div>
</div>



