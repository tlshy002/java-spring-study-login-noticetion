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
<div align="right"><a href="index.jsp?BODY=userEntry.jsp">�����ϱ�</a></div>
<div align="center">


<form:form action="../login/loginDo.html" method="post" modelAttribute="loginUser">
	����: <form:input path="id" size="12" />
		<font color="red"><form:errors path="id"/></font><br/>
	��ȣ: <form:password path="password" size="12"/>
		<font color="red"><form:errors path="password"/></font><br/><br/>
	<input type="submit" value="�α���"/>
	<input type="reset" value="�� ��"/>
</form:form>

</div>
<script type="text/javascript">
function check(frm) {
	if(frm.ID.value == '') { alert("������ �Է��ϼ���."); frm.ID.focus(); return false; }
	if(frm.PW.value == '') { alert("��ȣ�� �Է��ϼ���."); frm.PW.focus(); return false; }
}
</script>
</body>
</html>