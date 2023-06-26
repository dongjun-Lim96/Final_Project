<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../accounts/accountsMyPageHeader.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">
    
  .rating {
      display: inline-block;
      font-size: 0;
    }
    .rating input {
      display: none;
    }
    .rating label {
      float: right;
      cursor: pointer;
      color: gray;
    }
    .rating label:before {
      content: '\2606';
      font-size: 24px;
    }
    .rating input:checked ~ label:before,
    .rating input:checked ~ label ~ label:before {
      content: '\2605';
      color: gold;
    }
</style>

<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="https://www.wannaedu.com//theme/6/css/mypage/lecture.css" />
<link rel="stylesheet" type="text/css" href="https://www.wannaedu.com//theme/6/css/mypage/percentage.css" />
</head>
<body>
<script type="text/javascript" src="<%=conPath%>/resources/js/review.js"></script>	  
<div class="whiteBox lec_cont">

    <h4 class="adm_tit">후기 수정</h4>
    <form name="form1" id="myForm" method="post" action="reviewUpdate.rv" onsubmit="return review()">
    <div class="form_table">
        <input type="hidden" name="courseCode" value="${courseCode}">
        <input type="hidden" name="userId" value="${userId}">
        <dl>
            <dt>별점<span class="pointColor">*</span></dt>
            <dd>
            
			 <div class="rating">
			    <input type="radio" id="star10" name="reviewCount" value="10" style="display: none;">
			    <label for="star10"></label>
			    <input type="radio" id="star9" name="reviewCount" value="9" style="display: none;">
			    <label for="star9"></label>
			    <input type="radio" id="star8" name="reviewCount" value="8" style="display: none;">
			    <label for="star8"></label>
			    <input type="radio" id="star7" name="reviewCount" value="7" style="display: none;">
			    <label for="star7"></label>
			    <input type="radio" id="star6" name="reviewCount" value="6" style="display: none;">
			    <label for="star6"></label>
			    <input type="radio" id="star5" name="reviewCount" value="5" style="display: none;">
			    <label for="star5"></label>
			    <input type="radio" id="star4" name="reviewCount" value="4" style="display: none;">
			    <label for="star4"></label>
			    <input type="radio" id="star3" name="reviewCount" value="3" style="display: none;">
			    <label for="star3"></label>
			    <input type="radio" id="star2" name="reviewCount" value="2" style="display: none;">
			    <label for="star2"></label>
			    <input type="radio" id="star1" name="reviewCount" value="1" style="display: none;">
			    <label for="star1"></label>
			  </div>
			 
            </dd> 
            
        </dl>
        
        <dl>
            <dt>제목<span class="pointColor">*</span></dt>
            <dd>
                
                <input type="text" name="reviewTitle" class="input" value="${review.reviewTitle}" placeholder="제목 (20자 이내로 입력하세요)" />
                
            </dd>
        </dl>
        <dl>
            <dt>내용<span class="pointColor">*</span></dt>
            <dd>
                <textarea class="tinymce" name="reviewContent" class="sg_ta">${review.reviewContent}</textarea>
            </dd>
        </dl>
    </div>

    <div class="bbs_btn">
        <ul>
        	<li class="sel_btn"><a href="accountsLearning.acc?courseCode=${courseCode}&userId=${userId}" class="btn_w">돌아가기</a></li>
            <li class="list_btn">
                
                <a href="#" onclick="goSubmit()" class="btn_b">등록</a>
                
                
                <a onClick="deleteReview('${userId}','${courseCode}')" class="btn_w">삭제</a>
            </li>
        </ul>
    </div>
    </form>
    
<script>

function goSubmit() {
	if(review()){
  		document.getElementById("myForm").submit();
	}
}

function deleteReview(userId, courseCode) {
	 if (confirm("삭제 하시겠습니까? ")) {
		
	    location.href = "reviewDelete.rv?userId="+userId+"&courseCode="+courseCode;
	  } else {
	    alert("삭제 취소");
	  }
}	
</script>

</div>
</body>
</html>
<%@ include file="./../accounts/accountsMyPageFooter.jsp"%>