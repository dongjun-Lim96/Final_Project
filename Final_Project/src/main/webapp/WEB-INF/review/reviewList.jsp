<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../accounts/accountsMyPageHeader.jsp"%>    
<style>

</style>
<main>
	<div class="container-fluid px-4">
<h1 class="mt-4">리뷰 관리</h1>
		<ol class="breadcrumb mb-4">
			<!-- <li class="breadcrumb-item active">Dashboard</li> -->
		</ol>
<div class="card mb-4">
			<div class="card-header">
				<i class="fas fa-table me-1"></i> 리뷰 조회
			</div>
			<div class="card-body">
				<table id="datatablesSimple">
					<thead>
						<tr>
							<th>강의코드</th>
							<th>제목</th>
							<th>별점</th>
							<th>수정일</th>
						</tr>
					</thead>

					<tbody>

						<c:forEach var="list" items="${lists}">
							<tr>
								<td>${list.courseCode}</td>
								<td>
									<a href="reviewUpdate.rv?courseCode=${list.courseCode}&userId=${userId}">
										${list.reviewTitle}
									</a>
								</td>
								
								<td>
									<c:set var="filledStars" value="${(list.reviewCount/2)}" />
									<c:set var="halfStar" value="${list.reviewCount % 2 == 1}" />
									
									<c:forEach var="star" begin="1" end="${filledStars}">
									    <span class="star">★</span>
									</c:forEach>
									
									<c:if test="${halfStar}">
									    <span class="star">☆</span>
									</c:if>
								</td>
								
								<td>${list.reviewDate}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>

</div>
</main>	

<%@ include file="./../accounts/accountsMyPageFooter.jsp"%>