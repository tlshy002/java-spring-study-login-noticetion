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
	<h3 align="center">�̹��� �Խñ� �ۼ�</h3>
	<form:form action="../image/write.html" method="post" enctype="multipart/form-data"
			modelAttribute="bbsimage">
	<table>
		<tr><th>�� ��</th><td><form:input path="title"/>
			<font color="red"><form:errors path="title"/></font></td></tr>
		<tr><th>�� ȣ</th><td><form:input path="password"/>
			<font color="red"><form:errors path="password"/></font></td></tr>
		<tr><th>�̹���</th><td><input type="file" name="image"/>
			<font color="red"><form:errors path="image"/></font></td></tr>
		<tr><th>�� ��</th><td><form:textarea path="content" rows="8" cols="60"/>
			<font color="red"><form:errors path="content"/></font></td></tr>
		<tr><td colspan="2" align="center">
			<input type="submit" value="�� �ø���"/>
			<input type="reset" value="�� ��" /></td></tr>
	</table>
	</form:form>
</body>
</html>