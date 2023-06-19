<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

  <%@ include file="./../../header.jsp"%>

<style>
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

   .search-form select,
   .search-form input[type="text"],
   .search-form input[type="submit"] {
      padding: 5px;
      margin: 5px;
   }

   .table {
      width: 100%;
      border-collapse: collapse;
      margin-bottom: 20px;
   }

   .table th,
   .table td {
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

   .table th,
   .table td {
      padding: 10px;
      border: 1px solid #ccc;
      width: 16.66%; /* 각 열의 너비를 1/6로 설정 (6개의 열이므로) */
      text-align: center; /* 가운데 정렬 (선택적으로 설정) */
      white-space: nowrap; /* 텍스트 줄바꿈 방지 (선택적으로 설정) */
      overflow: hidden; /* 내용이 너무 길 경우 잘리지 않고 숨김 처리 (선택적으로 설정) */
      text-overflow: ellipsis; /* 너비를 넘어가는 내용은 ...으로 표시 (선택적으로 설정) */
   }
:root {
    --point-color:#1bceb8;
}

.bgColor {background-color:var(--point-color) !important;}

   .event-type {
      text-decoration: none;
      font-size: 20px;
      font-weight: bold;
      color: #888888;
      margin-right: 25px;
   }

</style>
<div id="sub_banner" class="bgColor" >
    <h2 class="page_title">
        
        이벤트
        
    </h2>
</div>
<br>
<div class="container">
<a href="list.ev?expired=0&pageNumber=${pageInfo.pageNumber}" class="event-type">전체이벤트</a>
<a href="list.ev?expired=1&pageNumber=${pageInfo.pageNumber}" class="event-type">진행중이벤트</a>
<a href="list.ev?expired=2&pageNumber=${pageInfo.pageNumber}" class="event-type">종료이벤트</a>
<br><br>

<div>
   <form class="search-form" action="list.ev" method="post">
      <select id="eventFilter" class="search-form__select" name="whatColumn">
         <option value="all">전체검색</option>
            <option value="eventTitle">제목</option>
            <option value="adminId">작성자</option>
      </select>

      <input class="search-form__input" type="text" name="keyword">
      <input class="search-form__submit" type="submit" value="검색">

   </form>
</div>
<div>

   <table class="table"> 
      <c:if test="${loginInfo.adminCheck eq 1}">
         <tr>
            <td colspan="7" align="right">
               <a class="table__write-link" href="write.ev?pageNumber=${pageInfo.pageNumber}">글쓰기</a>
            </td>
         </tr>
      </c:if>
      <!--    <tr><td colspan="6" align="right"><a href="write.ev">글쓰기</a></td></tr> -->
      <tr>
         <th>번호</th>
         <th>작성자</th>
         <th>제목</th>
         <th>내용</th>
         <!--    <td>이미지1</td>
         <td>이미지2</td> -->
         <th>작성일</th>
         <th>조회수</th>
         <th>이벤트종료일</th>
      </tr>
      <c:if test="${empty eventLists}">
         <tr>
            <td colspan="7" align="center">조회 결과 없습니다.</td>
         </tr>
      </c:if>
      <c:forEach var="event" items="${eventLists}">
         <tr>
            <td>${event.rank}</td>
            <td>${event.adminId}</td>
            <td>${event.eventTitle}</td>
            <td><a href="detailView.ev?eventNumber=${event.eventNumber}&pageNumber=${pageInfo.pageNumber}">${event.eventContent}</a></td>
            <td><fmt:formatDate value="${event.getEventDate()}" pattern="yyyy-MM-dd"/></td>
            <td>${event.eventView}</td>
            <td>${event.eventEnd}</td>
         </tr>
      </c:forEach>
   <c:forEach var="event" items="${eventLists }">
<div class="card" style="display: inline-block; width: 350px; margin-left: 3%; margin-right: 3%; margin-bottom: 3%; text-align: center;">
  <c:if test="${!empty event.eventImage}">
    <a href="detailView.ev?eventNumber=${event.eventNumber}&pageNumber=${pageInfo.pageNumber}">
      <img src="<%=request.getContextPath()%>/resources/${event.eventImage}" class="card-img-top" alt="..." width="200" height="150">
    </a>
  </c:if>
  <c:if test="${empty event.eventImage}">
    <div style="width: 350px; height: 150px; background-color: lightgray;"></div>
  </c:if>
  <div class="card-body">
    <a href="detailView.ev?eventNumber=${event.eventNumber}&pageNumber=${pageInfo.pageNumber}">
      <h5 class="card-title">${event.eventTitle}</h5>
    </a>
    <p class="card-text">등록일 : <fmt:formatDate value="${event.getEventDate()}" pattern="yyyy-MM-dd"/></p>
    <p class="card-text">조회수 : ${event.eventView}</p>
    <p class="card-text">이벤트 종료일 : ${event.eventEnd}</p>
  </div>
</div>
</div>
</c:forEach>
   </table>
   ${pageInfo.pagingHtml}<br>
   </div>
</div>

<!-- Ajax 호출 -->
<!-- Ajax 호출 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="selectedExpiredType" value="0" />
<c:if test="${not empty param.selectedExpiredType}">
   <c:set var="selectedExpiredType" value="${param.selectedExpiredType}" />
</c:if>

<script>
// 선택한 이벤트 유형에 따라 색상 설정
var eventLinks = document.querySelectorAll(".event-type");
var selectedExpiredType = localStorage.getItem("selectedExpiredType");

// 함수를 정의하여 스타일을 적용하는 로직을 분리합니다.
function applyStyles(expiredType) {
  eventLinks.forEach(function (link) {
    var linkExpiredType = link.getAttribute("href").split("=")[1];
    if (linkExpiredType === expiredType) {
      link.style.color = "#555555";
    } else {
      link.style.color = "#888888";
    }
  });
}

eventLinks.forEach(function (link) {
  link.addEventListener("click", function () {
    var targetExpiredType = link.getAttribute("href").split("=")[1];
    applyStyles(targetExpiredType);
    localStorage.setItem("selectedExpiredType", targetExpiredType);
  });
});

if (selectedExpiredType === null) {
  var defaultLink = document.querySelector('a[href="list.ev?expired=0"]');
  defaultLink.style.color = "#555555";
} else {
  applyStyles(selectedExpiredType);
}
</script>
<!-- 나머지 HTML 코드 -->

  <%@ include file="./../../footer.jsp"%>