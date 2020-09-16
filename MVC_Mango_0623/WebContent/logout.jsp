<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%
		request.setCharacterEncoding("utf-8");
		String page_name = request.getParameter("page_name").toString();
		String seq = request.getParameter("seq").toString();
		
		//회원정보를 세션에서 삭제
		session.removeAttribute("kakaoId"); 
		session.removeAttribute("kakaoName"); 
		session.removeAttribute("kakaoImage");
	%>
	
	<script> 
		/* 
			로그아웃 한 페이지로 리다이렉트 
		*/
		var page_name = "<%=page_name%>";
		var seq = "<%=seq%>";
		switch (page_name) {
		case "restaurants":
			location.href = "restaurants.do?seq=" + seq;
			break;
		case "deleteCookie":
			location.href = "restaurants.do?seq=" + seq;
			break;	
		default:
			location.href = "main.do";
			break;
		}
	</script>