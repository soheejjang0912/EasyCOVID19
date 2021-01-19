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
		//수정버튼 클릭
		$("#btnUpdate").click(function() {
			document.form1.action = "update.do";
			document.form1.submit();
		});

		//삭제버튼 클릭
		$("#btnDelete").click(function() {
			if (confirm("삭제하시겠습니까?")) {
				document.form1.action = "delete.do";
				document.form1.submit();
			}
		});
	});
</script>
<div class="memberModification">
	<div class="container">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="titlepage text_align_left">
						<h2>JOIN</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form id="form1" name="form1" method="post" class="main_form">
						<div class="row">
							<div class="col-md-12 ">
								<h2>아이디</h2>
								<input name="userId" class="contactus" placeholder="ID"
									type="text" value="${dto.userId}" readonly>
							</div>
							<div class="col-md-12">
								<h2>비밀번호</h2>
								<input name="userPw" class="contactus" placeholder="Password"
									type="password">
							</div>
							<div class="col-md-12 ">
								<h2>이름</h2>
								<input name="name" class="contactus" placeholder="Full Name"
									type="text" value="${dto.name}">
							</div>
							<div class="col-md-12">
								<h2>이메일</h2>
								<input name="email" class="contactus" placeholder="E-mail"
									type="text" value="${dto.email}">
							</div>
							<div class="col-md-12">
								<h2>회원가입 일자</h2>
								<input class="contactus" type="text"
									value="<fmt:formatDate value="${dto.joinDate}"
											pattern="yyyy-MM-dd HH:mm:ss" />">
							</div>
							<div class="col-md-6">
								<button type="button" class="send_btn" id="btnUpdate">수정</button>
								&nbsp;
							</div>
							<div class="col-md-6">
								<button type="button" class="send_btn" id="btnDelete">삭제</button>
								&nbsp;
							</div>

							<div class="col-md-12">
								<div style="color: red">${message}</div>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- end contact -->
<!--  footer -->
<jsp:include page="footer.jsp" />