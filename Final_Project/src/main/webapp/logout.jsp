<%@page import="accounts.model.AccountsBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./header.jsp"%>
<%
	System.out.println("1111111111111");
	
	if (session != null) {
		System.out.println("2222222222");
		AccountsBean ab = (AccountsBean)session.getAttribute("loginInfo");
		System.out.println("333333333"+ab.getUserId());		
   		session.invalidate();
	}	
    System.out.println("7777777777777777");
    // 로그아웃 후 이동할 페이지로 리다이렉트
   response.sendRedirect("redirect:/list.cs");
    
%>

 
