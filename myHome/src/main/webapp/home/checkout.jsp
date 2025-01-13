<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>구매확인 화면</h2>
<font color="red"><b>배송 받을 곳</b></font>
<table>
	<tr><th>사용자ID</th><td>${User.user_id }</td></tr>
	<tr><th>이 름</th><td>${User.name }</td></tr>
	<tr><th>주 소</th><td>${User.addr }</td></tr>
	<tr><th>이메일</th><td>${User.email }</td></tr>
</table><br/><br/>
</div>

<font color="red"><b>구매 목록</b></font>
<table>
	<tr><th width="150">상품명</th><th width="150">가 격</th><th width="50">개 수</th><th width="150">소 계</th></tr>
	
	<c:forEach var="item" items="${CARTLIST }">
	<tr><td align="left">${item.item_title }</td>
		<td align="right">${item.price}원</td>
		<td align="right">${item.num}개</td>
		<td align="right">${item.sum}원</td>
	</tr>
	</c:forEach>
</table><br/><br/><b>구 매 총 액 : ${TOTAL}원</b><br/><br/>

<form action="../checkout/end.html" onsubmit="return check()">
	<input type="submit" value="구매 확정">
</form>

<script type="text/javascript">
function check(){
	if( ! confirm("구매확정 하시겠습니까?")) return false;
}
</script>
</body>
</html>