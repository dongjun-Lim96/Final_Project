<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
  <%@ include file="./../../header.jsp"%>
<!DOCTYPE html>
<html>
<head>

    <style>
    
        .container {
            text-align: center;
            margin-bottom: 20px;
        }

        table {
            width: 950px;
            border-collapse: collapse;
            margin: 0 auto; /* 가운데 정렬을 위해 margin을 auto로 설정 */
            table-layout: fixed;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
        }

        th {
            background-color: #f5f5f5;
             width: 100px;
        }



        pre {
            white-space: pre-wrap;
            word-wrap: break-word;
        }

        .btn-container {
            text-align: right;
            margin-top: 10px;
        }

        .btn-container button {
            margin-left: 5px;
        }
        	.table th {
		background-color: #f5f5f5;
	}

	.table tr:nth-child(even) {
		background-color: #f9f9f9;
	}
	:root {
    --point-color:#1bceb8;
}

.bgColor {background-color:var(--point-color) !important;}
	
    </style>
<script>
		 
		function deleteEvent(eventNumber, pageNumber) {
		
			alert("delete" +eventNumber + "," + pageNumber);
			location.href = "deleteEvent.ev?pageNumber=" + pageNumber + "&eventNumber=" + eventNumber;
		}
		

		function updateEvent(eventNumber, pageNumber) {
	
			alert("update" +eventNumber + "," + pageNumber);
			location.href = "updateEvent.ev?pageNumber=" + pageNumber + "&eventNumber=" + eventNumber;
			System.out.println("pageNumber"+pageNumber+"eventNumber"+eventNumber);
		}


	</script>
</head>

<body>
<div id="sub_banner" class="bgColor" >
    <h2 class="page_title">
        
        이벤트
        
    </h2>
</div>
<div class="container">
<br>
	<form>
		<table width="600px" border="1">
			<tr>
	
				<th>글번호</th>
				<td>${event.eventNumber}</td>
				<th>조회수</th>
				<td>${event.eventView}</td>
			</tr>

			<tr>
				<th>작성자</th>
				<td>${event.adminId}</td>
				<th>작성일</th>
				<td><fmt:formatDate value="${event.eventDate}" pattern="yyyy-MM-dd"/></td>
			</tr>

			<tr>
				<th>글제목</th>
				<td colspan="3">${event.eventTitle}</td>
			</tr>
			<c:if test="${event.eventImage != null}">
				<tr>
					<th>이미지</th>
					<td colspan="3"><img src="<%=request.getContextPath() %>/resources/${event.eventImage}" width="800" height="800"></td>
				</tr>
			</c:if>
			
			<tr>
				<th>글내용</th>
				<td colspan="3" align="left"><pre>${event.eventContent}</pre></td>
			</tr>
			<tr>
				<th>이벤트시작일</th>
				<td colspan="3">${event.eventStart}</td>

			</tr>
			<tr>
				<th>이벤트종료일</th>
				<td colspan="3">${event.eventEnd}</td>
			</tr>
			<tr>
				<td colspan="4" align="right">
					    <c:if test="${sessionScope.loginInfo.adminCheck eq 1}">
 				 <!-- adminCheck 값이 1인 관리자 경우에만 실행될 버튼 -->
                        <input type="button" value="글수정" onClick= "updateEvent(${event.eventNumber}, ${pageNumber})">
                       
                        	 <!-- loginInfo.userId eq adminId 관리자중 본인이 작성한경우에만 실행될 버튼 -->
 				 		 <c:if test="${sessionScope.loginInfo.userId eq event.adminId}">
                        <input type="button" value="글삭제" onClick="deleteEvent(${event.eventNumber}, ${pageNumber})">
                        </c:if> 
                    </c:if>

					
					<input type="button" value="글목록" onClick="location.href = 'list.ev?pageNumber=${param.pageNumber}'"> 

				
				</td>
			</tr>
		</table>

		
	</form>
</div>

</body>
</html>
  <%@ include file="./../../footer.jsp"%>