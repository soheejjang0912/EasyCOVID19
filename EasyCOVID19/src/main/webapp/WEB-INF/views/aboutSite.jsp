<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	
<jsp:include page="header.jsp"/> 
 
     <div class="aboutSite"> 
         	<div class="cases">
		         <div class="container-fluid">
		            <div class="row">
		               <div class="col-md-12">
		                  <div class="titlepage text_align_center ">
		                     <h2>ABOUT Easy COVID19 SITE</h2>
		                     <p>코로나 관련 정보확인, 코로나 자가진단, 코로나 관련 게시판 기능을 사용할 수 있는 사이트입니다.</p>
		                  </div>
		               </div>
		            </div>
		            <div class="row d_flex">
		               <div class="col-md-4">
		                  <div class="latest text_align_center">
		                     <figure><img src="<%=request.getContextPath()%>/resources/images/cases1.png" alt="#"/></figure>
		                      <a class="read_more" href="aboutCovid.do">코로나 정보</a>
		                     <div class="nostrud">
		                        <h3>01 코로나 정보 확인</h3>
		                        <p>코로나 관련 정보확인, <br>
		                        코로나 관련 뉴스를 <br>
		                        확인할 수 있습니다.</p> 
		                     </div>
		                  </div>
		               </div>
		               <div class="col-md-4">
		                  <div class="latest text_align_center">
		                     <figure><img src="<%=request.getContextPath()%>/resources/images/cases2.png" alt="#"/></figure>
		                      <a class="read_more" href="selfDiagnosis.do">자가진단</a>
		                     <div class="nostrud">
		                        <h3>02 코로나 자가진단</h3>
		                        <p>오늘 일어난 코로나 관련 증상을 자가진단 할 수 있습니다. <br>
		                        또한 지금까지 기록했던 자가진단 내용을 확인 할 수 있습니다.<br>
		                        ✔ 자가진단 기능은 회원가입한 회원만 이용 가능합니다.</p>
		                     </div>
		                  </div>
		               </div>
		               <div class=" col-md-4">
		                  <div class="latest text_align_center">
		                     <figure><img src="<%=request.getContextPath()%>/resources/images/cases3.png" alt="#"/></figure>
		                      <a class="read_more" href="board.do">참여마당</a>
		                     <div class="nostrud">
		                        <h3>03 참여마당</h3>
		                        <p>코로나 때문에 모두가 힘든 지금<br>
		                        코로나 극복을 위한 💪응원글 또는<br>
		                        👨🏼‍🤝‍👨🏻이야기들을 나눌 수 있습니다.</p>
		                     </div>
		                  </div>
		               </div>
		            </div>
		         </div>
      		</div>
         </div>
 
      <!-- end contact -->
      <!--  footer -->
<jsp:include page="footer.jsp"/>    