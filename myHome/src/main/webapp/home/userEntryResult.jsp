<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:set var="result" value="${param.R }"/>
<c:if test="${result == 'YES' }">
	<script type="text/javascript">
		setTimeout(function(){alert("���ԵǾ����ϴ�~ �����մϴ�~~~");} , 100);//�ð� ���� �Լ�
	</script>
</c:if>
<c:if test="${result == 'NO' }">
	<script type="text/javascript">
		alert("���Ե��� �ʾҽ��ϴ�. �����ڿ��� ���ǹٶ��ϴ�.");
	</script>
</c:if>
</body>
</html>















