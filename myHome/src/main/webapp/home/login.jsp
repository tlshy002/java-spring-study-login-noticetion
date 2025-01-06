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
<div align="right"><a href="index.jsp?BODY=userEntry.jsp">가입하기</a></div>
<div align="center">


<form:form action="../login/loginDo.html" method="post" modelAttribute="loginUser">
	계정: <form:input path="id" size="12" />
		<font color="red"><form:errors path="id"/></font><br/>
	암호: <form:password path="password" size="12"/>
		<font color="red"><form:errors path="password"/></font><br/><br/>
	<input type="submit" value="로그인"/>
	<input type="reset" value="취 소"/>
</form:form>

</div>
<script type="text/javascript">
function check(frm) {
	if(frm.ID.value == '') { alert("계정을 입력하세요."); frm.ID.focus(); return false; }
	if(frm.PW.value == '') { alert("암호을 입력하세요."); frm.PW.focus(); return false; }
}
</script>
</body>
</html>