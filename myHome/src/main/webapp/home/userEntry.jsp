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
<h3 align="center">개인 정보 입력</h3>
<form:form action="register.do" method="post" name="frm" modelAttribute="user">
<input type="hidden" name="idChecked">
<table>
	<tr><th>계 정</th><td><form:input path="user_id"/>
		<input type="button" value="중복검사" onclick="idCheck()"/></td></tr>
	<tr><th>이 름</th><td><form:input path="name"/></td></tr>
	<tr><th>주 소</th><td><form:input path="addr"/></td></tr>
	<tr><th>연락처</th><td><form:input path="phone"/></td></tr>
	<tr><th>암 호</th><td><form:input path="user_pw"/> </td></tr>
	<tr><th>암호확인</th><td><input type="password" name="CONFIRM"/></td></tr>
	<tr><th>성 별</th><td>남<form:radiobutton path="gender" value="M"/>,
			여<form:radiobutton path="gender" value="F"/></td></tr>
	<tr><th>이메일</th><td><form:input path="email"/>/ </td></tr>
	<tr><th>생 일</th><td><input type="date" name="birth"/></td></tr>
	<tr><th>직 업</th><td><form:select path="">
		<form:option value="학 생">학 생</form:option>
		<form:option value="회사원">회사원</form:option>
		<form:option value="주 부">주 부</form:option>
		<form:option value="자영업">자영업</form:option>
		<form:option value="기 타">기 타</form:option>
	</form:select></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="가입하기"/>
		<input type="reset" value="취 소"/></td></tr>
</table><br/>
<script type="text/javascript">

function idCheck(){
	if(document.frm.user_id.value == ''){
		alert("계정을 입력하세요."); document.frm.user_id.focus(); return false;
	}else {
		if(document.frm.user_id.value.length < 5 || document.frm.user_id.value.length > 15){
			alert("계정은 6자 이상, 15자 이하로 입력하세요."); 
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

















