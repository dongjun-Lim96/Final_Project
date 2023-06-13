<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>

<style type="text/css">
.container {
	text-align: center;
	margin-top: 20px;
}

form {
	width: 600px;
	margin: 0 auto;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

table th, table td {
	padding: 10px;
	border: 1px solid #ccc;
}

.table th {
	background-color: #f5f5f5;
	width: 3%;
	font-weight: bold;
}

.form-field {
	width: 100%;
}

textarea {
	width: 100%;
	resize: vertical;
	height: 350px;
}

.err {
	color: #1bceb8;
	font-size: 14px;
	font-weight: bold;
}

input[type="submit"], input[type="reset"], input[type="button"], input[type="file"]
	{
	padding: 5px 10px;
	margin-right: 5px;
}
</style>

<script>
	function List(pageNumber){
		alert(pageNumber);
		location.href="list.nt?pageNumber="+pageNumber;
	}
</script>

updateForm
<br>
<center>
	<form:form commandName="notice" action="updateNotice.nt" method="post"
		enctype="multipart/form-data">

		<table width="600px" border="1">
			<tr>
				<td colspan="2"><a href="list.nt">글목록</a> <input type="hidden"
					name="noticeNumber" value="${notice.noticeNumber }"> <input
					type="hidden" name="pageNumber" value="${pageNumber }"></td>
			</tr>

			<tr>
				<th>이 름</th>
				<td><input type="text" name="adminId" size="60"
					value="${notice.adminId}" readonly></td>
			</tr>

			<tr>
				<th>제 목</th>
				<td><input type="text" name="noticeTitle" size="80"
					value="${notice.noticeTitle}"> <form:errors cssClass="err"
						path="noticeTitle" /></td>
			</tr>

			<tr>
				<th>이미지</th>
				<td><img
					src="<%=request.getContextPath()%>/resources/${notice.noticeImage}"
					width="200" height="200"> <br> <input type="file"
					name="upload" id="upload" value="${notice.upload}"> <input
					type="hidden" name="upload2" value="${notice.noticeImage}">
				</td>
			</tr>

			<tr>
				<th>내 용</th>
				<td><textarea name="noticeContent" rows="20" cols="75">${notice.noticeContent}</textarea>
					<form:errors cssClass="err" path="noticeContent" /></td>
			</tr>


			<tr height="30">
				<td colspan="2" align="center"><input type="submit"
					value="수정하기"> <input type="reset" value="다시작성"> <input
					type="button" value="목록보기" onClick="List(${pageNumber})"></td>
			</tr>
		</table>
	</form:form>
</center>