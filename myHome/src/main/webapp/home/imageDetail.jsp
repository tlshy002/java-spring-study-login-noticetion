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
<h3>�̹��� �Խñ� �󼼺���</h3>
<table>
	<tr><th>�� ��</th><td>${IMAGE.title }</td></tr>
	<tr><th>�ۼ���</th><td>${IMAGE.writer }</td></tr>
	<tr><th>�ۼ���</th><td>${IMAGE.w_date }</td></tr>
	<tr><td colspan="2" align="center"><img alt="" src="${pageContext.request.contextPath}/upload/${IMAGE.imagename }"
			width="250" height="200"/></td></tr>
	<tr><th>�� ��</th><td><textarea rows="5" cols="60" 
			readonly="readonly">${IMAGE.content }</textarea></td></tr>
	<tr><td colspan="2" align="center"><a href="../image/imageList.html">[���]</a></td></tr></table>
</div>
</body>
</html>





