<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../adminsidebar.jsp" %>
<script>
var message = "${message}";

if (message !== "") {
    
    alert(message);
} else {
    
}
	function deleteAccount(userId){
		//alert(1);
		//alert(categoryCode);
		location.href="?userId="+userId;
		  
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

	<h1 class="category-heading" style="font-weight: bold;">회원 목록</h1>

<table class="table table-striped table-sm" style="border-spacing: 5px; margin-right: 0 auto;" >

	<thead>
	<tr>
		<th scope="col" style="width: 200px;"></th>
		<th scope="col" style="width: 200px;">아이디</th>
		<th scope="col" style="width: 200px;">이름</th>
		<th scope="col" style="width: 200px;">비밀번호</th>
		<th scope="col" style="width: 200px;">이메일</th>
		<th scope="col" style="width: 250px;">구매횟수</th>
		<th scope="col" style="width: 200px;"></th>
    </tr>
	</thead>
	<tbody>
	<c:forEach var="accountBuyList" items="${accountBuyList }" varStatus="status">
	    <tr> 
			<th scope="row">${status.count }</th>

			<td>${accountBuyList.userId }</td>
			<td>${accountBuyList.userName }</td>
			<td>${accountBuyList.userPw }</td>
			<td>${accountBuyList.userEmail }</td>
			<td>${accountBuyList.count }</td>
			<td><button type="button" class="btn btn-outline-info" onClick="deleteAccount('${accountBuyList.userId }')">삭제</button></td>
    	</tr>
	</c:forEach>	
	</tbody>	
</table>
<center>
	<form action="#" method="get">
		<select name="whatColumn" style="width: 100px;">
			<option value="all">전체 검색
			<option value="name">강의명</option>
			<option value="price">가격</option>
			<option value="date">기간</option>
		</select> <input type="text" name="keyword"> <input type="submit" class="btn btn-outline-info" value="검색">
	</form>
</center>
</body>
</html>
</div>
</div>