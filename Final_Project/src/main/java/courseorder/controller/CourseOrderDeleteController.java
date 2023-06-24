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
public class CourseOrderDeleteController {
	private final String commnad="/orderRefund.co";
	private final String gotoPage="redirect:/accountDetail.co";
	
	@Autowired
	CourseOrderDao courseOrderDao;
	
	@RequestMapping(value = commnad)
	public ModelAndView doAction(@RequestParam("orderNumber") int orderNumber,
			@RequestParam("userId") String userId,
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			Model model,RedirectAttributes redirectAttributes
			) {
		ModelAndView mav= new ModelAndView();
		System.out.println(" orderRefund orderNumber : " + orderNumber);
		System.out.println(" orderRefund userId : " + userId);
		
		
		int cnt = courseOrderDao.deleteCourseByOrderNumber(orderNumber);
		
	    if (cnt > 0) {
	        redirectAttributes.addFlashAttribute("message", "환불완료");
	    }else if(cnt ==0){
	    	 redirectAttributes.addFlashAttribute("message", "리뷰 작성된 강의가 있습니다. 삭제실패");
	    }else {
			redirectAttributes.addFlashAttribute("message", "환불실패");
		}

	    redirectAttributes.addAttribute("userId",userId);

		
		mav.setViewName(gotoPage);
		return mav;
	}
}
