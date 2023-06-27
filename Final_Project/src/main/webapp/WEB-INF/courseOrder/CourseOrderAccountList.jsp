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
	var message = "${message}";
	
	if (message !== "") {
	    
	    alert(message);
	} else {
	    
	}
	function deleteAccount(userId,pageNumber){
		
		var confirmDelete = confirm("정말 탈퇴 시키겠습니까?");
		if (confirmDelete) {
			location.href = "deleteUserAccount.co?userId=" + userId+"&pageNumber="+pageNumber;
		}
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
		
		.myinfo_cont dt {
			display: inline-block;
			width: 550px;
		}
	</style>

 
 
<div class="login_cont member_cont" style="width: 1500px; margin-left : 15%">
	<input type="hidden" value="${pageInfo.pageNumber}" name="pageNumber">
	<div class="login_in">
		<c:forEach var="accountBuyList" items="${accountBuyList }" varStatus="status">
		</c:forEach>
		<h3>회원 목록 (${totalCount } 명)</h3>

	</div>

	
	
	<div class="mem_cont" align="center">
		
 
		<div class="myinfo_cont refund_info" align="center">
			
			<dl >
				<dt> </dt>
				<dt style="font-weight:bold; ">아이디</dt>						
				<dt style="font-weight:bold; ">이름</dt>						
				<dt style="font-weight:bold; ">비밀번호</dt>						
				<dt style="font-weight:bold; ">이메일</dt>						
				<dt style="font-weight:bold; ">총 구매금액</dt>						
				<dt style="font-weight:bold; ">구매횟수</dt>						
				<dt> </dt>						
				 	
			</dl>
			<c:if test="${not empty accountBuyList }">
			<c:forEach var="accountBuyList" items="${accountBuyList }" varStatus="status">
			<dl> 
				<dt>${status.count }</dt>
				<dt><a href="accountDetail.co?userId=${accountBuyList.userId }&pageNumber=${pageInfo.pageNumber}" onmouseover="this.style.color='red'" onmouseout="this.style.color='black'">${accountBuyList.userId }</a> </dt>
				<dt>${accountBuyList.userName }</dt>
				<dt>${accountBuyList.userPw }</dt>
				<dt>${accountBuyList.userEmail }</dt>
				<dt>
					<c:set var="sum" value="${accountBuyList.sum}" />
					<fmt:formatNumber value="${sum}" pattern="#,###" var="formattedSum" />
						${formattedSum}원
				</dt>
				<dt>${accountBuyList.count }</dt>
				<dt><button type="button" class="btn btn-outline-info" onClick="deleteAccount('${accountBuyList.userId }','${pageInfo.pageNumber}')">탈퇴</button></dt>						
			</dl>
			</c:forEach>
			</c:if>
			<c:if test="${ empty accountBuyList }">
			
			<dl align="center">
				<dt></dt>
				<dt></dt>
				<dt></dt>
				<dt>검색 결과가 없습니다</dt>
				<dt></dt>
				<dt></dt>
				<dt></dt>
			</dl>
			</c:if>
<center>
	<form action="courseAccountList.co" method="get">
		<select name="whatColumn" style="width: 100px;">
			<option value="all">전체 검색
			<option value="userName">성명</option>
			<option value=userId>아이디</option>
			<option value="userEmail">이메일</option>
		</select> <input type="text" name="keyword"> <input type="submit" class="btn btn-outline-info" value="검색">
	</form>
	
<br>
${pageInfo.pagingHtml }
</center>
				

			
		</div>
	</div>





</div>

    <iframe src="" name="sysfrm" id="sysfrm" width="100%" height="0" scrolling="no" frameborder="0"></iframe>

</body>
</html>
</div>
</div>