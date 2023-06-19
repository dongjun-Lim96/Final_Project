package course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import course.model.CourseDao;

@Controller
public class AdminMain {
	private final String command="adminmain.cs";
	private final String getPage="adminMian";
	
	@Autowired
	CourseDao courseDao;
	
	@RequestMapping(value = command)
	public ModelAndView doAction() {
		ModelAndView mav= new ModelAndView();
		
		
		mav.setViewName(getPage);
		return mav;
	}
}
