<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="boardUpdate.do" method="post" 
enctype="multipart/form-data" name="boradform">
<input type="hidden" name="bno" value="${board.bno}">
<input type="hidden" name="page" value="${page }">
<input type="hidden" name="nonMakeImg" value="${board.filename}">
<table>
	<tr>
	<th>작성자</th><td><input type="text" name="member_id" value="${board.member_id}"></td>
	</tr>
	<tr>
	<th>제목</th><td><input type="text" name="title" value="${board.title}"></td>
	</tr>
	<tr>
	<th>내용</th><td><textarea rows=10 cols=50 name="content">${board.content }</textarea></td>
	</tr>
	<tr>
	<th>파일첨부</th><td><input type="file" name="filename">${board.filename}</td>
	</tr>
	<tr>
	<td colspan=2 align="center">
		<input type="submit" value="수정">
		<input type="reset" value="다시쓰기">
		<input type="button" value="글목록보기" onclick="location.href='boardList.do'">
	</td>
	</tr>
</table>
</form>
</body>
</html>