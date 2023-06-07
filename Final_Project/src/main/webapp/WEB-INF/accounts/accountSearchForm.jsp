<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no,maximum-scale=1.0,minimum-scale=1.0" />

<title>쌍용에듀</title>



<link rel="stylesheet" type="text/css" href="//cdn.malgnlms.com/theme/6/css/common.css?t=20230606" />
<link rel="stylesheet" type="text/css" href="//cdn.malgnlms.com/theme/6/css/font_notoSans.css?t=20230606" />
<link rel="stylesheet" type="text/css" href="//cdn.malgnlms.com/theme/6/css/green_theme.css?t=20230606" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css" />

<link rel="stylesheet" type="text/css" href="/html/css/custom.css?t=20230606" /> <!-- 커스텀 css -->

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.3/TweenMax.min.js"></script>
<script src="https://unpkg.com/page-scroll-to-id@1.6.8/jquery.malihu.PageScroll2id.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.js"></script>

<script type='text/javascript' src='//cdn.malgnlms.com/common/js/common.js?t=20230606'></script>
<script type='text/javascript' src='//cdn.malgnlms.com/common/js/validate.js?t=20230606'></script>

<script type="text/javascript" src="/html/js/slick.min.js"></script>
<script type="text/javascript" src="/html/js/m_slick.js"></script>


</head>
	<%
	String conPath = request.getContextPath();
	%>
<body>
    <script type="text/javascript" src="/theme/6/js/ui.js"></script>

<link rel="stylesheet" type="text/css" href="resources/css/register.css" />

    <div class="login_cont member_cont idpw_cont">
	<div class="login_in">
		<a href="../../ex/main.jsp">
		<h1><img src="<%=conPath%>/resources/images/logo.png" alt="쌍용에듀 로고" class="svg_logo"/></h1>
		</a>
		<h3>아이디와 비밀번호가 생각이 안 나시나요?</h3>
	</div>

	<div class="mem_cont">
		<ul class="tab_cont grayBox">
			<li><a href="javascript:findId();" id="find-1" class="tab_up pointColor pointBorder"  onfocus="keyd()" >아이디 찾기</a></li>
			<li><a href="javascript:findPasswd();" id="find-2"  onfocus="keyd()" >비밀번호 찾기</a></li>
		</ul>

<br></br>
		<div class="id_cont">
			<div class="myinfo_cont refund_info email_cont">
				<form name="form1">
				<input type="hidden" name="mode" value="find_id">
				<h4 class="mem_tit marb20 inline">회원정보 입력 <span class="tx"> 회원가입 시 입력한 이름과 이메일을 입력해 주세요.</span></h4>
				<dl>
					<dt>이름 <span class="pointColor">*</span></dt>
					<dd><input name="userName" class="input" type="text" onfocus="keyd()" ></dd>
				</dl>

				<dl>
					<dt>이메일 <span class="pointColor">*</span></dt>
					<dd>
						<input type="text" name="userEmail"  class="input" onfocus="keyd()" >
	
					</dd>
				</dl>
				<div id="result"></div>
				<div class="btn_list">
					<a href="#" class="moreBtn bgColor" id="findId">아이디 찾기</a>
					<a href="#" class="moreBtn bgColor"onclick="login()">로그인 하기</a>
				</div>
				<div>
				
				</div>
				</form>
			<script>
			function goFindId() {
				var f = document.forms['form1'];
				if(!validate(f)) return;
				f.submit();
				return;
			}
			
			
			</script>
			</div>

		</div>

		<div class="passwd_cont">
			<div class="myinfo_cont refund_info email_cont">
				<form name="form2" >
				<input type="hidden" name="mode" value="email_authno">
				<input type="hidden" name="domain" value="www.wannaedu.com">
				<h4 class="mem_tit marb20 inline">회원정보 입력 <span class="tx"> 회원가입 시 입력한 아이디와 이메일을 입력해 주세요.</span></h4>
				<dl>
					<dt>아이디 <span class="pointColor">*</span></dt>
					<dd><input name="userId" class="input" type="text" onfocus="keyd()"  /></dd>
				</dl>

				<dl>
					<dt>이메일 <span class="pointColor">*</span></dt>
					<dd>
						<input name="userEmail" id="email1" type="text" class="input" onfocus="keyd()" />
						</div>
					
					</dd>
				</dl>
				<div id="result1"></div>
				<div class="btn_list">
					<a href="#" class="moreBtn bgColor" id="findPw">비밀번호 찾기</a>
					<a href="#" class="moreBtn bgColor"onclick="login()">로그인 하기</a>
				</div>
		
				
				</form>
			</div>
		

		</div>
	</div>
</div>
<script>
	$(function(){
		$("#findId").on('click',function(){
			console.log('test')
			
		var userName = $("[name=userName]").val();
        
        if (userName === "") {
            alert("이름을 입력하세요.");
            return;
        }
        
        var userEmail = $("[name=userEmail]").val();
        
        if (userEmail === "") {
            alert("이메일 값도 넣어주세요.");
            return;
        }
        
			sand();
		});
	})
	function findPw(){
		location.href='accountPwSearchForm.acc';
	}
	function register(){
		location.href='register.acc';
	}
	function login() {
	    location.href = 'loginForm.acc';
	}
	
	function main() {
		 location.href='../../ex/main.jsp';
	}
	function sand(){
		var userEmail = $("[name=userEmail]").val();
		var userName = $("[name=userName]").val();
		isCheck = true;
		console.log(userEmail);
		$.ajax({
		    type: 'post',
		    url: "searchAccountsUserId.acc",
		    data: { userEmail: userEmail, userName: userName },
		    success: function (data) {
	            console.log(data.replace('=', ':'));
	            var d = JSON.parse(data.replace('=', ':'));
	            console.log(d);
	            if (d.checkGbn === 'Y') {
	                $("#result").text("회원님의 ID는 : " + d.userId + "입니다.").show();
	             
	            } else {
	            	alert("이메일과 이름 다시 확인하세요.");
	            }
	        },
	        error: function (e) {
	            console.log(e);
	            // 에러가 발생했을 경우 실행할 코드
	        }
	    });
	}
	
	$(function(){
		$("#findPw").on('click',function(){
			console.log('test')
			
		var userId = $("[name=userId]").val();
        
        if (userId === "") {
            alert("ID 입력하세요.");
            return;
        }
        
        var userEmail = $("#email1").val();
        
        if (userEmail === "") {
            alert("이메일 값도 넣어주세요.");
            return;
        }
        
			sand1();
		});
	})
		function sand1(){
		var userEmail =  $("#email1").val();
		var userId = $("[name=userId]").val();
		isCheck = true;
		console.log(userEmail);
		$.ajax({
		    type: 'post',
		    url: "searchAccountsUserPw.acc",
		    data: { userEmail: userEmail, userId: userId },
		    success: function (data) {
	            console.log(data.replace('=', ':'));
	            var d = JSON.parse(data.replace('=', ':'));
	            console.log(d);
	            if (d.checkGbn === 'Y') {
	                $("#result1").text("회원님의 PW는 : " + d.userPw + "입니다.").show();
	             
	            } else {
                    alert("이메일과 이름 다시 확인하세요.");
	            }
	        },
	        error: function (e) {
	            console.log(e);
	            // 에러가 발생했을 경우 실행할 코드
	        }
	    });
	}
</script>
<script>
function keyd(){
	//alert(key);
	$('#result').css('display','none');
	$('#result1').css('display','none');
	use = "";
	isCheck = false;
}

function findId(){
	var idArea = $("#find-1");
	var passwdArea = $("#find-2");
	$(".id_cont").show();
	$(".passwd_cont").hide();

	idArea.prop("class","tab_up pointColor pointBorder");
	passwdArea.prop("class", "");
}

function findPasswd(){
	var idArea = $("#find-1");
	var passwdArea = $("#find-2");
	$(".passwd_cont").show();
	$(".id_cont").hide();

	idArea.prop("class","");
	passwdArea.prop("class", "tab_up pointColor pointBorder");

}
$(document).ready(function() {
	$(".passwd_cont").hide();
	$(".id_cont").show();
});
</script>
    <iframe src="" name="sysfrm" id="sysfrm" width="100%" height="0" scrolling="no" frameborder="0"></iframe>
</body>
</html>