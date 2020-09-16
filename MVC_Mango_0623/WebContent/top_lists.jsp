<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" media="screen" href="./css/Top_list.css"/>
<title>맛집 리스트</title>
</head>
<body>
	<%
	 	int pagenum = 0;
		double restaurantnum = 0;
		String search = null;
		String rest_category = null;
		String rest_addr = null;
		restaurantnum = Integer.valueOf((int)request.getAttribute("restaurantnum"));		
	
		rest_category = request.getAttribute("rest_category").toString();
		rest_addr = request.getAttribute("rest_addr").toString();
		pagenum = (int)Math.ceil(restaurantnum/10);
		
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<%-- <div class="Header-Toplist">
		<P>${title}</P>
	</div> --%>
	
	<div class="Contents-Outer">
		<section class="Contents-Main">
			<div class="Contents">
				<div class="Contents-View">
					<section class="ItemList">
						<c:forEach items="${list}" var="dto" begin="1" end="10">
							<div class="Item-Container">
									<ul class="Item">	
										<li class="image"><a href="restaurants.do?seq=${dto.id_store}"><img src="./img/${dto.image_food}" width="280" height="230"></a></li>		
										<div class="Restaurants_Contents">
											<div style="display: flex; padding: 5px 0 5px 0;"><li class="store_name">${dto.store_name}&nbsp;&nbsp;&nbsp;&nbsp;</li><li class="store_rating">${dto.rating}</li></div>
											<li>${dto.address}</li>
										</div>		
									</ul>
							</div>	
							<hr>
						</c:forEach>
					</section>
					<div class="page">
						<% 
			 				for (int i = 1 ; i <=pagenum  ; i++) {
				 		%>		
							<a href="top_lists.do?page=<%=i%>&restaurantnum=<%=restaurantnum%>&rest_category=<%=rest_category%>&rest_addr=<%=rest_addr%>"><%=i%></a>	
						<%
							}
						%> 
					</div>
				</div>	
	<script type="text/javascript">
		$('document').ready(function() {
			$('#HeaderId').attr('class','Header-White');
			$('#logo').attr('class','mango-logo-White');
			$('#SearchBoxId').attr('class','Header-SearchBox');
		});
		
	</script>
</body>
</html>