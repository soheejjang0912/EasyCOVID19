<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
	<head>
      <!-- basic -->
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>EasyCOVID19</title>
      <meta name="keywords" content="">
      <meta name="description" content="">
      <meta name="author" content="">
      <!-- bootstrap css -->
      <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
      <!-- Responsive-->
      <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/responsive.css">
      <!-- fevicon -->
      <link rel="icon" href="<%=request.getContextPath()%>/resources/images/fevicon.png" type="image/gif" />
      <!-- Scrollbar Custom CSS -->
      <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
       <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/owl.carousel.min.css"> 
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
      <link rel="stylesheet" href="https://rawgit.com/LeshikJanz/libraries/master/Bootstrap/baguetteBox.min.css">
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
   </head>
   
   <!-- body -->
   <body class="main-layout">
      <!-- loader  -->
      <div class="loader_bg">
         <div class="loader"><img src="<%=request.getContextPath()%>/resources/images/loading.gif" alt="#"/></div>
      </div>
      <!-- end loader -->
      <!-- top -->
                    <!-- header -->
         <header class="header-area">
            <div class="left">
               <a href="Javascript:void(0)"><i class="fa fa-search" aria-hidden="true"></i></a>
            </div>
            <div class="right">
               <a href="Javascript:void(0)"><i class="fa fa-user" aria-hidden="true"></i></a>
            </div>
            <div class="container">
               <div class="row d_flex">
                  <div class="col-sm-3 logo_sm">
                     <div class="logo">
                        <a href="index.html"></a>
                     </div>
                  </div>
                  <div class="col-lg-10 offset-lg-1 col-md-12 col-sm-9">
                     <div class="navbar-area">
                        <nav class="site-navbar">
                           <ul>
                              <li><a class="active" href="index.jsp">Home</a></li>
                              <li><a href="about.jsp">About</a></li>
                              <li><a href="action.jsp">take action</a></li>
                              <li><a href="index.jsp" class="logo_midle">COVID19</a></li>
                              <li><a href="news.jsp">news</a></li>
                              <li><a href="board.do">게시판</a></li>
                              
                              <!-- sessionScope.userId
                              		는 자바의 
                              	   session.getAttribute("userId")  -->
                              <c:if test="${sessionScope.userId != null}"> 
                              <h3>
                              	${sessionScope.name} 님
                              	<!-- (${sessionScope.userId}) -->
                              </h3>
                              </c:if>
                              
                              <c:if test="${sessionScope.userId == null}"> 
                              <li><a href="login.do">LOGIN</a></li>
                              <li><a href="join.do">JOIN</a></li>
                              </c:if>
                              
                              
                           </ul>
                           <button class="nav-toggler">
                           <span></span>
                           </button>
                        </nav>
                     </div>
                  </div>
               </div>
            </div>
         </header>