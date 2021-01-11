<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en"> 
<jsp:include page="header.jsp"/>  
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script> 
$(function(){ 
	listReply("1");
	$("#btnReply").click(function(){ 
		reply();
	});
	$("#btnList").click(function(){
		loaction.href="board.do"
	});
}); 
function reply(){ 
	var replytext=$("#replytext").val();
	var bno="${dto.bno}"; 
	var param={"replytext":replytext, "bno":bno};
	$.ajax({
		type: "post",
		url: "replyInsert.do",
		data: param,
		success: function(){ 
			alert("댓글이 등록되었습니다.");
			listReply("1");
		},
		error: function(){
			alert("댓글 등록에 실패하였습니다.");
			e.printStackTrace();
		}
	});
};
function listReply(num){
	$.ajax({
		type: "post",
		url: "replyList.do?bno=${dto.bno}&curPage="+num,
		success: function(result){ 
			alert(result);
			$("#listReply").html(result); 
		},
		error: function(){
			alert("리스트 불러오기에 실패하였습니다.");
			e.printStackTrace();
		}
	});
};
</script>
 
     <div class="aboutSite"> 
       	<div class="cases">
	         <div class="container-fluid">
	            <div class="row">
	               <div class="col-md-12">
	                  <div class="titlepage text_align_left ">
	                     <h2>view!</h2>
	                     <p>코로나 관련 정보확인, 코로나 자가진단, 코로나 관련 게시판 기능을 사용할 수 있는 사이트입니다.</p>
	                  </div>
	               </div>
	            </div>
	            <div class="row d_flex">
	               <div class="col-md-12">
	                  <div class="latest text_align_center">
	                     <figure><img src="<%=request.getContextPath()%>/resources/images/cases1.png" alt="#"/></figure>
	                      <a class="read_more" href="aboutCovid.do">코로나 정보</a>
	                      	<div>제목 : ${dto.writer}</div> 
	                      	<div>??? :${sessionScope.userId}</div> 
		                     <div class="nostrud">
		                        <h3>01 코로나 정보 확인</h3>
		                        <p>코로나 관련 정보확인</p> 
		                     </div>
	                  </div>
	               </div> 
	            </div>
	            
	            <div>
	            	<input type="hidden" name="bno" value="${bto.bno}">
	            	<c:if test="${sessionScope.userId == dto.writer}">
	            		<button type="button" id="btnUpdate">수정</button>
	            		<button type="button" id="btnDelete">삭제</button>
	            	</c:if>
            		<button type="button" id="btnList">목록</button> 
	            </div> 
	            
	            <!-- 댓글 -->
	            <div sytle="width: 700px; text-align:center">
	            <c:if test="${sessionScope.userId != null}">
	            	<textarea rows="5" cols="80" id="replytext" placehoder="댓글을 작성하세요."></textarea>
	            	<br>
	            	<button type="button" id="btnReply">댓글쓰기</button>
	            </c:if> 
	            </div>
	            <!-- /댓글 --> 
	            
	            <!-- 댓글목록 출력 -->
	            <div id="listReply"></div>
	            
	        </div>
    	</div>
     </div> 
      <!-- end contact -->
      <!--  footer -->
<jsp:include page="footer.jsp"/>    