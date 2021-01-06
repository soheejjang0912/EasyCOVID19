<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	
<jsp:include page="header.jsp"/> 
                
     <!-- contact -->
     <div class="aboutSite"> 
       	<div class="cases">
	         <div class="container-fluid">
	            <div class="row">
	               <div class="col-md-12">
	                  <div class="titlepage text_align_center ">
	                     <h2>About Corona Virus </h2> 
	                     <p>${update}</p> 
	                  </div>
	               </div>
	            </div>
	            <div class="row d_flex">
	               <div class="col-md-12">
	                  <div class="latest text_align_center">
	                     <figure><img src="<%=request.getContextPath()%>/resources/images/cases1.png" alt="#"/></figure> 
	                     <div class="nostrud">
	                        <h3>코로나바이러스감염증-19(COVID-19) 정보</h3>
	                        <p>${about}</p>  
	                        <p>${map}</p>    
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