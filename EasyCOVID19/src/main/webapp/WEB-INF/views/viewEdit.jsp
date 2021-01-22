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
	$("#btnUpdate").click(function(){ 
		//보내는 방법 두가지!
		//document.writeForm.action="insert.do"
		document.writeForm.submit(); // insert.do로 간다.
	});
});
</script>   
     <!-- contact -->
     <div class="contact">
         <div class="container">
            <div class="row">
                <div class="col-md-12">
                     <div class="titlepage text_align_left">
                        <h2>글 쓰기</h2>
                        <form id = "writeForm" name="writeForm" method="post"
                        	action="viewUpdate.do"> 
                        	<div><br>
                        		제목 <input name="title" id="title" size="80"
                        		value="${dto.title}">
                        	</div><br>
                        	 
                        	<div>
                        		내용 <input id="content" name="content" size="80" style="height: 300px;" 
                        			 value="${dto.content}">
                        	</div>
                        	<input type= "hidden" name="bno" id="bno" value="${dto.bno}"><br>
                        	<div style="width:700px; text-align:center">
                        		<button type="button" id="btnUpdate" name="btnUpdate" class="btn btn-dark">확인</button>
                        	</div><br>
                        </form>
                     </div>
                  </div>
            </div> 
         </div>
      </div> 
      
      <!--  footer -->
<jsp:include page="footer.jsp"/>    