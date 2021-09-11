<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="w3-content" style="width: 95%">
		<table>
			<caption>
				<h2>통합 도서관 회원리스트 title 예시</h2>
			</caption>
			<tr colspan="11" bgcolor="yellow" align="center">
				<td colspan="11" span style="color: gray">
					----------------------------------------- ( 소제목: 회원목록 )
					------------------------------------------</td>
			</tr>
			<table border="1" width=700 bordercolor="purple" cellspacing="2"
				text-align="center">
				<tr align="center" bgcolor="Lavender">
					<th>아이디</th>
					<th>이름</th>
					<th>비밀번호</th>
					<th>생일</th>
					<th>성별</th>
					<th>전화번호</th>
					<th>이메일</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr>
				<c:forEach var="mem" items="${mlist}">
					<tr>
						<td>${mem.memberid}</td>
						<td>${mem.name}</td>
						<td>${mem.pass}</td>
						<td>${mem.birthday}</td>
						<td>${mem.gender}</td>
						<td>${mem.tel}</td>
						<td>${mem.email}</td>

						<td><a
							href="<%=request.getContextPath() %>/book/memberInfo?userid=${mem.memberid}">[회원정보]</a></td>
						<td><a
							href="<%=request.getContextPath() %>/book/memberUpdate?userid=${mem.memberid}">[수정]</a></td>
						<td><a
							href="<%=request.getContextPath() %>/book/memberDelete?userid=${mem.memberid}">[강제탈퇴]</a></td>
					</tr>
				</c:forEach>
			</table>
		</table>
	</div>
</body>
</html>