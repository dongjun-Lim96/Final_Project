<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<!-- 네이버 스크립트 -->
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
      <div>
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
      <br>      
         <li>카카오로 로그인하기
      <a href="javascript:void(0)" onclick="kakaoLogin();" >
			<img width="200" src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg"/></a>
      </a>
   </li>
      <br>      
         <li>네이버로 로그인하기
      <a href="${url}">
         <img width="200" src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png"/>
      </a> 
   </li> 
   
        </div>
         </ul> 
        
      </div>
<script type="text/javascript">
   function kakaoLogin() {
      $.ajax({
         url: 'getKakaoAuthUrl.acc',
         type: 'get',
         async: false,
         dataType: 'text',
         success: function (res) {
            location.href = res;
         }
      });
   }
</script>

    <!-- 실험 -->
   <iframe src="" name="sysfrm" id="sysfrm" width="100%" height="0"
      scrolling="no" frameborder="0"></iframe> 
</body>
</html>