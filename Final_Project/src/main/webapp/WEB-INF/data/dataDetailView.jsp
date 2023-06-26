<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
  <%@ include file="./../../header.jsp"%>
<!DOCTYPE html>
<html>
<head>

  <style>
    #sub_banner {position:relative; height:200px; width:100%; }
    #sub_banner::after {content:''; width:100%; height:100%; background:url('/theme/6/img/main/subtop_pattern.png')no-repeat center; background-size:contain; position:absolute; top:0; left:0;}
    #sub_banner h2 {position:relative; top:50%; transform:translateY(-50%); font-size:2.941rem; color:#fff; text-align:center; letter-spacing:-0.7pt; line-height:1; font-weight:bold; z-index:99;}
    .bgColor {background-color:#0DCAF0;}
    
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
  

    </style>
<script>
       
      function deleteData(dataNumber, pageNumber) {
      
         alert("delete" +dataNumber + "," + pageNumber);
         location.href = "deleteData.dt?pageNumber=" + pageNumber + "&dataNumber=" + dataNumber;
      }
      

      function updateData(dataNumber, pageNumber) {
   
         alert("update" +dataNumber + "," + pageNumber);
         location.href = "updateData.dt?pageNumber=" + pageNumber + "&dataNumber=" + dataNumber;
         System.out.println("pageNumber"+pageNumber+"dataNumber"+dataNumber);
      }


   </script>
</head>

<body>
<div id="sub_banner" class="bgColor" >
    <h2 class="page_title">
        
        무료 학습자료
        
    </h2>
</div>
<div class="container">
<br>
   <form>
      <table width="600px" border="1">
         <tr>
   
            <th>글번호</th>
            <td>${data.dataNumber}</td>
            <th>조회수</th>
            <td>${data.dataView}</td>
         </tr>

         <tr>
            <th>작성자</th>
            <td>${data.adminId}</td>
            <th>작성일</th>
            <td>${data.dataDate}</td>
         </tr>

         <tr>
            <th>글제목</th>
            <td colspan="3">${data.dataTitle}</td>
         </tr>
         <c:if test="${data.dataImage != null}">
            <tr>
               <th>이미지</th>
               <td colspan="3"><img src="<%=request.getContextPath() %>/resources/${data.dataImage}" width="800" height="800"></td>
            </tr>
         </c:if>
         
         <tr>
            <th>글내용</th>
            <td colspan="3" align="left"><pre>${data.dataContent}</pre></td>
         </tr>

         <tr>
            <td colspan="4" align="right">
                   <c:if test="${sessionScope.loginInfo.adminCheck eq 1}">
              <!-- adminCheck 값이 1인 관리자 경우에만 실행될 버튼 -->
                        <input type="button" value="글수정" onClick= "updateData(${data.dataNumber}, ${pageNumber})">
                       
                            <!-- loginInfo.userId eq adminId 관리자중 본인이 작성한경우에만 실행될 버튼 -->
                     <c:if test="${sessionScope.loginInfo.userId eq data.adminId}">
                        <input type="button" value="글삭제" onClick="deleteData(${data.dataNumber}, ${pageNumber})">
                        </c:if>
                    </c:if>

               
               <input type="button" value="글목록" onClick="location.href = 'list.dt?pageNumber=${param.pageNumber}'"> 

            
            </td>
         </tr>
      </table>

      
   </form>
</div>

</body>
</html>
  <%@ include file="./../../footer.jsp"%>