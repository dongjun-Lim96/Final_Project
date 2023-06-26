package accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import accounts.model.AccountsBean;
import accounts.model.AccountsDao;

@Controller
public class AccountsUpdateController {
	private final String command = "/update.acc";
	private String getPage = "accountsUpdate";
	private String gotoPage = "redirect:/mypage.acc";
	
	@Autowired
	AccountsDao adao;
	
	@RequestMapping(value =  command , method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("userId") String userId) {
		
		ModelAndView mav = new ModelAndView();
		AccountsBean ab = adao.GetAccountsById(userId);
		
		mav.addObject("userId", userId);
		mav.addObject("accounts", ab);
		
		mav.setViewName(getPage);
		
		return mav;
	}
	
	@RequestMapping(value =  command , method = RequestMethod.POST)
	public ModelAndView doAction(AccountsBean accounts
			,@RequestParam("mobile1") String mobile1
			,@RequestParam("mobile2") String mobile2
			,@RequestParam("mobile3") String mobile3) {
		
		ModelAndView mav = new ModelAndView();
		String userphone = mobile1+mobile2+mobile3;
		
		accounts.setUserPhone(userphone);
		/*
		System.out.println(accounts.getUserId());
		System.out.println(accounts.getUserPw());
		System.out.println(accounts.getUserName());
		System.out.println(accounts.getUserBirth());
		System.out.println(accounts.getUserEmail());
		System.out.println(accounts.getUserChkEmail());
		System.out.println(accounts.getUserPhone());
		System.out.println(accounts.getUserChkPhone());
		*/
		int cnt = adao.accountsUpdate(accounts);
		
		
		mav.addObject("userId", accounts.getUserId());
		mav.setViewName(gotoPage);
		
		return mav;
	}
}
