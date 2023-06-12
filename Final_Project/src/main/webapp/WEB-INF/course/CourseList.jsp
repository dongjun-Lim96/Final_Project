<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../adminsidebar.jsp" %>
<script>
 
</script> 
<style>
  .category-heading {
    margin-bottom: 20px;
    margin-top: 20px;
    
  }
   table.table-striped th,
  table.table-striped td {
    padding: 5px;
  }
    .btn {
    display: inline; /* 또는 display: inline; */
    /* 기타 스타일 설정 */
  }
</style>

 <div class="content" align="center" style="margin-left : 15%;">     

	<h1 class="category-heading" style="font-weight: bold;">강의 목록</h1>

<table class="table table-striped table-sm" style="border-spacing: 5px; margin-right: 0 auto; width: 100%;" >

  <thead>
    <tr>

      
      <th scope="col" style="width: 100px;">강의명</th>
      <th scope="col" style="width: 100px;">가격</th>
      <th scope="col" style="width: 100px;">기간</th>
      <th scope="col" style="width: 100px;">썸네일</th>
      <th scope="col" style="width: 100px;"></th>

    </tr>
  </thead>
  <tbody>
  <c:forEach var="course" items="${courseLists}" varStatus="status">
    <tr> 
      <td><a href="courseDetail.cs?courseCode=${course.courseCode}&pageNumber=${pageInfo.pageNumber}">${course.cousreName }</a></td>
      <td>${course.cousrePrice }</td>
      <td>${course.cousreTerm }</td>
      <td><img src="<%=request.getContextPath() %>/resources/${course.cousreImg}" class="card-img-top" alt="${lists.cousreImg }사진나중에" style="width: 50px; height: 50px; border-radius: 20%;"></td>
     
     
	<td>
		<button type="button" class="btn btn-outline-info" onClick="deleteCategory('${course.cousreTerm }')" style="display: inline;">삭제</button>
	</td>
    </tr>
	</c:forEach>
		<tr>
		<td colspan="5" align="center">
			<button type="button" class="btn btn-outline-info" onClick="insertCategory()">강의 추가하기</button>
		</td>
	</tr>
  </tbody>
</table>
	<form action="getlist.cs" method="get">
		<select name="whatColumn">
			<option value="all">전체 검색
			<option value="name">강의명</option>
			<option value="price">가격</option>
			<option value="date">기간</option>
		</select> <input type="text" name="keyword"> <input type="submit" class="btn btn-outline-info" value="검색">
	</form>
	<br>
	${pageInfo.pagingHtml }
</body>
</html>
</div>
</div>