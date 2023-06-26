<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/common.css" />
<link rel="stylesheet" type="text/css" href="resources/css/mypage/main.css" />
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>        
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="resources/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
<body class="sb-nav-fixed">
    <%
		String conPath = request.getContextPath();
	%>
	
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

<!-- 최신 버전의 Bootstrap JavaScript 및 종속성 (popper.js) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

<!-- 최신 버전의 jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<style>
    .logo-container {
        margin-right: 220px;
    }
    .bgColor {
        background-color: #0DCAF0;
        border-radius: 20px;        
        padding: 10px 20px;
        color : white;
        font-weight: bold;
        text-align: center;
        text-decoration: none;
        /* 다른 스타일 속성 */
    }
    .promotion_1 {
        display: flex;
        align-items: center;
        justify-content: center;
        min-height: 100vh;
    }

    .mainimg1 {
        width: 75%;
    }

    .mainimg1 .text_cont {
        margin-left: 20px;
    }
    .grayBox {
        background-color: gray;
        position: absolute;
        top: 0;
        right: 0;
        width: 50%;
        height: 100%;
        z-index: -1;
    }	
	.header {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    z-index: 999;
   
  }
  
  
  
          /* top으로 가는 글씨 스타일 */
        #scrollToTopText {
            display: none; /* 초기에 숨김 */
            position: fixed;
            bottom:80px;
            right: 80px;
            z-index: 99;
            font-size: 18px;
            color: #fff;
            background-color: #0DCAF0;
            padding: 10px;
            border-radius: 4px;
            cursor: pointer;
        }
        
        .dropdown:hover .dropdown-menu {
  display: block;
}
        
</style>
<script type="text/javascript">

//스크롤 이벤트 감지하여 글씨 보이기/숨기기
window.onscroll = function() {
    showScrollToTopText();
};

// 페이지 맨 위로 스크롤 이동
function scrollToTop() {
    document.body.scrollTop = 0; // For Safari
    document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE, Opera
}

// 글씨 보이기/숨기기 함수
function showScrollToTopText() {
    var scrollToTopText = document.getElementById("scrollToTopText");
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        scrollToTopText.style.display = "block";
    } else {
        scrollToTopText.style.display = "none";
    }
}

function logout() {
	  $.ajax({
	    url: "logout.acc",
	    type: "POST",
	    success: function() {
	    	   /*  window.location.reload();  */
		      window.location.href = "list.cs"; 
	    },
	    error: function() {
	      alert("로그아웃에 실패했습니다.");
	      window.location.href = "list.cs"; 
	    }
	  });
	}
</script>


<nav class="navbar navbar-expand-lg bg-body-tertiary sb-topnav navbar navbar-expand">
	<div class="container-fluid">
		<a class="navbar-brand" href="list.cs"><img src="<%=conPath%>/resources/images/logo.png" width="190" height="80"></a>
		<div style="width: 30%;"></div> <!-- 오른쪽 공백 -->
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation" >
				<span class="navbar-toggler-icon"></span>
			</button>
			 
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				
				<li class="nav-item dropdown" style="margin-right: 30px;">
					<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-hover="dropdown" aria-expanded="false">
						<span style="font-size: 25px; font-weight: bold;">무료자료/자료</span>
					</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="freeCourse.cs?userId=${loginInfo.userId}">전체보기</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">무료 샘플강의</a></li>
						<li><a class="dropdown-item" href="#">무료 특강</a></li>
						<li><a class="dropdown-item" href="#">무료 자료</a></li>
					</ul>
				</li>
				
				<li class="nav-item dropdown" style="margin-right: 30px;">
					<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						 <span style="font-size: 25px; font-weight: bold; " >수강신청<span>
					</a>
					<ul class="dropdown-menu">  
						<li><a class="dropdown-item" href="paidCourse.cs?userId=${loginInfo.userId}">전체보기</a></li>
						<li><hr class="dropdown-divider"></li>
					    <!-- 포문돌려서 나중에 고쳐야함 -->
					    <c:forEach var="categoryList" items="${catelists}">
					    	<li><a class="dropdown-item" href="sortedPaidCourse.cs?categoryCode=${categoryList.categoryCode }&userId=${loginInfo.userId}">${categoryList.categoryName }</a></li>  
						</c:forEach>
						<!-- 포문돌려서 나중에 고쳐야함 -->
					</ul>					
				</li>
				
				<li class="nav-item dropdown" style="margin-right: 30px;">
					<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						 <span style="font-size: 25px; font-weight: bold; " >고객센터<span>
					</a>
					   
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="/ex/list.nt">공지사항</a></li>
						<li><a class="dropdown-item" href="list.ev">이벤트</a></li>
						<li><a class="dropdown-item" href="/ex/list.faq">자주묻는질문</a></li>
						<li><a class="dropdown-item" href="#">카카오톡문의</a></li>
					</ul>					
				</li> 
				<li class="nav-item" style="display: block; margin-top: 5px;">
					<a class="bgColor" style=" display: block;">${loginInfo.userId} 님 </a>
					<!-- <a class="bgColor" onclick="logout()" style=" display: block;">로그아웃</a> -->
				</li>
					
			</ul>
			<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="list.cs">home</a></li>
                        <!-- <li><a class="dropdown-item" href="#!">Activity Log</a></li> -->
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" onclick="logout()">Logout</a></li>
                    </ul>
                </li>
            </ul>
		</div>
	</div>
</nav>

 <div onclick="scrollToTop()" id="scrollToTopText">&#9650; 위로</div>	
	<%--  마이
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="mypage.acc?userId=${userId}"><img src="<%=conPath%>/resources/images/logo.png" width="190" height="80"></a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <!-- <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button> -->
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="list.cs">home</a></li>
                        <!-- <li><a class="dropdown-item" href="#!">Activity Log</a></li> -->
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="#!">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
         --%>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">마이페이지</div>
                            <a class="nav-link" href="mypage.acc?userId=${userId}">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                MyPage
                            </a>
                            <div class="sb-sidenav-menu-heading">강의정보</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                수강현황
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="aCourse.acc?userId=${userId}">수강중인 과정</a>
                                    <a class="nav-link" href="aCourseEnd.acc?userId=${userId}">종료된 과정</a>
                                    <a class="nav-link" href="reviewList.rv?userId=${userId}">리뷰 관리</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fa-solid fa-cart-shopping"></i></div>
                                결제관리 <!-- fas fa-book-open  fa-solid fa-cart-shopping-->
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        결제내역
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="pay.acc?userId=${userId}">결제내역 조회</a>
                                           <!--  <a class="nav-link" href="register.html">Register</a>
                                            <a class="nav-link" href="password.html">Forgot Password</a> -->
                                        </nav>
                                    </div>
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        위시리스트
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="wishlist.acc?userId=${userId}">수강신청</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">회원정보</div>
                            <a class="nav-link" href="updateCheck.acc?userId=${userId}">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                개인정보 수정
                            </a>
                            <a class="nav-link" href="out.acc?userId=${userId}">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                회원 탈퇴
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as: ${userId}님</div>
                    </div>
                </nav>
            </div>
             <div id="layoutSidenav_content">
             
             