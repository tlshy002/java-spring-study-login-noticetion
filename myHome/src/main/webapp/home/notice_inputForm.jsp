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
<div align="center">
<h3 align="center">�������� ����</h3> <!-- �� url�� ��Ʈ�ѷ� ���� -->
<form:form action="../notice/putForm.html" method="post" modelAttribute="notice">
<table border="1">
	<tr><th>�������� ����</th>
		<td><form:input path="title"/>
			<font color="red"><form:errors path="title"/></font></td></tr>
			
	<tr><th>�������� ����</th>
		<td><form:textarea path="content" rows="6" cols="40"/>
			<font color="red"><form:errors path="content"/></font></td></tr>
	
	<tr><td colspan="2" align="center"><input type="submit" value="�� �ø���"/>
						<input type="reset" value="�� ��"/></td></tr>
</table>
</form:form>
</div>
</body>
</html>










