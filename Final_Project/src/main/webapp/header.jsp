<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./WEB-INF/common/common.jsp" %>

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
function loginForm(){
	window.location.href="/ex/loginForm.acc";
}

function signinForm(){
	window.location.href="/ex/register.acc";
}

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
	
function cartList(userId){
	window.location.href="/ex/cartList.ct?userId="+userId;
}	
function openCenteredWindow(url, name, width, height) {
	  var left = (window.innerWidth / 2) - (width / 2);
	  var top = (window.innerHeight / 2) - (height / 2);
	  var options = 'width=' + width + ',height=' + height + ',left=' + left + ',top=' + top;
	  window.open(url, name, options);
	}
</script>
<%
	String conPath = request.getContextPath();
%>

<title>쌍용에듀</title>


<c:if test="${empty loginInfo.userId }">
<div class="row justify-content-end" style="background-color:white;">
	<div class="col-4 text-end">
		<div class="d-flex justify-content-end">
			<button type="button" class="btn btn-outline-info" onclick="loginForm();">login</button>
			<button type="button" class="btn btn-outline-info" onclick="signinForm();">signin</button>
			
		<div style="width: 12%;"></div> <!-- 오른쪽 공백 -->
		</div>
		
	</div>
</div>
</c:if>

<c:if test="${loginInfo.adminCheck eq 0}">
<div class="row justify-content-end" style="background-color:white;">
	<div class="col-4 text-end">
		<div class="d-flex justify-content-end align-items-center">
			<img src="<%=conPath%>/resources/images/loginimg.png">${loginInfo.userName} 님
			<button type="button" class="btn btn-outline-info" onclick="logout();">logout</button>
			<button type="button" class="btn btn-outline-info" onclick="cartList('${loginInfo.userId}');">장바구니</button>

			
		<div style="width: 12%;"></div> <!-- 오른쪽 공백 -->
		</div>
		
	</div>
</div>
</c:if>
<c:if test="${loginInfo.adminCheck eq 1}">
<div class="row justify-content-end" style="background-color:white;">
	<div class="col-4 text-end">
		 <div class="d-flex justify-content-end align-items-center">
			<img src="<%=conPath%>/resources/images/loginimg.png" width="40" height="40">${loginInfo.userName} 관리자님
			<button type="button" class="btn btn-outline-info" onclick="logout();">logout</button>

			
		<div style="width: 12%;"></div> <!-- 오른쪽 공백 -->
		</div>
		
	</div>
</div>
</c:if>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
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
						<li><a class="dropdown-item" href="/ex/freeCourse.cs">무료 샘플강의</a></li>
                 		<li><a class="dropdown-item" href="/ex/list.dt">무료 자료</a></li>
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
						<li><a class="dropdown-item" href="/ex/list.ev">이벤트</a></li>
						<li><a class="dropdown-item" href="/ex/list.faq">자주묻는질문</a></li>
						<li><a class="dropdown-item" href="http://pf.kakao.com/_xhGiAG" onclick="openCenteredWindow(this.href, '카카오톡문의', 800, 600); return false;">카카오톡문의</a></li>
					</ul>					
				</li> 
				<li class="nav-item" style="display: block;">
					<c:if test="${loginInfo.adminCheck eq 0}">
						<a class="bgColor" href="mypage.acc?userId=${loginInfo.userId}" style=" display: block;">마이페이지</a>
					</c:if>
					<c:if test="${loginInfo.adminCheck eq 1}">
						<a class="bgColor" href="adminmain.cs" style=" display: block;">관리자페이지</a>
					</c:if>
					
				</li>
			</ul>
		</div>
	</div>
</nav>

 <div onclick="scrollToTop()" id="scrollToTopText">&#9650; 위로</div>