/**
 * 
 */
 
 function review(){
	//alert(1);
	
	if($('input[name="reviewTitle"]').val() == ""){
		alert("제목을 입력해주세요.");
		$('input[name="reviewTitle"]').focus();
		return false;
	}
	
	if($('textarea[name="reviewContent"]').val() == ""){
		alert("내용을 입력해주세요.");
		$('input[name="reviewContent"]').focus();
		return false;
	}
	
	return true;
}