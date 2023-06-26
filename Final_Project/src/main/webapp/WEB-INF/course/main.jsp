<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="header">
  <%@ include file="./../../header.jsp"%>
</div>
<!-- 캐러셀사용부분  -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css">
<!-- 양옆 화살표 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css">
<script>

$(document).ready(function() {
	$('.slider').slick({
	    autoplay: true, // 자동 재생 설정
	    autoplaySpeed: 1000, // 재생 간격(2초)
		centerMode: true,
		centerPadding: '60px',
		slidesToShow: 3,
		speed: 1500,
		index: 2,
		focusOnSelect:true,
		responsive: [{
			breakpoint: 768,
				settings: {
					arrows: true,
					centerMode: true,
					centerPadding: '40px',
					slidesToShow: 3
					}
	        }, {
			breakpoint: 480,
			settings: {
				arrows: false,
				centerMode: true,
				centerPadding: '40px',
				slidesToShow: 1
			}
		}]
	});
});


</script>
<style>
  body {
    background-color: #0DCAF0;
  }
  
  .slick-prev, .slick-next {
    color: blue;
  }
  
  .slider {
    width: 1600px;
    height: 600px;
    margin: 20px auto;
    text-align: center;
  }
  
  .slide-h3 {
    margin: 10% 0 10% 0;
    padding: 10% 10%;
    background: white;
  }
  
  .slider div {
    margin-right: 13px;
  }
  
  
 .slick-center {
   display: block;
   max-width: 10% !important;
   max-height: 20% !important;
   opacity: 1;
 }
	.carousel-image {
		 width: 100%;
		height: auto;
	}
	#scrollToTopButton {
		display: none; /* 초기에 숨김 */
		position: fixed;
		bottom: 20px;
		right: 20px;
		z-index: 99;
	}
	  .card-img-top {
    width: 350px; /* 원하는 크기로 width 값을 조정하세요 */
    height: auto; /* 이미지의 가로세로 비율을 유지하도록 설정합니다 */
    border-radius: 10px; /* 원하는 값으로 border-radius를 조정하세요 */
  }
  .card {
  width: 400px;
}
</style>
<!-- 캐러셀사용부분  -->


<div style="margin-top:100px">
</div>

<div>
	<a href="#"><img src="<%=conPath%>/resources/images/mainbanner1.png"></a>
</div>
<div>
<center>
<span style="font-size : 40pt; font-style: bold; font-family:fantasy; color:white;">BEST 5</span>
</center>
</div>
<div class="slider">

	<c:forEach var="lists" items="${courseLists }">
	<div>
		<div class="slide-h3">
			<a href="coursePaidDetail.cs?courseCode=${lists.courseCode}&userId=${userId}" style="text-decoration: none;">
			<i class="fa fa-lg fa-trash"></i>
			<h3 align="center">
				<div class="card" style="width: 350px; --bs-card-border-color: none;">
					<img src="<%=request.getContextPath() %>/resources/${lists.cousreImg}" class="card-img-top" alt="${lists.cousreImg }사진나중에" style=" border-radius: 20%; width:350px; height:240px;">
					<div class="card-body">
						<p class="card-text" style="font-size:17pt">${lists.cousreName }</p>
						<p class="card-text" style="font-size:15pt">기간 : ${lists.cousreTerm }일</p>
						
						<p class="card-text" style="font-size:15pt">
 							<fmt:formatNumber value="${lists.cousrePrice}" pattern="#,###" />원
						</p>
					</div>
				</div>

			</h3>
			</a>
		</div>
	</div>
	</c:forEach>

</div>
<div class="promotion_1" style="height:150px !important; background-color:#f3f7f8;">
		
        <div class="video_cont" style="margin-right:30px">
        	<a href="https://www.wannaedu.com/template/viewer.jsp?id=223&lid=305811"  target="_blank">
        	<img src="<%=request.getContextPath()%>/resources/images/mainbanner2.png" style="border-radius: 30px;"/>
        	</a> 
        </div>
        
        <div class="text_cont">        	
            <h2 style="font-weight: bold; color: black;">정보처리기사 실기 파이널 맛보기</h2>            
            <p class="stxt" style="margin: 10px 0;">
                정보처리기사 합격을 위한 확실한 방법!<br>모의고사와 기출문제 풀이로 실전에 대비하세요.
            </p>            
            <a href="#" class="mypage bgColor" style="margin-top: 20px;">  ***  수강신청 하러가기</a>
       	</div>     	
</div>







<div class="footer">
  <%@ include file="./../../footer.jsp"%>
</div>