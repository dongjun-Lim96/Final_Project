<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#findId").on('click',function(){
			console.log('test')
			
		var userName = $("[name=userName]").val();
        
        if (userName === "") {
            alert("이름을 입력하세요.");
            return;
        }
        
        var userEmail = $("[name=userEmail]").val();
        
        if (userEmail === "") {
            alert("이메일 값도 넣어주세요.");
            return;
        }
        
			sand();
		});
	})
	function findPw(){
		location.href='accountPwSearchForm.acc';
	}
	function register(){
		location.href='register.acc';
	}
	function login() {
	    location.href = 'loginForm.acc';
	}
	
	function main() {
		 location.href='../../ex/main.jsp';
	}
	function sand(){
		var userEmail = $("[name=userEmail]").val();
		var userName = $("[name=userName]").val();
	
		console.log(userEmail);
		$.ajax({
		    type: 'post',
		    url: "searchAccountsUserId.acc",
		    data: { userEmail: userEmail, userName: userName },
		    success: function (data) {
	            console.log(data.replace('=', ':'));
	            var d = JSON.parse(data.replace('=', ':'));
	            console.log(d);
	            if (d.checkGbn === 'Y') {
	                $("#result").text("회원님의 ID는 : " + d.userId + "입니다.");
	             
	            } else {
	                if (d.userName === userName) {
	                    alert("존재하지 않는 이메일입니다.");
	                } else if (d.userEmail === userEmail) {
	                    alert("존재하지 않는 이름입니다.");
	                } else {
	                    alert("이메일과 이름 다시 확인하세요.");
	                }
	            }
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
			<td>이름</td>
			<td>
				<input type="text" name="userName"  placeholder="이름를 입력하세요.">
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
				<input type="button" value="비밀번호 찾기" onClick="findPw()">
				<input type="button" value="회원가입" onClick="register()">
				<input type="button" value="로그인하기" onClick="login()">
				<input type="button" value="메인으로 돌아가기" onClick="main()">
			</td>
		</tr>
	</table> 
</form>