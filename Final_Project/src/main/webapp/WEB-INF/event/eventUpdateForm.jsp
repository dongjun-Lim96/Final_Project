<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="./../../adminsidebar.jsp" %>
<%@ include file="../common/common.jsp"%>

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
	</style>
	<div class="content" align="center">
<script>
   function List(pageNumber){
      alert(pageNumber);
      location.href="list.ev?pageNumber="+pageNumber;
   }
</script>
<script type="text/javascript" src="<%=conPath%>/resources/js/event.js"></script>


<br>

<div class="login_cont member_cont">
	<div class="login_in">
		
		<h3>이벤트 수정</h3>

	</div>
   <form Name="event" action="updateEvent.ev"  onSubmit="return updateSave()" method="post"
      enctype="multipart/form-data">
      
	<div class="mem_cont">
      <table width="600px" >
      	<div class="myinfo_cont refund_info">
         <dl>
            <dt colspan="2"><a href="list.ev">글목록</a></dt> 
            <dd><input type="hidden"
               name="eventNumber" value="${event.eventNumber }"></dd>
                <dd><input
               type="hidden" name="pageNumber" value="${pageNumber }"></dd>
         </dl>

    		<dl>
				<dt>아이디 <span class="pointColor">*</span></dt>
				<dd>
					<input name="adminId" class="input" type="text" id="adminId" maxlength="20"  value="${loginInfo.userId}" readonly />
				</dd>
			</dl>
			<dl>
				<dt>제목 <span class="pointColor">*</span></dt>
				<dd>
					<input name="eventTitle" class="input" type="text" id="eventTitle" maxlength="20"  value="${event.eventTitle }" />
				
				</dd>
			</dl>
			
         	 <dl>
				<dt>이미지 <span class="pointColor">*</span></dt>
				<dd>
				<img
               src="<%=request.getContextPath()%>/resources/${event.eventImage}"
               width="200" height="200"> <br> <input type="file"
               name="upload" id="upload" value="${event.upload}"> <input
               type="hidden" name="upload2" value="${event.eventImage}">
			</dd>
			</dl>

 
    		 <dl>
				<dt>내용 <span class="pointColor">*</span></dt>
				<dd>
					<input name="eventContent" class="input" type="text" id="eventContent" maxlength="20"  value="${event.eventContent}" />
				
				</dd>
			</dl>

         	<dl>
				<dt>시작일 <span class="pointColor">*</span></dt>
				<dd><input type="date" name="eventStart" size="80" class="input"
              value="${event.eventStart}"></dd>
  			</dl> 
			<dl>
				<dt>종료일 <span class="pointColor">*</span></dt>
				<dd><input type="date" name="eventEnd" size="80" class="input"
              value="${event.eventEnd}"></dd>
  			</dl>
  			</div>
  			</div>
         <div class="btn_list">
		<input type="submit" class="moreBtn pointColor pointBorder" id="btn_submit" value="이벤트 수정" />
		<input type="reset" class="moreBtn pointColor pointBorder"  value="다시 작성" />
		<input type="button" class="moreBtn pointColor pointBorder"  value="목록보기" onClick="List(${pageNumber})" />
	</div>
      </table>
   </form>
   </div>
   </div>
