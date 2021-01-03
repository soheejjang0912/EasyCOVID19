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
		location.href="selfDiagnosisWrite.do";
	});
});
function list(page){
	location.href='selfDiagnosis.do?curPage='+page;
		/* +"&searchOption=${map.searchOption}"
		+"&keyword=${map.keyword}"; */
};
</script> 
      <!-- board -->
      <div class="board">
         <div class="container"> 
            <div class="row">
               <div class="col-md-12">
                  <div class="titlepage text_align_center ">
                     <h2>게시판</h2>
                  </div>
               </div>
            </div>  
            
            <button type="button" class="btn btn-dark" id="btnWrite">글쓰기</button>
     	 	&nbsp;
            <h5>${map.count}개의 게시물이 있습니다. </h5>     
			
            <c:forEach var="row" items="${map.list}"> 
	            <div class="row d_flex">
	               <div class=" col-md-12">
		               <div id="ho_efcet" class="reader text_align_center">
		                  <%-- <i><img src="<%=request.getContextPath()%>/resources/images/doctor1.png" alt="#"/></i> --%>
		                  <h3>${row.bno}</h3>  
		                  <h5 style="line-height:90px">${row.fever}</h5>
		                  <h5 style="line-height:20px">🧑 ${row.cough} 님이 작성하신 글입니다.</h5> 
		                  <h5 style="line-height:30px"><fmt:formatDate value="${row.regdate}" 
		                  	pattern="yyyy-MM-dd HH:mm:ss"/></h5>
		                  <span><img src="<%=request.getContextPath()%>/resources/images/do.png" alt="#"/></span>
		               </div>
	               </div> 
	           	</div>
           	</c:forEach> 
           	
           	<!-- 페이지 네비게이션 -->
       		<tr>
       			<td colspan="5" align="center">
       				<c:if test="${map.pager.curBlock > 1}">
       					<a href="javascript:list(1)">[처음]</a> 
       				</c:if>
       				
       				<c:if test="${map.pager.curBlock > 1}">
       					<a href="javascript:list('${map.pager.prevPage}')">[이전]</a> 
       				</c:if>
       				
       				<c:forEach var="num" begin="${map.pager.blockBegin}" 
       						end="${map.pager.blockEnd}"> 
       					<c:choose>
       						<c:when test="${num == map.pager.curPage}">
       							<span style="color:red;">${num}</span>&nbsp;
       						</c:when>
       						<c:otherwise>
       							<a href="javascript:list(${num})">${num}</a>&nbsp;
       						</c:otherwise>
       					</c:choose> 
     				</c:forEach>
     				
     				<c:if test="${map.pager.curBlock <= map.pager.totBlock}">
       					<a href="javascript:list(${map.pager.nextPage})">[다음]</a> 
       				</c:if>
       				
       				<c:if test="${map.pager.curPage < map.pager.totPage}">
       					<a href="javascript:list(${map.pager.totPage})">[끝]</a> 
       				</c:if> 
       				<%-- <c:forEach var="num" begin="1" end="${map.pager.totPage}"> 
       					<a href="javascript:list('${num}')">${num}</a> 
     				</c:forEach> --%>
     			</td>
     		</tr> 
         </div> 
     	 &nbsp; 
      </div> 
      
      <!--  footer -->
<jsp:include page="footer.jsp"/>    