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
<c:choose>
	<c:when test="${param.R == 'NO' }">
		<script type="text/javascript">
			setTimeout(function(){
				alert("����� �����ϹǷ�, �Խñ��� �������� �ʾҽ��ϴ�.");
				location.href="../image/imageList.html";
			},100);
		</script>
	</c:when>
		<script type="text/javascript">
			setTimeout(function(){
				alert("�Խñ��� �����Ǿ����ϴ�.");
				location.href="../image/imageList.html";
			},100);
		</script>
	<c:otherwise>
	</c:otherwise>
</c:choose>
</body>
</html>
















