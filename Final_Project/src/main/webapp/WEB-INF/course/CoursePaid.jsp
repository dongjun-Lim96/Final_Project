<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../header.jsp" %>
<style>
    
    #sub_banner {position:relative; height:200px; width:100%; }
    #sub_banner::after {content:''; width:100%; height:100%; background:url('/theme/6/img/main/subtop_pattern.png')no-repeat center; background-size:contain; position:absolute; top:0; left:0;}
    #sub_banner h2 {position:relative; top:50%; transform:translateY(-50%); font-size:2.941rem; color:#fff; text-align:center; letter-spacing:-0.7pt; line-height:1; font-weight:bold; z-index:99;}
    .bgColor {background-color:#0DCAF0;}
   



     
</style>
	<div id="sub_banner" class="bgColor">
    <h2 class="page_title">
     
        
        수강신청
       
    </h2>
    </div>
    <br><br>
<c:forEach var="paidCourse" items="${paidCourseLists }">
<div class="card" style="display: inline-block; width: 350px; margin-left: 3%; margin-right: 3%; margin-bottom: 3%; text-align: center;">
  <img src="<%=request.getContextPath() %>/resources/${paidCourse.cousreImg}" class="card-img-top" alt="..." style="border-radius: 20%; width: 350px; height: 240px;">
  <div class="card-body">
  
    <h5 class="card-title">${paidCourse.cousreName }</h5>
    <p class="card-text">금액 : <fmt:formatNumber value="${paidCourse.cousrePrice}" pattern="#,###" /></p>
    <p class="card-text">강사 : ${paidCourse.cousreTeacher }</p>
    <p class="card-text">강의기간 : ${paidCourse.cousreTerm }일</p>

    	<a href="#" class="btn btn-outline-info font-weight-bold">장바구니</a>
    	<a href="#" class="btn btn-outline-info font-weight-bold">구매하기</a> 
    
  </div>
</div>
</c:forEach>