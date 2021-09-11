<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/loginForm.css">
</head>
<body>

<div id="box">

<%@ include file = "../sidemenu/guide.jsp" %>



<form action="<%=request.getContextPath() %>/book/loginPro" method="post" id="form">

<h2>Login</h2>

<table class="table">


<tr>
	<th>아이디</th>
	<td><input type="text" name="memberid" placeholder="아이디를 입력해주세요" class="text"></td>
	<td rowspan="2"><input type="submit" value="로그인" class="button"></td>
</tr>

<tr><th>비밀번호</th><td><input type="password" name="pass" placeholder="비밀번호를 입력해주세요" class="text"></td></tr>

<tr>
	<td colspan="3" class="memberinput">
		아직 회원이 아니신가요? &nbsp; &nbsp;
		<a href="<%=request.getContextPath() %>/book/memberInput">[회원가입]</a>
	</td>
</tr>

</table>
</form>



</div>

</body>

</html>