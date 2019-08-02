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

<table border=1 width="550">
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

	<h3>답변글 영역</h3>
	<form action="replyWrite.do">
	<input type="hidden" name="page" value=${page }>
	<input type="hidden" name="bno" value=${board.bno }>
	<input type="hidden" name="member_id" value=${board.member_id }>
	<table border=1>
	<tr>
		<td width="50">${board.member_id }</td>
		<td width="400"><textarea name="content" row=4 cols=50></textarea></td>
		<td width="50">
		<input type="submit" value="댓글등록"></td>
	</tr>
	</table>
	</form>
	<h3>댓글 리스트</h3>
	<div id="replyList">
		<table>
			<c:choose>
				<c:when test="${board.reply_count>0 }">
				<c:forEach items="${replyList}" var="reply">
				<tr>
					<td>${reply.content }</td>
					<td>${reply.member_id }</td>
					<td>${reply.re_date }</td>
					<td><a href="replyDelete.do?rno=${reply.rno}&page=${page}&bno=${board.bno}">X</a></td>
				</tr> 
				</c:forEach>
				</c:when>
				<c:otherwise>
				<tr><td>등록된 댓글 없음</td></tr>
				</c:otherwise>
			</c:choose>
		</table>
	</div>

</body>
</html>