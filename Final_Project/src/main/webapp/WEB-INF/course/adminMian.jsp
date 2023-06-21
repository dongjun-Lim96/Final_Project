<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../../adminsidebar.jsp" %>
<!-- 제이쿼리 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous" type="text/javascript"></script>
<!-- chart.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>

<div style="position: relative; top: 50px;">
<button onclick="displayChart()" style="background-color: #0DCAF0; color: white; border: none; padding: 10px 20px; font-size: 16px; border-radius: 4px; cursor: pointer;">매출보기</button>
<button onclick="accountlist()" style="background-color: #0DCAF0; color: white; border: none; padding: 10px 20px; font-size: 16px; border-radius: 4px; cursor: pointer;">가입회원보기</button>
  <canvas id="line-chart" width="1000" height="700"></canvas>
</div>

<script>
  let lineChart = null;

  function clearChart() {
    if (lineChart !== null) {
      lineChart.destroy(); // 기존 차트 삭제
    }
  }

  function displayChart() {
    clearChart(); // 이전 차트 삭제
    let total = 0;
    lineChart = new Chart(document.getElementById("line-chart"), {
      type: 'bar',
      data: {
        labels: [
          <c:forEach var="weeklists" items="${weeklist}" varStatus="status">
            <c:if test="${!status.last}">
              '<fmt:formatDate value="${weeklists.orderDate}" pattern="yyyy-MM-dd" />',
            </c:if>
          </c:forEach>
        ],
        datasets: [{
          data: [
            <c:forEach var="weeklists" items="${weeklist}" varStatus="status">
            <c:set var="total" value="${total + weeklists.totalPrice}" />
              <c:if test="${!status.last}">
                ${weeklists.totalPrice},
              </c:if>
            </c:forEach>
            <fmt:formatNumber var="formattedTotal" value="${total}" pattern="#,###" />
          ],
          label: "total : ${formattedTotal}원",
          backgroundColor: "#0000FF",
          fill: false
        }]
      },
      options: {
        responsive: true,
        maintainAspectRatio: true, // 차트 크기 고정
        title: {
          display: true,
          text: '7일 매출',
          fontSize: 30
        }
      },
      
    });
  }
  
  function accountlist() {
	  clearChart(); // 이전 차트 삭제
	    lineChart = new Chart(document.getElementById("line-chart"), {
	      type: 'bar',
	      data: {
	        labels: [
	          <c:forEach var="countAccount" items="${countAccount}" varStatus="status">
	          '${countAccount.join_date}',
	          	            
	          </c:forEach>
	        ],
	        datasets: [{
	          data: [
	            <c:forEach var="countAccount" items="${countAccount}" varStatus="status">
	            <c:set var="totalaccount" value="${totalaccount + countAccount.count}" />
	              
	                ${countAccount.count},
	              
	            </c:forEach>
	            <fmt:formatNumber var="formattedTotalaccount" value="${totalaccount}" pattern="#,###" />
	          ],
	          label: "total : ${formattedTotalaccount}명",
	          backgroundColor: "#FF0000",
	          fill: false
	        }]
	      },
	      options: {
	        responsive: true,
	        maintainAspectRatio: true, // 차트 크기 고정
	        title: {
	          display: true,
	          text: '가입자(명)',
	          fontSize: 30
	        }
	      }
	    });
  }
</script>