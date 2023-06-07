package accounts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import accounts.model.AccountsBean;
import accounts.model.AccountsDao;

@Controller
public class AcoountsLoginController {
	
	
	@Autowired
	AccountsDao adao;
	
	@RequestMapping(value="/loginForm.acc", method = RequestMethod.GET)
	public String login() {
		return "accountsLoginForm";
	}

	// submit클릭
	@RequestMapping(value="/loginForm.acc", method = RequestMethod.POST)
	public ModelAndView doAction(
			@RequestParam("userId") String input_userId,
			@RequestParam("userPw") String input_userPw,
			HttpServletResponse response, HttpSession session) {

		ModelAndView mav = new ModelAndView();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		
		
		AccountsBean ab = adao.GetAccountsById(input_userId); // kim 1234
		System.out.println("ab:" + ab);
		
		if(ab == null) { // 가입안함
			System.out.println("가입하지 않은 회원");
			
			try {
				out = response.getWriter();
				out.println("<script>alert('해당 아이디가 존재하지 않습니다.');history.go(-1);</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			mav.setViewName("accountsLoginForm");
			
		}else { // 가입한 회원
			System.out.println("가입한 회원");
			
			if(ab.getUserPw().equals(input_userPw)) {
				// 로그인
				session.setAttribute("loginInfo", ab);
				
				mav.setViewName((String)session.getAttribute("destination")); 
				// "redirect:/insert.prd" : 상품 추가
				// "redirect:/detail.prd" : 주문하기  
				
				
				mav.setViewName("redirect:/list.cs");
				
			}else { // 가입은 했는데 비번이 일치하지 않는다.
				
				try {
					out = response.getWriter();
					out.println("<script>alert('비번이 일치하지 않습니다.');history.go(-1);</script>");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				mav.setViewName("accountsLoginForm");
			}
		}
		
		return mav;
	}

	@RequestMapping(value="/accountSearchForm.acc", method = RequestMethod.GET)
	public String searchAccounts() {
		return "accountSearchForm";
	}
	
	@RequestMapping(value="/searchAccountsUserId.acc", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void searchAccountsUserId(@RequestParam("userName") String input_userName,
	        @RequestParam("userEmail") String input_userEmail, HttpServletResponse response) {
	    System.out.println("aaaa");
	    AccountsBean ab = adao.GetAccountsByNameEmail(input_userName,input_userEmail);
	 
	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = null;
	    if (ab == null) { // 가입안함
	        System.out.println("가입하지 않은 회원");
	        String strJson = "{userEmail: " + input_userEmail + ",checkGbn: N}";
	        JSONObject jsonObj = new JSONObject(strJson);
	        try {
	            response.getWriter().append(jsonObj.toString());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    } else { // 가입한 회원
	        System.out.println("가입한 회원");
	        String strJson = "{userName: " + ab.getUserName() + ",checkGbn: Y}";
            JSONObject jsonObj = new JSONObject(strJson);
            jsonObj.put("userId", ab.getUserId());
            try {
                response.getWriter().append(jsonObj.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
	    }
	}
	
	@RequestMapping(value="/accountPwSearchForm.acc", method = RequestMethod.GET)
	public String searchAccountsPw() {
		return "accountPwSearchForm";
	}
	
	
	@RequestMapping(value="/searchAccountsUserPw.acc", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void searchAccountsUserPw(@RequestParam("userId") String input_userId,
	        @RequestParam("userEmail") String input_userEmail, HttpServletResponse response) {
	    System.out.println("aaaa");
	    AccountsBean ab = adao.GetAccountsByIdEmail(input_userId,input_userEmail);
	 
	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = null;
	    if (ab == null) { // 가입안함
	        System.out.println("가입하지 않은 회원");
	        String strJson = "{userEmail: " + input_userEmail + ",checkGbn: N}";
	        JSONObject jsonObj = new JSONObject(strJson);
	        try {
	            response.getWriter().append(jsonObj.toString());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    } else { // 가입한 회원
	        System.out.println("가입한 회원");
	            String strJson = "{userId: " + ab.getUserId() + ",checkGbn: Y}";
	            JSONObject jsonObj = new JSONObject(strJson);
	            jsonObj.put("userPw", ab.getUserPw());
	            try {
	                response.getWriter().append(jsonObj.toString());
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	    }
	}
}
