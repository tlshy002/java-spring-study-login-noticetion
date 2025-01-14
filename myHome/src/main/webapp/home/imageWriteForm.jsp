<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">이미지 게시글 작성</h3>
	<form:form action="../image/write.html" method="post" enctype="multipart/form-data"
			modelAttribute="bbsimage">
	<form:hidden path="order_no" value="${bbsimage.order_no + 1 }"/>
	<c:if test="${ ! empty bbsimage.group_id }">
		<form:hidden path="group_id" value="${bbsimage.group_id }"/>
	</c:if>
	
	<table>
		<tr><th>제 목</th><td><form:input path="title" value="${RE }"/> <!-- 제목앞에 "RE]" 붙음 -->
			<font color="red"><form:errors path="title"/></font></td></tr>
		<tr><th>암 호</th><td><form:password path="password"/>
			<font color="red"><form:errors path="password"/></font></td></tr>
		<tr><th>이미지</th><td><input type="file" name="image"/>
			<font color="red"><form:errors path="image"/></font></td></tr>
		<tr><th>내 용</th><td><form:textarea path="content" rows="8" cols="60"/>
			<font color="red"><form:errors path="content"/></font></td></tr>
		<tr><td colspan="2" align="center">
			<input type="submit" value="글 올리기"/>
			<input type="reset" value="취 소" /></td></tr>
	</table>
	</form:form>
</body>
</html>