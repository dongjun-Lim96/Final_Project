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
<h3 class="adm_tit marb30">위시리스트</h3>
  <c:forEach var="wishList" items="${wishList}">
<div class="card" style="display: inline-block; width: 350px; margin-left: 3%; margin-right: 3%; margin-bottom: 3%; text-align: center;">
  <a href="coursePaidDetail.cs?courseCode=${wishList.courseCode}">
  <img src="<%=request.getContextPath() %>/resources/${wishList.cousreImg}" class="card-img-top" alt="...">
</a>
  <div class="card-body">
  
    <h5 class="card-title">${wishList.cousreName }</h5>
    <p class="card-text">금액 : <fmt:formatNumber value="${wishList.cousrePrice}" pattern="#,###" /></p>
    <p class="card-text">강사 : ${wishList.cousreTeacher }</p>
    <p class="card-text">강의기간 : ${wishList.cousreTerm }일</p>

    	<a href="#" class="btn btn-outline-info font-weight-bold">장바구니</a>
    	<a href="#" class="btn btn-outline-info font-weight-bold">구매하기</a> 
    	 
    	  
  </div>
</div>
</c:forEach>
 </div> 

<%@ include file="accountsMyPageFooter.jsp"%>