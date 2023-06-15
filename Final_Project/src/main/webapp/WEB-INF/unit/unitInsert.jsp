<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<%@ include file="./../../adminsidebar.jsp" %>
<html> 
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no,maximum-scale=1.0,minimum-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="format-detection" content="telephone=no" />

    <style>
	.select_box {border:1px solid #dddfe3;transition:0.3s ease-in;padding:10px 20px 10px;border-radius:5px;margin-right:5px;}
	#uploader {width:100%;height:100px;border:1px solid #DDD;overflow:auto;border-radius:5px;}
	.qq-gallery.qq-uploader {line-height:68px;font-size:10px;padding:10px;}
	.qq-gallery .qq-upload-button {background:#fff;color:#999;font-size:14px;padding:5px;border:1px solid #DEDEDE;border-radius:5px;}
	.qq-gallery .qq-upload-list li {height:78px;}
	.qq-gallery .qq-thumbnail-wrapper {width:100px;height:40px;}
	.qq-gallery .qq-file-info {padding-top:0;}

	.mem_cont .myinfo_cont .comment {width:100%;font-size:14px;padding:5px;}
	.mem_cont .myinfo_cont .comment .good {color: #1758e0;}
	.mem_cont .myinfo_cont .comment .bad {color: #e01717;}
	.check_box {width:100%;}
	

</style>
<title>Insert title here</title>

<script async src="https://www.googletagmanager.com/gtag/js?id=G-8Y92N8GFN5"></script>

<script type="text/javascript" src="//wcs.naver.net/wcslog.js"></script>


<link rel="apple-touch-icon" href="/afc94f02f06e02366eb966793be29fae.png" sizes="114x114" />
<link rel="icon" href="/afc94f02f06e02366eb966793be29fae.png" sizes="72x72" />

<meta name="naver-site-verification" content="87ffd9a14ccde34ec704efbe9055248705337768" />
<meta name="description" content="에듀 : 원하는대로 이루어지다. 정보처리기사, 빅데이터분석기사, 기술사저자직강, 듀엣강의, 무료교안제공">



<link rel="stylesheet" type="text/css" href="//cdn.malgnlms.com/theme/6/css/common.css?t=20230604" />
<link rel="stylesheet" type="text/css" href="//cdn.malgnlms.com/theme/6/css/font_notoSans.css?t=20230604" />
<link rel="stylesheet" type="text/css" href="//cdn.malgnlms.com/theme/6/css/green_theme.css?t=20230604" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css" />

<link rel="stylesheet" type="text/css" href="/html/css/custom.css?t=20230604" /> <!-- 커스텀 css -->

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.3/TweenMax.min.js"></script>
<script src="https://unpkg.com/page-scroll-to-id@1.6.8/jquery.malihu.PageScroll2id.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.js"></script>

<script type='text/javascript' src='//cdn.malgnlms.com/common/js/common.js?t=20230604'></script>
<script type='text/javascript' src='//cdn.malgnlms.com/common/js/validate.js?t=20230604'></script>

<script type="text/javascript" src="/html/js/slick.min.js"></script>
<script type="text/javascript" src="/html/js/m_slick.js"></script>

</head>
<body>
<div class="content" align="center">
<script type="text/javascript" src="<%=conPath%>/resources/js/course.js"></script>
<script>
	function gotoList(pageNumber){
		location.href="getUnit.un?pageNumber="+pageNumber;
	}
</script>
 <!--  <script type="text/javascript" src="https://www.wannaedu.com/theme/6/js/ui.js"></script> -->

 <!-- <link rel="stylesheet" type="text/css" href="https://www.wannaedu.com/theme/6/css/member.css" /> -->
	<link rel="stylesheet" type="text/css" href="resources/css/register.css" />

    <style>
		.select_box {border:1px solid #dddfe3;transition:0.3s ease-in;padding:10px 20px 10px;border-radius:5px;margin-right:5px;}
		#uploader {width:100%;height:100px;border:1px solid #DDD;overflow:auto;border-radius:5px;}
		.qq-gallery.qq-uploader {line-height:68px;font-size:10px;padding:10px;}
		.qq-gallery .qq-upload-button {background:#fff;color:#999;font-size:14px;padding:5px;border:1px solid #DEDEDE;border-radius:5px;}
		.qq-gallery .qq-upload-list li {height:78px;}
		.qq-gallery .qq-thumbnail-wrapper {width:100px;height:40px;}
		.qq-gallery .qq-file-info {padding-top:0;}
	
		.mem_cont .myinfo_cont .comment {width:100%;font-size:14px;padding:5px;}
		.mem_cont .myinfo_cont .comment .good {color: #1758e0;}
		.mem_cont .myinfo_cont .comment .bad {color: #e01717;}
		.check_box {width:100%;}
		
	.myinfo_cont {
        display: flex;
        flex-direction: column;
        align-items: center;
        text-align: center;
    }
        .myinfo_cont dl {
        display: flex;
        justify-content: center;
        align-items: center;
        text-align: center;
    }

    .myinfo_cont dt,
    .myinfo_cont dd {
        margin: 0;
    }
	.button-text {
		text-align: center;
	}
	</style>

 
 
<div class="login_cont member_cont">
	<div class="login_in">
		
		<h3>목차 추가하기</h3>

	</div>
<c:forEach var="noUnit" items="${noUnit }">	
<div class="accordion" id="accordionExample">
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingOne${noUnit }">
<button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne${noUnit}" aria-expanded="true" aria-controls="collapseOne${noUnit}">
  <div class="button-text">
    ${noUnit.cousreName}&nbsp;&nbsp;&nbsp;||&nbsp;&nbsp;&nbsp;${noUnit.courseCode}
  </div>
</button>
    </h2>
    <div id="collapseOne${noUnit }" class="accordion-collapse collapse" aria-labelledby="headingOne${noUnit }" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        <div class="myinfo_cont refund_info">
        	<form action="insertUnit.un" method="post">
        	<input type="hidden" name="courseCode" value="${noUnit.courseCode}">
        	<dt>목차 1</dt>
        	<dd><input type="text" name="unit1"></dd>
        	<dt>목차 2</dt>
        	<dt><input type="text" name="unit2"></dt>
        	<dt>목차 3</dt>
        	<dt><input type="text" name="unit3"></dt>
        	<dt>목차 4</dt>
        	<dt><input type="text" name="unit4"></dt>
        	<dt>목차 5</dt>
        	<dt><input type="text" name="unit5"></dt>
        	<dt>목차 6</dt>
        	<dt><input type="text" name="unit6"></dt>
        	<dt>목차 7</dt>
        	<dt><input type="text" name="unit7"></dt>
        	<dt>목차 8</dt>
        	<dt><input type="text" name="unit8"></dt>
        	<dt>목차 9</dt>
        	<dt><input type="text" name="unit9"></dt>
        	<dt>목차 10</dt>
        	<dt><input type="text" name="unit10"></dt>
        	<br>
        	<dt><input type="submit" class="btn btn-outline-info" value="추가하기"></dt>
			</form>
        </div>
      </div>
    </div>
  </div>
  
</div>
</c:forEach>	

</div>

    <iframe src="" name="sysfrm" id="sysfrm" width="100%" height="0" scrolling="no" frameborder="0"></iframe>

</body>
</html>
</div>
</div>