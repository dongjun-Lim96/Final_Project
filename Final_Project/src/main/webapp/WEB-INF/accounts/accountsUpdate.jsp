<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="accountsMyPageHeader.jsp"%>
            
            
            <form name="form1" method="post" action="update.acc" onSubmit="return writeSave()">
				<input type="hidden" name="userId" value="${accounts.userId}">
				<div class="whiteBox">
					<h3 class="adm_tit marb30">개인정보수정</h3>
				
					<div class="myinfo_cont refund_info">
						
						<dl class="table">
							<dt>아이디</dt>
							<dd><p>${accounts.userId}</p></dd>
						</dl>
						
				
						
						<dl class="table">
							<dt>이름 </dt>
							<dd>
								<p><input name="userName" class="input input_m2" type="text" value="${accounts.userName}"/></p>
								
								
							</dd>
						</dl>

						
						<dl class="table">
							<dt>생년월일</dt>
							<dd>
								
								<p><input name="userBirth" class="input input_num" type="date" value="${accounts.userBirth}" /></p>
								
								
							</dd>
						</dl>
				
						
						<dl class="table">
							<dt>이메일</dt>
							<dd>
								
								<%-- 
								<span style="display:inline-block;margin-right:5px;line-height:60px;">
									<input name="email1" id="email1" type="text" class="input input_m2" value="${fn:substringBefore(accounts.userEmail, '@')}"><span class='hipen2'>@</span>
									<input name="email2" id="email2" type="text" class="input input_m2" value="${fn:substringAfter(accounts.userEmail, '@')}"/>
								</span>
								 --%>
								 <p>
								<input name="userEmail" id="userEmail" type="text" class="input input_m2" value="${accounts.userEmail}" onkeyup="emailcheck()">
								<span id="emailmsg"></span>
								</p>
								<div class="check_box" style="display:block;padding-top:10px;">
									
									
									<label><input name="userChkEmail" value="1" type="radio" class="radio" <c:if test="${accounts.userChkEmail == '1'}">checked</c:if> >수신동의</label>
									<label><input name="userChkEmail" value="0" type="radio" class="radio" <c:if test="${accounts.userChkEmail == '0'}">checked</c:if> >수신거부</label>
									
								</div>
								
				
							</dd>
				
						</dl>
				
						
						<dl class="table">
							<dt>휴대전화 </dt>
							<dd>
								<input name="mobile1" class="input input_num" type="text" value="${fn:substring(accounts.userPhone, 0, 3)}" maxlength="3">
								<span class="hipen">-</span>
								<input name="mobile2" class="input input_num" type="text" value="${fn:substring(accounts.userPhone, 3, 7)}" maxlength="4">
								<span class="hipen">-</span>
								<input name="mobile3" class="input input_num" type="text" value="${fn:substring(accounts.userPhone, 7, 11)}" maxlength="4">
								
								<div class="check_box" style="display:block;padding-top:10px;">
									
									<label><input name="userChkPhone" value="1" type="radio" class="radio" <c:if test="${accounts.userChkPhone == '1'}">checked</c:if> />수신동의</label>
									<label><input name="userChkPhone" value="0" type="radio" class="radio" <c:if test="${accounts.userChkPhone == '0'}">checked</c:if> />수신거부</label>
									
								</div>
								
							</dd>
						</dl>
						
						<dl class="table">
							<dt>비밀번호</dt>
							<dd>
								<p>
									<input name="userPw" class="input input_m2" maxlength="50" type="password"  onblur="return pwcheck()"/>
									<span id="pwmessage">영문, 숫자, 특수문자 조합 8자 이상 입력하세요.</span>
								</p>
								
							</dd>
						</dl>
						
						<dl class="table">
							<dt>비밀번호 확인</dt>
							<dd>
								<p>
									<input name="userPw2" class="input input_m2" maxlength="50" type="password" onkeyup="pw2check()"/>
									<span id="pwmessage2">영문, 숫자, 특수문자 조합 8자 이상 입력하세요.</span>
								</p>
							</dd>
						</dl>
				
					</div>
				
				</div>
				
				<div class="bbs_btn">
					<div>
						<button type="reset" class="bgColor">취소</button>
						<button type="submit" class="bgColor">정보수정</button>
					</div>
				</div>
				</form>
            
            
                <%@ include file="accountsMyPageFooter.jsp"%>