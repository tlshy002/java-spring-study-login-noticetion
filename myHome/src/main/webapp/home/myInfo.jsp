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
<h2>내 정보 보기</h2>

<form:form action="" method="post" modelAttribute="user_info">
<form:hidden path="gender"/>
<form:hidden path="birth"/>
<table>
	<tr><th>계 정</th><td><form:input path="user_id" readonly="true"/></td></tr>
	<tr><th>암 호</th><td><form:password path="user_pw" value="${user_info.user_pw }"/></td></tr>
	<tr><th>이 름</th><td><form:input path="name" readonly="true"/></td></tr>
	<tr><th>주 소</th><td><form:input path="addr"/></td></tr>
	<tr><th>전화번호</th><td><form:input path="phone"/></td></tr>
	<tr><th>성 별</th>
		<td><c:if test="${user_info.gender =='M' }">남자</c:if>
			<c:if test="${user_info.gender =='F' }">여자</c:if></td></tr>
	<tr><th>등 급</th><td><form:input path="grade" readonly="true"/></td></tr>
	<tr><th>이메일</th><td><form:input path="email"/></td></tr>
	<tr><th>생 일</th><td><input type="date" value="${user_info.birth }" readonly="readonly"></td></tr>
	<tr><th>직 업</th><td><form:select path="job">
		<c:choose>
			<c:when test="${user_info.job == '학 생' }">
				<form:option value="학 생" selected="selected">학 생</form:option>
			</c:when>
			<c:otherwise>
				<form:option value="학 생">학 생</form:option>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${user_info.job == '회사원' }">
				<form:option value="회사원" selected="selected">회사원</form:option>
			</c:when>
			<c:otherwise>
				<form:option value="회사원">회사원</form:option>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${user_info.job == '주 부' }">
				<form:option value="주 부" selected="selected">주 부</form:option>
			</c:when>
			<c:otherwise>
				<form:option value="주 부">주 부</form:option>
			</c:otherwise>
		</c:choose>
		<c:choose>	
			<c:when test="${user_info.job == '기 타' }">
				<form:option value="기 타" selected="selected">기 타</form:option>
			</c:when>
			<c:otherwise>
				<form:option value="기 타">기 타</form:option>
			</c:otherwise>
		</c:choose>
	</form:select>
	
	<tr><td align="center" colspan="2">
		<input type="submit" value="개인정보 수정"/>
		<input type="reset" value="취 소"/>
	</td></tr>
</table>
</form:form><br/><br/>
</div>
</body>
</html>