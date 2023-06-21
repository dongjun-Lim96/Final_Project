package courseorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import courseorder.model.CourseOrderDao;

@Controller
public class CourseOrderPaymentController {
	private final String command = "/courseOrder.cod";
	private String getPage = "courseOrderPayment";
	
	@Autowired
	CourseOrderDao coDao;
	
	@RequestMapping(value =  command , method = RequestMethod.GET)
	public ModelAndView doAction() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(getPage);
		
		return mav;
	}
}
