<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h3>이미지 게시글 상세보기</h3>
<table>
	<tr><th>제 목</th><td>${IMAGE.title }</td></tr>
	<tr><th>작성자</th><td>${IMAGE.writer }</td></tr>
	<tr><th>작성일</th><td>${IMAGE.w_date }</td></tr>
	<tr><td colspan="2" align="center"><img alt="" src="${pageContext.request.contextPath}/upload/${IMAGE.imagename }"
			width="250" height="200"/></td></tr>
	<tr><th>내 용</th><td><textarea rows="5" cols="60" 
			readonly="readonly">${IMAGE.content }</textarea></td></tr>
	<tr><td colspan="2" align="center">
		<a href="javascript:goReply()">[답글]</a>
		<a href="">[목록]</a></td></tr>
</table>
</div>
<form name="move" method="post">
	<input type="hidden" name="id" value="${IMAGE.w_id }">
	<input type="hidden" name="parentid" value="${IMAGE.w_id }">
	<input type="hidden" name="groupid" value="${IMAGE.group_id }">
</form>
<script type="text/javascript">
function goReply(){
	document.move.action="imageForm.do";
	document.move.submit();
}
</script>
</body>
</html>

















