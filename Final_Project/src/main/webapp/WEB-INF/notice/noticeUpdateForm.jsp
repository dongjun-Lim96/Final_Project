<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<%@ include file="./../../adminsidebar.jsp" %>
   <link rel="stylesheet" type="text/css" href="resources/css/register.css" />
   <link rel="stylesheet" type="text/css" href="/html/css/custom.css?t=20230604" /> <!-- 커스텀 css -->

<link rel="stylesheet" type="text/css" href="//cdn.malgnlms.com/theme/6/css/common.css?t=20230604" />
<link rel="stylesheet" type="text/css" href="//cdn.malgnlms.com/theme/6/css/font_notoSans.css?t=20230604" />
<link rel="stylesheet" type="text/css" href="//cdn.malgnlms.com/theme/6/css/green_theme.css?t=20230604" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css" />
<style type="text/css">

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
   <div class="content" align="center">
<script>
   function List(pageNumber){
      alert(pageNumber);
      location.href="list.nt?pageNumber="+pageNumber;
   }
</script>
<div class="login_cont member_cont">
   <div class="login_in">
      
      <h3>공지사항 수정</h3>

   </div>
   <form:form commandName="notice" action="updateNotice.nt" method="post"
      enctype="multipart/form-data">
      <div class="mem_cont">
      <table width="600px" >
               <div class="myinfo_cont refund_info">
   <dl>
            <dt colspan="2"><a href="list.nt">글목록</a> <input type="hidden"
               name="noticeNumber" value="${notice.noticeNumber }"> <input
               type="hidden" name="pageNumber" value="${pageNumber }"></dd>
               </dl>

                <dl>
            <dt>아이디 <span class="pointColor">*</span></dt>
            <dd><input type="text"  class="input" name="adminId" maxlength="20"
               value="${notice.adminId}" readonly>
               </dd>
         </dl>
         <dl>
            <dt>제목 <span class="pointColor">*</span></dt>
            <dd><input type="text"  class="input" name="noticeTitle"maxlength="20"
               value="${notice.noticeTitle}"> 
               <span id="noticeTitle_hint"  style="color:#0DCAF0;"></span>
               <form:errors cssClass="err" path="noticeTitle" />         
               </dd>
         </dl>
              <dl>
            <dt>이미지 <span class="pointColor">*</span></dt>
            <dd><img
               src="<%=request.getContextPath()%>/resources/${notice.noticeImage}"
               width="200" height="200"> <br> <input type="file"
               name="upload" id="upload" value="${notice.upload}"> <input
               type="hidden" name="upload2" value="${notice.noticeImage}">
</dd>
         </dl>


             <dl>
            <dt>내용 <span class="pointColor">*</span></dt>
            <dd>
            <input name="noticeContent"  class="input" type="text" maxlength="20" value="${notice.noticeContent}"/>
               <span id="noticeContent_hint"  style="color:#0DCAF0;"></span>
               <form:errors cssClass="err" path="noticeContent" />
               </dd>
         </div>
</div>


          <div class="btn_list">
         <input type="submit" class="moreBtn pointColor pointBorder" value="수정하기"/> 
         <input type="reset" class="moreBtn pointColor pointBorder"  value="다시 작성" />
         <input type="button" class="moreBtn pointColor pointBorder" value="목록보기" onClick="List(${pageNumber})"/>
      
            </div>
      </table>
   </form:form>
   </div>
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