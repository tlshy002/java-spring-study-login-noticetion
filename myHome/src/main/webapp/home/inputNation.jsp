<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h3>��ǰ ������ ���</h3>
<form action="" method="post" name="madeinfrm" onsubmit="return check(this)">
<table>
	<tr><th>�����ڵ�</th><td><input type="text" name="CODE"/>
		<input type="button" value="�ߺ� �˻�" onclick="codeCheck()"/></td></tr>
	<tr><th>�����̸�</th><td><input type="text" name="NAME"/></td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="������ ���"/>
		<input type="reset" value="�� ��"/></td></tr>
</table>
</form>
<script type="text/javascript">
function codeCheck(){
	
	if(document.frm.CODE.value == '') {
		alert("���� �ڵ带 �Է��ϼ���.");
	} else if(document.frm.CODE.value.lenth < 2 || document.frm.CODE.value.lenth > 10) {
		alert("�ڵ�� 2�� �̻�, 10�� ���Ϸ� �Է��ϼ���.");
		document.frm.user_id.focus(); return false;
	}
	var url = "../nation/codeCheck.html?CODE" + document.frm.CODE.value;
	window.open(url, "_blank_", "width=450,height=200");
}
</script>
</div>
</body>
</html>















