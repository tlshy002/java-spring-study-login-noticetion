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
<h2>�� ���� ����</h2>

<form:form action="../mypage/modify.html" method="post" modelAttribute="user_info">
<form:hidden path="gender"/>
<form:hidden path="birth"/>
<table>
	<tr><th>�� ��</th><td><form:input path="user_id" readonly="true"/></td></tr>
	<tr><th>�� ȣ</th><td><form:password path="user_pw" value="${user_info.user_pw }"/>
		<font color="red"><form:errors path="user_pw"/></font></td></tr>
	<tr><th>�� ��</th><td><form:input path="name" readonly="true"/></td></tr>
	<tr><th>�� ��</th><td><form:input path="addr"/>
		<font color="red"><form:errors path="addr"/></font></td></tr>
	<tr><th>��ȭ��ȣ</th><td><form:input path="phone"/>
		<font color="red"><form:errors path="phone"/></font></td></tr>
	<tr><th>�� ��</th>
		<td><c:if test="${user_info.gender =='M' }">����</c:if>
			<c:if test="${user_info.gender =='F' }">����</c:if></td></tr>
	<tr><th>�� ��</th><td><form:input path="grade" readonly="true"/></td></tr>
	<tr><th>�̸���</th><td><form:input path="email"/>
		<font color="red"><form:errors path="email"/></font></td></tr>
	<tr><th>�� ��</th><td><input type="date" value="${user_info.birth }" readonly="readonly"></td></tr>
	<tr><th>�� ��</th><td><form:select path="job">
		<c:choose>
			<c:when test="${user_info.job == '�� ��' }">
				<form:option value="�� ��" selected="selected">�� ��</form:option>
			</c:when>
			<c:otherwise>
				<form:option value="�� ��">�� ��</form:option>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${user_info.job == 'ȸ���' }">
				<form:option value="ȸ���" selected="selected">ȸ���</form:option>
			</c:when>
			<c:otherwise>
				<form:option value="ȸ���">ȸ���</form:option>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${user_info.job == '�� ��' }">
				<form:option value="�� ��" selected="selected">�� ��</form:option>
			</c:when>
			<c:otherwise>
				<form:option value="�� ��">�� ��</form:option>
			</c:otherwise>
		</c:choose>
		<c:choose>	
			<c:when test="${user_info.job == '�� Ÿ' }">
				<form:option value="�� Ÿ" selected="selected">�� Ÿ</form:option>
			</c:when>
			<c:otherwise>
				<form:option value="�� Ÿ">�� Ÿ</form:option>
			</c:otherwise>
		</c:choose>
	</form:select>
	
	<tr><td align="center" colspan="2">
		<input type="submit" value="�������� ����"/>
		<input type="reset" value="�� ��"/>
	</td></tr>
</table>
</form:form><br/><br/>
</div>
</body>
</html>