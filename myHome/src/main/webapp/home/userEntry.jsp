<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">���� ���� �Է�</h3>
<form:form action="register.do" method="post" name="frm" modelAttribute="user">
<input type="hidden" name="idChecked">
<table>
	<tr><th>�� ��</th><td><form:input path="user_id"/>
		<input type="button" value="�ߺ��˻�" onclick="idCheck()"/></td></tr>
	<tr><th>�� ��</th><td><form:input path="name"/></td></tr>
	<tr><th>�� ��</th><td><form:input path="addr"/></td></tr>
	<tr><th>����ó</th><td><form:input path="phone"/></td></tr>
	<tr><th>�� ȣ</th><td><form:input path="user_pw"/> </td></tr>
	<tr><th>��ȣȮ��</th><td><input type="password" name="CONFIRM"/></td></tr>
	<tr><th>�� ��</th><td>��<form:radiobutton path="gender" value="M"/>,
			��<form:radiobutton path="gender" value="F"/></td></tr>
	<tr><th>�̸���</th><td><form:input path="email"/>/ </td></tr>
	<tr><th>�� ��</th><td><input type="date" name="birth"/></td></tr>
	<tr><th>�� ��</th><td><form:select path="">
		<form:option value="�� ��">�� ��</form:option>
		<form:option value="ȸ���">ȸ���</form:option>
		<form:option value="�� ��">�� ��</form:option>
		<form:option value="�ڿ���">�ڿ���</form:option>
		<form:option value="�� Ÿ">�� Ÿ</form:option>
	</form:select></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="�����ϱ�"/>
		<input type="reset" value="�� ��"/></td></tr>
</table><br/>
<script type="text/javascript">

function idCheck(){
	if(document.frm.user_id.value == ''){
		alert("������ �Է��ϼ���."); document.frm.user_id.focus(); return false;
	}else {
		if(document.frm.user_id.value.length < 5 || document.frm.user_id.value.length > 15){
			alert("������ 6�� �̻�, 15�� ���Ϸ� �Է��ϼ���."); 
			document.frm.user_id.focus(); return false;
		}
	}
	var url="../entry/idcheck.html?USER_ID="+document.frm.user_id.value;
	window.open(url, "_blank_", "width=450,height=200");
}
</script>
</form:form>
</body>
</html>

















