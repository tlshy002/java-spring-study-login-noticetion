<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, model.*" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h3>��ٱ��� ���</h3>
<c:choose>
	<c:when test="${CARTLIST == null}">
		<h3>��ٱ��ϰ� ����ֽ��ϴ�.</h3>
	</c:when>
	<c:otherwise>
	<table>
	<tr><th>��ǰ�ڵ�</th><th>��ǰ�̸�</th><th>�� ��</th><th>��ǰ����</th><th>�� ��</th>
		<th>����/����</th></tr>
		<c:forEach var="item" items="${CARTLIST}">
			<form action="cartModify.do" method="post" onsubmit="return check()">
			<input type="hidden" name="CODE" value="${item.item_code}"/>
			<tr><td>${item.item_code}</td><td>${item.item_title }</td>
				<td>${item.price }��</td>
				<td><input type="number" name="NUM" min="0" value="${item.num }"></td>
				<td>${item.sum }</td><td><input type="submit" value="����" name="BTN"/>
					<input type="submit" value="����" name="BTN"/></td></tr>
			</form>
		</c:forEach>
	</table>	
	</c:otherwise>
</c:choose>
<script type="text/javascript">
function check(){
	if( ! confirm("������ �����Ͻðڽ��ϱ�?")) return false;
}
</script>

<form action="">
	�� �� : ${TOTAL }�� <input type="submit" value="�����ϱ�"/>
</form>
 
</div>
</body>
</html>










