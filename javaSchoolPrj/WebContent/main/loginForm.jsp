<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css"/>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="script/login.js"></script>
</head>
<body>
<c:if test="${empty user_id}">
 <div id="status">
     <ul>
        <li><label for="id">아 이 디</label>
            <input id="id" type="email" size="20" 
              maxlength="50" placeholder="example@kings.com">
        <li><label for="passwd">비밀번호</label>
            <input id="passwd" type="password" 
              size="20" placeholder="6~16자 숫자/문자" maxlength="16">
        <li class="label2">
            <button id="login">로그인</button>
            <button id="cancle">취소</button>
     </ul>
  </div>
</c:if>
<c:if test="${not empty user_id }">
	<div id="status">
     <ul>
        <li><b>${user_id}</b>님이 로그인 하셨습니다.
        <li class="label2">
        	<button id="logout">로그아웃</button>
        	<button id="cancle">취소</button>
        	
     </ul>
  </div>
</c:if>
</body>
</html>