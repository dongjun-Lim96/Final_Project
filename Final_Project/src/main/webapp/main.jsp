<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.carousel-item img {
		width: 50%;
		height: 50%;
		object-fit: cover;
	.carousel-inner .carousel-item.active,
	.carousel-inner .carousel-item-next,
	.carousel-inner .carousel-item-prev {
	  display: flex;
	}
	
	.carousel-inner .carousel-item-right.active,
	.carousel-inner .carousel-item-next {
	  transform: translateX(25%);
	}
	
	.carousel-inner .carousel-item-left.active, 
	.carousel-inner .carousel-item-prev {
	  transform: translateX(-25%);
	}
	  
	.carousel-inner .carousel-item-right,
	.carousel-inner .carousel-item-left{ 
	  transform: translateX(0);
	}


</style>
<script>
	
</script>
<div class="header">
  <%@ include file="./header.jsp" %>
</div>




<div style="margin-top:100px">
</div>

<div>
	<a href="#"><img src="<%=conPath%>/resources/images/mainbanner1.png"></a>
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


<div class="promotion_2" style="height: 800px !important;">
    <div class="container text-center my-5">
        <h2 class="mb-3" style="padding: 100px 0 50px 0; font-weight: bold; font-size: 30pt;">BEST 인기강의</h2>
        <div class="row mx-auto my-auto" style="height: 400px; width: 100%; overflow: hidden;">
            <div id="recipeCarousel" class="carousel slide w-100" data-ride="carousel">
                <div class="carousel-inner" role="listbox">
                    <div class="carousel-item active">
                        <img class="d-block col-3 img-fluid" src="<%=conPath%>/resources/images/mainimg2.png" alt="Slide 1">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block col-3 img-fluid" src="<%=conPath%>/resources/images/mainimg2.png" alt="Slide 2">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block col-3 img-fluid" src="<%=conPath%>/resources/images/mainimg2.png" alt="Slide 3">
                    </div>
                    <!-- 다른 슬라이드 아이템 추가 -->
                </div>
                <a class="carousel-control-prev" href="#recipeCarousel" role="button" data-bs-slide="prev" style="margin-left: -100px;">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </a>
                <a class="carousel-control-next" href="#recipeCarousel" role="button" data-bs-slide="next" style="margin-right: -100px;">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </a>
            </div>
        </div>
    </div>
</div>


<div class="promotion_1" style="height:150px !important; background-color:#f3f7f8;">
		
        <div class="video_cont" style="margin-right:30px">
        	<a href="https://www.wannaedu.com/template/viewer.jsp?id=735&lid=275874"  target="_blank">
        	<img src="<%=request.getContextPath()%>/resources/images/mainbanner3.png" alt="배너이미지1" style="border-radius: 30px;"/>
        	</a>
        </div>
        
        <div class="text_cont">        	
            <h2 style="font-weight: bold; color: black;">정보처리기사 필기 강의 맛보기</h2>            
            <p class="stxt" style="margin: 10px 0;">
                정보처리기사는 수제비!!<br>수제비쌤과 보안쌤의 찰떡 케미를 맛보세요~
            </p>            
            <a href="#" class="mypage bgColor" style="margin-top: 20px;">  ***  더 보러가기</a>
       	</div>     	
</div>



<div class="promotion_1" style="height:150px !important; background-color:#f3f7f8;">
		
        <div class="video_cont" style="margin-right:30px">
        	<a href="https://www.wannaedu.com/template/viewer.jsp?id=735&lid=276307"  target="_blank">
        	<img src="<%=request.getContextPath()%>/resources/images/mainbanner4.png" alt="배너이미지1" style="border-radius: 30px;"/>
        	</a>
        </div>
        
        <div class="text_cont">        	
            <h2 style="font-weight: bold; color: black;">ADsP 강의 맛보기</h2>            
            <p class="stxt" style="margin: 10px 0;">
                ADsP는 수제비!!<br>빅데이터쌤과 수제비쌤의 상세한 설명을 맛보세요~
            </p>            
            <a href="#" class="mypage bgColor" style="margin-top: 20px;">  ***  더 보러가기</a>
       	</div>     	
</div>







