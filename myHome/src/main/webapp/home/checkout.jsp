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
<h2>����Ȯ�� ȭ��</h2>
<font color="red"><b>��� ���� ��</b></font>
<table>
	<tr><th>�����ID</th><td>${User.user_id }</td></tr>
	<tr><th>�� ��</th><td>${User.name }</td></tr>
	<tr><th>�� ��</th><td>${User.addr }</td></tr>
	<tr><th>�̸���</th><td>${User.email }</td></tr>
</table><br/><br/>
</div>

<font color="red"><b>���� ���</b></font>
<table>
	<tr><th width="150">��ǰ��</th><th width="150">�� ��</th><th width="50">�� ��</th><th width="150">�� ��</th></tr>
	
	<c:forEach var="item" items="${CARTLIST }">
	<tr><td align="left">${item.item_title }</td>
		<td align="right">${item.price}��</td>
		<td align="right">${item.num}��</td>
		<td align="right">${item.sum}��</td>
	</tr>
	</c:forEach>
</table><br/><br/><b>�� �� �� �� : ${TOTAL}��</b><br/><br/>

<form action="../checkout/end.html" onsubmit="return check()">
	<input type="submit" value="���� Ȯ��">
</form>

<script type="text/javascript">
function check(){
	if( ! confirm("����Ȯ�� �Ͻðڽ��ϱ�?")) return false;
}
</script>
</body>
</html>