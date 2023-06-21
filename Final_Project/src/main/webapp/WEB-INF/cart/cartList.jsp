<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<%@ include file="./../../header.jsp"%>

<style>
#sub_banner {
   position: relative;
   height: 200px;
   width: 100%;
}

#sub_banner::after {
   content: '';
   width: 100%;
   height: 100%;
   background: url('/theme/6/img/main/subtop_pattern.png') no-repeat center;
   background-size: contain;
   position: absolute;
   top: 0;
   left: 0;
}

#sub_banner h2 {
   position: relative;
   top: 50%;
   transform: translateY(-50%);
   font-size: 2.941rem;
   color: #fff;
   text-align: center;
   letter-spacing: -0.7pt;
   line-height: 1;
   font-weight: bold;
   z-index: 99;
}

.bgColor {
   background-color: #0DCAF0;
}

.card-img-top {
   border-radius: 20%;
   width: 350px;
   height: 240px;
   transition: filter 0.3s;
}

.card-img-top:hover {
   filter: brightness(70%);
}
</style>
<div id="sub_banner" class="bgColor">
   <h2 class="page_title">장바구니</h2>
</div>
<br>
<br>
<script type="text/javascript">
function allcheck(ac) {
   //alert(1);
   var check = document.myform.allchk.checked
   
   var checknum = document.getElementsByName('cartNumber');
   
   if (check) {
      for (var i = 0; i < checknum.length; i++) {
         checknum[i].checked = true;
      }
   }else {
      for (var i = 0; i < checknum.length; i++) {
         checknum[i].checked = false;
      }
   }
}

function alldelete() {
   //alert(1);
   
   var num = document.getElementsByName('cartNumber');
   var flag = false;
   
   for (var i = 0; i < num.length; i++) {
      if (num[i].checked) {
         flag = true;
      }
   }
   
   if (!flag) {
      alert("하나라도 선택하세요");
      return false;
   }
   
   myform.submit();
}
function goBack() {
     window.history.back();
   }
   
   
function payment(userId, totalPrice) {
   //alert(userId);
   //alert(totalPrice);
    if (confirm("결제하시겠습니까?")) {
       
       location.href = "payment.ct?userId="+userId;
       alert("결제가 완료되었습니다!");
     } else {
       alert("결제가 취소되었습니다.");
     }
}   
</script>

<center>
<form name="myform" action="cartDelete.ct">
<input type="hidden" name="userId" value="${userId}">
   <table class="table"
      style="width: 1200px; border-top: 2px solid lightgray; border-bottom: 2px solid lightgray">
      <tr style="height: 40px;">
         <th style="width: 10%; text-align: center; vertical-align: middle;" >선택 <input type="checkbox" name="allchk" onclick="allcheck(this)"></th>
         <th style="width: 20%; text-align: center; vertical-align: middle;">카테고리</th>
         <th style="width: 40%; text-align: center; vertical-align: middle;">상품명</th>
         <th style="width: 30%; text-align: center; vertical-align: middle;">주문 금액</th>
         <th></th>
      </tr>
      <c:if test="${fn:length(cartList) == 0}">
         <tr>
            <td colspan=5
               style="text-align: center; vertical-align: middle; height: 100px;">
               장바구니가 비어있습니다</td>
         </tr>
      </c:if>
      <c:set var="totalprice" value="0" />
      <c:forEach var="cart" items="${cartList}">
         <tr>
            <td
               style="width: 10%; height: 100px; text-align: center; vertical-align: middle;">선택 <input type="checkbox" name="cartNumber" value="${cart.cartNumber}">
            </td>
            <td style="width: 20%; text-align: center; vertical-align: middle;">${cart.categoryCode}</td>
            <td style="width: 40%; text-align: center; vertical-align: middle;"><b>${cart.cousreName }</b></td>
            <fmt:formatNumber var="price" value="${cart.cousrePrice }"
               pattern="###,###" />
            <td style="width: 30%; text-align: center; vertical-align: middle;"><b>${price}원</b></td>
         </tr>
          <c:set var="totalprice" value="${totalprice + cart.cousrePrice}" />
      </c:forEach>
      <tr style="height: 20px;">
         <td></td>
      </tr>
      <tr class="table-active" style="height: 40px;">
         <td colspan=3><input type="button" value="선택 삭제" class="btn btn-secondary" onclick="alldelete()"></td>
         <fmt:formatNumber var="tot_price" value="${totalprice }"
            pattern="##,###,###" />
         <td style="text-align: center; vertical-align: middle;"><b>총
               금액 : <font color="red">${tot_price }원</font>
         </b></td>
         <td></td>
      </tr>
   </table>
</form>

<table class="table" style="width: 1328px;  margin-left: auto; margin-right: auto;">

      <tr>
         <td align=right>
            <input type="button" value="계속 쇼핑하기" class="btn btn-secondary" onClick="goBack()">
            &nbsp;&nbsp;
            <input type="button" value="결제하기" class="btn btn-primary" onClick="payment('${userId}','${totalprice}')">
            <!-- <input type="submit" value="결제하기" class="btn btn-primary"> -->
         </td>
         <td width=50px></td>
      </tr>
   </table>
   <!-- </form> -->
   <br><br>
</center>


<%@ include file="./../../footer.jsp"%>