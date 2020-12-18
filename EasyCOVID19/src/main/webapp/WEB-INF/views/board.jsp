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
	$("#btnWrite").click(function(){
		location.href="write.do";
	})
		
})
</script> 
      <!-- board -->
      <div class="doctor">
         <div class="container"> 
            <div class="row">
               <div class="col-md-12">
                  <div class="titlepage text_align_center ">
                     <h2>게시판</h2>
                  </div>
               </div>
            </div> 
             
                        
            <button type="button" class="send_btn" id="btnWrite">글쓰기</button>
            
            <c:forEach var="row" items="${map.list}">
	            <div class="row d_flex">
	               <div class=" col-md-12">
		               <div id="ho_efcet" class="reader text_align_center">
		                  <%-- <i><img src="<%=request.getContextPath()%>/resources/images/doctor1.png" alt="#"/></i> --%>
		                  <h3>${row.title}</h3>  
		                  <h5 style="line-height:90px">${row.content}</h5>
		                  <h5 style="line-height:20px">🧑 ${row.name} 님이 작성하신 글입니다.</h5>
		                  <!--${row.bno}, ${row.writer}, ${row.regdate}, ${row.viewCnt}  -->
		                  <h5 style="line-height:30px"><fmt:formatDate value="${row.regdate}" 
		                  	pattern="yyyy-MM-dd HH:mm:ss"/></h5>
		                  <span><img src="<%=request.getContextPath()%>/resources/images/do.png" alt="#"/></span>
		               </div>
	               </div> 
	           	</div>
           	</c:forEach> 
           	
         </div>
      </div> 
      
      <!--  footer -->
<jsp:include page="footer.jsp"/>    