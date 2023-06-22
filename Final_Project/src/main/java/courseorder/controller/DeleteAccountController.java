package courseorder.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import courseorder.model.CourseOrderDao;

@Controller
public class DeleteAccountController {
	private final String command="/deleteUserAccount.co";
	private final String getPage="redirect:/courseAccountList.co";
	
	@Autowired
	CourseOrderDao courseOrderDao;
	
	@RequestMapping(value = command)
	public ModelAndView doAction(@RequestParam("userId") String userId,
			@RequestParam("pageNumber") String pageNumber,
			Model model,RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView();
		System.out.println("delete userid :" + userId);
		System.out.println("delete pageNumber :" + pageNumber);
		
		int cnt = courseOrderDao.deleteAccount(userId);
		System.out.println("delete cnt :" + cnt );
		mav.addObject("pageNumber", pageNumber);
		mav.setViewName(getPage);
	    if (cnt > 0) {
	        redirectAttributes.addFlashAttribute("message", "회원 삭제완료");
	    }else {
	    	 redirectAttributes.addFlashAttribute("message", "회원 삭제실패");
	    }
		return mav;
		
	}
}
