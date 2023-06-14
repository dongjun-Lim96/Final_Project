package accounts.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import accounts.model.AccountsBean;
import accounts.model.AccountsDao;

@Controller
public class AccountsRegisterController {
	private final String command = "/register.acc";
	private String getPage = "register";
	private String gotoPage = "redirect:/list.cs";
	
	@Autowired
	AccountsDao adao;
	
	@RequestMapping(value =  command , method = RequestMethod.GET)
	public String doAction() {
		
		return getPage;
		// => register.jsp
	}
	
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public String doAction(@ModelAttribute("memberBean") 
							AccountsBean accountsBean
							,@RequestParam("mobile1") String mobile1
							,@RequestParam("mobile2") String mobile2
							,@RequestParam("mobile3") String mobile3) {
		
		int cnt = -1;
		String userphone = mobile1+mobile2+mobile3;
		System.out.println(userphone);
		
		accountsBean.setUserPhone(userphone);
		
		/*
		System.out.println(accountsBean.getUserId());
		System.out.println(accountsBean.getUserPw());
		System.out.println(accountsBean.getUserName());
		System.out.println(accountsBean.getUserBirth());
		System.out.println(accountsBean.getUserEmail());
		System.out.println(accountsBean.getUserChkEmail());
		System.out.println(accountsBean.getUserPhone());
		System.out.println(accountsBean.getUserChkPhone());
		*/
		
		cnt = adao.accountsRegister(accountsBean);
		
		if (cnt != -1) {
				return gotoPage;
			}else {
				return getPage;
			}
		}
	
}
