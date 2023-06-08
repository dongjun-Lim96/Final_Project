/**
 * 
 */
 
var use;
var isCheck = false;
 
function writeSave(){ // 가입클릭
	//alert(1);
	
	if($('input[name=courseCode]').val() == ""){
		alert("카테고리코드를 입력해주세요.");
		$('input[name=courseCode]').focus();
		return false;
	}
	if(use == "missing"){
		alert('카테고리코드를 입력하세요');
		$("input[name=courseCode]").focus();
		return false;
	}
	else if(use == "impossible"){
		alert('이미 등록된 카테고리코드입니다');
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
				$("#idmessage").html('<font color=red>카테고리코드를 입력하세요<font>').show();
				$('input[name=courseCode]').focus();
				use = "missing";
				
			}
			else if($.trim(data) == "NO"){
				$("#idmessage").html('<font color=red>이미 등록된 카테고리코드 입니다<font>').show();
				$('input[name=courseCode]').select();
				use = "impossible";
				 
			}
			else if($.trim(data) == "YES"){
				$("#idmessage").html('<font color=blue>사용가능한 카테고리코드 입니다<font>').show();
				use = "possible";
				
			}
		},
		error: function(xhr, status, error) {
            alert("에러 발생: " + error);
        }
	});//ajax
}//categoryCheck


function keyd(){
	//alert(key);
	$('#idmessage').css('display','none');
	use = "";
	isCheck = false;
}

