<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$(function(){ //페이지가 로딩되면 자동 실행

	//id가 btmLogin인 버튼을 누르면 아래의 펑션이 실행됨
	$("#btnLogin").click(function(){
		//태그에 입력한 값
		id=$("#id").val();
		pw=$("#pw").val();
		//아래와 같은 객체로 
		param={"id":id, "pw":pw};
		//비동기식 호출
		$.ajax({
			type: "post",
			url: "login_result.do",
			data: param,
			success: function(result){
				$("#result").html(result);
			}
		});
	});
});

</script>
</head>
<body>

id : <input type="text" id="id">
pw : <input type="password" id="pw">
<input type="button" id="btnLogin" value="로그인">

<div id="result"></div>
</body>
</html>