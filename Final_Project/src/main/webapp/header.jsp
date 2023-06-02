<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 최신 버전의 Bootstrap CSS -->
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
    .bgColor {
        background-color: #1BCEB8;
        border-radius: 20px;        
        padding: 10px 20px;
        color : white;
        font-weight: bold;
        text-align: center;
        text-decoration: none;
        /* 글씨색 */
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
</style>
<%
	String conPath = request.getContextPath();
%>

<title>쌍용에듀</title>



<div class="row justify-content-end" style="background-color:white;">
	<div class="col-4 text-end">
		<div class="d-flex justify-content-end">
			<button type="button" class="btn btn-outline-info">login</button>
			<button type="button" class="btn btn-outline-info">singin</button>
			
		<div style="width: 12%;"></div> <!-- 오른쪽 공백 -->
		</div>
		
	</div>
</div>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"><img src="<%=conPath%>/resources/images/logo.png" width="190" height="80"></a>
		<div style="width: 30%;"></div> <!-- 오른쪽 공백 -->
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation" >
				<span class="navbar-toggler-icon"></span>
			</button>
			
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				
				<li class="nav-item dropdown" style="margin-right: 30px;">
					<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						 <span style="font-size: 25px; font-weight: bold; " >무료자료/자료<span>
					</a>
					<ul class="dropdown-menu">
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
					    <!-- 포문돌려서 나중에 고쳐야함 -->
						<li><a class="dropdown-item" href="#">정보처리</a></li>
						<li><a class="dropdown-item" href="#">빅테이터</a></li>
						<li><a class="dropdown-item" href="#">전자계산기</a></li>
						<li><a class="dropdown-item" href="#">데이터자격</a></li>
						<li><a class="dropdown-item" href="#">패키지</a></li>
						<!-- 포문돌려서 나중에 고쳐야함 -->
					</ul>					
				</li>
				
				<li class="nav-item dropdown" style="margin-right: 30px;">
					<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						 <span style="font-size: 25px; font-weight: bold; " >고객센터<span>
					</a>
					   
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">공지사항</a></li>
						<li><a class="dropdown-item" href="#">이벤트</a></li>
						<li><a class="dropdown-item" href="#">자주묻는질문</a></li>
						<li><a class="dropdown-item" href="#">카카오톡문의</a></li>
					</ul>					
				</li>
				<li class="nav-item" style="display: block;">
					<a class="bgColor" href="#" style=" display: block;">마이페이지</a>
				</li>
			</ul>
		</div>
	</div>
</nav>

