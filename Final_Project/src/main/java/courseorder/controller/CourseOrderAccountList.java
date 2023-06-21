package courseorder.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import accounts.model.AccountsBean;
import courseorder.model.CourseOrderDao;

@Controller
public class CourseOrderAccountList {
	private final String command="courseAccountList.co";
	private final String getPage="CourseOrderAccountList";
	
	@Autowired
	CourseOrderDao courseOrderDao;
	
	@RequestMapping(value = command)
	public ModelAndView doAction() {
		ModelAndView mav = new ModelAndView();
		
		List<AccountsBean> accountBuyList = courseOrderDao.getAccountBuyList();
		System.out.println("accountBuyList : "+ accountBuyList.size());
		for(AccountsBean x :accountBuyList) {
			System.out.println(x.getUserId());
			System.out.println(x.getCount());
		}
		
		System.out.println("asdfasdfasdf");
		mav.addObject("accountBuyList", accountBuyList);
		mav.setViewName(getPage);
		return mav;
		
	}
}