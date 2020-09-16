<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String str = "Str";
	
	ArrayList<String> arrayString = new ArrayList<String>();
	
	arrayString.add("123");
	arrayString.add("124");
	arrayString.add("125");
	arrayString.add("126");
	arrayString.add("127");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	var str = "<%=arrayString %>";
	console.log(str);

</script>

</head>
<body>

</body>
</html>