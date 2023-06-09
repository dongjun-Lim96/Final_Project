/**
 * 
 */
 
var use;
var isCheck = false;
 
function writeSave(){ // 가입클릭
	//alert(1);
	
	if($('input[name=courseCode]').val() == ""){
		alert("강의코드를 입력해주세요.");
		$('input[name=courseCode]').focus();
		return false;
	}
	if(use == "missing"){
		alert('강의코드를 입력하세요');
		$("input[name=courseCode]").focus();
		return false;
	}
	else if(use == "impossible"){
		alert('이미 등록된 강의코드입니다');
		$('input[name=courseCode]').select();
		return false;
		
	}else if(isCheck == false){
		alert('중복체크 먼저 하세요');
		return false;
	}
	
	if($('input[name=categoryName]').val() ==''){
		alert('카테고리이름을 입력해주세요.');
		$('input[name=categoryName]').focus();
		return false;
	}
	if($('input[name=cousreName]').val() ==''){
		alert('강의명을 입력해주세요.');
		$('input[name=cousreName]').focus();
		return false;
	}
	if($('input[name=cousrePrice]').val() ==''){
		alert('금액을 입력해주세요.');
		$('input[name=cousrePrice]').focus();
		return false;
	}
	if($('input[name=cousreTeacher]').val() ==''){
		alert('강사명을 입력해주세요.');
		$('input[name=cousreTeacher]').focus();
		return false;
	}
	if($('input[name=cousreImg]').val() ==''){
		alert('썸네일 입력해주세요.');
		
		return false;
	}
	if($('input[name=cousreVideo]').val() ==''){
		alert('강의동영상을 입력해주세요.');
		
		return false;
	}
	if($('input[name=cousreTerm]').val() ==''){
		alert('강의기간을 입력해주세요.');
		$('input[name=cousreTerm]').focus();
		return false;
	}
	if(termuse =='termerror'){
		alert('기간이 잘못되었습니다');
		return false;
	}
	if(priceuse =='priceerror'){
		alert('금액이 잘못되었습니다');
		return false;
	}
	
}//writeSave()



function courseCodeCheck(){ // 중복체크 클릭
	alert($('input[name=courseCode]').val());
	isCheck = true;
    $.ajax({
		url : "CourseCheck.cs",
		data : ({
			courseCode : $('input[name=courseCode]').val()
		}),
		success : function(data){
			
			if($('input[name=courseCode]').val()==""){
				$("#idmessage").html('<font color=red>강의코드를 입력하세요<font>').show();
				$('input[name=courseCode]').focus();
				use = "missing";
				
			}
			else if($.trim(data) == "NO"){
				$("#idmessage").html('<font color=red>이미 등록된 강의코드 입니다<font>').show();
				$('input[name=courseCode]').select();
				use = "impossible";
				 
			}
			else if($.trim(data) == "YES"){
				$("#idmessage").html('<font color=blue>사용가능한 강의코드 입니다<font>').show();
				use = "possible";
				
			}
		},
		error: function(xhr, status, error) {
            alert("에러 발생: " + error);
        }
	});//ajax
}//categoryCheck

function termCheck(){
	//alert("termcheck");
	term = $('input[name="cousreTerm"]').val();
		var regExp = /^[0-9]+$/;
	
	if (term.match(regExp) != null) {
		$('#termmsg').html('<font color=blue>성공<font>');
		termuse = "";
	}
	else {
		$('#termmsg').html('<font color=red>숫자만 입력해주세요.<font>');
		termuse = "termerror";
	}
}
function priceCheck(){
	//alert("priceCheck");
	price = $('input[name="cousrePrice"]').val();
		var regExp = /^[0-9]+$/;
	
	if (price.match(regExp) != null) {
		$('#pricemsg').html('<font color=blue>성공<font>');
		priceuse = "";
	}
	else {
		$('#pricemsg').html('<font color=red>숫자만 입력해주세요.<font>');
		priceuse = "priceerror";
	}
}
function keyd(){
	//alert(key);
	$('#idmessage').css('display','none');
	use = "";
	isCheck = false;
}

