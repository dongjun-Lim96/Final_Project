package faq.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import faq.model.FaqBean;
import faq.model.FaqDao;

@Controller
public class FaqController {

	private final String command = "/insert.faq";
	private final String getPage = "faqInsertForm";
	private final String gotoPage="redirect:/faqlist.jsp";
	
	@Autowired
	private FaqDao faqDao;
	
	
	@RequestMapping(value=command , method = RequestMethod.GET)
	public String doAction() {
		
		return getPage;
	}
	
	@RequestMapping(value=command , method = RequestMethod.POST)
	public ModelAndView  doAction(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String faqTitle = request.getParameter("faqTitle");
		String faqContent = request.getParameter("faqContent");
		FaqBean fb = new FaqBean(0, faqTitle,faqContent); 

		int cnt = faqDao.insertFaq(fb);
		if(cnt >0) {
			mav.addObject("message", "자주묻는질문 등록완료");
			mav.setViewName(getPage);
			return mav;
		}else {
			mav.addObject("message", "자주묻는질문 등록실패");
			mav.setViewName(getPage);
			return mav;
		}
		
	}
	
}
