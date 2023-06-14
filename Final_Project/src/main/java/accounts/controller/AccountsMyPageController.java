package accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import accounts.model.AccountsDao;
import course.model.CourseBean;
import courseorder.model.CourseOrderBean;

@Controller
public class AccountsMyPageController {
	private final String command = "/mypage.acc";
	private String getPage = "accountsMyPage";
	
	@Autowired
	AccountsDao adao;
	
	@RequestMapping(value =  command , method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("userId") String userId) {
		
		System.out.println("유저 아이디: "+userId);
		
		ModelAndView mav = new ModelAndView();
		List<CourseBean> lists = adao.getOrderById(userId);
		
		mav.addObject("userId", userId);
		mav.addObject("lists", lists);
		mav.setViewName(getPage);
		
		return mav;
		// => accountsMyPage.jsp
	}
	
	
}