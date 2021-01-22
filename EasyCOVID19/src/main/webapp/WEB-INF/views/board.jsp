<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="header.jsp" />
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(function() {
		$("#btnWrite").click(function() {
			location.href = "write.do";
		});
	});
	function list(page) {
		location.href = 'board.do?curPage=' + page;
	};
</script>

<div class="board">
	<div class="cases">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="titlepage text_align_left">
						<h2>게시판</h2>
					</div>
				</div>
			</div>

			<button type="button" class="btn btn-dark" id="btnWrite"
				style="float: right;">글쓰기</button>
			&nbsp;
			<h5>🙋‍♂️${map.count}개의 게시물이있습니다.</h5>

			<div class="row d_flex">
				<div class="col-md-12">
					<c:forEach var="row" items="${map.list}">
						<div class="row d_flex">
							<div class=" col-md-12">
								<div id="ho_efcet" class="reader text_align_center">
									<%-- <i><img src="<%=request.getContextPath()%>/resources/images/doctor1.png" alt="#"/></i> --%>
									<a href="view.do?bno=${row.bno}&curPage=${map.pager.curPage}">
										<h3>${row.title}</h3> <br>
										<h5 style="line-height: 20px">🧑 ${row.name} 님이 작성하신
											글입니다.</h5>
										<br>
										<h5 style="line-height: 30px">
											<fmt:formatDate value="${row.regdate}"
												pattern="yyyy-MM-dd HH:mm:ss" />
										</h5> <br> <span><img
											src="<%=request.getContextPath()%>/resources/images/do.png"
											alt="#" /></span>
									</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<!-- 페이지 네비게이션 -->
				<tr>
					<td colspan="5" align="center">
						<c:if
							test="${map.pager.curBlock != 1}">
							<a href="javascript:list(1)">[처음]</a>
						</c:if> <c:if test="${map.pager.curBlock > 1}">
							<a href="javascript:list('${map.pager.prevPage}')">[이전]</a>
						</c:if> <c:forEach var="num" begin="${map.pager.blockBegin}"
							end="${map.pager.blockEnd}">
							<c:choose>
								<c:when test="${num == map.pager.curPage}">
									<span style="color: red;">${num}</span>&nbsp;
       						</c:when>
								<c:otherwise>
									<a href="javascript:list(${num})">${num}</a>&nbsp;
       						</c:otherwise>
							</c:choose>
						</c:forEach> <c:if test="${map.pager.curBlock <= map.pager.totBlock}">
							<a href="javascript:list(${map.pager.nextPage})">[다음]</a>
						</c:if> <c:if test="${map.pager.curPage < map.pager.totPage}">
							<a href="javascript:list(${map.pager.totPage})">[끝]</a>
						</c:if></td>
				</tr>
			</div>
		</div>
	</div>
	&nbsp;
</div>

<jsp:include page="footer.jsp" />