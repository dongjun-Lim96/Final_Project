
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

<%-- <script type="text/javascript" src="<%=conPath%>/resources/js/category.js"></script> --%>
<script>
    var message = "${message}";

    if (message !== "") {
        alert(message);
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
		.input {
        height: 150px !important; /* 원하는 높이로 조정 */
   		 }
		
	</style>

 <script>
 	function gotoFaq(){ 
 		location.href="list.faq";
 	}
 </script>
 
<div class="login_cont member_cont" style="width: 700%">
  <div class="login_in">
    <h3>자주묻는질문 추가</h3>
  </div>

  <form name="form1" method="POST" action="insert.faq" onSubmit="return writeSave()">
    <div class="mem_cont">
      <div class="myinfo_cont refund_info">
        <dl>
          <dt>질문 제목 <span class="pointColor">*</span></dt>
          <dd>
  			<textarea name="faqTitle" class="input" id="faqTitle" rows="6" cols="50" onkeydown="keyd()"></textarea>&nbsp;
		</dd>

        </dl>

        <dl>
          <dt>질문 답변 <span class="pointColor">*</span></dt>
          <dd>
            <textarea name="faqContent" class="input" type="text" id="faqContent" rows="6" cols="50"></textarea>  
            <div class="comment"></div>
          </dd>
        </dl>
      </div>
    </div>

    <div class="btn_list">
      <input type="button" class="moreBtn pointColor pointBorder" onclick="gotoFaq()" value="자주묻는질문 목록" />
      <input type="submit" class="moreBtn pointColor pointBorder" id="btn_submit" value="등록하기" />
    </div>
  </form>
</div>


    <iframe src="" name="sysfrm" id="sysfrm" width="100%" height="0" scrolling="no" frameborder="0"></iframe>

</body>
</html>