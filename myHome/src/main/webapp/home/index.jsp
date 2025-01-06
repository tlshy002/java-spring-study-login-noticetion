<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
table { width: 90%; height: 90%; border: 1px solid blue; background-color: skyblue;
		border-collapse: collapse; margin-left: 20px; margin-right: 20px;}
td.main { width: 30%; border: 1px solid green; }
#menu { margin-left: 10px; margin-top: 10px; margin-right: 10px; 
		background-color: lightgreen; width: 90%; border: 1px dashed red; }
#login { margin-left: 10px; margin-top: 10px; width: 90%; background-color: yellow;
		border: 1px dashed orange; }	
#content { background-color: wheat; }			
</style>
</head>
<body onload="startClock()">
<header>
	<div align="center"><img alt="" src="../imgs/logo.gif"></div>
</header>
<section>
<c:set var="body" value="${param.BODY }"/>
<c:set var="id" value="${sessionScope.ID }"/>
	<table id="body">
		<tr>
			<td width="40%" height="300px" class="main">
				<div id="login">
					<jsp:include page="../login/login.html"/>
				</div>
				<div id="menu">
					<a href="../beer/beer.html">�� ������õ</a><br/>
					<a href="../gavabo/gavabo.html">�� ����������</a><br/>
					<a href="../home/index.html">�� Ȩ����</a><br/>
					<a href="">�� �Խñ� ����</a><br/>
					<a href="../write/write.html">�� �Խñ� ����</a><br/>
					<a href="">�� ��ǰ ����</a><br/>
					<c:if test="${id != null && id !='admin' }">
						<a href="">�� ��ٱ��� ����</a><br/>
					</c:if>
					<c:if test="${id != null && id == 'admin' }">
						<a href="">�� ��ǰ ������ ���</a><br/>
						<a href="">�� ��ǰ ���</a><br/>
					</c:if>
					<a href="">�� �������� ����</a><br/>
					<a href="../image/imageWrite.html">�� �̹��� �� ��� �Խñ� ����</a><br/>
					<a href="">�� �̹��� �� ��� �Խñ� ����</a><br/>
					<c:if test="${id != null && id=='admin' }">
						<a href="">�� �������� ����</a><br/>
					</c:if>
				</div>
			</td>
			<td id="content">
			<c:choose>
				<c:when test="${BODY != null }">
					<jsp:include page="${ BODY }"/>
				</c:when>
				<c:otherwise>
					<img alt="" src="../imgs/¯����.png" width="400" height="300">
				</c:otherwise>
			</c:choose>
			</td>
		</tr>
	</table>
</section>
<footer>
	<h3 align="center">�� ���ø����̼� �ۼ� ������Ʈ. Copyright 2024 
	<font color="red"><span id="clock"></span></font></h3>
</footer>
<script type="text/javascript">
function workingClock(){
	var today = new Date();
	var year = today.getFullYear(); 	var month = today.getMonth() + 1;
	if(month < 10) month = "0" + month; var date = today.getDate();
	if(date < 10) date = "0" + date;	var hour = today.getHours();
	if(hour < 10) hour = "0" + hour;	var min = today.getMinutes();
	if(min < 10) min = "0" + min;		var sec = today.getSeconds();
	if(sec < 10) sec = "0" + sec;		
	var str = year+"/"+month+"/"+date+" "+hour+":"+min+":"+sec;
	document.getElementById("clock").innerHTML = str;
}
function startClock(){
	workingClock();//���� �ð��� �����ִ� �ð踦 ����Ѵ�.
	setInterval(workingClock, 1000);//1�� �������� workingClock�Լ��� ��� ȣ���Ѵ�.
}</script>
</body>
</html>









