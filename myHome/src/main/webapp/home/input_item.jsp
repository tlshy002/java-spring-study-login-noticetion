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
<h3 align="center">상품 등록</h3>
<div align="center">
<script type="text/javascript">
function codeCheck() {
	if(document.itemFrm.item_code.value == '') {
		alert("상품코드를 입력하세요."); return;
	}
	var url="../item/codecheck.html?CODE=" + document.itemFrm.item_code.value;
	window.open(url, "__blank__", "width=450, height=200, top=200, left=300");
}
</script>

<form:form action="" method="post" modelAttribute="item" name="itemFrm">
	<table border="1">
	<tr><th>상품코드</th><td><form:input path="item_code"/>
			<input type="button" value="코드 중복 검사" onclick="codeCheck()" /></td></tr>
	<tr><th>상품이름</th><td><form:input path="item_title"/></td></tr>
	<tr><th>상품가격</th><td><form:input path="price"/></td></tr>
	<tr><th>원산지</th><td><form:select path="madein">
		<c:forEach var="nation" items="${NATIONS}">
			<form:option value="${nation.code }">${nation.name }</form:option>
		</c:forEach>
		
		</form:select></td></tr>
	<tr><th>상품설명</th><td><form:textarea path="item_spec" rows="5" cols="40"/> </td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="상품 등록"/>
		<input type="reset" value="취 소"/></td></tr>
	</table>
</form:form>
</div>
</body>
</html>













