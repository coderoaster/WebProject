<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// 회원 정보 세션에 담기
	if(request.getAttribute("kakaoId")==null){
		session.setAttribute("kakaoId",session.getAttribute("kakaoId"));
	}else{
		session.setAttribute("kakaoId",request.getAttribute("kakaoId"));
	}
	if(request.getAttribute("kakaoName")==null){
		session.setAttribute("kakaoName",session.getAttribute("kakaoName"));
	}else{
		session.setAttribute("kakaoName",request.getAttribute("kakaoName"));
	}
	if(request.getAttribute("kakaoImage")==null){
		session.setAttribute("kakaoImage",session.getAttribute("kakaoImage"));
	}else{
		session.setAttribute("kakaoImage",request.getAttribute("kakaoImage"));
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" media="screen" href="./css/Header.css"/>

<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="./js/script.js"></script>

<title>Insert title here</title>
	<style>
		body {
		    position: relative;
		    min-width: 520px;
		    margin: 0 auto;
		    font-size: 100%;
		    line-height: 100%;
		    text-size-adjust: 100%;
		    -webkit-text-size-adjust: 100%;
		    word-break: keep-all
		}
	</style>
</head>
<body>
<section class="Header-White" id="HeaderId">
	<i onclick="location.href='main.do';" class="mango-logo-White" id="logo"></i>
	
	<div class="Header-SearchBox-Hidden" id="SearchBoxId">
		<i class="Header-SearchIcon"></i>
		<form action="search.do">
			<input id="main-search" name="search" type="text" placeholder="지역,식당 또는 음식" class="Header-SearchInput">
		</form>
		<form style="display: none;">
			<input type="text" value="${kakaoImage}" id="profile-image">
		</form>
	</div>
		<ul>
			<li id="TopList-Btn" class="Header-White-Btn-TopList"><a href="top_listsMain.do">맛집 리스트</a></li>
			<!-- 미구현 버튼 -->
			<!-- <li id="MangoPick-Btn" class="Header-White-Btn-MangoPick">망고 스토리</li> --> 
			<%-- <c:if test="${kakaoId == 1111}">
				<li id="MangoPick-Btn" class="Header-White-Btn-MangoPick"><a href="top_listsMain.do">식당 입력</a></li>
			</c:if> --%>
			
			<li id="Profile-Btn" class="Header-Btn-Profile">
			
				<c:if test="${kakaoImage != null}">
					<div class="Profile-Outer"><img src="${kakaoImage}" class="Header-Btn-Profile-Image-on" onclick="btn_profile()"></div>
				</c:if>
				<c:if test="${kakaoImage == null}">
					<i class="Header-Btn-Profile-Image-off" onclick="btn_profile()"></i>
				</c:if>
				
			</li>
		</ul>
</section>	

<div class="Dialog-Login" title="" style='display:none'>
	
	<button class="Dialog-Btn-Close"><h1>X</h1></button>

	<center style="position: relative; padding: 90px 0 0 0;"><h1>로그인</h1> <br>로그인 하면 가고싶은 식당을 <br>저장할 수 있어요</center>
	<a id="login-form-btn" href="javascript:kakaoLogin()">
 	 	<img
   			src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg"
   		 	width="200"
  	 	/>
 	</a>
</div>

<div class="Dialog-Cookie" title="" style='display:none'>
	<div class="Dialog-Cookie-Btn-Outer">
		<ul class="Dialog-Cookie-Btns">
			<li class="Dialog-Cookie-Btn1">최근 본 맛집</li>
			<li class="Dialog-Cookie-Btn2">가고싶다</li>
		</ul>
	</div>
	<div class="Dialog-Cookie-Scrollbox">
		<span id="cookie-clear" onclick="deleteCookie()">x clear all</span>
		<div class="Restaurants-ItemList-Outer">
			<ul class="Restaurants-ItemList">
				<!-- 최근 식당 리스트 생성  최대값 10개 -->
				<c:forEach items="${cookie_list}" var="dto" begin="0" end="${cookie_Cnt}">
					<li class="Restaurants-Item-Outer">
						<section class="Restaurants-Item-Section">
							<a class="Restaurants-ItemLink-Thumnail" href="restaurants.do?seq=${dto.id_store}"><img id="recent-thumnail" src="./img/${dto.image_food}"></a>
							
							<div class="Restaurants-ItemInfo-Outer">
								<a class="Restaurants-ItemLink" href="restaurants.do?seq=${dto.id_store}"><span>${dto.store_name}</span></a>
								<span class="Restaurants-ItemInfo">${dto.r_gu} - ${dto.kind} <br> ${dto.category_food}</span>
							</div>
						</section>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="Dialog-Cookie-Login" id="LoginBtn">
		<c:if test="${kakaoId == null}">
			<div class="Dialog-Cookie-Login-Btn" onclick="btn_login()"><h3>로그인</h3></div>
		</c:if>
		<c:if test="${kakaoId != null}">
			<script type="text/javascript"> $(function() { $("#LoginBtn").attr('class','Dialog-Cookie-Logout'); }); </script>
			<div class="Dialog-Cookie-Logout-Btn" onclick="btn_logout()">logout</div>
		</c:if>
	</div>
	
</div>

<script type="text/javascript">
	//회원 로그아웃
	function btn_logout() {
		var path = window.location.pathname; var page = path.split("/").pop();
		var page_name = page.split(".");
		alert("로그아웃 되었습니다.");
		var seq = "${restaurant_info.id_store}";
		location.href = "logout.do?page_name=" + page_name[0] + "&seq=" + seq;
		/* kakaoLogout(); */
	}
	//쿠키 삭제
	function deleteCookie() {
		var path = window.location.pathname; var page = path.split("/").pop();
		var page_name = page.split(".");
		var seq = null;
		//현재 페이지의 이름을 가져온다. 쿠키를 삭제한 페이지로 다시 리다이렉트
		switch (page_name[0]) {
		case "restaurants":
			seq = "${restaurant_info.id_store}";
			location.href = "deleteCookie.do?page_name=" + page_name[0] + "&seq=" + seq;
			beak;
		case "deleteCookie":
			seq = "${restaurant_info.id_store}";
			location.href = "restaurants.do?page_name=" + page_name[0] + "&seq=" + seq;
			beak;
		case "main":
			location.href = "deleteCookie.do?page_name=" + page_name[0];
			beak;
		default:
			location.href = "main.do";
			beak;
		}
	}
</script>

<!-- 사용자 정보 전송용 히든 폼 -->
<form class="KakaoLoginForm-Hidden" action="login.do" method="post">
	<input id="kakaoId" type="text" name="kakaoId" value=""> <br>
	<input id="kakaoName" type="text" name="kakaoName" value=""> <br>
	<input id="kakaoImage" type="text" name="kakaoImage" value=""> <br>
</form>
</body>
</html>