<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="accountsMyPageHeader.jsp"%>
            
            
              <form name="form1" method="post" action="out.acc">
				<div class="whiteBox">
					<h3 class="adm_tit marb30">회원탈퇴</h3>
					<input type="hidden" name="userId" value="${accounts.userId}">
					<div class="myinfo_cont refund_info">
						<dl>
							<dt class="pad0">비밀번호 <span class="pointColor">*</span></dt>
							<dd><input type="password" name="userPw"  class="input input_m"></dd>
						</dl>
				
				
						<dl>
							<dt class="pad0">삭제 동의 <span class="pointColor">*</span></dt>
							<dd>
								<div class="check_box block_line">
									<label>
										<input type="radio" name="agree" value="y"/>동의  &nbsp;
										<input type="radio" name="agree" value="n" checked>미동의
									</label>
									<label>
										
									</label>
									<br><br>
									<label>
									탈퇴 후에는 유료로 구매한 과정을 포함한 모든 수강정보가 삭제되어 복구가 불가능하며, 약관에 따라 일정 시일 후 모든 정보가 삭제됩니다.</label>
									</label>
								</div>
							</dd>
						</dl>
					</div>
				</div>
				
				<div class="bbs_btn">
					<div>
						<button type="submit" class="bgColor">탈퇴하기</button>
					</div>
				</div>
				</form>
           
            
               <%@ include file="accountsMyPageFooter.jsp"%>