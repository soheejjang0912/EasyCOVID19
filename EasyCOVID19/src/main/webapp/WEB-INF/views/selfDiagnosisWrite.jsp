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
		$("#btnSave").click(function() {
			//document.writeForm.action="insert.do"
			document.writeForm.submit(); // insert.do로 간다.
		});
	});
</script>

<div class="selfDiagnosisWrite">
	<div class="cases">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="titlepage text_align_left">
						<h2>글 쓰기</h2>
						<p>${update}</p>
					</div>
				</div>
			</div>
			<div class="row d_flex">
				<div class="col-md-12">
					<form id="writeForm" name="writeForm" method="post"
						action="selfDiagnosisWriteinsert.do">

						<div>
							<h4>1. 열(37.5도 이상)또는 발열감</h4>
							&nbsp; <input type="radio" name="fever" id="fever" value="yes"
								size="80" placeholder="제목을 입력하세요.">있음 <input
								type="radio" name="fever" id="fever" value="no" size="80"
								placeholder="제목을 입력하세요.">없음
						</div>
						<br>

						<div>
							<h4>2. 기침</h4>
							&nbsp; <input type="radio" name="cough" id="cough" value="yes"
								size="80" placeholder="제목을 입력하세요.">있음 <input
								type="radio" name="cough" id="cough" value="no" size="80"
								placeholder="제목을 입력하세요.">없음
						</div>
						<br>

						<div>
							<h4>3. 인후통</h4>
							&nbsp; <input type="radio" name="soreThroat" id="soreThroat"
								value="yes" size="80" placeholder="제목을 입력하세요.">있음 <input
								type="radio" name="soreThroat" id="soreThroat" value="no"
								size="80" placeholder="제목을 입력하세요.">없음
						</div>
						<br>

						<div>
							<h4>4. 몸살</h4>
							&nbsp; <input type="radio" name="bodyAche" id="bodyAche"
								value="yes" size="80" placeholder="제목을 입력하세요.">있음 <input
								type="radio" name="bodyAche" id="bodyAche" value="no" size="80"
								placeholder="제목을 입력하세요.">없음
						</div>
						<br>

						<div>
							<h4>5-1. 기타(두통, 후각, 미각소실 등)</h4>
							&nbsp; <input type="radio" name="etc" id="etc" value="yes"
								size="80" placeholder="제목을 입력하세요.">있음 <input
								type="radio" name="etc" id="etc" value="no" size="80"
								placeholder="제목을 입력하세요.">없음
						</div>
						<br>

						<div style="width: 800px;">
							<h4>5-2. 기타 상세내용</h4>
							&nbsp;
							<textarea id="etcDetails" name="etcDetails" rows="6" cols="80"
								placeholder="내용을 입력하세요."></textarea>
						</div>
						<br>

						<div style="width: 700px; text-align: center">
							<button type="button" id="btnSave" name="btnSave"
								class="send_btn">확인</button>
						</div>
						<br>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp" />