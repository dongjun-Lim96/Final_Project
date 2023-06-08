package accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import accounts.model.AccountsDao;
import courseorder.model.CourseOrderBean;

@Controller
public class AccountsMyPageController {
	private final String command = "/mypage.acc";
	private String getPage = "accountsMyPage";
	
	@Autowired
	AccountsDao adao;
	
	@RequestMapping(value =  command , method = RequestMethod.GET)
	public String doAction(Model model ,@RequestParam("userId") String userId) {
		
		CourseOrderBean cob = new CourseOrderBean();
		cob = adao.getOrderById(userId);
		
		model.addAttribute("colists", cob);
		
		return getPage;
		// => accountsMyPage.jsp
	}
	
	
}
