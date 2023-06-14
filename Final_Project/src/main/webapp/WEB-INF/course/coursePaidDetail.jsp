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
        ${course.cousreName}      
    </h2>
    </div>

coursePaidDetailcoursePaidDetail
${course.courseCode}
${course.categoryCode}
${course.cousreName}
${course.cousrePrice}
${course.cousreTeacher} 
${course.courseCode}
<hr>
<c:forEach var="review" items="${review}">
${review.courseCode}
${review.userId}
${review.reviewTitle}
${review.reviewContent}
${review.reviewDate}
${review.reviewCount}
</c:forEach>