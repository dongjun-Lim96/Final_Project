<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../adminsidebar.jsp" %>
<script>
var message = "${message}";

if (message !== "") {
    
    alert(message);
} else {
    
}
	function deleteCategory(categoryCode){
		//alert(1);
		//alert(categoryCode);
		location.href="delete.cg?categoryCode="+categoryCode;
		  
	}
	function insertCategory(){
		location.href="category.cg";
	}
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
</style>

 <div class="content" align="center" style="margin-left : 30% ;">     

	<h1 class="category-heading" style="font-weight: bold;">카테고리 목록</h1>

<table class="table table-striped table-sm" style="border-spacing: 5px; margin-right: 0 auto;" >

  <thead>
    <tr>
      <th scope="col" style="width: 200px;"></th>
      <th scope="col" style="width: 200px; font-weight:bold; ">카테고리 코드</th>
      <th scope="col" style="width: 200px; font-weight:bold; ">카테고리 명</th>
      <th scope="col" style="width: 200px;"> </th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="cateList" items="${categoryLists}" varStatus="status">
    <tr> 
      <th scope="row">${status.count }</th>
      <td>${cateList.categoryCode }</td>
      <td>${cateList.categoryName }</td>
      <td><button type="button" class="btn btn-outline-info" onClick="deleteCategory('${cateList.categoryCode }')">삭제</button></td>
    </tr>
	</c:forEach>
		<tr>
		<td colspan="4" align="center">
			<button type="button" class="btn btn-outline-info" onClick="insertCategory()">카테고리 추가하기</button>
		</td>
	</tr>
  </tbody>
</table>
</body>
</html>
</div>
</div>