<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
<!--  <script type="text/javascript">
function check(frm) {
	if(frm.seq.value == '') { alert('글번호를 입력하세요.'); return false; }
	else {
		if(isNaN(frm.seq.value)) { alert("글번호는 숫자로 입력하세요."); return false; }
	}
	if(frm.id.value == '') { alert('작성자를 입력하세요.'); return false; }
	if(frm.title.value == '') { alert('제목을 입력하세요.'); return false; }
	if(frm.content.value == '') { alert('내용을 입력하세요.'); return false; }
	if(!confirm("정말로 등록하시겠습니까?")) return false;
}
</script> -->

<div align="center">
<h3 align="center">게시글 쓰기</h3>
<form:form action="../write/entryBoard.html" method="post" modelAttribute="board"> <!-- onsubmit,JS로 폼체크 => js대신 폼폼으로 변경 -->
<p>자유롭게 글을 작성하신 후 글올리기 버튼을 누르면, 작성한 글이 게시글에 올라갑니다.</p>
<table border="1">
	<tr><th>글번호</th>
		<td><form:input path="seq"/> <!-- 주입되는 Board객체의 변수이름 -->
			<font color="red"><form:errors path="seq"/></font></td></tr> 
	<tr><th>작성자</th>
		<td><form:input path="id"/>
		<font color="red"><form:errors path="id"/></font></td></tr>
	<tr><th>글제목</th><td>
		<form:input path="title" placeHolder="제목을 입력하세요"  size="30"/>
		<font color="red"><form:errors path="title"/></font></td></tr>
	<tr><th>글내용</th><td>
		<form:textarea path="content" rows="5" cols="50"/>
		<font color="red"><form:errors path="content"/></font></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="글 올리기"/>
						<input type="reset" value="취 소"/></td></tr>
</table>
</form:form>
</div>
</body>
</html>










