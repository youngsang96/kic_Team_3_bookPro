<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<br><br><br><br><br><br><br><br>
<div class="w3-content " style="width:80%;">
	<form action="<%=request.getContextPath() %>/book/memberUpdatePro" 
	name="f" method="post">
		<input type="hidden" name="userid" value="${member.memberid}">
		<table   >
			<caption>정보수정</caption>
			<tr>
				<td>아이디</td>
				<td>${member.memberid}</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"    value="${member.name}"></td>
			</tr>			
			<tr>
				<td>생일</td>
				<td><input type="date" name="birthday" value="1990-01-01" min="1800-01-01" class="text"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio"  value="male" name="gender" ${member.gender==male? 'checked':'' }>남
					<input type="radio"  value="female" name="gender" ${member.gender==female? 'checked':'' }>여</td>
			</tr>			<tr>				<td>전화번호</td>
				<td colspan="2"><input type="text" name="tel" value="${member.tel}"></td>
			</tr>			<tr>
				<td>이메일</td>
				<td colspan="2"><input type="text" name="email"  value="${member.email}"></td>
			</tr>			<tr>
				<td colspan="3"  align="right"><input type="submit"   value="정보수정"></td>
			</tr>
		</table>
		
	</form></div>
</body>
</html>