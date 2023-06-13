package accounts.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import accounts.model.AccountsBean;
import accounts.model.AccountsDao;

@Controller
public class AccountsUpdateCheckController {
	private final String command = "/updateCheck.acc";
	private String getPage = "accountsUpdateCheck";
	private String gotoPage = "redirect:/update.acc";
	
	@Autowired
	AccountsDao adao;
	
	@RequestMapping(value =  command , method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("userId") String userId) {
		
		System.out.println("유저 아이디: "+userId);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("userId", userId);
		mav.setViewName(getPage);
		
		return mav;
	}
	
	@RequestMapping(value =  command , method = RequestMethod.POST)
	public ModelAndView doAction(
			@RequestParam("userId") String userId,
			@RequestParam("userPw") String userPw,
			HttpServletResponse response) {
		
		System.out.println("유저 아이디: "+userId);
		
		ModelAndView mav = new ModelAndView();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		
		AccountsBean ab = adao.GetAccountsById(userId);
		
		System.out.println("유저 userPw: "+ ab.getUserPw());
		
		
		if (ab.getUserPw().equals(userPw)) {
				System.out.println("비밀번호 일치");
				
				mav.setViewName(gotoPage+"?userId="+userId);
		}else {
			try {
				out = response.getWriter();
				out.println("<script>alert('비번이 일치하지 않습니다.');history.go(-1);</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mav.setViewName(getPage);
		}
		
		return mav;
	}
}
