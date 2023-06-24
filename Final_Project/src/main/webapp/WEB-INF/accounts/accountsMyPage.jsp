<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="accountsMyPageHeader.jsp"%>

<main>
	<div class="container-fluid px-4">
		<h1 class="mt-4">MyPage</h1>
		<ol class="breadcrumb mb-4">
			<li class="breadcrumb-item active">내 정보</li>
		</ol>
		<div class="row">
			<div class="col-xl-3 col-md-6">
				<div class="card bg-primary text-white mb-4">
					<div class="card-body">수강중인 과정</div>
					<div
						class="card-footer d-flex align-items-center justify-content-between">
						<a class="small text-white stretched-link" href="#">View
							Details</a>
						<div class="small text-white">
							<i class="fas fa-angle-right"></i>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xl-3 col-md-6">
				<div class="card bg-warning text-white mb-4">
					<div class="card-body">종료예정 과정</div>
					<div
						class="card-footer d-flex align-items-center justify-content-between">
						<a class="small text-white stretched-link" href="#">View
							Details</a>
						<div class="small text-white">
							<i class="fas fa-angle-right"></i>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xl-3 col-md-6">
				<div class="card bg-success text-white mb-4">
					<div class="card-body">수료 완료</div>
					<div
						class="card-footer d-flex align-items-center justify-content-between">
						<a class="small text-white stretched-link" href="#">View
							Details</a>
						<div class="small text-white">
							<i class="fas fa-angle-right"></i>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xl-3 col-md-6">
				<div class="card bg-danger text-white mb-4">
					<div class="card-body">입금 대기</div>
					<div
						class="card-footer d-flex align-items-center justify-content-between">
						<a class="small text-white stretched-link" href="#">View
							Details</a>
						<div class="small text-white">
							<i class="fas fa-angle-right"></i>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%-- 
		<div class="row">
			<div class="col-xl-6">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-area me-1"></i> 공지사항
					</div>
					<div class="card-body">
						
						<canvas id="myAreaChart" width="100%" height="40"></canvas> 그래프
					</div>
				</div>
			</div>
			<div class="col-xl-6">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-bar me-1"></i> Q&A
					</div>
					<div class="card-body">
						<canvas id="myBarChart" width="100%" height="40"></canvas> 그래프
					</div>
				</div>
			</div>
		</div>
		 --%>
		<div class="card mb-4">
			<div class="card-header">
				<i class="fas fa-table me-1"></i> 수강중인 과정
			</div>
			<div class="card-body">
				<table id="datatablesSimple">
					<thead>
						<tr>
							<th>강의코드</th>
							<th>카테고리코드</th>
							<th>강의명</th>
							<th>강사</th>
							<th>강의기간</th>
							<th>가격</th>
						</tr>
					</thead>

					<tbody>

						<c:forEach var="list" items="${lists}">
							<tr>
								<td>${list.courseCode}</td>
								<td>${list.categoryCode}</td>
								<%-- <td><a href="goshow.cs?courseCode=${list.courseCode}">${list.cousreName}</a></td> --%>
								<td><a href="accountsLearning.acc?courseCode=${list.courseCode}&userId=${userId}">${list.cousreName}</a></td>
								<td>${list.cousreTeacher}</td>
								<td>${list.cousreTerm}</td>
								<td>${list.cousrePrice}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>
</main>

<%@ include file="accountsMyPageFooter.jsp"%>