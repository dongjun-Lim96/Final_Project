<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function register(){
		location.href='registerForm.acc';
	}
	
	function listAccounts() {
		location.href='list.acc';
	}
	function findUserId(){
		location.href='accountSearchForm.acc';
	}
	function findUserPassword(){
		location.href='accountPwSearchForm.acc';
	}
</script>
    
accounts\accountsLoginForm.jsp <br>

<form action="loginForm.acc" method="post">
	<table border="1" height="150px">
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="userId">
			</td>
		</tr>
		<tr>
			<td>비번</td>
			<td>
				<input type="text" name="userPw">
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="button" value="아이디 찾기" onClick="findUserId()">
			<input type="button" value="비번 찾기" onClick="findUserPassword()">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인">
				<input type="reset" value="취소">
				<input type="button" value="회원가입" onClick="register()">
			</td>
		</tr>
	</table>
</form>