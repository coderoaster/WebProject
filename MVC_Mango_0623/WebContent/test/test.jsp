<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="./js/script.js"></script>
	<style>
		.Header-Btn-Profile-Image-on {
			width: 35px;
			height: 35px;
			/* background-repeat: no-repeat;
			background-position: -82px -920px; */
			cursor: pointer;
		}
		.Profile-Outer {
			width: 35px;
			height: 35px;
			border-radius: 50px;
			border: solid 3px #ff6f00;
			overflow: hidden;
		}
	</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="Profile-Outer"><img src="http://k.kakaocdn.net/dn/bCbU96/btqvXvu2ub9/7kMQT78zjy8bkmJkhRXqpK/img_110x110.jpg"class="Header-Btn-Profile-Image-on" onclick="btn_profile()" ></i></div>
</body>
</html>

style='background-image: url("${member.kakaoImage}")'
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="./js/script.js"></script>
	<style>
	
	</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="table" class="table">
    <thead>
        <tr>
            <th>지역</th>
            <th>콘텐츠명</th>
            <th>콘텐츠 구분</th>
            <th>페이지 뷰</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${conList }" var="resultList" varStatus="status">
        <tr>
            <td>${resultList.area}</td>
            <td>${resultList.name}</td>
            <td>${resultList.gubun}</td>
            <td>${resultList.cnt}</td>
        </tr>
        </c:forEach>
        <tr id='addbtn'><td colspan="5"><divclass="btns"><a href="javascript:moreList();" class="btn btn-primary">더보기</a></div></td></tr>
    </tbody>
</table>

<script >
function moreList(){
    $.ajax({
        url :"/admin/jsonlist",
        type :"POST",
        cache : false,
        dataType:'json',
        data :"conectType="+conectType +"&eDate="+eDate+"&sDate="+sDate+"&codeId="+codeId+"&limit="+limit,
        success :function(data){
            //console.log(data);
            var content="";
            for(var i=0; i<data.hashMapList.length; i++){
                content +=
                "<tr>"+
                    "<td>"+data.hashMapList[i].area+"</td>"+
                    "<td>"+data.hashMapList[i].name+"</td>"+
                    "<td>"+data.hashMapList[i].gubun+"</td>"+
                    "<td>"+data.hashMapList[i].cnt+"</td>"+
                "</tr>";
            }
            content+="<tr id='addbtn'><td colspan='5'><div class='btns'><a href='javascript:moreList();' class='btn'>더보기</a></div>  </td></tr>";
            $('#addbtn').remove();//remove btn
            $(content).appendTo("#table");
        }, error:function(request,status,error){
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
           }
    });
};
</script>




</body>
</html>
