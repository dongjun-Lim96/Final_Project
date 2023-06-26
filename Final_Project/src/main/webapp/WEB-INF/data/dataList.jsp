<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>

<%@ include file="./../../header.jsp"%>

<style>
#sub_banner {
   position: relative;
   height: 200px;
   width: 100%;
}

#sub_banner::after {
   content: '';
   width: 100%;
   height: 100%;
   background: url('/theme/6/img/main/subtop_pattern.png') no-repeat center;
   background-size: contain;
   position: absolute;
   top: 0;
   left: 0;
}

#sub_banner h2 {
   position: relative;
   top: 50%;
   transform: translateY(-50%);
   font-size: 2.941rem;
   color: #fff;
   text-align: center;
   letter-spacing: -0.7pt;
   line-height: 1;
   font-weight: bold;
   z-index: 99;
}

.bgColor {
   background-color: #0DCAF0;
}

:root { -
   -point-color: #0DCAF0;
}

.bgColor {
   background-color: var(- -point-color) !important;
}

.pointBorder {
   border: 1px solid var(- -point-color) !important;
}

.pointColor {
   color: var(- -point-color) !important;
}

.body {
   font-family: Arial, sans-serif;
   margin: 0;
   padding: 20px;
}

.container {
   text-align: center;
   margin-bottom: 20px;
}

.heading {
   text-align: center;
   margin-bottom: 20px;
}

.search-form {
   text-align: center;
   margin-bottom: 20px;
}

.search-form select, .search-form input[type="text"], .search-form input[type="submit"]
   {
   padding: 5px;
   margin: 5px;
}

.table {
   width: 100%;
   border-collapse: collapse;
   margin-bottom: 20px;
}

.table th, .table td {
   padding: 10px;
   border: 1px solid #ccc;
}

.table th {
   background-color: #f5f5f5;
}

.table tr:nth-child(even) {
   background-color: #f9f9f9;
}

.no-result {
   text-align: center;
   margin-bottom: 20px;
}

.paging {
   text-align: center;
   margin-bottom: 20px;
}

.table {
   width: 100%;
   border-collapse: collapse;
   margin-bottom: 20px;
   table-layout: fixed; /* 테이블 레이아웃을 고정으로 설정 */
}

.table th, .table td {
   padding: 10px;
   border: 1px solid #ccc;
   width: 16.66%; /* 각 열의 너비를 1/6로 설정 (6개의 열이므로) */
   text-align: center; /* 가운데 정렬 (선택적으로 설정) */
   white-space: nowrap; /* 텍스트 줄바꿈 방지 (선택적으로 설정) */
   overflow: hidden; /* 내용이 너무 길 경우 잘리지 않고 숨김 처리 (선택적으로 설정) */
   text-overflow: ellipsis; /* 너비를 넘어가는 내용은 ...으로 표시 (선택적으로 설정) */
}
</style>
<div id="sub_banner" class="bgColor">
   <h2 class="page_title">무료 자료</h2>
</div>
<br>
<div class="container">
   <form class="search-form" action="list.dt" method="post">
      <select class="search-form__select" name="whatColumn">
         <option value="all">전체검색</option>
         <option value="dataTitle">제목</option>
         <option value="adminId">작성자</option>
      </select> <input class="search-form__input" type="text" name="keyword">
      <input class="search-form__submit" type="submit" value="검색">
   </form>
   <table class="table">
      <c:if test="${loginInfo.adminCheck eq 1}">
         <tr>
            <td colspan="6" align="right"><a class="table__write-link"
               href="write.dt?pageNumber=${pageInfo.pageNumber}">글쓰기</a></td>
         </tr>
      </c:if>
      <!--    <tr><td colspan="6" align="right"><a href="write.nt">글쓰기</a></td></tr> -->
      <tr>
         <th>번호</th>
         <th>작성자</th>
         <th>제목</th>
         <th>내용</th>
         <!--    <td>이미지1</td>
         <td>이미지2</td> -->
         <th>작성일</th>
         <th>조회수</th>
      </tr>
      <c:if test="${empty dataLists}">
         <tr>
            <td colspan="6" align="center">조회 결과 없습니다.</td>
         </tr>
      </c:if>
      <c:forEach var="data" items="${dataLists}">
         <tr>
            <td>${data.rank}</td>
            <td>${data.adminId}</td>
            <td>${data.dataTitle}</td>
            <td><a
               href="detailView.dt?dataNumber=${data.dataNumber}&pageNumber=${pageInfo.pageNumber}">${data.dataContent}</a></td>
            <td>${data.getDataDate()}</td>
            <td>${data.dataView}</td>
         </tr>
      </c:forEach>
   </table>
   ${pageInfo.pagingHtml}<br>

</div>
<%@ include file="./../../footer.jsp"%>