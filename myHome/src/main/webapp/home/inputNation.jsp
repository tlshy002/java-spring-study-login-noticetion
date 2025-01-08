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
<h3>상품 원산지 등록</h3>
<form action="" method="post" name="madeinfrm" onsubmit="return check(this)">
<table>
	<tr><th>국가코드</th><td><input type="text" name="CODE"/>
		<input type="button" value="중복 검사" onclick="codeCheck()"/></td></tr>
	<tr><th>국가이름</th><td><input type="text" name="NAME"/></td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="원산지 등록"/>
		<input type="reset" value="취 소"/></td></tr>
</table>
</form>
<script type="text/javascript">
function codeCheck(){
	
	if(document.frm.CODE.value == '') {
		alert("국가 코드를 입력하세요.");
	} else if(document.frm.CODE.value.lenth < 2 || document.frm.CODE.value.lenth > 10) {
		alert("코드는 2자 이상, 10자 이하로 입력하세요.");
		document.frm.user_id.focus(); return false;
	}
	var url = "../nation/codeCheck.html?CODE" + document.frm.CODE.value;
	window.open(url, "_blank_", "width=450,height=200");
}
</script>
</div>
</body>
</html>















