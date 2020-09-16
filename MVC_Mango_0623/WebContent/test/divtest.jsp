<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	 <style>
	 	.box {
    position: relative;
    width: 25%; /* 원하는 너비 */
    background-color: green;
    
}
 .outer {
 	width: 100%;
 	display: flex;
 	flex-flow:row wrap;
 }
.box:before {
    content: "";
    display: block;
    padding-top: 100%; /* 1:1 비율 */
}
 
.content {
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background-color: black;
}
	 </style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div> 
		<form action="insertRestaurants.do" method="post">
		<div style="height:100%; background-color: #FF7100">
			<table>
				<tr>
					<td>카테고리:</td>
					<td><input type="text" name="category"  size="50"></td>
				</tr>
				<tr>
					<td>가게이름:</td>
					<td><input type="text" name="R_name"  size="50"></td>
				</tr>
				<tr>
					<td>주소:</td>
					<td><input type="text" name="addr"  size="50"></td>
				</tr>
				<tr>
					<td>전화번호:</td>
					<td><input type="text" name="tel"   size="50"></td>
				</tr>
				<tr>
					<td>음식종류:</td>
					<td><input type="text" name="kind"  size="50"></td>
				</tr>
				<tr>
					<td>오픈시간:</td>
					<td><input type="text" name="open_time"  size="50"></td>
				</tr>
				<tr>
					<td>휴일:</td>
					<td><input type="text" name="holiday"  size="50"></td>
				</tr>
				</center>
				
			</table>
			<tr>
				<div class="button">
				   <input type="submit" value="맛집입력">
				</div>
			</tr>
	</div>
		</form>
	</div>
</body>
</html>