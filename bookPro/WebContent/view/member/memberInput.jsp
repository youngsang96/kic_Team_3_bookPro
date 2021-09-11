<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/memberInput.css">
</head>
<script>
function checkValue(){
	 
	 
	 
	 if(userInfo.memberid.value == ""){
		 alert("아이디를 입력하세요")
		 return false;
	 }
	 
	
	 
	 else if(userInfo.pass.value == ""){
		 alert("비밀번호를 입력하세요")
		 return false;
	 }
	 
	 else if(userInfo.pass.value != userInfo.passcheck.value){
		 alert("비밀번호를 동일하게 입력하세요");
		 return false;
	 }
	 
	 else if(userInfo.name.value == ""){
		 alert("이름을 입력하세요")
		 return false;
	 }
	 
	 else if(userInfo.birthday.value == ""){
		 alert("생일을 입력하세요")
		 return false;
	 }
	 
	 else if(userInfo.email.value == ""){
		 alert("이메일을 입력하세요")
		 return false;
	 }
	 
	 else if(userInfo.tel.value == ""){
		 alert("핸드폰 번호를 입력하세요")
		 return false;
	 }

	 else{
		 return true;
	 }
}



</script>



<body>

<div id="box">

<%@ include file = "../sidemenu/guide.jsp" %>


<form method="post" action="<%=request.getContextPath() %>/book/memberInputPro" name="userInfo"
		onsubmit = "return checkValue()" id="form">
		
<h2>회원가입</h2>
		
<table class="table">



<tr>
	<td>아이디<br>
	<input type="text" name="memberid" maxlength="50" class="text">
	<input type="button" value="중복체크" class="button">
	</td>
</tr>

<tr>
	<td>비밀번호<br>
	<input type="password" name="pass" maxlength="50" class="text">
	</td>
</tr>

<tr>
	<td>비밀번호 확인<br>
	<input type="password" name="passcheck" maxlength="50" class="text">
	</td>
</tr>

<tr>
	<td>이름<br>
	<input type="text" name="name" maxlength="50" class="text">
	</td>
</tr>

<tr>
	<td>성별 &nbsp &nbsp
	<input type="radio" name="gender" value="male" checked class="radio">
	<label for="select">남</label>
    <input type="radio" name="gender" value="female" checked class="radio">
    <label for="select">여</label>
	</td>
</tr>

<tr>
	<td>생일<br>
	<input type="date"  name="birthday" value="1990-01-01" min="1800-01-01" class="text">
	</td>
</tr>

<tr>
	<td>이메일<br>
	<input type="email"  name="email" placeholder="KIClibrary@gmail.com" class="text">
	<input type="button" value="인증" class="button">
	</td>
</tr>

<tr>
	<td>인증번호 확인<br>
	<input type="text"  name="emailcheck" class="text">
	</td>
</tr>

<tr>
	<td>휴대전화<br>
	<input type="text"  name="tel" class="text">
	</td>
</tr>



<tr>
	<td>
	<input type="submit" value="회원가입" class="button2">
	<input type="button" value="취소" class="button3">
	</td>
</tr>
</table>

</form>

</div>
</body>
</html>