<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<%@ include file="./../../header.jsp" %>

<script type="text/javascript">
   function gotolist(){
      location.href = "list.cos";

   }
</script>

<style>
   
   * { /* 기본적인 마진,패딩 없앰*/
      margin:0;
      padding:0; 
      text-decoration : none; /* 밑줄 없애기 */
      list-style : none; /* 불릿 없애기 */
   }
      
   body { 
      width:100%;
      margin-top:30px;
   }
   
   #button1{ /* 강의목록 버튼 색상 설정 */
       border : 1px solid #35BCAE;
         background-color:#35BCAE;
    }
         
    #button2{ /* 뒤로가기 버튼 색상 설정 */
       border : 1px solid gray;
         background-color: gray;
    }
    
    .text-muted{
       font-size: 20px;
    }
    #contentdiv{
       background-color: #F6F6F6;
      height: 800px; /* 원하는 높이로 조정 */
      width: 1200px; /* 원하는 너비로 조정 */
      margin: 0 auto; /* 가운데 정렬을 위해 추가 */
      padding: 20px; /* 내용과의 여백을 위해 추가 */
      box-sizing: border-box; /* padding을 포함한 크기 계산을 위해 추가 */
    }
    h1 {
      font:20px "맑은 고딕",돋움,arial; 
      color:#fff;
      background-color:#0DCAF0;
      border-radius:20px;
      padding:10px 30px;
      margin-bottom:20px;
      height:50px
   }
   
   #covideo {
      width: 100%;
      height: auto;
   }
</style>

<br>
<center>

<br>
<div id="contentdiv">
   <div> 
      <h1>${list.cousreName }</h1>
   </div>
   
   <br><br>
   
   <div id="covideo"> <!-- 강의영상출력 -->
            
      <video
            src="<%=request.getContextPath() %>/resources/${list.cousreVideo}"  
            poster="<%=request.getContextPath()%>/resources/images/logo.png"
            width="1000" height="500"
            controls>
      </video>
   </div>
   
   <br>
   
   <div>
      <!-- <input type="button" value="뒤로가기" onClick="history.back();"> -->
      <!-- <input type="button" value="강의목록" onClick="gotolist()"> -->
      <a onclick="history.back();"><button id="button2" type="button" class="btn btn-secondary btn-sm">뒤로가기 &nbsp;<img src="<%=request.getContextPath() %>/resources/images/icon/back.png" width="20" height="20"/></button></a>
      <a onclick="gotolist()"><button id="button1" type="button" class="btn btn-secondary btn-sm">강의목록 &nbsp;<img src="<%=request.getContextPath() %>/resources/images/icon/list.png" width="20" height="20"/></button></a>
   </div>
</div>
</center>
<br>

<%@ include file="./../../footer.jsp" %>