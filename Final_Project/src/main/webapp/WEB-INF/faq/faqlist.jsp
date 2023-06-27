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
.btn-delete {
  padding: 0.2rem 0.5rem;
  font-size: 0.8rem;
}


</style>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script>
   function insert() {
      location.href = "insert.faq";
   }

   function deleteFaq(faqNumber) {
      location.href = "delete.faq?faqNumber=" + faqNumber;
   }
</script>




<div id="sub_banner" class="bgColor">
   <h2 class="page_title">자주묻는질문</h2>

   <article class="stickyMenu w1230">
      <nav class="lnb">
         <a href="/main/main.jsp" class="lnbHome" title="메인으로이동">
         </a>
      </nav>
   </article>
</div>

<br>

<c:forEach var="faqList" items="${faqLists}" varStatus="status">
   <div class="accordion-body">
      <table class="table table-striped table-sm"
         style="border-spacing: 5px; margin-right: 0 auto;">
         <thead>
            <tr class="faq-item" data-toggle="collapse"
               data-target="#faq-content-${status.index}" aria-expanded="false">
               <th scope="col" style="width: 200px; cursor: pointer;">Q. ${faqList.faqTitle} <span style="font-size: 12px; color: red;">클릭하세요!</span></th>
               
            </tr>
         </thead>
         <tbody>
            <tr class="faq-item" data-toggle="collapse"
               data-target="#faq-content-${status.index}" aria-expanded="false">
               <td class="faq-content collapse" id="faq-content-${status.index}">
                  A. ${faqList.faqContent}</td>
               
            </tr>
            <c:if test="${loginInfo.adminCheck eq 1 }">
                  <td>
                     <button class="btn btn-danger btn-sm btn-delete"
                        onclick="deleteFaq(${faqList.faqNumber})">삭제</button>
                  </td>
               </c:if>
         </tbody>
      </table>
   </div>
</c:forEach>

<script>
   $(document).ready(function() {
      $('.faq-item').click(function() {
         var contentId = $(this).data('target');
         $(contentId).collapse('toggle');
      });
   });
</script>

<%@ include file="./../../footer.jsp"%>