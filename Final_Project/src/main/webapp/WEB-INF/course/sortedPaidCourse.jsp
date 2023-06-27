<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../header.jsp" %>
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
	<div id="sub_banner" class="bgColor">
    <h2 class="page_title">
     
        
        수강신청
       
    </h2>
    </div>
    <br><br>
<c:if test="${empty paidCourseLists }">
	없습니다
</c:if>
<c:if test="${not empty paidCourseLists }">
<c:forEach var="paidCourse" items="${paidCourseLists }">
<div class="card" style="display: inline-block; width: 350px; margin-left: 3%; margin-right: 3%; margin-bottom: 3%; text-align: center; border-top-right-radius: 20%;border-top-left-radius: 20%;">
  <a href="coursePaidDetail.cs?courseCode=${paidCourse.courseCode}&userId=${userId}">
  <img src="<%=request.getContextPath() %>/resources/${paidCourse.cousreImg}" class="card-img-top" alt="...">
</a>
  <div class="card-body">
  
    <h5 class="card-title">${paidCourse.cousreName }</h5>
    <p class="card-text">금액 : <fmt:formatNumber value="${paidCourse.cousrePrice}" pattern="#,###" /></p>
    <p class="card-text">강사 : ${paidCourse.cousreTeacher }</p>
    <p class="card-text">강의기간 : ${paidCourse.cousreTerm }일</p>
    
    <c:set var="isCourseEnrolled" value="false" />
      <c:forEach var="courseId" items="${CourseIdLists}">
        <c:if test="${courseId.courseCode eq paidCourse.courseCode}">
          <c:set var="isCourseEnrolled" value="true" />
        </c:if>
      </c:forEach>

      <c:choose>
        <c:when test="${isCourseEnrolled}">
          <!-- 학습하기 버튼 -->
          <a href="accountsLearning.acc?courseCode=${paidCourse.courseCode}&userId=${userId}" class="btn btn-outline-info font-weight-bold">학습하기</a>
        </c:when>
        <c:otherwise>
          <!-- 장바구니 또는 구매하기 버튼 -->
          <a href="cartAdd.ct?courseCode=${paidCourse.courseCode}&userId=${userId}" class="btn btn-outline-info font-weight-bold">장바구니</a>
          <a onClick="paynow('${userId}','${paidCourse.courseCode}')" class="btn btn-outline-info font-weight-bold">구매하기</a>
        </c:otherwise>
      </c:choose>

      <c:set var="isWishlist" value="false" />
      <c:forEach var="wishlist" items="${wishLists}">
        <c:if test="${wishlist.courseCode eq paidCourse.courseCode}">
          <c:set var="isWishlist" value="true" />
        </c:if>
      </c:forEach>

      <c:choose>
        <c:when test="${isWishlist}">
          <!-- 위시리스트에 추가됨 -->
          <a class="btn btn-outline-info font-weight-bold" onclick="toggleHeartColor(this, '${paidCourse.courseCode}')">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart-fill heart-icon text-danger" viewBox="0 0 16 16">
              <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
            </svg>
          </a>
        </c:when>
        <c:otherwise>
          <!-- 위시리스트에 추가되지 않음 -->
          <a class="btn btn-outline-info font-weight-bold" onclick="toggleHeartColor(this, '${paidCourse.courseCode}', '${userId}')">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart-fill heart-icon" viewBox="0 0 16 16">
              <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
            </svg>
          </a>
        </c:otherwise>
      </c:choose>
<%-- 
    	<a href="cartAdd.ct?courseCode=${paidCourse.courseCode}&userId=${userId}" class="btn btn-outline-info font-weight-bold">장바구니</a>
    	<a href="#" class="btn btn-outline-info font-weight-bold">구매하기</a> 
    	 
    	  <c:set var="isWishlist" value="false" />
      <c:forEach var="wishlist" items="${wishLists}">
        <c:if test="${wishlist.courseCode == paidCourse.courseCode}">
          <c:set var="isWishlist" value="true" />
        </c:if>
      </c:forEach>

      <c:choose>
        <c:when test="${isWishlist == 'true'}">
          <a class="btn btn-outline-info font-weight-bold" onclick="toggleHeartColor(this, '${paidCourse.courseCode}')">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart-fill heart-icon text-danger" viewBox="0 0 16 16">
              <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
            </svg>
          </a>
        </c:when>
        <c:otherwise>
          <a class="btn btn-outline-info font-weight-bold" onclick="toggleHeartColor(this, '${paidCourse.courseCode}', '${userId}')">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart-fill heart-icon" viewBox="0 0 16 16">
              <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
            </svg>
          </a>
        </c:otherwise>
      </c:choose>
       --%>
    	<script>
    function toggleHeartColor(button,courseCode, userId) {
    	var courseCode = courseCode;
    	var userId = userId;
    	//alert(1);
    	//alert(courseCode);
    	//alert(userId);
        var heartIcon = button.querySelector("svg.heart-icon");
        if (heartIcon.classList.contains("text-danger")) {
        	
        	heartIcon.classList.remove("text-danger");
        	
        	$.ajax({
        	    url: "WLremove.wl",
        	    data : {
        	    	courseCode : courseCode
        		},
        	    success: function() {
        		      //window.location.href = "paidCourse.cs"; 
        	    }
        	  });
        	
        } else {
        	
        	heartIcon.classList.add("text-danger");
        	
        	$.ajax({
        	    url: "WLadd.wl",
        	    data : {
        	    	courseCode : courseCode,
        			userId : userId
        		},
        	    success: function() {
        		     // window.location.href = "paidCourse.cs"; 
        	    }
        	  });
        	
           /*  heartIcon.classList.remove("text-danger"); */
        }
    }
    
    function paynow(userId, courseCode) {
    	//alert(userId);
    	//alert(courseCode);
    	 if (confirm("결제하시겠습니까? (구매시 장바구니 모두 구매)")) {
    		
    	    location.href = "paynow.ct?userId="+userId+"&courseCode="+courseCode;
    	  } else {
    	    alert("결제가 취소되었습니다.");
    	  }
    }	
</script>
  </div>
</div>
</c:forEach>
</c:if>