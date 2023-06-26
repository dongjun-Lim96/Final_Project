<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no,maximum-scale=1.0,minimum-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="format-detection" content="telephone=no" />

<link rel="stylesheet" type="text/css" href="resources/css/register.css" />
<link rel="stylesheet" type="text/css"
   href="/html/css/custom.css?t=20230604" />
<!-- 커스텀 css -->

<link rel="stylesheet" type="text/css"
   href="//cdn.malgnlms.com/theme/6/css/common.css?t=20230604" />
<link rel="stylesheet" type="text/css"
   href="//cdn.malgnlms.com/theme/6/css/font_notoSans.css?t=20230604" />
   <link rel="stylesheet" type="text/css" href="//cdn.malgnlms.com/theme/6/css/green_theme.css?t=20230604" />
<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css" />
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
   
   :root {
    --point-color:#0DCAF0;
}.bgColor {background-color:var(--point-color) !important;}
   
.pointBorder {border:1px solid var(--point-color) !important;}

.pointColor {color:var(--point-color) !important;}

</style>
<title>Insert title here</title>
</head>
<body>
<div class="content" align="center">
<script>
   function gotoList(){
      location.href="getlist.cs";
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
   </style>

 
 
<div class="login_cont member_cont">
   <div class="login_in">
      
      <h3>리뷰 쓰기</h3>

   </div>

   <form:form commandName="noticeBean"  action="write.nt"  method="post" enctype="multipart/form-data">
   
   <div class="mem_cont">
      
 
      <div class="myinfo_cont refund_info">
         
         
         <dl>
            <dt>아이디 <span class="pointColor">*</span></dt>
            <dd>
               <input name="adminId" class="input" type="text" id="adminId" maxlength="20"  value="${loginInfo.userId}" readonly />
            </dd>
         </dl>
         <dl>
            <dt>제목 <span class="pointColor">*</span></dt>
            <dd>
               <input name="noticeTitle" class="input" type="text" id="noticeTitle" maxlength="20" value="${noticeBean.noticeTitle}"/>
                  <span id="noticeTitle_hint"  style="color:#0DCAF0;"></span>
               <div class="comment">
                   <form:errors
                  cssClass="comment" path="noticeTitle" />
               </div>
            </dd>
         </dl>
         <dl>
            <dt>내용 <span class="pointColor">*</span></dt>
            <dd>
               <input name="noticeContent" class="input" type="text" id="noticeContent" maxlength="200" />
               <span id="noticeContent_hint"  style="color:#0DCAF0;"></span>
               <div class="comment">
                  <form:errors
                  cssClass="comment" path="noticeContent" />
               </div>
            </dd>
         </dl>

         
                   <dl>
            <dt>이미지 <span class="pointColor">*</span></dt>
            <dd>
               <input name="upload" class="input" type="file" id="upload" maxlength="20" />
               <div class="comment">
                  
               </div>
            </dd>
         </dl>
         
      </div>
   </div> 

   <div class="btn_list">
      <input type="submit" class="moreBtn pointColor pointBorder" id="btn_submit" value="공지사항 등록" />
      <input type="reset" class="moreBtn pointColor pointBorder"  value="다시 작성" />
      <input type="button" class="moreBtn pointColor pointBorder" onClick="location.href = 'list.nt?pageNumber=${param.pageNumber}'" value="목록보기" />
   </div>

</form:form>

</div>
<script type="text/javascript">
  function checkCapsLock(element, hintElement) {
    element.addEventListener('keyup', function(e){
      if (e.getModifierState){
        if (e.getModifierState('CapsLock')) {
          $(hintElement).html('CAPS LOCK 켜져 있습니다.');
          $(hintElement).css('display', 'block');
        } else {
          $(hintElement).css('display', 'none');
        }
      }
    });
  }
  
  checkCapsLock(document.querySelector('input[name=noticeContent]'), '#noticeContent_hint');
  checkCapsLock(document.querySelector('input[name=noticeTitle]'), '#noticeTitle_hint');
</script>

</body>
</html>