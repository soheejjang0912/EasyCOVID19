<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="header.jsp" />

<div class="aboutSite">
	<div class="cases">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="titlepage text_align_left">
						<h2>About COVID19</h2>
						<p>${update}</p>
					</div>
				</div>
			</div>
			<div class="row d_flex">
				<div class="col-md-12">
					<div class="latest text_align_center">
						<div class="nostrud">
							<p>${about}</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp" />