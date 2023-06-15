package accounts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
public class AccountsOutController {
	private final String command = "/out.acc";
	private String getPage = "accountsOut";
	private String gotoPage = "redirect:/list.cs";
	
	@Autowired
	AccountsDao adao;
	
	@RequestMapping(value =  command , method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("userId") String userId) {
		
		ModelAndView mav = new ModelAndView();
		AccountsBean ab = adao.GetAccountsById(userId);
		
		mav.addObject("accounts", ab);
		
		mav.setViewName(getPage);
		
		return mav;
	}
	
	@RequestMapping(value = command , method = RequestMethod.POST)
	public ModelAndView doAction(@RequestParam("userId") String userId,
								@RequestParam("userPw") String userPw,
								@RequestParam("agree") String agree,
								HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		
		AccountsBean ab = adao.GetAccountsById(userId);
		
		if (agree.equals("y")) {
			if (ab.getUserPw().equals(userPw)) {
				adao.outUser(userId);
				mav.setViewName(gotoPage);
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
		}else if (!agree.equals("y")) {
			try {
				out = response.getWriter();
				out.println("<script>alert('삭제 미동의');history.go(-1);</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mav.setViewName(getPage);
		}
		
		
		return mav;
	}
	
	
}
