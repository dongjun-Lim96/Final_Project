package accounts.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import accounts.model.AccountsDao;
import courseorder.model.CourseOrderBean;
import courseorder.model.CourseOrderDao;


@Controller
public class AccountsPayController {
	private final String command = "/pay.acc";
	private String getPage = "accountsPay";
	
	@Autowired
	AccountsDao adao;
	
	@RequestMapping(value =  command , method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("userId") String userId) {
		
		ModelAndView mav = new ModelAndView();
		
		CourseOrderDao cado = new CourseOrderDao();
		List<CourseOrderBean> lists = adao.getPayList(userId);
		
		mav.addObject("lists", lists);
		mav.addObject("userId", userId);
		mav.setViewName(getPage);
		
		return mav;
	}
}
