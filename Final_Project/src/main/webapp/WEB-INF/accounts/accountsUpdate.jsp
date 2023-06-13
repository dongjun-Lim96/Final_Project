<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
 <head>
 <link rel="stylesheet" type="text/css" href="https://www.wannaedu.com/theme/6/css/mypage/main.css" />
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>        
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="resources/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
   <%
	String conPath = request.getContextPath();
%>
<script type="text/javascript" src="<%=conPath%>/resources/js/update.js"></script>
   <%--  <%@ include file="/WEB-INF/common/common.jsp" %> --%>
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.html">mypage</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="list.cs">home</a></li>
                        <!-- <li><a class="dropdown-item" href="#!">Activity Log</a></li> -->
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="#!">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">마이페이지</div>
                            <a class="nav-link" href="mypage.acc?userId=${accounts.userId}">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Dashboard
                            </a>
                            <div class="sb-sidenav-menu-heading">강의정보</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                수강현황
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="layout-static.html">수강중인 과정</a>
                                    <a class="nav-link" href="layout-sidenav-light.html">종료된 과정</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fa-solid fa-cart-shopping"></i></div>
                                결제관리 <!-- fas fa-book-open  fa-solid fa-cart-shopping-->
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        결제내역
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="login.html">결제내역 조회</a>
                                           <!--  <a class="nav-link" href="register.html">Register</a>
                                            <a class="nav-link" href="password.html">Forgot Password</a> -->
                                        </nav>
                                    </div>
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        위시리스트
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="401.html">수강신청</a>
                                            <a class="nav-link" href="404.html">마켓</a>
                                            <a class="nav-link" href="500.html">도서</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">회원정보</div>
                            <a class="nav-link" href="updateCheck.acc?userId=${accounts.userId}">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                개인정보 수정
                            </a>
                            <a class="nav-link" href="tables.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                회원 탈퇴
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Start Bootstrap
                    </div>
                </nav>
            </div>
             <div id="layoutSidenav_content">
            
            
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
            
            
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2023</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="resources/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="resources/assets/demo/chart-area-demo.js"></script>
        <script src="resources/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="resources/js/datatables-simple-demo.js"></script>
    </body>
</html>