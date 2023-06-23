<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>Insert title here</title>
</head>
<body>

   <form name="form1" action="loading.acc" method="post">

         
         </form>
<script type="text/javascript">
    // 카카오 최초 로그인시 DB에 정보넣기
    $(document).ready(function () {
        // 인가코드 가져오기
        let codeURL = new URL(window.location.href);
        let code= codeURL.searchParams.get('code');

        // 인가코드 유무 확인
        if(code != null){
            console.log("codeURL: " + codeURL);
            console.log("code: " + code);

            /* 토큰 가져오기 */
            function selectMyAccessTocken() {
                let param = {"code" : code}

                $.ajax({
                    url  : 'selectMyAccessTocken.acc',
                    type : 'get',
                    data : param, 
                    contentType: "application/json; charset=UTF-8",
                    success : function(res){
                        location.href="list.cs"  
                    },
                    error: function(xhr, type){
                        console.log(xhr); 
                        console.log(type);
                        alert("가입되지 않은 회원입니다. 확인 후 로그인 또는 회원가입을 해주세요.");
                        location.href="loginForm.acc";
                    }
                })
            }
            selectMyAccessTocken();
        }else {
            console.log("코드 존재하지 않음")
        }

    })
</script>


</form>

</body>
</html>