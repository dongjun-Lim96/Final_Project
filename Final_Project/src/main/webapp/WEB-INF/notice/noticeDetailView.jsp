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
            width: 600px;
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
		
		function deleteNotice(noticeNumber, pageNumber) {
		
			alert("delete" +noticeNumber + "," + pageNumber);
			location.href = "deleteNotice.nt?pageNumber=" + pageNumber + "&noticeNumber=" + noticeNumber;
		}
		

		function updateNotice(noticeNumber, pageNumber) {
	
			alert("update" +noticeNumber + "," + pageNumber);
			location.href = "updateNotice.nt?pageNumber=" + pageNumber + "&noticeNumber=" + noticeNumber;
			System.out.println("pageNumber"+pageNumber+"noticeNumber"+noticeNumber);
		}


	</script>
</head>

<body>
<div id="sub_banner" class="bgColor" >
    <h2 class="page_title">
        
        공지사항
        
    </h2>
</div>
<div class="container">
<br>
	<form>
		<table width="600px" border="1">
			<tr>
	
				<th>글번호</th>
				<td>${notice.noticeNumber}</td>
				<th>조회수</th>
				<td>${notice.noticeView}</td>
			</tr>

			<tr>
				<th>작성자</th>
				<td>${notice.adminId}</td>
				<th>작성일</th>
				<td>${notice.noticeDate}</td>
			</tr>

			<tr>
				<th>글제목</th>
				<td colspan="3">${notice.noticeTitle}</td>
			</tr>
			<c:if test="${notice.noticeImage != null}">
				<tr>
					<th>이미지</th>
					<%-- <td colspan="3">${notice.noticeImage}</td> --%>
					<td colspan="3"><img src="<%=request.getContextPath() %>/resources/${notice.noticeImage}" width="200" height="200"></td>
				</tr>
			</c:if>
			
			<tr>
				<th>글내용</th>
				<td colspan="3" align="left"><pre>${notice.noticeContent}</pre></td>
			</tr>

			<tr>
				<td colspan="4" align="right">
					    <c:if test="${sessionScope.loginInfo.adminCheck eq 1}">
 				 <!-- adminCheck 값이 1인 관리자 경우에만 실행될 버튼 -->
                        <input type="button" value="글수정" onClick= "updateNotice(${notice.noticeNumber}, ${pageNumber})">
                       
                        	 <!-- loginInfo.userId eq adminId 관리자중 본인이 작성한경우에만 실행될 버튼 -->
 				 		 <c:if test="${sessionScope.loginInfo.userId eq notice.adminId}">
                        <input type="button" value="글삭제" onClick="deleteNotice(${notice.noticeNumber}, ${pageNumber})">
                        </c:if>
                    </c:if>

					
					<input type="button" value="글목록" onClick="location.href = 'list.nt?pageNumber=${param.pageNumber}'"> 

				
				</td>
			</tr>
		</table>

		
	</form>
</div>

</body>
</html>
  <%@ include file="./../../footer.jsp"%>