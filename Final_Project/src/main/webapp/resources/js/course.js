/**
 * 
 */
 
var use;
var isCheck = false;
 
function writeSave(){ // 가입클릭
	//alert(1);
	
	if($('input[name=userId]').val() == ""){
		alert("아이디를 입력해주세요.");
		$('input[name=userId]').focus();
		return false;
	}
	if(use == "missing"){
		alert('아이디를 입력하세요');
		$("input[name=userId]").focus();
		return false;
	}
	else if(use == "impossible"){
		alert('이미 등록된 아이디입니다');
		$('input[name=userId]').select();
		return false;
		
	}else if(isCheck == false){
		alert('중복체크 먼저 하세요');
		return false;
	}
	
	
	if($('input[name=userPw]').val() == ""){
		alert("비밀번호를 입력해주세요.");
		$('input[name=userPw]').focus();
		return false;
	}
	
	if(pwuse=='pwerror'){
		alert("비밀번호 형식이 잘못되었습니다.");
		return false;
	}
	
	if($('input[name=userPw2]').val() == ""){
		alert("비밀번호를 입력해주세요.");
		$('input[name=userPw2]').focus();
		return false;
	}
	
	if(pwsame == "nosame"){
		alert("비번번호가 불일치");
		return false;
	}
	
	
	if($('input[name="userName"]').val() == ""){
		alert("이름을 입력해주세요.");
		$('input[name="userName"]').focus();
		return false;
	}
	
	if($('input[name="userBirth"]').val() == ""){
		alert("생년월일을 입력해주세요.");
		$('input[name="userBirth"]').focus();
		return false;
	}
	
	
	if($('input[name=userEmail]').val() == ""){
		alert("이메일을 입력해주세요.");
		$('input[name=userEmail]').focus();
		return false;
	}
	
	if(emailuse =='emailerror'){
		alert("이메일 형식이 잘못되었습니다.");
		return false;
	}
	
	
	
	if($('input[name="mobile2"]').val() == ""){
		alert("휴대폰 번호를 입력해주세요.");
		$('input[name="mobile2"]').focus();
		return false;
	}
	if($('input[name="mobile3"]').val() == ""){
		alert("휴대폰 번호를 입력해주세요.");
		$('input[name="mobile3"]').focus();
		return false;
	}
	
	if(teluse=='telerror'){
		alert("번호가 잘못되었습니다.");
		return false;
	}
	
	
	
	
}//writeSave()

function duplicate(){ // 중복체크 클릭
	//alert(1);
	isCheck = true;
    $.ajax({
		url : "check.acc",
		data : ({
			userId : $('input[name=userId]').val()
		}),
		success : function(data){
			//alert(data);
			if($('input[name=userId]').val()==""){
				$("#idmessage").html('<font color=red>아이디를 입력하세요<font>').show();
				$('input[name=userId]').focus();
				use = "missing";
			}
			else if($.trim(data) == "NO"){
				$("#idmessage").html('<font color=red>이미 등록된 아이디입니다<font>').show();
				$('input[name=userId]').select();
				use = "impossible";
			}
			else if($.trim(data) == "YES"){
				$("#idmessage").html('<font color=blue>사용가능한 아이디입니다<font>').show();
				use = "possible";
			}
		}
	});//ajax
}//duplicate

function categoryCheck(){ // 중복체크 클릭
	alert(1);
	isCheck = true;
    $.ajax({
		url : "CategoryDao.cg",
		data : ({
			categoryCode : $('input[name=categoryCode]').val()
		}),
		success : function(data){
			
			if($('input[name=categoryCode]').val()==""){
				$("#idmessage").html('<font color=red>카테고리코드를 입력하세요<font>').show();
				$('input[name=categoryCode]').focus();
				use = "missing";
				alert(22);
			}
			else if($.trim(data) == "NO"){
				$("#idmessage").html('<font color=red>이미 등록된 카테고리코드 입니다<font>').show();
				$('input[name=categoryCode]').select();
				use = "impossible";
				alert(33);
			}
			else if($.trim(data) == "YES"){
				$("#idmessage").html('<font color=blue>사용가능한 카테고리코드 입니다<font>').show();
				use = "possible";
				alert(44);
			}
		}
	});//ajax
}//categoryCheck


function keyd(){
	//alert(key);
	$('#idmessage').css('display','none');
	use = "";
	isCheck = false;
}

