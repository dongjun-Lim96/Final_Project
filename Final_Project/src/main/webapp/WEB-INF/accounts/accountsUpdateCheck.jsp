<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="accountsMyPageHeader.jsp"%>
                
                  <div class="whiteBox">
					<h3 class="adm_tit">개인정보수정</h3>
				
					<form name="form1" method="post" action="updateCheck.acc">
					<div class="login_box">
						<span class="grayBox"></span>
						<h3>비밀번호를 입력해주세요</h3>
						<p>
							회원님의 개인정보 보호를 위해 회원정보를 조회/수정하기 전
							비밀번호를 다시 확인 받고 있습니다.
						</p>
						<div class="login_input">
							<input type="hidden" name="userId" value="${userId}">
							<input type="password" name="userPw" id="userPw" class="input" placeholder="비밀번호">
							<input type="submit" value="확인" class="search_btn2">
						</div>
					</div>
					</form>
				     </div>           
                
                <%@ include file="accountsMyPageFooter.jsp"%>