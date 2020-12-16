<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="header.jsp"/>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$(function(){
	$("#btnLogin").click(function(){ 
		var userId = $("#userId").val();
		var userPw = $("#userPw").val();

		console.log(userId);
		if(userId == ""){
			alert("아이디를 입력하세요");
			$("#userId").focus();
			return;
		}
		if(userPw == ""){
			alert("비밀번호를 입력하세요.");
			$("#userPw").focus();
			return;
		}
		document.loginForm.action="loginCheck.do"
		document.loginForm.submit();
		
	});
});
</script>  

     <!-- contact -->
     <div class="contact">
         <div class="container">
            <div class="row">
                <div class="col-md-12">
                     <div class="titlepage text_align_left">
                        <h2>LOGIN</h2>
                     </div>
                  </div>
            </div>
            <div class="row">
               <div class="col-md-12">
                  <form id="loginForm" name="loginForm" method="post" class="main_form">
                     <div class="row">
                        <div class="col-md-12 ">
                        	<h2>아이디</h2> 
                           <input id="userId" name="userId" class="contactus" placeholder="ID" type="text"> 
                        </div>
                        <div class="col-md-12">
                        	<h2>비밀번호</h2> 
                           <input id="userPw" name="userPw" class="contactus" placeholder="Password" type="password">                          
                        </div>
                        <div class="col-md-12">
                        	<c:if test="${param.message == 'nologin' }">
	                           	<div style="color:red;">
	                           		먼저 로그인 하세요.
	                           	</div>
                           	</c:if> 
                           
                           <c:if test="${message=='error'}"> 
	                           	<div style="color:red;">
	                           		아이디 또는 비밀번호가 일치하지 않습니다.
	                           	</div>
                           </c:if>
                           
                           <c:if test="${message == 'logout' }">
	                           	<div style="color:red;">
	                           		로그아웃 되었습니다.
	                           	</div>
                           </c:if>
                           &nbsp; 
                           <button type="button" id="btnLogin" class="send_btn">LOGIN</button>
                           &nbsp; 
                             
                        </div>
                     </div>
                  </form>
               </div>  
            </div>
         </div>
      </div>
      <!-- end contact -->
      <!--  footer -->
<jsp:include page="footer.jsp"/>    