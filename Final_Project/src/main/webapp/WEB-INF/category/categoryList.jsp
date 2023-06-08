<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../header.jsp" %>
<script>
	function deleteCategory(categoryCode){
		//alert(1);
		alert(categoryCode);
		location.href="delete.cg?categoryCode="+categoryCode;
		
	}
	
    var message = "${message}";

    if (message !== "") {
        alert(message);
    }

</script> 
<style>
  .category-heading {
    margin-bottom: 20px;
    margin-top: 20px;
    
  }
</style>

    
<center>
	<h1 class="category-heading" style="font-weight: bold;">카테고리 목록</h1>
</center>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">categoryCode</th>
      <th scope="col">categoryName</th>
      <th scope="col"> </th>
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
  </tbody>
</table>