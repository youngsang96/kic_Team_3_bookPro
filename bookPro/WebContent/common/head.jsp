<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통합도서관</title>

<script
	src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin = "anonymous">
	
</script>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/headstyle.css">
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">

</head>




	<nav id="header" class="clearfix">
	
		
		<div class="sitemap">
			<ul class="clearfix">
				<c:if test="${login == null }">
				<li class="li"><a href="<%=request.getContextPath()%>/book/siteMap">사이트맵</a>
				<li class="slash">|</li>
				<li class="li"><a href="<%=request.getContextPath()%>/book/loginForm">로그인</a>
				<li class="slash">|</li>
				<li class="li"><a href="<%=request.getContextPath()%>/book/memberInput">회원가입</a>
				
				</c:if>
				
				<c:if test="${login != null }">
				
				<li class="li"><a href="<%=request.getContextPath()%>/book/loginForm">My library</a>
				<li class="slash">|</li>
				<li class="li"><a href="<%=request.getContextPath()%>/book/logOut">로그아웃</a>
				
				
				<c:if test="${login eq 'admin' }">
				<li class="slash">|</li>
				<li class="li"><a href="<%=request.getContextPath()%>/book/memberList">회원리스트</a>
				</c:if>
                </c:if>
			
				
				
				
			</ul>
		</div>
	


	<nav id="navbar" class="clearfix">
	
		<div class="navbar_logo">
			<i class="fab fa-accusoft"></i>
			<a href="<%=request.getContextPath()%>/book/main">통합도서관</a>
		</div>
		
		<div class="navbar_menu">
			<ul class="clearfix" >
			
				<li class="mainmenu"><a href="" class="content">자료검색</a>
					<ul class="submenu">
						<li><a href="">도서검색</a></li>
						<li><a href="">신착도서</a></li>
						<li><a href="">인기도서</a></li>
						
					</ul>
				</li>
				
				
				
				<li class="mainmenu"><a href="" class="content">독서문화행사</a>
					<ul class="submenu">
						<li><a href="">지역행사</a></li>
						<li><a href="">강연</a></li>
						<li><a href="">체험프로그램</a></li>
						<li><a href="">이벤트</a></li>
					</ul>
				</li>
				
				
				
				<li class="mainmenu"><a href="" class="content">도서관 서비스</a>
					<ul class="submenu">
						<li><a href="">도서관 이용</a></li>
						<li><a href="">도서관 정보</a></li>
						<li><a href="">시설 예약</a></li>
						
					</ul>
				</li>
				
			
				
				<li class="mainmenu"><a href="" class="content">공지사항</a>
					
				</li>
				
				
				<li class="mainmenu"><a href="" class="content">건의사항</a>
				    <ul class="submenu">
						<li><a href="">FAQ</a></li>
						<li><a href="">글쓰기</a></li>
					</ul>
				</li>
				
			</ul>
		</div>
		
	</nav>
	
</nav>

</html>