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
	$("#btnSave").click(function(){
		documemt.writeForm.submit(); // insert.do로 간다.
	})
})
</script>  
 
     <!-- contact -->
     <div class="contact">
         <div class="container">
            <div class="row">
                <div class="col-md-12">
                     <div class="titlepage text_align_left">
                        <h2>글 쓰기</h2>
                        <form id = "writeForm" name="writeForm" method="post"
                        	action="${path}/insert.do"> 
                        	<div>
                        		제목 <input name="title" id="title" size="80" placeholder="제목을 입력하세요.">
                        	</div>	 
                        	<div style="width:800px;">
                        		내용 <textarea id="content" name="content" rows="6" cols="80"
                        			 placeholder="내용을 입력하세요."></textarea>
                        	</div> 
                        	<div>
                        		첨부파일을 등록하세요.
                        		<div class="fileDrop"></div>
                        		<div id="uploardedList"></div>
                        	</div> 
                        	<div style="width:700px; text-align:center">
                        		<button type="button" id="btnSave" name="btnSave">확인</button>
                        	</div> 
                        </form>
                     </div>
                  </div>
            </div> 
         </div>
      </div>
      <!-- end contact -->
      
      <!--  footer -->
<jsp:include page="footer.jsp"/>    