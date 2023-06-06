package accounts.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import accounts.model.AccountsDao;

@Controller
public class AccountsRegisterCheckController {
private final String command = "/check.acc";
	
	@Autowired
	AccountsDao aDao;
	
	@ResponseBody
	@RequestMapping(command)
	public String doAction(HttpServletResponse response ,
			@RequestParam("userId") String userId) {
		
		boolean result =aDao.searchId(userId);
		
		if (result) {
			return "NO";
		}else {
			return "YES";
		}
		
	}
}
