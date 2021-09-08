<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	function checkValue() {
		if (!document.userInfo.memberid.value) {
			alert("아이디를 입력하세요")
			return false;
		} else if (!document.userInfo.pass.value) {
			alert("비밀번호를 입력하세요")
			return false;
		}

		else if (document.userInfo.pass.value != document.userInfo.passcheck.value) {
			alert("비밀번호를 동일하게 입력하세요");
			return false;
		}
	}
</script>

<body>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<b><font size="6" color="grey">회원가입</font></b>
	<br>
	<br>
	<div >
	<form method="post"
		action="<%=request.getContextPath()%>/book/memberInputPro"
		name="userInfo" onsubmit="return checkValue()">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberid" maxlength="50">
				</td>
			</tr>

			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass" maxlength="50"></td>
			</tr>

			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="passcheck" maxlength="50"></td>
			</tr>

			<tr>
				<td>이름</td>
				<td><input type="text" name="name" maxlength="50"></td>
			</tr>

			<tr>
				<td>성별</td>
				<td><input type="radio" name="gender" value="male" checked>남
					<input type="radio" name="gender" value="female" checked>여
				</td>
			</tr>

			<tr>
				<td>생일</td>
				<td><input type="date" name="birthday" value="1990-01-01"
					min="1800-01-01"></td>
			</tr>

			<tr>
				<td>이메일</td>
				<td><input type="email" name="email"
					placeholder="SSquarepants@gmail.com"></td>
			</tr>

			<tr>
				<td>휴대전화</td>
				<td><input type="text" name="tel"></td>
			</tr>


		</table>
		<br> <input type="submit" value="가입"> <input
			type="button" value="취소">

	</form></div>


</body>
</html>