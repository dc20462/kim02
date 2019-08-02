<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><td colspan="5" align="right"><a href="boardWriteForm.do">글쓰기</a></td></tr>
<tr>
<th>번호</th><th>제목</th><th>작성자</th><th>날짜</th><th>조회수</th>
</tr>
<c:forEach items="${boardList }" var="board">
<tr>
<td>${board.bno }</td>
<td><a href="boardView.do?bno=${board.bno}&page=${pageMaker.currPage}">${board.title } [${ board.reply_count}]</a></td>
<td>${board.member_id }</td>
<td>${board.write_date}</td>
<td>${board.read_count}</td>
</tr>
</c:forEach>
<tr>
<td colspan=5>
<c:if test="${pageMaker.prev }">
	<a href="boardList.do?page=${pageMaker.startPage-pageMaker.pageSize}">[이전]</a>
</c:if>
<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="page">
<c:choose>
	<c:when test="${page==pageMaker.currPage }">${page }</c:when>
	<c:otherwise><a href="boardList.do?page=${page}">${page}</a></c:otherwise>
</c:choose>
</c:forEach>
<c:if test="${pageMaker.next }">
	<a href="boardList.do?page=${pageMaker.endPage+1}">[다음]</a>
</c:if>
</td>
</tr>
</table>
</body>
</html>