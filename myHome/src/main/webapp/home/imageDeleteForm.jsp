<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.*" %>    
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
<h3>�̹��� �Խñ� �� ����</h3>
<form action="imageDeleteDo.do" method="post" onsubmit="return check(this)">
<input type="hidden" name="id" value="<%= dto.getW_id()  %>"/>
<input type="hidden" name="pwd" value="<%= dto.getPassword() %>"/>
<table>
	<tr><th>�� ��</th><td><%= dto.getTitle() %></td></tr>
	<tr><th>�ۼ���</th><td><%= dto.getWriter() %></td></tr>
	<tr><th>�� ȣ</th><td><input type="password" name="PWD"/></td></tr>
	<tr><th>�ۼ���</th><td><%= dto.getW_date() %></td></tr>
	<tr><td colspan="2" align="center"><img alt="" src="upload/<%= dto.getImagename() %>"
			width="250" height="200"/></td></tr>
	<tr><th>�� ��</th><td><textarea rows="5" cols="60" 
			readonly="readonly"><%= dto.getContent() %></textarea></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="����"/>
		<input type="reset" value="�� ��"/></td></tr>
</table>
</form>
<script type="text/javascript">
function check(frm){
	if(frm.PWD.value == ''){alert("��ȣ�� �Է��ϼ���."); frm.PWD.focus(); return false;	}
	else {
		if(frm.pwd.value != frm.PWD.value){//�Է��� ��ȣ�� DB�� ��ȣ�� �ٸ� ���
			alert("�Է��� ��ȣ�� �Խñ��� ��ȣ�� ��ġ���� �ʽ��ϴ�. ��ȣ�� Ȯ���ϼ���.");
			frm.PWD.value
			return false;
		}
	}
	if( ! confirm("������ �����Ͻðڽ��ϱ�?")) return false;
}
</script>
</div>
</body>
</html>










