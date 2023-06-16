<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<%@ include file="./../../header.jsp"%>
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

.err {
	color: #1bceb8;
	font-size: 14px;
	font-weight: bold;
}

textarea {
	width: 100%;
	resize: vertical;
	height: 350px;
}

input[type="submit"], input[type="reset"], input[type="button"], input[type="file"]
	{
	padding: 5px 10px;
	margin-right: 5px;
}
</style>

<div class="container">
	<form:form commandName="noticeBean" action="write.nt" method="post"
		enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td colspan="2"><a href="list.nt">글목록</a></td>
			</tr>
			<tr>
				<th class="form-label">아이디</th>
				<td class="form-field"><input type="text" name="adminId"
					size="60" value="${loginInfo.userId}" readonly></td>
			</tr>
			<tr>
				<th class="form-label">제 목</th>
				<td class="form-field"><input type="text" name="noticeTitle"
					size="60" value="${noticeBean.noticeTitle}"> <br> <form:errors
						cssClass="err" path="noticeTitle" /></td>
			</tr>
			<tr>
				<th class="form-label">내 용</th>
				<td class="form-field"><textarea name="noticeContent" rows="20"
						cols="75">${noticeBean.noticeContent}</textarea> <br> <form:errors
						cssClass="err" path="noticeContent" /></td>
			</tr>
			<tr>
				<th class="form-label">이미지</th>
				<td class="form-field"><input type="file" name="upload"
					size="80"></td>
			</tr>
			<tr height="30">
				<td colspan="2" align="center"><input type="submit" value="글쓰기">
					<input type="reset" value="다시작성"> <input type="button"
					value="목록보기"
					onClick="location.href = 'list.nt?pageNumber=${param.pageNumber}'">
				</td>
			</tr>
		</table>
	</form:form>
</div>
<br>
<br>
