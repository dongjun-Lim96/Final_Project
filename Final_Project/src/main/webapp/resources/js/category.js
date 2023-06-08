/**
 * 
 */
 
var use;
var isCheck = false;
 
function writeSave(){ // 가입클릭
	//alert(1);
	
	if($('input[name=categoryCode]').val() == ""){
		alert("카테고리코드를 입력해주세요.");
		$('input[name=userId]').focus();
		return false;
	}
	if(use == "missing"){
		alert('카테고리코드를 입력하세요');
		$("input[name=userId]").focus();
		return false;
	}
	else if(use == "impossible"){
		alert('이미 등록된 카테고리코드입니다');
		$('input[name=userId]').select();
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



function categoryCheck(){ // 중복체크 클릭
	alert($('input[name=categoryCode]').val());
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
				
			}
			else if($.trim(data) == "NO"){
				$("#idmessage").html('<font color=red>이미 등록된 카테고리코드 입니다<font>').show();
				$('input[name=categoryCode]').select();
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

