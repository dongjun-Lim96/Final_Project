<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../header.jsp" %>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no,maximum-scale=1.0,minimum-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="format-detection" content="telephone=no" />
<link rel="stylesheet" type="text/css" href="resources/css/register.css" />
<style>
    
    #sub_banner {position:relative; height:200px; width:100%; }
    #sub_banner::after {content:''; width:100%; height:100%; background:url('/theme/6/img/main/subtop_pattern.png')no-repeat center; background-size:contain; position:absolute; top:0; left:0;}
    #sub_banner h2 {position:relative; top:50%; transform:translateY(-50%); font-size:2.941rem; color:#fff; text-align:center; letter-spacing:-0.7pt; line-height:1; font-weight:bold; z-index:99;}
    .bgColor {background-color:#0DCAF0;}
    
    
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
		
	.lnb_tab {
	    list-style-type: none;
	    margin: 20px 0;
	    padding: 0;
	    display: flex;
	    justify-content: center;
	    background-color: #f1f1f1;
	    border-radius: 5px;
	}
	
	.lnb_tab li {
	    flex-grow: 1;
	    text-align: center;
	}
	
	.lnb_tab li a {
	    display: block;
	    color: #333;
	    text-align: center;
	    padding: 18px 16px;
	    text-decoration: none;
	    transition: background-color 0.3s ease;
	    font-size: 24px;
	}
	
	.lnb_tab li a:hover {
	    background-color: #ddd;
	}
	
	.lnb_tab li a.active {
	    background-color: #ccc;
	}
    .star {
        color: #0DCAF0;
    }
    td {
        padding: 10px;
    }
    .bordered-table {

        border-top: 1px solid black;
        border-botoom: 1px solid black;
        border-collapse: collapse;       
    }
    
    .rounded-row {
        border-radius: 10px;
        border: 1px solid black;
    }
    

	table tr:hover {
	    background-color: #f5f5f5;
	}
</style>
	<div id="sub_banner" class="bgColor">
    <h2 class="page_title">   
        ${course.cousreName}      
    </h2>
    </div>
<br><br>
<center>
<div style="display: inline-block;" >
	<img src="<%=request.getContextPath() %>/resources/${course.cousreImg}" class="card-img-top" alt="${lists.cousreImg }사진나중에" style="width: 550px; height: 350px; border-radius: 20%;">
</div>
<div class="myinfo_cont refund_info" style="display: inline-block; vertical-align: middle;">			
	<dl>
		<dt style="font-size: 30px; font-weight: bold;">카테고리</dt>
		<dd style="font-size: 40px; font-weight: bold;">${course.categoryCode}</dd>				
	</dl>
	<dl>
		<dt style="font-size: 30px; font-weight: bold;">강사명</dt>
		<dd style="font-size: 40px; font-weight: bold;">
			${course.cousreTeacher}
		</dd>				
	</dl>
	<dl>
		<dt style="font-size: 30px; font-weight: bold;">기간</dt>
		<dd style="font-size: 40px; font-weight: bold;">
			${course.cousreTerm}일
		</dd>				
	</dl>
	
	<dl>
      
        <dt style="text-align: right;">
          <a href="goshow.cs?courseCode=${course.courseCode}" class="btn btn-outline-info font-weight-bold" class="btn btn-outline-info font-weight-bold" style="font-size:25px;">학습하기</a>
       	</dt> 
       	
       	<c:if test="${reviewCount > 0}">
       		<dt>
	          <a href="reviewUpdate.rv?courseCode=${course.courseCode}&userId=${userId}" class="btn btn-outline-info font-weight-bold" style="font-size:25px;">리뷰수정</a>
	        </dt> 
       	</c:if>
       	
        <c:if test="${reviewCount <= 0}">
	        <dt>
	          <a href="review.rv?courseCode=${course.courseCode}&userId=${userId}" class="btn btn-outline-info font-weight-bold" style="font-size:25px;">리뷰쓰기</a>
	        </dt> 
    	</c:if>
    	
	</dl>
	
				
</div>
</center>
<br><br>


<ul class="lnb_tab">
    <li><a href="#gotoUnit">강의목차</a></li>
    <li><a href="#gotoReview">강의후기</a></li>
</ul>




<hr>
<center>
<div id="gotoUnit">
<h2>강의목차</h2>
</div>
<c:if test="${empty unit }">
	목차없습니다
</c:if>
<c:if test="${not empty unit }">
	<table>
    <c:forEach var="unit" items="${unit}">
        <c:if test="${not empty unit.unit1}">
            <tr class="rounded-row">
                <td style="width:300px;">${unit.unit1}</td>
            </tr>
        </c:if>
        <c:if test="${not empty unit.unit2}">
            <tr class="rounded-row">
                <td>${unit.unit2}</td>
            </tr>
        </c:if>
        <c:if test="${not empty unit.unit3}">
            <tr class="rounded-row">
                <td>${unit.unit3}</td>
            </tr>
        </c:if>
        <c:if test="${not empty unit.unit4}">
            <tr class="rounded-row">
                <td>${unit.unit4}</td>
            </tr>
        </c:if>
        <c:if test="${not empty unit.unit5}">
            <tr class="rounded-row">
                <td>${unit.unit5}</td>
            </tr>
        </c:if>
        <c:if test="${not empty unit.unit6}">
            <tr class="rounded-row">
                <td>${unit.unit6}</td>
            </tr>
        </c:if>
        <c:if test="${not empty unit.unit7}">
            <tr class="rounded-row">
                <td>${unit.unit7}</td>
            </tr>
        </c:if>
        <c:if test="${not empty unit.unit8}">
            <tr class="rounded-row">
                <td>${unit.unit8}</td>
            </tr>
        </c:if>
        <c:if test="${not empty unit.unit9}">
            <tr class="rounded-row">
                <td>${unit.unit9}</td>
            </tr>
        </c:if>
        <c:if test="${not empty unit.unit10}">
            <tr class="rounded-row">
                <td>${unit.unit10}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>

</c:if>
</center>

<hr>





<center>
<div id="gotoReview">
	<h2>강의후기</h2>
</div>

<c:if test="${empty review }">
	<span style="font-size: 20px;">수강후기가 없습니다.</span>
</c:if>
<c:if test="${not empty review }">
	<c:forEach var="review" items="${review}">
		<table class="bordered-table" style=" margin-bottom: 20px;">
			<tr>
				<td>${review.userId} 님</td>
				<td>  
					<c:set var="filledStars" value="${(review.reviewCount/2)}" />
					<c:set var="halfStar" value="${review.reviewCount % 2 == 1}" />
					
					<c:forEach var="star" begin="1" end="${filledStars}">
					    <span class="star">★</span>
					</c:forEach>
					
					<c:if test="${halfStar}">
					    <span class="star">☆</span>
					</c:if>
				</td>
				<td>
					<fmt:formatDate value="${review.reviewDate}" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr align="center">
				<td colspan="3" style="font-size: 20px; ">
					${review.reviewTitle}
				</td>
			</tr>
			<tr align="center">
				<td colspan="3" style="font-weight: bold;">
					${review.reviewContent}
				</td>
			</tr>
		</table>
	</c:forEach>
</c:if>
</center>

<%@ include file="./../../footer.jsp"%>