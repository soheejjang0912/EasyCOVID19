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
		listReply("1");
		$("#btnReply").click(function() {
			reply();
		});
		$("#btnList").click(function() {
			location.href = "board.do"
		});
		$("#btnUpdate").click(function() {
			location.href = "viewEdit.do?bno=${dto.bno}"
		}); 
		$("#btnDelete").click(function() { 
			if (confirm("삭제하시겠습니까?")) {
				location.href = "viewDelete.do?bno=${dto.bno}"
			}
		});

	});
	function reply() {
		var replytext = $("#replytext").val();
		var bno = "${dto.bno}";
		var param = {
			"replytext" : replytext,
			"bno" : bno
		};
		$.ajax({
			type : "post",
			url : "replyInsert.do",
			data : param,
			success : function() {
				alert("댓글이 등록되었습니다.");
				document.getElementById("replytext").value = '';
				listReply("1");
			}, //여기 , 이 쉼표 안해서 에러났었음! 주의!!
			error : function() {
				alert("댓글 등록에 실패하였습니다.");
				e.printStackTrace();
			}
		});
	};
	function listReply(num) {
		$.ajax({
			type : "post",
			url : "replyList.do?bno=${dto.bno}&curPage=" + num,
			success : function(result) {
				$("#listReply").html(result);
			},
			error : function() {
				alert("리스트 불러오기에 실패하였습니다.");
				e.printStackTrace();
			}
		});
	};
</script>
<div class="view">
	<div class="cases">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="titlepage text_align_left ">
						<h2>🔊 ${dto.title}</h2>&nbsp;
						<h3>🧑 ${dto.name}님이 ⏰ <fmt:formatDate value="${dto.regdate}"
								pattern="yyyy-MM-dd HH:mm:ss" /> 에 작성한 글입니다! </h3> 
					</div>
				</div>
			</div>
			<div class="row d_flex">
				<div class="col-md-12">
					<div class="latest text_align_center">
						<div class="nostrud">
							<h2>${dto.content}</h2>
							<br> <br>
						</div>
					</div>
				</div>
			</div>

			<div>
				<input type="hidden" name="bno" value="${bto.bno}">
				<c:if test="${sessionScope.userId == dto.writer}">
					<button type="button" id="btnUpdate" class="btn btn-dark">수정</button>
					<button type="button" id="btnDelete" class="btn btn-dark">삭제</button>
				</c:if>
				<button type="button" id="btnList" class="btn btn-dark">목록</button>
			</div>

			<!-- 댓글 -->
			<div sytle="width: 1000px; text-align:center">
				<c:if test="${sessionScope.userId != null}">
					<br>
					<h3>😊댓글을 입력하세요😊</h3>
					<br>
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

<jsp:include page="footer.jsp" />