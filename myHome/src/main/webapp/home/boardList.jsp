<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, model.*" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h3 align="center">�Խñ� ���</h3>
<div align="center">
	<table border="1">
		<tr><th>�۹�ȣ<th>�ۼ���</th><th>�� ��</th><th>�ۼ���</th></tr>
		<c:forEach var="dto" items="${BOARD}">
		<tr><td>${dto.seq}</td>
			<td>${dto.id}</td>
			<td><a href="../write/detail.html?SEQ=${dto.seq}">${dto.title}</a></td>
			<td>${dto.write_date}</td></tr>
		</c:forEach>
	</table>
</div>
</body>
</html>