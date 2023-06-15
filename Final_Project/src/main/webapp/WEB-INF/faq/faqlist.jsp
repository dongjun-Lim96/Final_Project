<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../common/common.jsp"%>
    <%@ include file="./../../header.jsp"%>
<style>
    
    #sub_banner {position:relative; height:200px; width:100%; }
    #sub_banner::after {content:''; width:100%; height:100%; background:url('/theme/6/img/main/subtop_pattern.png')no-repeat center; background-size:contain; position:absolute; top:0; left:0;}
    #sub_banner h2 {position:relative; top:50%; transform:translateY(-50%); font-size:2.941rem; color:#fff; text-align:center; letter-spacing:-0.7pt; line-height:1; font-weight:bold; z-index:99;}
    .bgColor {background-color:#467fd7;}
    
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
    
    
</style>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script>  
	function insert() {
		location.href = "insert.faq";
	}
	
	$(document).ready(function(){
	      $("a[id=navselect]").click(
	         function(){$(this).addClass("active");},
	         function(){$(this).removeClass("active");}         
	      );
	 });
</script>




<div id="sub_banner" class="bgColor">
    <h2 class="page_title">
        
        
        자주하는질문
        
    </h2>
    
     <article class="stickyMenu w1230">
    <nav class="lnb">
        <a href="/main/main.jsp" class="lnbHome" title="메인으로이동">
            <img src="<%=request.getContextPath()%>/resources/images/lnbHome.png" alt="home" style="float: right; margin-right: 10px; margin-bottom: 50px; margin-top: 40px;">
        </a>
    </nav>
</article>
</div>

<ul class="nav nav-tabs justify-content-center">
	<li class="nav-item"><a class="nav-link" id="navselect" href="list.faq">전체</a></li>
	<li class="nav-item"><a class="nav-link" id="navselect" href="list.faq?bacategory=회원">회원</a></li>
	<li class="nav-item"><a class="nav-link" id="navselect" href="list.faq?bacategory=수강 및 교재">수강 및 교재</a></li>
	<li class="nav-item"><a class="nav-link" id="navselect" href="list.faq?bacategory=결제/취소/환불">결제/취소/환불</a></li>
	<li class="nav-item"><a class="nav-link" id="navselect" href="list.faq?bacategory=동영상&기기관련">동영상&기기관련</a></li>
</ul>
<br>

<div>
<div id=container>
<nav class="navbar navbar-light bg-light">
	<div class="container-fluid justify-content-end">
	
	
		<%-- <div class="count">총${totalCount}개</div> --%>
		<%-- <a class="navbar-brand">총 ${totalCount}개</a> --%>
		<c:if test="${sessionScope.loginInfo.type eq 'admininfo' }">
			<input class="btn btn-secondary btn-sm" type="button" value="질문삽입" onClick="insert()">
		</c:if>
		<form action="list.faq" method="get" class="d-flex">
			<input class="form-control me-2" type="search" placeholder="Search" name="keyword">
			<button class="btn btn-outline-success" type="submit">Search</button>
		</form>
		
	</div>
</nav>

<div class="accordion accordion-flush" id="accordionFlushExample">
    <c:if test="${fn:length(list)==0 }">
        <!-- 검색 결과가 없을 때의 처리 -->
    </c:if>
    <c:if test="${fn:length(list)!=0 }">
        <c:forEach var="faq" items="${faqLists}">
            <div class="accordion-item">
                <h2 class="accordion-header" id="${heading[i] }">
                    <c:set var="s" value="#" />
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="${s}${collapse[i] }" aria-expanded="false" aria-controls="${collapse[i] }">
                        ${list[i].basubject }
                    </button>
                </h2>
                <div id="${collapse[i] }" class="accordion-collapse collapse" aria-labelledby="${heading[i] }" data-bs-parent="#accordionFlushExample">
                    <div class="accordion-body">
                        <table>
                            <thead>
                                <tr>
                                    <th>제목</th>
                                    <th>내용</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>${faq.faqTitle}</td>
                                    <td>${faq.faqContent}</td>
                                </tr>
                            </tbody>
                        </table>
                        <%-- 추가적인 내용 및 버튼 등 --%>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>
</div>

 <%@ include file="./../../footer.jsp"%>
</div>