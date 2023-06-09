package course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryBean;
import category.model.CategoryDao;
import course.model.CourseDao;

@Controller
public class CourseInsertController {   
	private final String command="/insert.cs";
	private final String getPage="CourseInsert"; 
	 
	@Autowired
	CourseDao coursedao;

	
	
	@RequestMapping(value = command,method = RequestMethod.GET)
	public ModelAndView doAction() {
		ModelAndView mav = new ModelAndView();
		
		
		
		
		mav.setViewName(getPage);
		return mav;

	}
}
