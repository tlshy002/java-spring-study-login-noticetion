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
<h3>�������� �󼼺���</h3>
<form action="" method="post" onsubmit="return check(this)">
<table>
	<tr><th>������ ��ȣ</th><td>${NOTICE.num }</td></tr>
	<tr><th>������ ����</th><td><input type="text" name="TITLE" 
								value="${NOTICE.title }"/></td></tr>
	<tr><th>�ۼ���</th><td>${NOTICE.writer }</td></tr>
	<tr><th>�ۼ���</th><td>${NOTICE.write_date }</td></tr>
	<tr><th>�۳���</th><td><textarea rows="5" cols="40" 
						name="CONTENT">${NOTICE.content }</textarea></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="�� ��"/>
		<input type="submit" value="�� ��"/></td>
</table>
</form>
</div>
<script type="text/javascript">
function check(frm){
	if(frm.TITLE.value == ''){alert("������ �Է��ϼ���."); return false;}
	if(frm.CONTENT.value == ''){alert("������ �Է��ϼ���."); return false;}
	if( ! confirm("������ �۾��� �����Ͻðڽ��ϱ�?")) return false;
}
</script>
</body>
</html>














