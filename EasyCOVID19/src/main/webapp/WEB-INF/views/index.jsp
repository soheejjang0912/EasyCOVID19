<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="header.jsp" />

<!-- end header -->
<div class="full_bg">
	<!-- header inner -->
	<div class="section">
		<!-- carousel code -->
		<div id="banner1" class="carousel slide slider_main">
			<ol class="carousel-indicators ">
				<li data-target="#banner1" data-slide-to="0" class="indicator-li-1">01</li>
				<li data-target="#banner1" data-slide-to="1" class="">02</li>
			</ol>
			<div class="carousel-inner">
				<!-- first slide -->
				<div class="carousel-item active">
					<div class="carousel-caption cuplle">
						<div class="container">
							<div class="row">
								<div class="col-md-8">
									<div class="photog">
										<h1>
											Care early<br>Coronavirus
										</h1>
										<a class="read_more" href="aboutSite.do">About Site</a> <a
											class="read_more" href="aboutCovid.do">About Covid19</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- second slide -->
				<div class="carousel-item">
					<div class="carousel-caption cuplle">
						<div class="container">
							<div class="row">
								<div class="col-md-8">
									<div class="photog">
										<h1>
											Care early<br>자가진단
										</h1>
										<a class="read_more" href="selfDiagnosis.do">자가진단 하기</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- controls -->
			<a class="carousel-control-prev" href="#banner1" role="button"
				data-slide="prev"> <i class="fa fa-angle-left"
				aria-hidden="true"></i> <span class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#banner1" role="button"
				data-slide="next"> <i class="fa fa-angle-right"
				aria-hidden="true"></i> <span class="sr-only">Next</span>
			</a>
		</div>
	</div>
</div>
<!-- end banner -->
<!-- about -->
<div class="about">
	<div class="container_width">
		<div class="row d_flex">
			<div class="col-md-7">
				<div class="titlepage text_align_left">
					<h2>About Corona Virus</h2>
					<p>2019년 12월 중국 우한에서 처음 발생한 이후 중국 전역과 전 세계로 확산된, 새로운 유형의
						코로나바이러스(SARS-CoV-2)에 의한 호흡기 감염질환이다. 코로나바이러스감염증-19는 감염자의 비말(침방울)이
						호흡기나 눈·코·입의 점막으로 침투될 때 전염된다. 감염되면 약 2~14일(추정)의 잠복기를 거친 뒤 발열(37.5도)
						및 기침이나 호흡곤란 등 호흡기 증상, 폐렴이 주증상으로 나타나지만 무증상 감염 사례 빈도도 높게 나오고 있다.</p>
					<a class="read_more" href="aboutCovid.do">About More</a>
				</div>
			</div>
			<div class="col-md-5">
				<div class="about_img text_align_center">
					<figure>
						<img
							src="<%=request.getContextPath()%>/resources/images/about.png"
							alt="#" />
					</figure>
				</div>
			</div>

		</div>
	</div>
</div>
<!-- end about -->
<!-- coronata -->
<div class="coronata">
	<div class="container">
		<div class="row d_flex grid">
			<div class="col-md-7">
				<div class="coronata_img text_align_center">
					<figure>
						<img
							src="<%=request.getContextPath()%>/resources/images/corona.png"
							alt="#" />
					</figure>
				</div>
			</div>
			<div class="col-md-5 oder1">
				<div class="titlepage text_align_left">
					<h2>Coronavirus what it is?</h2>
					<p>발열, 권태감, 기침, 호흡곤란 및 폐렴 등 경증에서 중증까지 다양한 호흡기감염증이 나타남 그 외 가래,
						인후통, 두통, 객혈과 오심, 설사 등도 나타남</p>
					<a class="read_more" href="aboutCovid.do">About More</a>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- end coronata -->

<!-- protect -->
<div class="protect">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="titlepage text_align_center">
					<h2>How to Protect Yourself</h2>
				</div>
			</div>
		</div>
	</div>
	<div class="protect_bg">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<!--  Demos -->
					<div class="owl-carousel owl-theme">
						<div class="item">
							<div class="protect_box text_align_center">
								<div class="desktop">
									<i><img
										src="<%=request.getContextPath()%>/resources/images/pro1.png"
										alt="#" /></i>
									<h3>Wear Mask</h3>
									<span> 외출시 마스크 착용하기</span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="protect_box text_align_center">
								<div class="desktop">
									<i><img
										src="<%=request.getContextPath()%>/resources/images/pro2.png"
										alt="#" /></i>
									<h3>Wash Your Hands</h3>
									<span> 흐르는 물에 비누로 꼼꼼하게 손씻기</span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="protect_box text_align_center">
								<div class="desktop">
									<i><img
										src="<%=request.getContextPath()%>/resources/images/pro3.png"
										alt="#" /></i>
									<h3>Stay at Home</h3>
									<span> 사람 많은 곳 방문 자제하기</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
<br>
<!-- end protect -->

<jsp:include page="footer.jsp" />