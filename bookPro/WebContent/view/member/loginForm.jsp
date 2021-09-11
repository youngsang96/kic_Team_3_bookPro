<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm</title>
</head>
<body>
	<br>
	<br>
	<form action="<%=request.getContextPath()%>/book/loginPro"
		method="post">

		<br>
		<br> <br>
		<br> <br>
		<br> <br>
		<br> <br>
		<br> <br>
		<br>
		<table>
			<caption>로그인</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="memberid"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인"> <input
					type="button" value="회원가입"
					onclick="location.href='<%=request.getContextPath()%>/book/memberInput'">
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>