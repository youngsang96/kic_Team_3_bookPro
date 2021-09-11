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
<h2>회원정보</h2>
<table border=1>


<tr>
	<td>아이디</td>
	<td>${member.memberid}</td>
</tr>

<tr>
	<td>비밀번호</td>
	<td>${member.pass }</td>
</tr>


<tr>
	<td>이름</td>
	<td>${member.name}</td>
</tr>

<tr>
	<td>성별</td>
	<td>${member.gender }</td>
</tr>

<tr>
	<td>생일</td>
	<td>${member.birthday}</td>
</tr>

<tr>
	<td>이메일</td>
	<td>${member.email }</td>
</tr>


<tr>
	<td>휴대전화</td>
	<td>${member.tel}</td>
</tr>
</table>
</body>
</html>