<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<%@ include file="./../../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no,maximum-scale=1.0,minimum-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="format-detection" content="telephone=no" />



<link rel="stylesheet" type="text/css" href="https://cdn.malgnlms.com/theme/6/css/common.css?t=20230619" />
<link rel="stylesheet" type="text/css" href="https://cdn.malgnlms.com/theme/6/css/font_notoSans.css?t=20230619" />
<link rel="stylesheet" type="text/css" href="https://cdn.malgnlms.com/theme/6/css/green_theme.css?t=20230619" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css" />


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.3/TweenMax.min.js"></script>
<script src="https://unpkg.com/page-scroll-to-id@1.6.8/jquery.malihu.PageScroll2id.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.js"></script>


</head>

<body>
<link rel="stylesheet" type="text/css" href="https://www.wannaedu.com/theme/6/css/shop.css" />

<script type='text/javascript' src="https://www.wannaedu.com/theme/6/js/webpublisher.js"></script>
<script type="text/javascript" src="https://www.wannaedu.com/theme/6/js/ui.js"></script>



    <div id="contents">
        
<style>
    
    #sub_banner {position:relative; height:200px; width:100%; }
    #sub_banner::after {content:''; width:100%; height:100%; background:url('/theme/6/img/main/subtop_pattern.png')no-repeat center; background-size:contain; position:absolute; top:0; left:0;}
    #sub_banner h2 {position:relative; top:50%; transform:translateY(-50%); font-size:2.941rem; color:#fff; text-align:center; letter-spacing:-0.7pt; line-height:1; font-weight:bold; z-index:99;}
    .bgColor {background-color:#467fd7;}
    
</style>

<div id="sub_banner" class="bgColor">

    <h2 class="page_title">
        
        
        결제완료
        
    </h2>
</div>

    <div class="pay_ok_cont contents_in w1230 compad">
	<div class="pay_cont">

		<div class="fixed_cont" >
			<!-- ##price_table -->
			<div class="price_table">
				<h4>주문완료</h4>

				<div class="pay_ok">
					<div class="pay_icon">
						<img src="https://www.wannaedu.com//theme/6/img/shop/pay_ok.svg" class="cart Bg_svg svg" alt="쇼핑카트아이콘" />
						<img src="https://www.wannaedu.com//theme/6/img/shop/check.svg" class="check Bg_svg svg" alt="체크아이콘" />
					</div>
					<p>
						주문이 완료되었습니다. <br />
						확인을 누르면 마이페이지로 이동합니다.
					</p>
				</div>

				<div class="applyBtn">
					<a href="mypage.acc?userId=${userId}" class="bgColor pointBorder" style="display: flex; justify-content: center; align-items: center;">확인</a>
				</div>
			</div>
			<!-- ##price_table -->
		</div>

		<div class="pay_table">
			<div class="pay_line">
				<h3>주문 정보</h3>
				<ul>
					<c:set var="ordernum" value="0" />
					<c:set var="totalprice" value="0" />
					<c:forEach var="cart" items="${cartList}">
					<li style="padding-left: 0px;">
						<span class="cate" style="position:relative;">${cart.categoryCode }</span>
						${cart.cousreName }<b>(수량 : 1)</b>
						<span class="price">
							
							<strong class="eng">${cart.cousrePrice }</strong>원
						</span>
					</li>
					
					<c:set var="ordernum" value="${ordernum}${cart.cartNumber}" />
					<c:set var="totalprice" value="${totalprice + cart.cousrePrice}" />
					</c:forEach>
					
				</ul>

				<div class="total">
					<p class="">
						<fmt:formatNumber var="tot_price" value="${totalprice }" pattern="##,###,###" />
						
						
						<i>판매금액 <b>${tot_price}원</b></i>
						
						<span class="price_item plus"></span>
						<i>배송금액<b class="red red_s">(무료)</b> <b>0원</b></i>
						<span class="price_item minus"></span>
						<i>할인금액 <b class="red">0원</b></p></i>
					<h4>총 결제금액<span class="pointColor price"><strong class="eng">${tot_price}원</strong>원</span></h4>
				</div>
			</div>


			<div class="pay_line">
				<h3>결제 정보</h3>

				<div class="delivery_info">
					<dl>
						<dt>주문번호</dt>
						<dd>${ordernum}</dd>
					</dl>
					<dl>
						<dt>주문상태</dt>
						<dd>결제완료</dd>
					</dl>
					
					<dl>
						<dt>총 결제금액</dt>
						<dd>${tot_price}원원</dd>
					</dl>
					
					<dl>
						<dt>주문/결제일시</dt>
						<dd>2023.06.19 09:29</dd>
					</dl>
				</div>
			</div>
		</div>
	</div>
</div>
				
    </div>


<%@ include file="./../../footer.jsp"%>    
</body>
</html>