<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.Item" %>    
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
<c:set var="dto" value="${ITEM }"/>
<div align="center">
<h3>��ǰ �� ����</h3>
<form:form modelAttribute="item">
<table>
	<tr><th>��ǰ��ȣ</th><td><form:input path="item_code" readonly="true"/></td></tr>
	<tr><th>��ǰ�̸�</th><td><form:input path="item_title"/></td></tr>
	<tr><th>��ǰ����</th><td><form:input path="price"/></td></tr>
	<tr><th>�� �� ��</th><td><form:input path="madein"/></td></tr>
	<tr><th>�� �� ��</th><td><form:input path="reg_date"/></td></tr>
	<tr><th>��ǰ����</th><td>
		<form:textarea path="item_spec" rows="5" cols="40"/>
		</td></tr>
</table>
</form:form>
</div>
</body>
</html>








