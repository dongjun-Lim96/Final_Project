<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>


<title>쌍용에듀</title>



<script type="text/javascript">
	function register() {
		location.href = 'register.acc';
	}

	function listAccounts() {
		location.href = 'list.acc';
	}
	function findUserId() {
		location.href = 'accountSearchForm.acc';
	}
	function findUserPassword() {
		location.href = 'accountPwSearchForm.acc';
	}
</script>

<link rel="stylesheet" type="text/css"
	href="//cdn.malgnlms.com/theme/6/css/common.css?t=20230604" />
<link rel="stylesheet" type="text/css"
	href="//cdn.malgnlms.com/theme/6/css/font_notoSans.css?t=20230604" />
<link rel="stylesheet" type="text/css"
	href="//cdn.malgnlms.com/theme/6/css/green_theme.css?t=20230604" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css" />

<link rel="stylesheet" type="text/css"
	href="/html/css/custom.css?t=20230604" />
<!-- 커스텀 css -->


</head>

<body>
	<%
	String conPath = request.getContextPath();
	%>
	<script type="text/javascript" src="/theme/6/js/ui.js"></script>

	<link rel="stylesheet" type="text/css" href="resources/css/register.css" />

	<div class="login_cont">
		<div class="login_in">
			<a href='list.cs'>
				<h1>
					<img src="<%=conPath%>/resources/images/logo.png" alt="워너에듀 로고"
						class="svg_logo" />
				</h1>
			</a>
			<h3>가입한 계정으로 로그인 하세요.</h3>
			<form name="form1" action="loginForm.acc" method="post">

				<dl class="login_input">
					<dd>
						<input type="text" name="userId" class="input" placeholder="아이디">
					</dd>
					<dd>
						<input type="text" name="userPw" class="input" placeholder="비밀번호">
					</dd>
					<dt>
						<input type="submit" value="로그인" class="bgColor search_btn">
					</dt>
				</dl>
			</form>

			<ul>
				<li>아직 회원이 아니라면? <a href="register.acc">회원가입</a>
				</li>
				<li>아이디/비밀번호가 생각나지 않는다면? <a href='accountSearchForm.acc'>아이디/비밀번호 찾기</a>
				</li>
				
			</ul>


		</div>
	</div>



	<iframe src="" name="sysfrm" id="sysfrm" width="100%" height="0"
		scrolling="no" frameborder="0"></iframe>
</body>
</html>