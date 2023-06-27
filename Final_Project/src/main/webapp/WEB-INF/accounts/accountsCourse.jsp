<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="accountsMyPageHeader.jsp"%>

<style>
    
    #sub_banner {position:relative; height:200px; width:100%; }
    #sub_banner::after {content:''; width:100%; height:100%; background:url('/theme/6/img/main/subtop_pattern.png')no-repeat center; background-size:contain; position:absolute; top:0; left:0;}
    #sub_banner h2 {position:relative; top:50%; transform:translateY(-50%); font-size:2.941rem; color:#fff; text-align:center; letter-spacing:-0.7pt; line-height:1; font-weight:bold; z-index:99;}
    .bgColor {background-color:#0DCAF0;}
   
    .card-img-top {
		border-radius: 20%;
		width: 350px;
		height: 240px;
		transition: filter 0.3s;
	 }

  .card-img-top:hover {
    filter: brightness(70%);
  }
</style> 
<div class="whiteBox">  
<h3 class="adm_tit marb30">수강중인 과정</h3>
  <c:forEach var="courseList" items="${courseList}">
<div class="card" style="display: inline-block; width: 350px; margin-left: 3%; margin-right: 3%; margin-bottom: 3%; text-align: center; border-top-right-radius: 20%;border-top-left-radius: 20%;">
  <a href="accountsLearning.acc?courseCode=${courseList.courseCode}&userId=${userId}">
  <img src="<%=request.getContextPath() %>/resources/${courseList.cousreImg}" class="card-img-top" alt="...">
</a>
  <div class="card-body">
  
    <h5 class="card-title">${courseList.cousreName }</h5>
    <p class="card-text">코스 코드 : ${courseList.courseCode }</p>

    	<a href="accountsLearning.acc?courseCode=${courseList.courseCode}&userId=${userId}" class="btn btn-outline-info font-weight-bold">학습하기</a> 
    	 
    	  
  </div>
</div>
</c:forEach>
 </div> 

<%@ include file="accountsMyPageFooter.jsp"%>