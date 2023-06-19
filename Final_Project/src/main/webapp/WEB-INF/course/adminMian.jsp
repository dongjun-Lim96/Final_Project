<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../adminsidebar.jsp" %>
<!-- 제이쿼리 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous" type="text/javascript"></script>
<!-- chart.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>

<canvas id="line-chart" width="100" height="50"></canvas>
<script>
  new Chart(document.getElementById("line-chart"), {
	  type: 'line',
	    data: {
	      labels: [
	        <c:forEach var="weeklists" items="${weeklist}">
	          '${weeklists.orderDate}',
	        </c:forEach>
	      ],
	      datasets: [{
	        data: [
	          <c:forEach var="weeklists" items="${weeklist}">
	            ${weeklists.totalPrice},
	          </c:forEach>
	        ],
	        label: "7일매출",
	        borderColor: "#3e95cd",
	        fill: false
	      }]
	    },
    options: {
      responsive: true,
      maintainAspectRatio: false,
      title: {
        display: true,
        text: '7일 매출'
      }
    }
  });
</script>
