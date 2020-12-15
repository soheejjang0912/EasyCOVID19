<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>

<!-- 백그라운드 호출 -->
<script>
//$(선택자).이벤트함수(코드) //달러다음에 들어가는것이 선택하는것
//$(document).ready(function(){ //현재 전체 문서를 객체로 선택하고 / 로딩이되면 / 펑션을 실행하시오
$(function(){
	$.ajax({
		type: "post",
		url: "background.do", //이 주소로 전달된다.
		success: function(result){ //콜백함수 - 백그라운드로 콜을 하고 응답을 받는 것
			console.log("test: " + result);
			$("#result").html("상품명: " + result.name + ", 가격: " + result.price);
				//#은 아이디 아래의 result쪽에 들어간다.
		}
	});
});
  

</script>
</head>
<body>
<jsp:include page="../include/menu.jsp"></jsp:include>
<div id="result"></div>
</body>
</html>