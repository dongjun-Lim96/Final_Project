package course.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import accounts.model.AccountsDao;
import course.model.CourseBean;
import course.model.CourseDao;


@Controller
public class CourseGetMainController {
	private final String command="/list.cs";
	private final String getPage="main";
	
	@Autowired
	CourseDao coursedao;
	
	@RequestMapping(value = command)
	public ModelAndView doAction() {
		System.out.println("/list.cs/list.cs/list.cs");
		ModelAndView mav = new ModelAndView();
		
		List<CourseBean> courseLists = coursedao.getCourse();
		mav.addObject("courseLists",courseLists);
		mav.setViewName(getPage);
		return mav; 
	}
	 
}
