<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#findId").on('click',function(){
			console.log('test')
			sand();
		});
	})
	function register(){
		location.href='registerForm.acc';
	}
	
	function listAccounts() {
		location.href='list.acc';
	}
	function sand(){
		var userEmail = $("[name=userEmail]").val();
		var userId = $("[name=userId]").val();
		console.log(userEmail);
		$.ajax({
		    type: 'post',
		    url: "searchAccountsUserId.acc",
		    data: { userEmail: userEmail, userId: userId },
		    success: function (data) {
		    	console.log(data.replace('=', ':'));
		        var d = JSON.parse(data.replace('=', ':'));
		        console.log(d);
		        if(d.checkGbn=='Y'){
			        $("#result").text("회원님의 ID는 : "+d.userId+"입니다.");
		        }else{
		        	$("#result").text("회원님의 가입회원이 아닙니다.");
		        }
		        // 작업이 성공적으로 발생했을 경우
		    },
		    error: function (e) {
		        console.log(e);
		        // 에러가 발생했을 경우 실행할 코드
		    }
		});

	}
</script>
<style type="text/css">

	table{
		
	margin-top:25px;
	line-height: 150% !important;	
	} 


</style>
    
accounts\accountsSearchForm.jsp <br>

<form action="loginForm.acc" method="post">
<div id="result"></div>
	<table border="1" height="150px">
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="userId"  placeholder="이름를 입력하세요.">
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="text" name="userEmail"  placeholder="이메일을 입력하세요.">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" id="findId" value="아이디 찾기">
				<input type="button" id="findPw" value="비밀번호 찾기">
				<input type="button" value="회원가입" onClick="register()">
				<input type="button" value="회원목록보기" onClick="listAccounts()">
			</td>
		</tr>
	</table>
</form>