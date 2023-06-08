
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<%@ include file="./../../header.jsp" %>
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

<script type="text/javascript" src="<%=conPath%>/resources/js/course.js"></script>
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
	</style>

 
 
<div class="login_cont member_cont">
	<div class="login_in">
		
		<h3>강의 추가</h3>

	</div>

	<form name="form1" method="POST" action="register.acc" onSubmit="return writeSave()">
	
	<div class="mem_cont">
		

		<div class="myinfo_cont refund_info">
			 
			<dl>
				<dt>카테고리명 <span class="pointColor">*</span></dt>
				<dd>
					<input name=categoryCode class="input input_m2" id="categoryCode" maxlength="20" type="text"  onkeydown="keyd()" />&nbsp
					<input type="button" class="moreBtn pointColor pointBorder" value="중복체크" onClick="categoryCheck()" > 
					<div class="comment" id="checkLoginIdArea">
						<span id="idmessage">영문으로 시작하는 2-20자 영문, 숫자 조합을 입력하세요.</span>
					</div>
				</dd>
				
			</dl>
			
			
			<dl>
				<dt>비밀번호 <span class="pointColor">*</span></dt>
				<dd>
					<input name="userPw" class="input" id="userPw" maxlength="50" type="password" placeholder="영문, 숫자, 특수문자 8자 이상" onblur="return pwcheck()" />
					<div class="comment" id="checkPasswordArea">
						<span id="pwmessage">영문, 숫자, 특수문자 조합 8자 이상 입력하세요.</span>
					</div>
				</dd>
				
			</dl>

			<dl>
				<dt>비밀번호 재입력 <span class="pointColor">*</span></dt>
				<dd>
					<input name="userPw2" class="input" id="userPw2" maxlength="50" type="password" placeholder="영문, 숫자, 특수문자 8자 이상" onkeyup="pw2check()" />
					<div class="comment" id="checkPasswordArea">
						<span id="pwmessage2">영문, 숫자, 특수문자 조합 8자 이상 입력하세요.</span>
					</div>
				</dd>
			</dl>
			

			
			<dl>
				<dt>이름 <span class="pointColor">*</span></dt>
				<dd>
					<input name="userName" class="input" type="text" id="userName" maxlength="20" />
					<div class="comment">
						
					</div>
				</dd>
			</dl>
			
			<dl>
				<dt>생년월일<span class="pointColor">*</span></dt>
				<dd>
					<input name="userBirth" class="input input_num" type="date" id="userBirth" maxlength="20" />
					<div class="comment">
						
					</div>
				</dd>
			</dl>
			
			
			<dl>
				<dt>
					이메일
					
					<span class="pointColor">*</span>
					
				</dt>
				<dd>
					<input name="userEmail" id="userEmail" type="text" class="input" onkeyup="emailcheck()">
					<div class="comment" id="checkPasswordArea">
						<span id="emailmsg"></span>
					</div>

					<div class="check_box">
						<label><input name="userChkEmail" value="1" type="radio" class="radio" >수신동의</label>
						<label><input name="userChkEmail" value="0" type="radio" class="radio" checked="checked">수신거부</label>
					</div>
				</dd>
			</dl>
			
			
			<dl>
				<dt>
					휴대전화
					
					<span class="pointColor">*</span>
					
				</dt>
				<dd>
					<div class="selectBox input_num">
						<select name="mobile1" id="mobile1">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
						</select>
					</div>
					<span class="hipen">-</span>
					<input name="mobile2" class="input input_num" type="text" id="mobile2" maxlength="4" onkeyup="telcheck1()">
					<span class="hipen">-</span>
					<input name="mobile3" class="input input_num" type="text" id="mobile3" maxlength="4" onchange='' onkeyup="telcheck2()">
					<div class="check_box">
						<label><input name="userChkPhone" value="1" type="radio" class="radio" />수신동의</label>
						<label><input name="userChkPhone" value="0" type="radio" class="radio" checked="checked"/>수신거부</label>
					</div>
				</dd>
			</dl>

			
		</div>
	</div>

	<div class="btn_list">
		<input type="button" class="moreBtn pointColor pointBorder" onclick="location.href= '/member/agreement.jsp'" value="이전으로" />
		<input type="submit" class="moreBtn bgColor pointBorder" id="btn_submit" value="회원가입하기" />
	</div>

</form>

</div>

    <iframe src="" name="sysfrm" id="sysfrm" width="100%" height="0" scrolling="no" frameborder="0"></iframe>

</body>
</html>