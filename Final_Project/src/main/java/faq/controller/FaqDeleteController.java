package faq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import faq.model.FaqDao;

@Controller
public class FaqDeleteController {

	private final String command="delete.faq";
	private final String getPage="redirect:/list.faq";
	 
	@Autowired
	FaqDao faqDao;
	
	@RequestMapping(value = command)
	public String doAction(@RequestParam("faqNumber") String faqNumber, RedirectAttributes redirectAttributes) {
	    int cnt = faqDao.deleteFaq(faqNumber);
	    
	    if (cnt > 0) {
	        redirectAttributes.addFlashAttribute("message", "FAQ 삭제완료"); 
	    } else {
	        redirectAttributes.addFlashAttribute("message", "FAQ 삭제실패");
	    }
	     
	    return getPage;
	}
}
