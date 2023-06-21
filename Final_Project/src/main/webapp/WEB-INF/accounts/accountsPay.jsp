<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="accountsMyPageHeader.jsp"%>    

<main>
	<div class="container-fluid px-4">
<h1 class="mt-4">결제 내역 조회</h1>
		<ol class="breadcrumb mb-4">
			<!-- <li class="breadcrumb-item active">Dashboard</li> -->
		</ol>
<div class="card mb-4">
			<div class="card-header">
				<i class="fas fa-table me-1"></i> 결제내역
			</div>
			<div class="card-body">
				<table id="datatablesSimple">
					<thead>
						<tr>
							<th>주문코드</th>
							<th>강의코드</th>
							<th>회원명</th>
							<th>가격</th>
							<th>주문일</th>
						</tr>
					</thead>

					<tbody>

						<c:forEach var="list" items="${lists}">
							<tr>
								<td>${list.orderNumber}</td>
								<td>${list.courseCode}</td>
								<td>${list.userId}</td>
								<td>${list.totalPrice}</td>
								<td>${list.orderDate}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>

</div>
</main>
<%@ include file="accountsMyPageFooter.jsp"%>