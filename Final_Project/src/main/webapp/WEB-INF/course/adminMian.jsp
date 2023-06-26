<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../../adminsidebar.jsp" %>
<!-- 제이쿼리 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous" type="text/javascript"></script>
<!-- chart.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>

<div style="position: relative; top: 50px;">
<button onclick="displayChart()" style="background-color: #0DCAF0; color: white; border: none; padding: 10px 20px; font-size: 16px; border-radius: 4px; cursor: pointer;">매출보기</button>
<button onclick="accountlist()" style="background-color: #0DCAF0; color: white; border: none; padding: 10px 20px; font-size: 16px; border-radius: 4px; cursor: pointer;">가입회원보기</button>
  <canvas id="line-chart" width="900" height="600"></canvas>
</div>





  <!-- 오른쪽 영역 -->
  <div style="width: 50%;">
    <!-- 오른쪽 영역 내용 -->
    <div style="display: grid; grid-template-columns: repeat(1, 1fr); grid-template-rows: repeat(3, 1fr); grid-gap: 30px; margin-top: 95px;">
     
      <table style="background-color:#DCDCDC;box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); border: none; border-radius: 10px; width: 400px; height:100%;">
        <tr>
          <td>회원현황</td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td>신규회원</td>
          <td>탈퇴회원</td>
          <td>Total</td>
        </tr>
        <tr>
          <td>
          	 <c:forEach var="countAccount" items="${countAccount}" varStatus="status">
	            <c:set var="totalaccount" value="${totalaccount + countAccount.count}" />        
	       	 </c:forEach>
	         <fmt:formatNumber var="formattedTotalaccount" value="${totalaccount}" pattern="#,###" />   
          	${formattedTotalaccount} 명
          </td>
           
          <td>${accountLeave } 명</td>
          <td>${accountTotal } 명</td>
        </tr>
      </table>
      <table style="background-color:#DCDCDC;box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); border: none; border-radius: 10px; width: 400px; height:100%;">
        <tr>
          <td>최근가입회원</td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td>가입일시</td>
          <td>아이디</td>
          <td>이름</td>
        </tr>
        <c:forEach var="recentlyAccount" items="${recentlyAccount }">
        	<tr>
        	
	          <td><fmt:formatDate value="${recentlyAccount.userJoinDate}" pattern="yyyy-MM-dd" /></td>
	          <td>${recentlyAccount.userId }</td>
	          <td>${recentlyAccount.userName }</td>
        	</tr>
          </c:forEach>
      </table>
       <table style="background-color:#DCDCDC;box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); border: none; border-radius: 10px; width:400px; height:100%;">
      	<tr>
      		<td>등록강의 현황 ${courseCount }건</td>
      		<td></td>
      		<td></td>
      	</tr>
        <tr>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td>1</td>
          <td>2</td>
          <td>3</td>
        </tr>
      </table>
    </div>
  </div>
</div>






<script>
  let lineChart = null;

  function clearChart() {
    if (lineChart !== null) {
      lineChart.destroy(); // 기존 차트 삭제
    }
  }
  window.onload = function() {
	    displayChart(); // 페이지가 로드되면 displayChart() 함수를 호출하여 차트를 생성
	  };
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