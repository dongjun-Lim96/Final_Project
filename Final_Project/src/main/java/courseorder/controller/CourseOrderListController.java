package courseorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import courseorder.model.CourseOrderDao;

@Controller
public class CourseOrderListController {
	private final String command="/courseOrderList.co";
	private final String getPage="CourseorderListAdmin";
	
	@Autowired
	CourseOrderDao courseOrderDao;
	
	@RequestMapping(value = command)
	public ModelAndView doAction() {
		ModelAndView mav = new ModelAndView();
		
		System.out.println("asdfasdfasdf");
		mav.setViewName(getPage);
		return mav;
		
	}
}
