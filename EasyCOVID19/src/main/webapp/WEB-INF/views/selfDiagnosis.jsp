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
			location.href = "selfDiagnosisWrite.do";
		});
	});
	function list(page) {
		location.href = 'selfDiagnosis.do?curPage=' + page;
		/* +"&searchOption=${map.searchOption}"
		+"&keyword=${map.keyword}"; */
	};
</script>

<div class="selfDiagnosis">
	<div class="cases">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="titlepage text_align_left">
						<h2>자가진단</h2>
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
								<div id="ho_efcet" class="reader text_align_center" style="height:250px">
									<div class="table-responsive"><br>
										<table class="table">
											<thread>
											<tr>
												<th>검사날짜</th>
												<th>열(37.5도 이상)또는 발열감</th>
												<th>기침</th>
												<th>인후통</th>
												<th>몸살</th>
											</tr>
											</thread>
											<tbody>
												<tr>
													<td><fmt:formatDate value="${row.regdate}"
															pattern="yyyy-MM-dd HH:mm:ss" /></td>
													<td>${row.fever}</td>
													<td>${row.cough}</td>
													<td>${row.soreThroat}</td>
													<td>${row.bodyAche}</td>
											</tbody>
										</table>
										<table class="table">
											<thread>
											<tr>
												<th>기타(두통, 후각, 미각소실 등)</th>
												<th>기타 상세내용</th>
											</tr>
											</thread>
											<tbody>
												<tr>
													<td>${row.etc}</td>
													<td>${row.etcDetails}</td>
											</tbody>
										</table>
									</div> 
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<!-- 페이지 네비게이션 -->
				<tr>
					<td colspan="5" align="center"><c:if
							test="${map.pager.curBlock > 1}">
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
						</c:if>
					</td>
				</tr>
			</div>
		</div>
	</div>
	&nbsp;
</div>

<jsp:include page="footer.jsp" />