<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../header.jsp" %>
<script>
	function deleteCategory(){
		alert(1);
	}
</script>    
categoryList<br>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">#</th>
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
      <td><button type="button" class="btn btn-outline-info" onClick="deleteCategory()">삭제</button></td>
    </tr>
	</c:forEach>
  </tbody>
</table>