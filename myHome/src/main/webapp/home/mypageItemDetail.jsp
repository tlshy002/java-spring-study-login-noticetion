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
<h2>��ǰ �� ����</h2>
<form:form modelAttribute="sellingItem">
<table border="1">
	<tr><th>��ǰ ��ȣ</th><td><form:input path="item_code" readonly="true"/></td></tr>
	<tr><th>��ǰ �̸�</th><td><form:input path="item_title" readonly="true"/></td></tr>
	<tr><th>��ǰ ����</th><td><form:input path="price" readonly="true"/></td></tr>
	<tr><th>�� �� ��</th><td><form:input path="reg_date" readonly="true"/></td></tr>
	<tr><th>�� �� ��</th><td><form:input path="madein" readonly="true"/></td></tr>
	<tr><th colspan="2" align="center">��ǰ ����</th></tr>
	<tr><td colspan="2" align="center">
		<form:textarea path="item_spec" rows="5" cols="40" readonly="true"/></td></tr>
</table>
</form:form><br/><br/>
</div>
</body>
</html>