/**
 * 
 */
  
var use; 
var isCheck = false;
 
function writeSave(){ // 등록 submit
	//alert(1);
	

	
	if($('input[name=eventTitle]').val() ==''){
		alert('이벤트 제목을 입력해주세요.');
		$('input[name=eventTitle]').focus();
		return false;
	}
	if($('input[name=eventContent]').val() ==''){
		alert('이벤트 내용을 입력해주세요.');
		$('input[name=eventContent]').focus();
		return false;
	}


  if ($('input[name=eventStart]').val() =='') {
    alert('이벤트 시작일을 입력해주세요.');
    $('input[name=eventStart]').focus();
    return false;
  }
  
  if ($('input[name=eventEnd]').val() =='') {
    alert('이벤트 종료일을 입력해주세요.');
    $('input[name=eventEnd]').focus();
    return false;
  }
  
  var eventStartDate = new Date($('input[name=eventStart]').val());
  var eventEndDate = new Date($('input[name=eventEnd]').val());
  
  if (eventStartDate > eventEndDate) {
    alert('이벤트 시작일은 종료일보다 이전이어야 합니다.');
    return false;
  }
	
}//writeSave()


function updateSave() {
  if ($('input[name=eventTitle]').val() ==''){
    alert('이벤트 제목을 입력해주세요.');
    $('input[name=eventTitle]').focus();
    return false;
  }

  if ($('textarea[name=eventContent]').val() ==''){
    alert('이벤트 내용을 입력해주세요.');
    $('textarea[name=eventContent]').focus();
    return false;
  }

  if ($('input[name=eventStart]').val() =='') {
    alert('이벤트 시작일을 입력해주세요.');
    $('input[name=eventStart]').focus();
    return false;
  }
  
  if ($('input[name=eventEnd]').val() =='') {
    alert('이벤트 종료일을 입력해주세요.');
    $('input[name=eventEnd]').focus();
    return false;
  }
  
  var eventStartDate = new Date($('input[name=eventStart]').val());
  var eventEndDate = new Date($('input[name=eventEnd]').val());
  
  if (eventStartDate > eventEndDate) {
    alert('이벤트 시작일은 종료일보다 이전이어야 합니다.');
    return false;
  }

  return true;
}

