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
	        redirectAttributes.addFlashAttribute("message", "ȯ�ҿϷ�");
	    }else if(cnt ==0){
	    	 redirectAttributes.addFlashAttribute("message", "���� �ۼ��� ���ǰ� �ֽ��ϴ�. ��������");
	    }else {
			redirectAttributes.addFlashAttribute("message", "ȯ�ҽ���");
		}

	    redirectAttributes.addAttribute("userId",userId);

		
		mav.setViewName(gotoPage);
		return mav;
	}
}
