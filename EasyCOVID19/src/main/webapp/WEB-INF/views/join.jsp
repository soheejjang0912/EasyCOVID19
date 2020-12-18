<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	
<jsp:include page="header.jsp"/>
      <!-- end header -->

      <!-- contact -->
     <div class="contact">
         <div class="container">
            <div class="row">
                <div class="col-md-12">
                     <div class="titlepage text_align_left">
                        <h2>JOIN</h2>
                     </div>
                </div>
            </div>
            <div class="row">
               <div class="col-md-12">
                  <form id="form1" method="post" action="joinAction.do" class="main_form">
                     <div class="row">
                        <div class="col-md-12 ">
                        	<h2>아이디</h2> 
                           <input name="userId" class="contactus" placeholder="ID" type="text"> 
                        </div>
                        <div class="col-md-12">
                        	<h2>비밀번호</h2> 
                           <input name="userPw" class="contactus" placeholder="Password" type="password">                          
                        </div>
                        <div class="col-md-12 ">
                        	<h2>이름</h2> 
                           <input name="name" class="contactus" placeholder="Full Name" type="text"> 
                        </div>
                        <div class="col-md-12">
                        	<h2>이메일</h2> 
                           <input name="email" class="contactus" placeholder="E-mail" type="text">                          
                        </div>
                        <div class="col-md-12">
                           <button type="submit" class="send_btn">회원가입</button>
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