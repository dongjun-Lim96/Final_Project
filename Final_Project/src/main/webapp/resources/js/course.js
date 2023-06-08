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


function keyd(){
	//alert(key);
	$('#idmessage').css('display','none');
	use = "";
	isCheck = false;
}


function pwcheck(){
	pw = $('input[name=userPw]').val();
	var reg = /^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[\W_]).{8,}$/;
	
	if(!reg.test(pw)){
		//alert("비밀번호 형식이 틀렸습니다.");
		$("#pwmessage").html('<font color=red>비밀번호 형식이 틀렸습니다.<font>');
		pwuse = "pwerror";
		return;
	}else{
		$("#pwmessage").html('<font color=blue>가능한 비밀번호<font>');
	}
	
	var chk_num = pw.search(/[0-9]/);
	var chk_eng = pw.search(/[a-z]/i);
	
	
	if(chk_num < 0 || chk_eng < 0){
		//alert('영문과 숫자조합으로 완성하세요')
		pwuse = "pwerror";
	}else{
		pwuse = "";
	}
}

function pw2check() {
	if($('input[name=userPw]').val() == $('input[name=userPw2]').val()){
		$('#pwmessage2').html('<font color=blue>비밀번호 일치<font>');
		pwsame = "same";
	}else{
		$('#pwmessage2').html('<font color=red>비밀번호 불일치<font>');
		pwsame = "nosame";
	}
}

function emailcheck(){
  email = $('input[name=userEmail]').val();
  var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
  // 검증에 사용할 정규식 변수 regExp에 저장

  if (email.match(regExp) != null) {
    $('#emailmsg').html('<font color=blue>사용 가능한 이메일.<font>');
    emailuse = "";
  }
  else {
   	$('#emailmsg').html('<font color=red>이메일 형식이 잘못되었습니다.<font>');
   	emailuse = "emailerror";
  }
}


function telcheck1(){
  tel = $('input[name="mobile2"]').val();
  var regExp = /[0-9]{3,4}$/;

  if (tel.match(regExp) != null) {
    $('#telmsg').html('<font color=blue>성공<font>');
    teluse = "";
  }
  else {
   	$('#telmsg').html('<font color=red>번호가 잘못되었습니다.<font>');
   	teluse = "telerror";
  }
}

function telcheck2(){
  tel = $('input[name="mobile3"]').val();
  var regExp = /[0-9]{4}$/;

  if (tel.match(regExp) != null) {
    $('#telmsg').html('<font color=blue>성공<font>');
    teluse = "";
  }
  else {
   	$('#telmsg').html('<font color=red>번호가 잘못되었습니다.<font>');
   	teluse = "telerror";
  }
}