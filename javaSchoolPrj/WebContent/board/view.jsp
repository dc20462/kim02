<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border=1>
	<tr>
	<th>게시물 번호</th><td>${board.bno}</td>
	</tr>
	<tr>
	<th>작성자</th><td>${board.member_id}</td>
	</tr>
	<tr>
	<th>제목</th><td>${board.title}</td>
	</tr>
	<tr>
	<th>내용</th><td>${board.content}</td>
	</tr>
	<tr>
	<th>조회수</th><td>${board.read_count}</td>
	</tr>
	<c:if test="${not empty board.filename }">
		<tr>
		<th>첨부파일</th><td><img src="upload/${board.filename }"></td>
		</tr>
	</c:if>
	<tr>
	<td colspan=2 align="center">
		<input type="button" value="수정" onclick="location.href='boardUpdateForm.do?bno=${board.bno}&page=${page}'">
		<input type="button" value="삭제" onclick="location.href='boardDelete.do?bno=${board.bno}&page=${page}'">
		<input type="button" value="글목록보기" onclick="location.href='boardList.do'">
	</td>
	</tr>
</table>
</body>
</html>